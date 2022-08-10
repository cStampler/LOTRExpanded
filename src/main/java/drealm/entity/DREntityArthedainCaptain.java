package drealm.entity;

import drealm.database.DRAchievement;
import drealm.database.DRInvasions;
import drealm.database.DRRegistry;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRCapes;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import lotr.common.entity.animal.LOTREntityWildBoar;
import lotr.common.entity.npc.LOTREntityGondorSoldier;
import lotr.common.entity.npc.LOTRUnitTradeEntries;
import lotr.common.entity.npc.LOTRUnitTradeEntry;
import lotr.common.entity.npc.LOTRUnitTradeable;
import lotr.common.world.spawning.LOTRInvasions;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityArthedainCaptain extends DREntityArthedainLevyman implements LOTRUnitTradeable {

    public static final LOTRUnitTradeEntries ARTHEDAIN_COMMANDER = new LOTRUnitTradeEntries(200.0f, new LOTRUnitTradeEntry(DREntityArthedain.class, 20, 0.0f), new LOTRUnitTradeEntry(DREntityArthedainSoldier.class, 30, 50.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.FACTION), new LOTRUnitTradeEntry(DREntityArthedainArcher.class, 50, 100.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.FACTION), new LOTRUnitTradeEntry(DREntityArthedainBannerBearer.class, 50, 200.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.FACTION));

    public DREntityArthedainCaptain(World world) {
        super(world);
        this.addTargetTasks(false);
    }

    @Override
    public EntityAIBase createGondorAttackAI() {
        return new LOTREntityAIAttackOnCollide(this, 1.6, false);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        data = super.onSpawnWithEgg(data);
        this.npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.arthedain_sword));
        this.npcItemsInv.setMeleeWeaponMounted(this.npcItemsInv.getMeleeWeapon());
        this.npcItemsInv.setIdleItem(this.npcItemsInv.getMeleeWeapon());
        this.npcItemsInv.setIdleItemMounted(this.npcItemsInv.getMeleeWeaponMounted());
        this.setCurrentItemOrArmor(1, new ItemStack(DRRegistry.arthedain_boots));
        this.setCurrentItemOrArmor(2, new ItemStack(DRRegistry.arthedain_leggings));
        this.setCurrentItemOrArmor(3, new ItemStack(DRRegistry.arthedain_chestplate));
        this.setCurrentItemOrArmor(4, null);
        return data;
    }

    @Override
    public float getAlignmentBonus() {
        return 5.0f;
    }

    @Override
    public LOTRUnitTradeEntries getUnits() {
        return ARTHEDAIN_COMMANDER;
    }

    @Override
    public LOTRInvasions getWarhorn() {
        return DRInvasions.ARTHEDAIN;
    }

    @Override
    public boolean canTradeWith(EntityPlayer entityplayer) {
        return LOTRLevelData.getData(entityplayer).getAlignment(this.getFaction()) >= 200.0f && this.isFriendly(entityplayer);
    }

    @Override
    public void onUnitTrade(EntityPlayer entityplayer) {
        LOTRLevelData.getData(entityplayer).addAchievement(DRAchievement.trade_arthedain_commander);
    }

    @Override
    public boolean shouldTraderRespawn() {
        return true;
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
