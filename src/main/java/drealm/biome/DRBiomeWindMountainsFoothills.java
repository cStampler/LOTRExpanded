package drealm.biome;

import java.util.Random;

import drealm.structure.DRStructureWindMountainsSmithy;
import drealm.structure.DRStructureWindMountainsStronghold;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class DRBiomeWindMountainsFoothills extends DRBiomeWindMountains {
	public DRBiomeWindMountainsFoothills(int i, boolean major) {
		super(i, major);
		biomeTerrain.resetXZScale();
		biomeTerrain.resetHeightStretchFactor();
		decorator.biomeGemFactor = 0.75f;
		decorator.addRandomStructure(new DRStructureWindMountainsStronghold(false), 1200);
		decorator.addRandomStructure(new DRStructureWindMountainsSmithy(false), 750);
	}

	@Override
	protected void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
	}
}
