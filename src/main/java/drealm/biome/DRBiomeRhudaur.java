package drealm.biome;

import drealm.database.DRAchievement;
import drealm.entity.*;
import drealm.structure.DRStructureRhudaurCaptain;
import drealm.structure.DRStructureRhudaurHouse;
import drealm.structure.DRStructureRhudaurSmith;
import drealm.structure.DRStructureRhudaurVillage;
import drealm.util.DRCommander;
import lotr.common.LOTRAchievement;
import lotr.common.world.biome.LOTRBiomeGenLoneLands;
import lotr.common.world.biome.LOTRMusicRegion;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.LOTRWorldGenRuinedDunedainTower;
import lotr.common.world.structure2.*;
import lotr.common.world.village.LOTRVillageGenDunedain;

public class DRBiomeRhudaur extends LOTRBiomeGenLoneLands {

    public static final LOTRSpawnList ARTHEDAIN = DRCommander.newLOTRSpawnList(new LOTRSpawnEntry(DREntityRhudaurMan.class, 100, 4, 4), new LOTRSpawnEntry(DREntityRhudaurSoldier.class, 15, 1, 3), new LOTRSpawnEntry(DREntityRhudaurArcher.class, 15, 1, 3));
    public DRBiomeRhudaur(int i, boolean major) {
        super(i, major);
        this.npcSpawnList.clear();
        LOTRBiomeSpawnList.SpawnListContainer[] arrspawnListContainer = new LOTRBiomeSpawnList.SpawnListContainer[1];
        arrspawnListContainer[0] = LOTRBiomeSpawnList.entry(ARTHEDAIN, 10).setSpawnChance(200);
        this.npcSpawnList.newFactionList(500, 0.0f).add(arrspawnListContainer);
        LOTRBiomeSpawnList.SpawnListContainer[] arrspawnListContainer2 = new LOTRBiomeSpawnList.SpawnListContainer[1];
        arrspawnListContainer2[0] = LOTRBiomeSpawnList.entry(ARTHEDAIN, 10);
        this.npcSpawnList.newFactionList(0).add(arrspawnListContainer2);
        LOTRBiomeSpawnList.SpawnListContainer[] arrspawnListContainer3 = new LOTRBiomeSpawnList.SpawnListContainer[3];
        arrspawnListContainer3[0] = LOTRBiomeSpawnList.entry(LOTRSpawnList.GUNDABAD_ORCS, 10);
        arrspawnListContainer3[1] = LOTRBiomeSpawnList.entry(LOTRSpawnList.GUNDABAD_WARGS, 2);
        arrspawnListContainer3[2] = LOTRBiomeSpawnList.entry(LOTRSpawnList.GUNDABAD_URUKS, 1).setConquestThreshold(100.0f);
        this.npcSpawnList.newFactionList(1).add(arrspawnListContainer3);
        LOTRBiomeSpawnList.SpawnListContainer[] arrspawnListContainer4 = new LOTRBiomeSpawnList.SpawnListContainer[3];
        arrspawnListContainer4[0] = LOTRBiomeSpawnList.entry(LOTRSpawnList.ANGMAR_ORCS, 10);
        arrspawnListContainer4[1] = LOTRBiomeSpawnList.entry(LOTRSpawnList.ANGMAR_WARGS, 2);
        arrspawnListContainer4[2] = LOTRBiomeSpawnList.entry(LOTRSpawnList.ANGMAR_HILLMEN, 10);
        this.npcSpawnList.newFactionList(0).add(arrspawnListContainer4);
        this.clearBiomeVariants();
        this.variantChance = 0.3f;
        this.addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK);
        this.addBiomeVariant(LOTRBiomeVariant.FOREST, 1.0f);
        this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT, 1.0f);
        this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST, 1.0f);
        this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.2f);
        this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.2f);
        this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.2f);
        this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.2f);
        this.addBiomeVariant(LOTRBiomeVariant.FOREST_ASPEN, 0.2f);
        this.addBiomeVariant(LOTRBiomeVariant.FOREST_MAPLE, 0.2f);
        this.registerPlainsFlowers();
        this.decorator.clearVillages();
        this.decorator.clearRandomStructures();
        this.decorator.addRandomStructure(new DRStructureRhudaurHouse(false), 1000);
        this.decorator.addRandomStructure(new DRStructureRhudaurCaptain(false), 500);
        this.decorator.addRandomStructure(new DRStructureRhudaurSmith(false), 500);
        this.setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
        this.invasionSpawns.clearInvasions();
        this.invasionSpawns.addInvasion(LOTRInvasions.RANGER_NORTH, LOTREventSpawner.EventChance.COMMON);
        this.invasionSpawns.addInvasion(LOTRInvasions.GUNDABAD, LOTREventSpawner.EventChance.RARE);
        this.invasionSpawns.addInvasion(LOTRInvasions.GUNDABAD_WARG, LOTREventSpawner.EventChance.RARE);
        this.invasionSpawns.addInvasion(LOTRInvasions.ANGMAR_HILLMEN, LOTREventSpawner.EventChance.RARE);
        this.biomeColors.setGrass(7696686);
    }

    @Override
    public LOTRAchievement getBiomeAchievement() {
        return DRAchievement.enter_arthedain;
    }

    @Override
    public LOTRMusicRegion.Sub getBiomeMusic() {
        return LOTRMusicRegion.ERIADOR.getSubregion("angle");
    }

    @Override
    public float getTreeIncreaseChance() {
        return 0.5f;
    }

    @Override
    public float getChanceToSpawnAnimals() {
        return 0.2f;
    }
}
