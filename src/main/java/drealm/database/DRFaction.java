package drealm.database;

import java.util.EnumSet;

import drealm.database.DRAchievement.DRAchievementCategory;
import drealm.map.DRWaypoint;
import drealm.util.DRCommander;
import lotr.common.*;
import lotr.common.fac.*;
import lotr.common.world.map.LOTRWaypoint;

public class DRFaction {
	public static LOTRFaction RED_MOUNTAINS;
	public static LOTRFaction WIND_MOUNTAINS;
	public static LOTRFaction RHUDAUR;
	public static LOTRFaction ARTHEDAIN;
	public static LOTRFaction CARDOLAN;

	public static void onInit() {
		DRFaction.setupRelations();
		DRFaction.setupMapInfo();
		DRFaction.setupRanks();
		DRFaction.setupControlZones();
	}

	public static void preInit() {
		DRFaction.setupFactions();
	}



	private static void setupControlZones() {
		DRCommander.addControlZone(RED_MOUNTAINS, new LOTRControlZone(2437, 898, 454));
		DRCommander.addControlZone(WIND_MOUNTAINS, new LOTRControlZone(2500, 1535, 292));
		DRCommander.addControlZone(WIND_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.MORANNON, 70));
		DRCommander.addControlZone(WIND_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.DIMRILL_DALE, 1));
		DRCommander.addControlZone(RED_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.MORANNON, 70));
		DRCommander.addControlZone(RED_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.DIMRILL_DALE, 1));
		DRCommander.addControlZone(WIND_MOUNTAINS, new LOTRControlZone(DRWaypoint.KHIBIL_TARAG, 50));
		DRCommander.addControlZone(RED_MOUNTAINS, new LOTRControlZone(DRWaypoint.BRAGAZGATHOL, 30));

		DRCommander.addControlZone(RHUDAUR, new LOTRControlZone(LOTRWaypoint.WEATHERTOP, 25));
		DRCommander.addControlZone(RHUDAUR,  new LOTRControlZone(DRWaypoint.FORNOT,20));
		DRCommander.addControlZone(RHUDAUR,  new LOTRControlZone(DRWaypoint.ANUMINAS,20));
		DRCommander.addControlZone(RHUDAUR,  new LOTRControlZone(LOTRWaypoint.GREENWAY_CROSSROADS,25));
		DRCommander.addControlZone(RHUDAUR,  new LOTRControlZone(DRWaypoint.CARDOLAN_BORDER_OUTPOST,20));


		DRCommander.addControlZone(ARTHEDAIN,  new LOTRControlZone(DRWaypoint.FORNOT,25));
		DRCommander.addControlZone(ARTHEDAIN,  new LOTRControlZone(DRWaypoint.ANUMINAS,25));
		DRCommander.addControlZone(ARTHEDAIN, new LOTRControlZone(LOTRWaypoint.WEATHERTOP, 10));
		DRCommander.addControlZone(ARTHEDAIN,  new LOTRControlZone(LOTRWaypoint.GREENWAY_CROSSROADS,25));

		DRCommander.addControlZone(CARDOLAN,  new LOTRControlZone(LOTRWaypoint.GREENWAY_CROSSROADS,25));
		DRCommander.addControlZone(CARDOLAN,  new LOTRControlZone(DRWaypoint.CAR_ANDROS,25));
		DRCommander.addControlZone(CARDOLAN, new LOTRControlZone(LOTRWaypoint.WEATHERTOP, 10));
		DRCommander.addControlZone(CARDOLAN,  new LOTRControlZone(DRWaypoint.CARDOLAN_BORDER_OUTPOST,20));
	}


	private static void setupFactions() {
		EnumSet<LOTRFaction.FactionType> enumSetFreeDwarf = EnumSet.of(LOTRFaction.FactionType.TYPE_FREE, LOTRFaction.FactionType.TYPE_DWARF);
		EnumSet<LOTRFaction.FactionType> enumSetGoodHuman = EnumSet.of(LOTRFaction.FactionType.TYPE_MAN, LOTRFaction.FactionType.TYPE_MAN);
		EnumSet<LOTRFaction.FactionType> enumSetEvilHuman = EnumSet.of(LOTRFaction.FactionType.TYPE_ORC, LOTRFaction.FactionType.TYPE_MAN);
		EnumSet<LOTRFaction.FactionType> enumSetEvilDwarf = EnumSet.of(LOTRFaction.FactionType.TYPE_ORC, LOTRFaction.FactionType.TYPE_DWARF);
		RED_MOUNTAINS = DRCommander.addFaction("RED_MOUNTAINS", 0x570000, LOTRDimension.DimensionRegion.EAST, enumSetFreeDwarf);
		WIND_MOUNTAINS = DRCommander.addFaction("WIND_MOUNTAINS", 0xCEA863, LOTRDimension.DimensionRegion.EAST, enumSetEvilDwarf);
		ARTHEDAIN = DRCommander.addFaction("ARTHEDAIN", 0x857D7D, LOTRDimension.DimensionRegion.WEST, enumSetGoodHuman);
		CARDOLAN = DRCommander.addFaction("CARDOLAN", 0x1F6741, LOTRDimension.DimensionRegion.WEST, enumSetGoodHuman);
		RHUDAUR = DRCommander.addFaction("RHUDAUR", 0x6B3A3A, LOTRDimension.DimensionRegion.WEST, enumSetEvilHuman);

		RED_MOUNTAINS.approvesWarCrimes = false;
		RHUDAUR.approvesWarCrimes = true;
		WIND_MOUNTAINS.approvesWarCrimes = false;
		ARTHEDAIN.approvesWarCrimes = false;

	}

	private static void setupMapInfo() {
		RED_MOUNTAINS.factionMapInfo = new LOTRMapRegion(2437, 898, 454);
		WIND_MOUNTAINS.factionMapInfo = new LOTRMapRegion(2500, 1535, 292);
		ARTHEDAIN.factionMapInfo = new LOTRMapRegion(862, 679, 100);
		CARDOLAN.factionMapInfo = new LOTRMapRegion(870, 897, 100);
		RHUDAUR.factionMapInfo = new LOTRMapRegion(986, 726, 100);

	}

	private static void setupRanks() {
		DRCommander.setFactionAchievementCategory(RED_MOUNTAINS, LOTRAchievement.Category.OROCARNI);
		DRCommander.addFactionRank(RED_MOUNTAINS, 10.0F, "guest").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 50.0F, "friend").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		DRCommander.addFactionRank(RED_MOUNTAINS, 200.0F, "axebearer").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 500.0F, "champion").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 1000.0F, "commander").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 1500.0F, "lord", true).makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 3000.0F, "uzbad", true).makeAchievement().makeTitle();

		DRCommander.setFactionAchievementCategory(WIND_MOUNTAINS, DRAchievementCategory.WIND_MOUNTAINS);
		DRCommander.addFactionRank(WIND_MOUNTAINS, 10.0F, "guest").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 50.0F, "friend").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 200.0F, "axebearer").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 500.0F, "champion").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 1000.0F, "commander").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 1500.0F, "lord", true).makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 3000.0F, "uzbad", true).makeAchievement().makeTitle();

		DRCommander.setFactionAchievementCategory(ARTHEDAIN, DRAchievementCategory.ARTHEDAIN);
		DRCommander.addFactionRank(ARTHEDAIN, 10.0F, "guest").makeAchievement().makeTitle();
		DRCommander.addFactionRank(ARTHEDAIN, 50.0F, "friend").makeAchievement().makeTitle();
		DRCommander.addFactionRank(ARTHEDAIN, 100.0F, "trusted").makeAchievement().makeTitle();
		DRCommander.addFactionRank(ARTHEDAIN, 200.0F, "champion").makeAchievement().makeTitle();
		DRCommander.addFactionRank(ARTHEDAIN, 500.0F, "warlord").makeAchievement().makeTitle();
		DRCommander.addFactionRank(ARTHEDAIN, 1000.0F, "commander").makeAchievement().makeTitle();
		DRCommander.addFactionRank(ARTHEDAIN, 1500.0F, "lord").makeAchievement().makeTitle();
		DRCommander.addFactionRank(ARTHEDAIN, 3000.0F, "highlord", true).makeAchievement().makeTitle();

		DRCommander.setFactionAchievementCategory(CARDOLAN, DRAchievementCategory.CARDOLAN);
		DRCommander.addFactionRank(CARDOLAN, 10.0F, "guest").makeAchievement().makeTitle();
		DRCommander.addFactionRank(CARDOLAN, 50.0F, "friend").makeAchievement().makeTitle();
		DRCommander.addFactionRank(CARDOLAN, 100.0F, "trusted").makeAchievement().makeTitle();
		DRCommander.addFactionRank(CARDOLAN, 200.0F, "champion").makeAchievement().makeTitle();
		DRCommander.addFactionRank(CARDOLAN, 500.0F, "warlord").makeAchievement().makeTitle();
		DRCommander.addFactionRank(CARDOLAN, 1000.0F, "commander").makeAchievement().makeTitle();
		DRCommander.addFactionRank(CARDOLAN, 1500.0F, "lord").makeAchievement().makeTitle();
		DRCommander.addFactionRank(CARDOLAN, 3000.0F, "highlord", true).makeAchievement().makeTitle();

		DRCommander.setFactionAchievementCategory(RHUDAUR, DRAchievementCategory.RHUDAUR);
		DRCommander.addFactionRank(RHUDAUR, 10.0F, "guest").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RHUDAUR, 50.0F, "friend").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RHUDAUR, 100.0F, "trusted").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RHUDAUR, 200.0F, "champion").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RHUDAUR, 500.0F, "warlord").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RHUDAUR, 1000.0F, "commander").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RHUDAUR, 1500.0F, "lord").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RHUDAUR, 3000.0F, "highlord", true).makeAchievement().makeTitle();


	}

	private static void setupRelations() {
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.GUNDABAD, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.MORDOR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.RHUDEL, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.ANGMAR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.ISENGARD, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.DOL_GULDUR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.DORWINION, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.HALF_TROLL, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.GONDOR, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.ROHAN, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.DALE, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.BLUE_MOUNTAINS, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.DURINS_FOLK, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, DRFaction.WIND_MOUNTAINS, LOTRFactionRelations.Relation.MORTAL_ENEMY);

		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, LOTRFaction.GUNDABAD, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, LOTRFaction.MORDOR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, LOTRFaction.RHUDEL, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, LOTRFaction.ANGMAR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, LOTRFaction.ISENGARD, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, LOTRFaction.DOL_GULDUR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, LOTRFaction.DORWINION, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, LOTRFaction.HALF_TROLL, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, LOTRFaction.GONDOR, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, LOTRFaction.ROHAN, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, LOTRFaction.DALE, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, LOTRFaction.BLUE_MOUNTAINS, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, LOTRFaction.DURINS_FOLK, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, DRFaction.CARDOLAN, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(ARTHEDAIN, DRFaction.RHUDAUR, LOTRFactionRelations.Relation.MORTAL_ENEMY);

		LOTRFactionRelations.setDefaultRelations(CARDOLAN, LOTRFaction.GUNDABAD, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(CARDOLAN, LOTRFaction.MORDOR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(CARDOLAN, LOTRFaction.RHUDEL, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(CARDOLAN, LOTRFaction.ANGMAR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(CARDOLAN, LOTRFaction.ISENGARD, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(CARDOLAN, LOTRFaction.DOL_GULDUR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(CARDOLAN, LOTRFaction.DORWINION, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(CARDOLAN, LOTRFaction.HALF_TROLL, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(CARDOLAN, LOTRFaction.GONDOR, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(CARDOLAN, LOTRFaction.ROHAN, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(CARDOLAN, LOTRFaction.DALE, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(CARDOLAN, LOTRFaction.BLUE_MOUNTAINS, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(CARDOLAN, LOTRFaction.DURINS_FOLK, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(CARDOLAN, DRFaction.ARTHEDAIN, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(CARDOLAN, DRFaction.RHUDAUR, LOTRFactionRelations.Relation.MORTAL_ENEMY);


		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, WIND_MOUNTAINS, LOTRFactionRelations.Relation.NEUTRAL);

		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.MORDOR, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.RHUDEL, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.HIGH_ELF, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.ANGMAR, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.WOOD_ELF, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.GUNDABAD, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.LOTHLORIEN, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.ISENGARD, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.DOL_GULDUR, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.DORWINION, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.NEAR_HARAD, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.HALF_TROLL, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.GONDOR, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.ROHAN, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.DALE, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.BLUE_MOUNTAINS, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.DURINS_FOLK, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, DRFaction.RED_MOUNTAINS, LOTRFactionRelations.Relation.MORTAL_ENEMY);

		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.MORDOR, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.RHUDEL, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.HIGH_ELF, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.ANGMAR, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.WOOD_ELF, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.GUNDABAD, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.LOTHLORIEN, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.ISENGARD, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.DOL_GULDUR, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.DORWINION, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.NEAR_HARAD, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.HALF_TROLL, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.GONDOR, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.ROHAN, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.DALE, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.BLUE_MOUNTAINS, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, LOTRFaction.DURINS_FOLK, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, DRFaction.RED_MOUNTAINS, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, DRFaction.CARDOLAN, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RHUDAUR, DRFaction.ARTHEDAIN, LOTRFactionRelations.Relation.MORTAL_ENEMY);
	}
}
