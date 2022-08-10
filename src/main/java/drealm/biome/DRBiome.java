package drealm.biome;

import lotr.common.LOTRDimension;
import lotr.common.world.biome.LOTRBiome;

public class DRBiome {
	public static LOTRBiome redMountains;
	public static LOTRBiome redMountainsFoothills;
	public static LOTRBiome windMountains;
	public static LOTRBiome windMountainsFoothills;

	public static LOTRBiome arthedainPlains;

	public static LOTRBiome cardolanPlains;
	public static LOTRBiome rhudaurPlains;

	public static LOTRBiome windValley;


	public static void preInit() {
		for (int i : new int[] { 117, 118, 164, 165 }) {
			LOTRDimension.MIDDLE_EARTH.biomeList[i] = null;
		}
		redMountains = new DRBiomeRedMountains(117, true).setTemperatureRainfall(0.3f, 0.4f).setMinMaxHeight(1.5f, 2.0f).setColor(0x93714D).setBiomeName("redMountains");
		redMountainsFoothills = new DRBiomeRedMountainsFoothills(118, true).setTemperatureRainfall(0.7f, 0.4f).setMinMaxHeight(0.5f, 0.9f).setColor(0x999453).setBiomeName("redMountainsFoothills");
		windMountains = new DRBiomeWindMountains(164, true).setTemperatureRainfall(0.28f, 0.2f).setMinMaxHeight(2.0f, 2.0f).setColor(0xD3D3D4).setBiomeName("windMountains");
		windMountainsFoothills = new DRBiomeWindMountainsFoothills(165, true).setTemperatureRainfall(0.4f, 0.6f).setMinMaxHeight(0.5f, 0.6f).setColor(0x9A9F6B).setBiomeName("windMountainsFoothills");
		arthedainPlains = new DRBiomeArthedainPlains(171, true).setTemperatureRainfall(0.60f, 0.2f).setMinMaxHeight(0.2f, 0.5f).setColor(0x548725).setBiomeName("arthedain");
		cardolanPlains = new DRBiomeCardolan(172, true).setTemperatureRainfall(0.60f, 0.2f).setMinMaxHeight(0.2f, 0.5f).setColor(0x5a8335).setBiomeName("cardolan");
		rhudaurPlains = new DRBiomeRhudaur(173, true).setTemperatureRainfall(0.20f, 0.2f).setMinMaxHeight(0.2f, 0.5f).setColor(0x7b9743).setBiomeName("rhudaur");
		windValley = new DRBiomeWindMountains(174,true).setTemperatureRainfall(0.4f, 0.6f).setMinMaxHeight(0.2F, 0.3F).setColor(0x8fa248).setBiomeName("windMountainsValley");

	}
}