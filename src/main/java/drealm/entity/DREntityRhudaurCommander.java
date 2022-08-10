package drealm.entity;

import drealm.database.DRRegistry;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRLevelData;
import lotr.common.entity.npc.LOTREntityAngmarHillmanWarrior;
import lotr.common.entity.npc.LOTRUnitTradeEntries;
import lotr.common.entity.npc.LOTRUnitTradeEntry;
import lotr.common.entity.npc.LOTRUnitTradeable;
import lotr.common.world.spawning.LOTRInvasions;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;



public class DREntityRhudaurCommander extends LOTREntityAngmarHillmanWarrior implements LOTRUnitTradeable {
    public DREntityRhudaurCommander(World world) {
        super(world);
        this.addTargetTasks(false);
    }

    public static final LOTRUnitTradeEntries RHUDAUR_COMMANDER = new LOTRUnitTradeEntries(200.0f, new LOTRUnitTradeEntry(DREntityRhudaurMan.class, 20, 0.0f), new LOTRUnitTradeEntry(DREntityRhudaurSoldier.class, 30, 50.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.FACTION), new LOTRUnitTradeEntry(DREntityRhudaurArcher.class, 50, 100.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.FACTION), new LOTRUnitTradeEntry(DREntityRhudaurBannerBearer.class, 50, 200.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.FACTION));


    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        data = super.onSpawnWithEgg(data);
        this.npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.rhudaur_sword));
        this.npcItemsInv.setIdleItem(this.npcItemsInv.getMeleeWeapon());
        this.setCurrentItemOrArmor(1, new ItemStack(DRRegistry.rhudaur_boots));
        this.setCurrentItemOrArmor(2, new ItemStack(DRRegistry.rhudaur_leggings));
        this.setCurrentItemOrArmor(3, new ItemStack(DRRegistry.rhudaur_chestplate));
        this.setCurrentItemOrArmor(4, null);
        return data;
    }

    @Override
    public float getAlignmentBonus() {
        return 5.0f;
    }

    @Override
    public LOTRUnitTradeEntries getUnits() {
        return RHUDAUR_COMMANDER;
    }

    @Override
    public LOTRInvasions getWarhorn() {
        return LOTRInvasions.ANGMAR_HILLMEN;
    }

    @Override
    public boolean canTradeWith(EntityPlayer entityplayer) {
        return LOTRLevelData.getData(entityplayer).getAlignment(this.getFaction()) >= 100.0f && this.isFriendly(entityplayer);
    }

    @Override
    public void onUnitTrade(EntityPlayer entityplayer) {
        LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.tradeAngmarHillmanChieftain);
    }

    @Override
    public boolean shouldTraderRespawn() {
        return true;
    }

    @Override
    public String getSpeechBank(EntityPlayer entityplayer) {
        if(this.isFriendly(entityplayer)) {
            if(this.canTradeWith(entityplayer)) {
                return "angmar/hillmanChieftain/friendly";
            }
            return "angmar/hillmanChieftain/neutral";
        }
        return "angmar/hillman/hostile";
    }
}