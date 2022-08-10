package drealm.item;

import drealm.database.DRFaction;
import drealm.util.DRCommander;
import lotr.common.item.LOTRItemBanner;

public class DRItemBanner {
	public static LOTRItemBanner.BannerType RED_MOUNTAINS;
	public static LOTRItemBanner.BannerType WIND_MOUNTAINS;
	public static LOTRItemBanner.BannerType CARDOLAN;
	public static LOTRItemBanner.BannerType ARTHEDAIN;
	public static LOTRItemBanner.BannerType RHUDAUR;

	public static void preInit() {
		RED_MOUNTAINS = DRCommander.addBanner("red_mountains", DRFaction.RED_MOUNTAINS);
		WIND_MOUNTAINS = DRCommander.addBanner("wind_mountains", DRFaction.WIND_MOUNTAINS);
		CARDOLAN = DRCommander.addBanner("cardolan", DRFaction.CARDOLAN);
		ARTHEDAIN = DRCommander.addBanner("arthedain", DRFaction.ARTHEDAIN);
		RHUDAUR = DRCommander.addBanner("rhudaurs", DRFaction.RHUDAUR);
	}
}
