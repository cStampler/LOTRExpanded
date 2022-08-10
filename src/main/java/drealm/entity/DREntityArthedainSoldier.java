package drealm.entity;

import drealm.database.DRRegistry;
import drealm.database.DRShields;
import lotr.common.LOTRMod;
import lotr.common.LOTRShields;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import lotr.common.entity.npc.LOTREntityGondorLevyman;
import lotr.common.entity.npc.LOTREntityNPC;
import lotr.common.quest.LOTRMiniQuest;
import lotr.common.quest.LOTRMiniQuestFactory;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityArthedainSoldier extends DREntityArthedainLevyman {
    public DREntityArthedainSoldier(World world) {
        super(world);
        this.spawnRidingHorse = this.rand.nextInt(6) == 0;
        this.npcShield = DRShields.ALIGNMENT_ARTHEDAIN;
    }

    @Override
    public EntityAIBase createGondorAttackAI() {
        return new LOTREntityAIAttackOnCollide(this, 1.45, false);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(npcRangedAccuracy).setBaseValue(1.0);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        data = super.onSpawnWithEgg(data);
        int i = this.rand.nextInt(6);
        if(i == 0 || i == 1 || i == 2 || i == 3) {
            this.npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.arthedain_sword));
        }
        else if(i == 4) {
            this.npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.arthedain_spear));
        }
        else if(i == 5) {
            this.npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.arthedain_pike));
        }
        if(this.rand.nextInt(3) == 0) {
            this.npcItemsInv.setMeleeWeaponMounted(new ItemStack(DRRegistry.arthedain_pike));
        }
        else {
            this.npcItemsInv.setMeleeWeaponMounted(this.npcItemsInv.getMeleeWeapon());
        }
        if(this.rand.nextInt(5) == 0) {
            this.npcItemsInv.setSpearBackup(this.npcItemsInv.getMeleeWeapon());
            this.npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.arthedain_spear));
        }
        this.npcItemsInv.setIdleItem(this.npcItemsInv.getMeleeWeapon());
        this.npcItemsInv.setIdleItemMounted(this.npcItemsInv.getMeleeWeaponMounted());
        this.setCurrentItemOrArmor(1, new ItemStack(DRRegistry.arthedain_boots));
        this.setCurrentItemOrArmor(2, new ItemStack(DRRegistry.arthedain_leggings));
        this.setCurrentItemOrArmor(3, new ItemStack(DRRegistry.arthedain_chestplate));
        this.setCurrentItemOrArmor(4, new ItemStack(DRRegistry.arthedain_helmet));
        return data;
    }

    @Override
    protected void onAttackModeChange(LOTREntityNPC.AttackMode mode, boolean mounted) {
        if(mode == LOTREntityNPC.AttackMode.IDLE) {
            if(mounted) {
                this.setCurrentItemOrArmor(0, this.npcItemsInv.getIdleItemMounted());
            }
            else {
                this.setCurrentItemOrArmor(0, this.npcItemsInv.getIdleItem());
            }
        }
        else if(mounted) {
            this.setCurrentItemOrArmor(0, this.npcItemsInv.getMeleeWeaponMounted());
        }
        else {
            this.setCurrentItemOrArmor(0, this.npcItemsInv.getMeleeWeapon());
        }
    }

    @Override
    public float getAlignmentBonus() {
        return 2.0f;
    }

    @Override
    public LOTRMiniQuest createMiniQuest() {
        if(this.rand.nextInt(8) == 0) {
            return LOTRMiniQuestFactory.GONDOR_KILL_RENEGADE.createQuest(this);
        }
        return super.createMiniQuest();
    }
}
