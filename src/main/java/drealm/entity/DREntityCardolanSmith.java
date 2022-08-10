package drealm.entity;


import drealm.database.DRAchievement;
import drealm.database.DRRegistry;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTRTradeEntries;
import lotr.common.entity.npc.LOTRTradeEntries.TradeType;
import lotr.common.entity.npc.LOTRTradeEntry;
import lotr.common.entity.npc.LOTRTradeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityCardolanSmith extends DREntityCardolan implements LOTRTradeable.Smith {
    public static final LOTRTradeEntries CARDOLAN_SMITH_BUY = new LOTRTradeEntries(TradeType.BUY, new LOTRTradeEntry(new ItemStack(DRRegistry.cardolan_table), 100), new LOTRTradeEntry(new ItemStack(LOTRMod.blacksmithHammer), 18), new LOTRTradeEntry(new ItemStack(DRRegistry.cardolan_sword), 16), new LOTRTradeEntry(new ItemStack(DRRegistry.cardolan_spear), 18), new LOTRTradeEntry(new ItemStack(DRRegistry.cardolan_bow), 18), new LOTRTradeEntry(new ItemStack(DRRegistry.cardolan_pike), 18), new LOTRTradeEntry(new ItemStack(DRRegistry.cardolan_axe), 15), new LOTRTradeEntry(new ItemStack(DRRegistry.cardolan_pickaxe), 14), new LOTRTradeEntry(new ItemStack(DRRegistry.cardolan_shovel), 12), new LOTRTradeEntry(new ItemStack(DRRegistry.cardolan_helmet), 25), new LOTRTradeEntry(new ItemStack(DRRegistry.cardolan_chestplate), 36), new LOTRTradeEntry(new ItemStack(DRRegistry.cardolan_leggings), 30), new LOTRTradeEntry(new ItemStack(DRRegistry.cardolan_boots), 22), new LOTRTradeEntry(new ItemStack(DRRegistry.brick,4, 8), 10));
    public static final LOTRTradeEntries CARDOLAN_SMITH_SELL = new LOTRTradeEntries(TradeType.SELL, new LOTRTradeEntry(new ItemStack(Items.iron_ingot), 3), new LOTRTradeEntry(new ItemStack(Blocks.stone,8), 4), new LOTRTradeEntry(new ItemStack(Items.coal, 2, 32767), 1), new LOTRTradeEntry(new ItemStack(Items.gold_ingot), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.copper), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.tin), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.bronze), 3), new LOTRTradeEntry(new ItemStack(Items.string, 3), 1), new LOTRTradeEntry(new ItemStack(LOTRMod.diamond), 25), new LOTRTradeEntry(new ItemStack(LOTRMod.emerald), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.sapphire), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.ruby), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.opal), 10), new LOTRTradeEntry(new ItemStack(LOTRMod.amber), 10), new LOTRTradeEntry(new ItemStack(LOTRMod.amethyst), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.topaz), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.pearl), 25), new LOTRTradeEntry(new ItemStack(Items.cooked_beef), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_porkchop), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.muttonCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_chicken), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.gammon), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_fished), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.rabbitCooked), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.deerCooked), 3), new LOTRTradeEntry(new ItemStack(Items.bread), 2), new LOTRTradeEntry(new ItemStack(Items.lava_bucket), 16));

    public DREntityCardolanSmith(World world) {
        super(world);
        this.addTargetTasks(false);
    }

    @Override
    public boolean canTradeWith(EntityPlayer entityplayer) {
        return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 100.0f && isFriendly(entityplayer);
    }

    @Override
    protected void dropFewItems(boolean flag, int i) {
        super.dropFewItems(flag, i);
        dropItem(Items.iron_ingot, 1 + rand.nextInt(3) + rand.nextInt(i + 1));
    }

    @Override
    public float getAlignmentBonus() {
        return 2.0f;
    }

    @Override
    public LOTRTradeEntries getBuyPool() {
        return CARDOLAN_SMITH_BUY;
    }

    @Override
    public LOTRTradeEntries getSellPool() {
        return CARDOLAN_SMITH_SELL;
    }

    @Override
    public String getSpeechBank(EntityPlayer entityplayer) {
        if (isFriendly(entityplayer)) {
            if (canTradeWith(entityplayer)) {
                return "redDwarf/smith/friendly";
            }
            return "redDwarf/smith/neutral";
        }
        return "redDwarf/dwarf/hostile";
    }

    @Override
    public void onPlayerTrade(EntityPlayer entityplayer, TradeType type, ItemStack itemstack) {
        LOTRLevelData.getData(entityplayer).addAchievement(DRAchievement.trade_arthedain_smith);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        data = super.onSpawnWithEgg(data);
        npcItemsInv.setMeleeWeapon(new ItemStack(LOTRMod.blacksmithHammer));
        npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
        return data;
    }

    @Override
    public void setupNPCGender() {
        familyInfo.setMale(true);
    }

    @Override
    public boolean shouldTraderRespawn() {
        return true;
    }
}
