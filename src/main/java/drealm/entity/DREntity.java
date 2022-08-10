package drealm.entity;

import lotr.common.entity.LOTREntities;

public class DREntity {
	public static int id = 3000;

	public static void preInit() {
		LOTREntities.registerCreature(DREntityRedDwarf.class, "RedDwarf", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfWarrior.class, "RedDwarfWarrior", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfAxeThrower.class, "RedDwarfAxeThrower", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfFireThrower.class, "RedDwarfFireThrower", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfBannerBearer.class, "RedDwarfBannerBearer", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfCommander.class, "RedDwarfCommander", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfMiner.class, "RedDwarfMiner", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfMerchant.class, "RedDwarfMerchant", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfSmith.class, "RedDwarfSmith", id++, 0x570000, 0x570000);

		LOTREntities.registerCreature(DREntityArthedain.class, "ArthedainMan", id++, 0x808080, 0x808080);
		LOTREntities.registerCreature(DREntityArthedainLevyman.class,"ArthedainLevy", id++,0x808080, 0x808080);
		LOTREntities.registerCreature(DREntityArthedainCaptain.class, "ArthedainCommander", id++,0x808080, 0x808080);
		LOTREntities.registerCreature(DREntityArthedainSmith.class, "ArthedainSmith", id++,0x808080, 0x808080);
		LOTREntities.registerCreature(DREntityArthedainSoldier.class, "ArthedainSoldier", id++,0x808080, 0x808080);
		LOTREntities.registerCreature(DREntityArthedainArcher.class, "ArthedainArcher", id++,0x808080, 0x808080);
		LOTREntities.registerCreature(DREntityArthedainBannerBearer.class, "ArthedainBannerBearer", id++,0x808080, 0x808080);

		LOTREntities.registerCreature(DREntityRhudaurMan.class,"RhudaurMan", id++,0xc18080, 0x570000);
		LOTREntities.registerCreature(DREntityRhudaurSoldier.class,"RhudaurSoldier", id++,0xc18080, 0x570000);
		LOTREntities.registerCreature(DREntityRhudaurBannerBearer.class,"RhudaurBannerBearer", id++,0xc18080, 0x570000);
		LOTREntities.registerCreature(DREntityRhudaurArcher.class,"RhudaurArcher", id++,0xc18080, 0x570000);
		LOTREntities.registerCreature(DREntityRhudaurCommander.class,"RhudaurCommander", id++,0xc18080, 0x570000);
		LOTREntities.registerCreature(DREntityRhudaurSmith.class,"RhudaurSmith", id++,0xc18080, 0x570000);

		LOTREntities.registerCreature(DREntityCardolan.class,"CardolanMan", id++,0xc18080, 0x570000);
		LOTREntities.registerCreature(DREntityCardolanSoldier.class,"CardolanSoldier", id++,0xc18080, 0x570000);
		LOTREntities.registerCreature(DREntityCardolanBannerBearer.class,"CardolanBannerBearer", id++,0xc18080, 0x570000);
		LOTREntities.registerCreature(DREntityCardolanArcher.class,"CardolanArcher", id++,0xc18080, 0x570000);
		LOTREntities.registerCreature(DREntityCardolanCaptain.class,"CardolanCaptain", id++,0xc18080, 0x570000);
		LOTREntities.registerCreature(DREntityCardolanSmith.class,"CardolanSmith", id++,0xc18080, 0x570000);

		LOTREntities.registerCreature(DREntityWindDwarf.class, "WindDwarf", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfWarrior.class, "WindDwarfWarrior", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfAxeThrower.class, "WindDwarfAxeThrower", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfCrossbower.class, "WindDwarfCrossbower", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfBannerBearer.class, "WindDwarfBannerBearer", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfCommander.class, "WindDwarfCommander", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfMiner.class, "WindDwarfMiner", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfMerchant.class, "WindDwarfMerchant", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfSmith.class, "WindDwarfSmith", id++, 0xCEA863, 0xCEA863);
	}
}
