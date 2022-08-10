package drealm.map;

import drealm.database.DRFaction;
import drealm.util.DRCommander;
import lotr.common.world.map.LOTRWaypoint;

public class DRWaypoint {


	public static LOTRWaypoint PINNATH_NIMREN;
	public static LOTRWaypoint CAR_ANDROS;
	public static LOTRWaypoint CARDOLAN_BORDER_OUTPOST;
	public static LOTRWaypoint NARAG_GUND;
	public static LOTRWaypoint KHIBIL_TARAG;
	public static LOTRWaypoint KHELED_DUM;
	public static LOTRWaypoint RED_ROAD;
	public static LOTRWaypoint BRAGAZGATHOL;
	public static LOTRWaypoint LAKEWIND;
	public static LOTRWaypoint WINDGATE;
	public static LOTRWaypoint ANUMINAS;
	public static LOTRWaypoint FORNOT;

	public static LOTRWaypoint THARBAS;
	public static LOTRWaypoint GREENWAY_CROSSROAD;
	public static LOTRWaypoint WEATHERTOS;
	public static LOTRWaypoint ABARADA;

	public static LOTRWaypoint.Region Arthedain;

	public static void preInit() {
		DRCommander.disableWaypoint(LOTRWaypoint.FORNOST);
		DRCommander.disableWaypoint(LOTRWaypoint.ANNUMINAS);
		DRCommander.disableWaypoint(LOTRWaypoint.GREENWAY_CROSSROADS);
		DRCommander.disableWaypoint(LOTRWaypoint.THARBAD);
		DRCommander.disableWaypoint(LOTRWaypoint.WEATHERTOP);

		Arthedain = DRCommander.addWaypointRegion("ARTHEDAIN");

		FORNOT = DRCommander.addWaypoint("FORNOT", LOTRWaypoint.Region.SHIRE, DRFaction.ARTHEDAIN,897, 652);
		ANUMINAS = DRCommander.addWaypoint("ANUMINAS", LOTRWaypoint.Region.SHIRE, DRFaction.ARTHEDAIN,814, 661);

		WEATHERTOS = DRCommander.addWaypoint("WEATHERTOS", LOTRWaypoint.Region.LONE_LANDS, DRFaction.RHUDAUR,998, 723);
		ABARADA = DRCommander.addWaypoint("ABARADA", LOTRWaypoint.Region.LONE_LANDS, DRFaction.RHUDAUR,1029, 691);


		PINNATH_NIMREN = DRCommander.addWaypoint("PINNATH_NIMREN", LOTRWaypoint.Region.SHIRE, DRFaction.CARDOLAN, 894, 853);
		CAR_ANDROS = DRCommander.addWaypoint("CAR_ANDROS", LOTRWaypoint.Region.SHIRE, DRFaction.CARDOLAN, 808, 1011);
		CARDOLAN_BORDER_OUTPOST = DRCommander.addWaypoint("CARDOLAN_BORDER_OUTPOST", LOTRWaypoint.Region.SHIRE, DRFaction.CARDOLAN, 996,848);
		THARBAS = DRCommander.addWaypoint("THARBAS", LOTRWaypoint.Region.SHIRE, DRFaction.CARDOLAN, 979, 878);
		GREENWAY_CROSSROAD = DRCommander.addWaypoint("GREENWAY_CROSSROAD", LOTRWaypoint.Region.SHIRE, DRFaction.CARDOLAN, 920, 810);

		NARAG_GUND = DRCommander.addWaypoint("NARAG_GUND", LOTRWaypoint.Region.RHUN, DRFaction.RED_MOUNTAINS, 2579.0, 1262.0);
		KHIBIL_TARAG = DRCommander.addWaypoint("KHIBIL_TARAG", LOTRWaypoint.Region.RHUN, DRFaction.RED_MOUNTAINS, 2448.0, 952.0);
		KHELED_DUM = DRCommander.addWaypoint("KHELED_DUM", LOTRWaypoint.Region.RHUN, DRFaction.RED_MOUNTAINS, 2382.0, 570.0);
		BRAGAZGATHOL = DRCommander.addWaypoint("BRAGAZGATHOL", LOTRWaypoint.Region.RHUN, DRFaction.WIND_MOUNTAINS, 2362.0, 1573.0);
		LAKEWIND = DRCommander.addWaypoint("LAKEWIND", LOTRWaypoint.Region.RHUN, DRFaction.WIND_MOUNTAINS, 2544.0, 1632.0);
		WINDGATE = DRCommander.addWaypoint("WINDGATE", LOTRWaypoint.Region.RHUN, DRFaction.WIND_MOUNTAINS, 2477, 1641);

	}
}
