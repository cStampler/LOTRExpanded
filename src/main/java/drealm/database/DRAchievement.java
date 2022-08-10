package drealm.database;

import java.util.*;

import drealm.util.DRCommander;
import lotr.common.*;
import lotr.common.LOTRAchievement.Category;
import lotr.common.recipe.LOTRRecipesArmorDyes;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;

public class DRAchievement {
	private static Map<ItemArmor.ArmorMaterial, LOTRAchievement> armorAchievements = new HashMap<>();

	public static LOTRAchievement trade_red_dwarf_smith;
	public static LOTRAchievement trade_red_dwarf_miner;
	public static LOTRAchievement trade_red_dwarf_commander;

	public static LOTRAchievement trade_red_dwarf_merchant;
	public static LOTRAchievement kill_red_dwarf;
	public static LOTRAchievement kill_rhudaur_man;
	public static LOTRAchievement marry_red_dwarf;
	public static LOTRAchievement do_miniquest_red_mountains;
	public static LOTRAchievement smelt_red_dwarf_steel;
	public static LOTRAchievement wear_full_red_dwarven;
	public static LOTRAchievement use_red_dwarven_table;

	public static LOTRAchievement trade_wind_dwarf_smith;
	public static LOTRAchievement trade_wind_dwarf_miner;
	public static LOTRAchievement trade_wind_dwarf_commander;
	public static LOTRAchievement trade_wind_dwarf_merchant;
	public static LOTRAchievement kill_wind_dwarf;
	public static LOTRAchievement marry_wind_dwarf;
	public static LOTRAchievement do_miniquest_wind_mountains;
	public static LOTRAchievement smelt_wind_dwarf_steel;
	public static LOTRAchievement wear_full_wind_dwarven;
	public static LOTRAchievement use_wind_dwarven_table;


	public static LOTRAchievement do_miniquest_cardolan;
	public static LOTRAchievement do_miniquest_arthedain;
	public static LOTRAchievement do_miniquest_rhudaur;

	public static LOTRAchievement enter_rhudaur;
	public static LOTRAchievement use_rhudaur_crafting_table;
	public static LOTRAchievement enter_cardolan;
	public static LOTRAchievement enter_arthedain;
	public static LOTRAchievement kill_arthedain_man;

	public static LOTRAchievement trade_arthedain_commander;
	public static LOTRAchievement use_arthedain_table;
	public static LOTRAchievement wear_arthedain_armor;
	public static LOTRAchievement wear_cardolan_armor;
	public static LOTRAchievement wear_rhudaur_armor;
	public static LOTRAchievement trade_arthedain_smith;

	private static LOTRAchievement createArmorAchievement(LOTRAchievement.Category category, int id, Item item, String name) {
		if (!(item instanceof ItemArmor)) {
			throw new IllegalArgumentException("Invalid armor achievement item, name: " + name + " for LOTR achievement category " + category);
		}
		LOTRAchievement achievement = new LOTRAchievement(category, id, item, name);
		armorAchievements.put(((ItemArmor) item).getArmorMaterial(), achievement);
		return achievement;
	}

