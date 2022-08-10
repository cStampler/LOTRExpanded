package drealm.entity;

import drealm.database.DRRegistry;
import drealm.item.DRItemBanner;
import lotr.common.entity.npc.LOTRBannerBearer;
import lotr.common.item.LOTRItemBanner;
import net.minecraft.world.World;

public class DREntityRhudaurBannerBearer extends DREntityRhudaurSoldier implements LOTRBannerBearer {
    public DREntityRhudaurBannerBearer(World world) {
        super(world);
    }


    @Override
    public LOTRItemBanner.BannerType getBannerType() {
        return DRItemBanner.RHUDAUR;
    }
}
