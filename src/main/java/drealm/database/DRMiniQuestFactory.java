package drealm.database;

import drealm.util.DRCommander;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.*;
import lotr.common.fac.LOTRFaction;
import lotr.common.quest.*;
import lotr.common.recipe.LOTRRecipeHaradRobesDye;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class DRMiniQuestFactory {
	public static LOTRMiniQuestFactory RED_MOUNTAINS;
	public static LOTRMiniQuestFactory WIND_MOUNTAINS;
	public static LOTRMiniQuestFactory CARDOLAN;
	public static LOTRMiniQuestFactory RHUDAUR;
	public static LOTRMiniQuestFactory ARTHEDAIN;

	private static void addMiniQuestsFactories() {
		RED_MOUNTAINS = DRCommander.addMiniQuestFactory("RED_MOUNTAINS", "redMountains");
		WIND_MOUNTAINS = DRCommander.addMiniQuestFactory("WIND_MOUNTAINS", "windMountains");
		CARDOLAN = DRCommander.addMiniQuestFactory("CARDOLAN", "cardolan");
		RHUDAUR = DRCommander.addMiniQuestFactory("RHUDAUR", "rhudaur");
		ARTHEDAIN = DRCommander.addMiniQuestFactory("ARTHEDAIN", "arthedain");

	}

	public static void onInit() {
		DRMiniQuestFactory.addMiniQuestsFactories();
		DRMiniQuestFactory.setupMiniQuestFactories();
	}

	private static void setupMiniQuestFactories() {
		// RED MOUNTAINS
		DRCommander.setMiniQuestFactoryAchievement(RED_MOUNTAINS, DRAchievement.do_miniquest_red_mountains);
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("mineMithril").setCollectItem(new ItemStack(LOTRMod.mithril), 1, 2).setRewardFactor(50.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(Items.gold_ingot), 3, 15).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.silver), 3, 15).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(Items.glowstone_dust), 5, 15).setRewardFactor(2.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.diamond), 1, 3).setRewardFactor(15.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.sapphire), 1, 3).setRewardFactor(12.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.opal), 1, 3).setRewardFactor(10.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.amethyst), 1, 3).setRewardFactor(10.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.hammer_red_dwarven), 1, 3).setRewardFactor(5.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.battleaxe_red_dwarven), 1, 3).setRewardFactor(5.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.throwing_axe_red_dwarven), 1, 4).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectDrink").setCollectItem(new ItemStack(LOTRMod.mugDwarvenAle), 2, 5).setRewardFactor(3.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestKillFaction.QFKillFaction("killMordor").setKillFaction(LOTRFaction.MORDOR, 20, 40));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestKillEntity.QFKillEntity("killOrc").setKillEntity(LOTREntityMordorOrc.class, 10, 30));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestKillEntity.QFKillEntity("killWarg").setKillEntity(LOTREntityMordorWarg.class, 10, 30));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestBounty.QFBounty("bounty"));

		// NEW FACTIONS
		DRCommander.setMiniQuestFactoryAchievement(ARTHEDAIN, DRAchievement.do_miniquest_arthedain);
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(Items.gold_ingot), 3, 15).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.silver), 3, 15).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(Items.glowstone_dust), 5, 15).setRewardFactor(2.0f));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.diamond), 1, 3).setRewardFactor(15.0f));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.sapphire), 1, 3).setRewardFactor(12.0f));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.opal), 1, 3).setRewardFactor(10.0f));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.amethyst), 1, 3).setRewardFactor(10.0f));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestCollect.QFCollect("forgeArnorWeapon").setCollectItem(new ItemStack(DRRegistry.arthedain_spear), 1, 3).setRewardFactor(5.0f));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestCollect.QFCollect("forgeArnorWeapon").setCollectItem(new ItemStack(DRRegistry.arthedain_pike), 1, 3).setRewardFactor(5.0f));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestCollect.QFCollect("forgeArnorWeapon").setCollectItem(new ItemStack(DRRegistry.arthedain_bow), 1, 4).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestCollect.QFCollect("collectDrink").setCollectItem(new ItemStack(LOTRMod.mugAle), 2, 5).setRewardFactor(3.0f));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestKillFaction.QFKillFaction("killRhudaur").setKillFaction(DRFaction.RHUDAUR, 20, 40));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestKillEntity.QFKillEntity("killOrc").setKillEntity(LOTREntityGundabadOrc.class, 10, 30));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestKillEntity.QFKillEntity("killWarg").setKillEntity(LOTREntityGundabadWarg.class, 10, 30));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestKillEntity.QFKillEntity("killOrc").setKillEntity(LOTREntityAngmarOrc.class, 10, 30));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestKillEntity.QFKillEntity("killWarg").setKillEntity(LOTREntityAngmarWarg.class, 10, 30));
		DRCommander.addMiniQuest(ARTHEDAIN, new LOTRMiniQuestBounty.QFBounty("bounty"));


		DRCommander.setMiniQuestFactoryAchievement(CARDOLAN, DRAchievement.do_miniquest_cardolan);
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(Items.gold_ingot), 3, 15).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.silver), 3, 15).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(Items.glowstone_dust), 5, 15).setRewardFactor(2.0f));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.diamond), 1, 3).setRewardFactor(15.0f));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.sapphire), 1, 3).setRewardFactor(12.0f));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.opal), 1, 3).setRewardFactor(10.0f));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.amethyst), 1, 3).setRewardFactor(10.0f));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestCollect.QFCollect("forgeArnorWeapon").setCollectItem(new ItemStack(DRRegistry.cardolan_spear), 1, 3).setRewardFactor(5.0f));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestCollect.QFCollect("forgeArnorWeapon").setCollectItem(new ItemStack(DRRegistry.cardolan_pike), 1, 3).setRewardFactor(5.0f));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestCollect.QFCollect("forgeArnorWeapon").setCollectItem(new ItemStack(DRRegistry.cardolan_bow), 1, 4).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestCollect.QFCollect("collectDrink").setCollectItem(new ItemStack(LOTRMod.mugAle), 2, 5).setRewardFactor(3.0f));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestKillFaction.QFKillFaction("killRhudaur").setKillFaction(DRFaction.RHUDAUR, 20, 40));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestKillEntity.QFKillEntity("killOrc").setKillEntity(LOTREntityGundabadOrc.class, 10, 30));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestKillEntity.QFKillEntity("killWarg").setKillEntity(LOTREntityGundabadWarg.class, 10, 30));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestKillEntity.QFKillEntity("killOrc").setKillEntity(LOTREntityAngmarOrc.class, 10, 30));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestKillEntity.QFKillEntity("killWarg").setKillEntity(LOTREntityAngmarWarg.class, 10, 30));
		DRCommander.addMiniQuest(CARDOLAN, new LOTRMiniQuestBounty.QFBounty("bounty"));

		DRCommander.setMiniQuestFactoryAchievement(RHUDAUR, DRAchievement.do_miniquest_rhudaur);
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(Items.gold_ingot), 3, 15).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.silver), 3, 15).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(Items.glowstone_dust), 5, 15).setRewardFactor(2.0f));
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.diamond), 1, 3).setRewardFactor(15.0f));
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.sapphire), 1, 3).setRewardFactor(12.0f));
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.opal), 1, 3).setRewardFactor(10.0f));
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.amethyst), 1, 3).setRewardFactor(10.0f));
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestCollect.QFCollect("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.rhudaur_spear), 1, 3).setRewardFactor(5.0f));
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestCollect.QFCollect("forgeArnorWeapon").setCollectItem(new ItemStack(DRRegistry.rhudaur_sword), 1, 3).setRewardFactor(5.0f));
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestCollect.QFCollect("forgeArnorWeapon").setCollectItem(new ItemStack(DRRegistry.rhudaur_pike), 1, 4).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestCollect.QFCollect("collectDrink").setCollectItem(new ItemStack(LOTRMod.mugAle), 2, 5).setRewardFactor(3.0f));
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestKillFaction.QFKillFaction("killGondor").setKillFaction(LOTRFaction.GONDOR, 20, 40));
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestKillFaction.QFKillFaction("killCardolan").setKillFaction(DRFaction.CARDOLAN, 20, 40));
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestKillFaction.QFKillFaction("killArthedain").setKillFaction(DRFaction.ARTHEDAIN, 20, 40));
		DRCommander.addMiniQuest(RHUDAUR, new LOTRMiniQuestBounty.QFBounty("bounty"));



		DRCommander.setMiniQuestFactoryAchievement(WIND_MOUNTAINS, DRAchievement.do_miniquest_wind_mountains);
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("mineMithril").setCollectItem(new ItemStack(LOTRMod.mithril), 1, 2).setRewardFactor(50.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(Items.gold_ingot), 3, 15).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.silver), 3, 15).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(Items.glowstone_dust), 5, 15).setRewardFactor(2.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.diamond), 1, 3).setRewardFactor(15.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.sapphire), 1, 3).setRewardFactor(12.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.opal), 1, 3).setRewardFactor(10.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.amethyst), 1, 3).setRewardFactor(10.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.hammer_wind_dwarven), 1, 3).setRewardFactor(5.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.battleaxe_wind_dwarven), 1, 3).setRewardFactor(5.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.throwing_axe_wind_dwarven), 1, 4).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectDrink").setCollectItem(new ItemStack(LOTRMod.mugDwarvenAle), 2, 5).setRewardFactor(3.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestKillFaction.QFKillFaction("killGondor").setKillFaction(LOTRFaction.GONDOR, 20, 40));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestKillFaction.QFKillFaction("killDale").setKillFaction(LOTRFaction.DALE, 20, 40));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestKillFaction.QFKillFaction("killElf").setKillFaction(LOTRFaction.WOOD_ELF, 20, 40));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestBounty.QFBounty("bounty"));

	}
}
