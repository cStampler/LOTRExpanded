package drealm.entity;

import drealm.database.DRAchievement;
import drealm.database.DRFaction;
import drealm.database.DRMiniQuestFactory;
import drealm.database.DRRegistry;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRFoods;
import lotr.common.LOTRMod;
import lotr.common.entity.ai.*;
import lotr.common.entity.animal.LOTREntityHorse;
import lotr.common.entity.npc.LOTREntityMan;
import lotr.common.entity.npc.LOTREntityNPC;
import lotr.common.entity.npc.LOTRNPCMount;
import lotr.common.entity.npc.LOTRNames;
import lotr.common.fac.LOTRFaction;
import lotr.common.quest.LOTRMiniQuest;
import lotr.common.quest.LOTRMiniQuestFactory;
import lotr.common.world.structure.LOTRChestContents;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class DREntityCardolan extends LOTREntityMan {
    private static ItemStack[] weapons = new ItemStack[] {new ItemStack(DRRegistry.cardolan_sword), new ItemStack(LOTRMod.daggerIron), new ItemStack(DRRegistry.cardolan_spear), new ItemStack(DRRegistry.cardolan_axe), new ItemStack(LOTRMod.axeBronze), new ItemStack(Items.stone_axe)};
    public DREntityCardolan(World world) {
        super(world);
        this.setSize(0.6F, 1.8F);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new LOTREntityAIHiredRemainStill(this));
        this.tasks.addTask(2, this.createGondorAttackAI());
        this.tasks.addTask(3, new LOTREntityAIFollowHiringPlayer(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0));
        this.tasks.addTask(6, new LOTREntityAIEat(this, LOTRFoods.GONDOR, 8000));
        this.tasks.addTask(6, new LOTREntityAIDrink(this, LOTRFoods.GONDOR_DRINK, 8000));
        this.tasks.addTask(7, new EntityAIWatchClosest2(this, EntityPlayer.class, 8.0F, 0.02F));
        this.tasks.addTask(7, new EntityAIWatchClosest2(this, LOTREntityNPC.class, 5.0F, 0.02F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F, 0.02F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.addTargetTasks(false);
    }


    protected LOTRFoods getDunedainFoods() {
        return LOTRFoods.RANGER;
    }

    protected LOTRFoods getDunedainDrinks() {
        return LOTRFoods.RANGER_DRINK;
    }

    @Override
    public void setupNPCGender() {
        this.familyInfo.setMale(this.rand.nextBoolean());
    }

    public LOTRNPCMount createMountToRide() {
        LOTREntityHorse horse = (LOTREntityHorse) super.createMountToRide();
        horse.setMountArmor(new ItemStack(LOTRMod.horseArmorIron));
        return horse;
    }


    protected EntityAIBase createGondorAttackAI() {
        return new LOTREntityAIAttackOnCollide(this, 1.4, false);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2);
    }



    @Override
    public void setupNPCName() {
        this.familyInfo.setName(LOTRNames.getGondorName(this.rand, this.familyInfo.isMale()));
    }


    @Override
    public String getNPCName() {
        return familyInfo.getName();
    }


    @Override
    protected void dropFewItems(boolean flag, int i) {
        super.dropFewItems(flag, i);
        int bones = this.rand.nextInt(2) + this.rand.nextInt(i + 1);
        for(int l = 0; l < bones; ++l) {
            this.dropItem(Items.bone, 1);
        }
        this.dropDunedainItems(flag, i);
    }

    protected void dropDunedainItems(boolean flag, int i) {
        if(this.rand.nextInt(6) == 0) {
            this.dropChestContents(LOTRChestContents.RANGER_HOUSE, 1, 2 + i);
        }
    }

    @Override
    public boolean getCanSpawnHere() {
        if(super.getCanSpawnHere()) {
            if(this.liftSpawnRestrictions) {
                return true;
            }
            int i = MathHelper.floor_double(this.posX);
            int j = MathHelper.floor_double(this.boundingBox.minY);
            int k = MathHelper.floor_double(this.posZ);
            Block block = this.worldObj.getBlock(i, j - 1, k);
            BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(i, k);
            if(j > 62 && (block == biome.topBlock || block == Blocks.grass || block == Blocks.sand)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public float getBlockPathWeight(int i, int j, int k) {
        float f = 0.0f;
        this.worldObj.getBiomeGenForCoords(i, k);
        return f += 20.0f;
    }


    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        data = super.onSpawnWithEgg(data);
        int i = this.rand.nextInt(weapons.length);
        this.npcItemsInv.setMeleeWeapon(weapons[i].copy());
        this.npcItemsInv.setIdleItem(null);
        return data;
    }


    @Override
    protected void onAttackModeChange(AttackMode mode, boolean mounted) {
        if(mode == AttackMode.IDLE) {
            this.setCurrentItemOrArmor(0, this.npcItemsInv.getIdleItem());
        }
        else {
            this.setCurrentItemOrArmor(0, this.npcItemsInv.getMeleeWeapon());
        }
    }

    @Override
    public LOTRMiniQuest createMiniQuest() {
        return LOTRMiniQuestFactory.RANGER_NORTH.createQuest(this);
    }

    @Override
    public float getAlignmentBonus() {
        return 1.0f;
    }

    @Override
    public LOTRMiniQuestFactory getBountyHelpSpeechDir() {
        return DRMiniQuestFactory.CARDOLAN;
    }



    @Override
    public LOTRFaction getFaction() {
        return DRFaction.CARDOLAN;
    }


    @Override
    protected LOTRAchievement getKillAchievement() {
        return DRAchievement.kill_arthedain_man;
    }



    @Override
    public String getSpeechBank(EntityPlayer entityplayer) {
        if(this.isDrunkard()) {
            return "rangerNorth/drunkard/neutral";
        }
        if(this.isFriendly(entityplayer)) {
            return "rangerNorth/man/friendly";
        }
        return "rangerNorth/man/hostile";
    }



            }