	public static void onInit() {
		smelt_red_dwarf_steel = new LOTRAchievement(Category.OROCARNI, 1, DRRegistry.red_dwarf_steel, "smeltRedDwarfSteel");
		kill_red_dwarf = new LOTRAchievement(Category.OROCARNI, 2, LOTRMod.dwarfBone, "killRedDwarf").setRequiresEnemy(DRFaction.RED_MOUNTAINS).createTitle();
		wear_full_red_dwarven = DRAchievement.createArmorAchievement(Category.OROCARNI, 3, DRRegistry.body_red_dwarven, "wearFullRedDwarven");
		use_red_dwarven_table = new LOTRAchievement(Category.OROCARNI, 4, DRRegistry.red_dwarven_table, "useRedDwarvenTable").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		trade_red_dwarf_smith = new LOTRAchievement(Category.OROCARNI, 5, LOTRMod.silverCoin, "tradeRedDwarfSmith").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		trade_red_dwarf_miner = new LOTRAchievement(Category.OROCARNI, 6, LOTRMod.silverCoin, "tradeRedDwarfMiner").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		trade_red_dwarf_commander = new LOTRAchievement(Category.OROCARNI, 7, LOTRMod.silverCoin, "tradeRedDwarfCommander").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		trade_red_dwarf_merchant = new LOTRAchievement(Category.OROCARNI, 8, LOTRMod.silverCoin, "tradeRedDwarfMerchant").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		marry_red_dwarf = new LOTRAchievement(Category.OROCARNI, 9, LOTRMod.dwarvenRing, "marryRedDwarf").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		do_miniquest_red_mountains = new LOTRAchievement(Category.OROCARNI, 10, LOTRMod.redBook, "doMiniquestRedMountains").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		trade_red_dwarf_smith = new LOTRAchievement(Category.OROCARNI, 11, LOTRMod.silverCoin, "tradeRedDwarfSmith").setRequiresAlly(DRFaction.RED_MOUNTAINS);

		smelt_wind_dwarf_steel = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 12, DRRegistry.wind_dwarf_steel, "smeltWindDwarfSteel");
		kill_wind_dwarf = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 13, LOTRMod.dwarfBone, "killWindDwarf").setRequiresEnemy(DRFaction.WIND_MOUNTAINS).createTitle();
		wear_full_wind_dwarven = DRAchievement.createArmorAchievement(DRAchievementCategory.WIND_MOUNTAINS, 14, DRRegistry.body_wind_dwarven, "wearFullWindDwarven");
		use_wind_dwarven_table = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 15, DRRegistry.wind_dwarven_table, "useWindDwarvenTable").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		trade_wind_dwarf_smith = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 16, LOTRMod.silverCoin, "tradeWindDwarfSmith").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		trade_wind_dwarf_miner = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 17, LOTRMod.silverCoin, "tradeWindDwarfMiner").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		trade_wind_dwarf_commander = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 18, LOTRMod.silverCoin, "tradeWindDwarfCommander").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		trade_wind_dwarf_merchant = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 19, LOTRMod.silverCoin, "tradeWindDwarfMerchant").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		marry_wind_dwarf = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 20, LOTRMod.dwarvenRing, "marryWindDwarf").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		do_miniquest_wind_mountains = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 21, LOTRMod.redBook, "doMiniquestWindMountains").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		trade_wind_dwarf_smith = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 22, LOTRMod.silverCoin, "tradeWindDwarfSmith").setRequiresAlly(DRFaction.WIND_MOUNTAINS);

		trade_arthedain_smith = new LOTRAchievement(DRAchievementCategory.ARTHEDAIN, 23, LOTRMod.silverCoin, "tradeArthedainSmith").setRequiresAlly(DRFaction.ARTHEDAIN);
		kill_arthedain_man = new LOTRAchievement(DRAchievementCategory.ARTHEDAIN, 24, LOTRMod.bodyBone, "killArthedainMan").setRequiresEnemy(DRFaction.ARTHEDAIN).createTitle();
		trade_arthedain_commander = new LOTRAchievement(DRAchievementCategory.ARTHEDAIN,25, LOTRMod.silverCoin, "tradeArthedainCommander").setRequiresAlly(DRFaction.ARTHEDAIN);
		use_arthedain_table = new LOTRAchievement(DRAchievementCategory.ARTHEDAIN, 26,DRRegistry.arthedain_table, "useArthedainTable").setRequiresAlly(DRFaction.ARTHEDAIN);
		wear_arthedain_armor = DRAchievement.createArmorAchievement(DRAchievementCategory.ARTHEDAIN,27, DRRegistry.arthedain_chestplate, "wearFullArthedain");
		do_miniquest_arthedain = new LOTRAchievement(DRAchievementCategory.ARTHEDAIN, 28, LOTRMod.redBook, "doMiniquestArthedain").setRequiresAlly(DRFaction.ARTHEDAIN);
		do_miniquest_cardolan = new LOTRAchievement(DRAchievementCategory.CARDOLAN, 29, LOTRMod.redBook, "doMiniquestCardolan").setRequiresAlly(DRFaction.CARDOLAN);
		do_miniquest_rhudaur = new LOTRAchievement(DRAchievementCategory.RHUDAUR, 30, LOTRMod.redBook, "doMiniquestRhudaur").setRequiresAlly(DRFaction.RHUDAUR);
		kill_rhudaur_man = new LOTRAchievement(DRAchievementCategory.RHUDAUR, 31, LOTRMod.bodyBone, "killRhudaurMan").setRequiresEnemy(DRFaction.RHUDAUR).createTitle();
		use_rhudaur_crafting_table = new LOTRAchievement(DRAchievementCategory.RHUDAUR, 32, DRRegistry.rhudaur_table, "useRhudaurCraftingTable").setRequiresAlly(DRFaction.RHUDAUR);
		wear_rhudaur_armor = DRAchievement.createArmorAchievement(DRAchievementCategory.RHUDAUR,33, DRRegistry.rhudaur_chestplate, "wearFullRhudaur");
		wear_cardolan_armor = DRAchievement.createArmorAchievement(DRAchievementCategory.CARDOLAN,34, DRRegistry.cardolan_chestplate, "wearFullCardolan");
	}

	public static void runAchievementCheck(EntityPlayer player) {
		ItemArmor.ArmorMaterial material = DRMaterial.getFullArmorMaterial(player);
		if (armorAchievements.containsKey(material)) {
			LOTRLevelData.getData(player).addAchievement(armorAchievements.get(material));
		}
	}

	public static class DRAchievementCategory {
		public static LOTRAchievement.Category WIND_MOUNTAINS;
		public static LOTRAchievement.Category ARTHEDAIN;
		public static LOTRAchievement.Category CARDOLAN;
		public static LOTRAchievement.Category RHUDAUR;


		public static void onInit() {
			ARTHEDAIN = DRCommander.addAchievementCategory("ARTHEDAIN", DRFaction.ARTHEDAIN);
			CARDOLAN = DRCommander.addAchievementCategory("CARDOLAN", DRFaction.CARDOLAN);
			RHUDAUR = DRCommander.addAchievementCategory("RHUDAUR", DRFaction.RHUDAUR);
			WIND_MOUNTAINS = DRCommander.addAchievementCategory("WIND_MOUNTAINS", DRFaction.WIND_MOUNTAINS);
		}
	}

}
