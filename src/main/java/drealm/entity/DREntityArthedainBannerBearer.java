package drealm.entity;

import drealm.item.DRItemBanner;
import lotr.common.entity.npc.LOTRBannerBearer;
import lotr.common.entity.npc.LOTREntityGondorSoldier;
import lotr.common.item.LOTRItemBanner;
import net.minecraft.world.World;

public class DREntityArthedainBannerBearer extends DREntityArthedainSoldier implements LOTRBannerBearer {
    public DREntityArthedainBannerBearer(World world) {
        super(world);
    }

    @Override
    public LOTRItemBanner.BannerType getBannerType() {
        return DRItemBanner.ARTHEDAIN;
    }
}
