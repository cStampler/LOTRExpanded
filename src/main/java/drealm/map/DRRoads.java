package drealm.map;

import drealm.util.DRCommander;
import lotr.common.world.map.LOTRWaypoint;

public class DRRoads {

	public static void onInit() {
		DRCommander.registerRoad("EastWind", LOTRWaypoint.KHAND_NORTH_ROAD, new int[] { 2043, 1357 }, new int[] { 2118, 1410 }, new int[] { 2216, 1518 }, new int[] { 2318, 1532 }, DRWaypoint.BRAGAZGATHOL);
		DRCommander.registerRoad("NorthWind", LOTRWaypoint.RHUN_EAST_CITY, DRWaypoint.BRAGAZGATHOL);

		DRCommander.registerRoad("NaragGund", LOTRWaypoint.RHUN_EAST_CITY, LOTRWaypoint.BALCARAS, new int[] { 2364, 1172 }, DRWaypoint.NARAG_GUND);
		DRCommander.registerRoad("KheledDum", DRWaypoint.KHELED_DUM, LOTRWaypoint.RHUN_ROAD_WAY, LOTRWaypoint.BALCARAS);
		DRCommander.registerRoad("KhibilTarag", DRWaypoint.KHIBIL_TARAG, new int[] { 2421, 1029 }, LOTRWaypoint.BALCARAS);
		DRCommander.registerRoad("WindGate", DRWaypoint.WINDGATE, DRWaypoint.LAKEWIND);
		DRCommander.registerRoad("Wind", DRWaypoint.WINDGATE, DRWaypoint.BRAGAZGATHOL);
		DRCommander.registerRoad("CardolanRoad", DRWaypoint.PINNATH_NIMREN, LOTRWaypoint.GREENWAY_CROSSROADS);
		DRCommander.registerRoad("CardolanBigRoad", DRWaypoint.PINNATH_NIMREN, DRWaypoint.CAR_ANDROS);
		DRCommander.registerRoad("TharbadOutpost", DRWaypoint.CARDOLAN_BORDER_OUTPOST, LOTRWaypoint.THARBAD);
		DRCommander.registerRoad("CardolanRoads", DRWaypoint.PINNATH_NIMREN, LOTRWaypoint.THARBAD);
		DRCommander.registerRoad("ArthedainRoad", LOTRWaypoint.OATBARTON, DRWaypoint.ANUMINAS);

	}
}
