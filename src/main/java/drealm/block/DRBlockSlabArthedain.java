package drealm.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import drealm.database.DRRegistry;
import lotr.common.block.LOTRBlockSlabBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.IIcon;

public class DRBlockSlabArthedain extends LOTRBlockSlabBase {
    public DRBlockSlabArthedain(boolean flag) {
        super(flag, Material.rock, 1);
    }

    @Override
    @SideOnly(value = Side.CLIENT)
    public IIcon getIcon(int i, int j) {
        if (j == 0) {
            return DRRegistry.pillar.getIcon(i, 2);
        }
        return super.getIcon(i, j);
    }

    public static class SlabExDouble extends ItemSlab {
        public SlabExDouble(Block block) {
            super(block, (BlockSlab) DRRegistry.slab_single, (BlockSlab) DRRegistry.slab_double, true);
        }
    }

    public static class SlabExSingle extends ItemSlab {
        public SlabExSingle(Block block) {
            super(block, (BlockSlab) DRRegistry.slab_single, (BlockSlab) DRRegistry.slab_double, false);
        }
    }
}
