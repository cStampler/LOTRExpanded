package drealm.entity;

import drealm.database.DRRegistry;
import lotr.common.LOTRMod;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import lotr.common.entity.npc.LOTREntityGondorMan;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityArthedainLevyman extends DREntityArthedain{
    private static int[] leatherDyes = new int[] {10855845, 8026746, 5526612, 3684408, 8350297, 10388590, 4799795, 5330539, 4211801, 2632504};

    public DREntityArthedainLevyman(World world) {
        super(world);
        this.addTargetTasks(true);
    }

    @Override
    protected EntityAIBase createGondorAttackAI() {
        return new LOTREntityAIAttackOnCollide(this, 1.4, true);
    }

    @Override
    public void setupNPCGender() {
        this.familyInfo.setMale(true);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        data = super.onSpawnWithEgg(data);
        int i = rand.nextInt(7);
        switch (i) {
            case 0:
                npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.arthedain_sword));
                break;
            case 1:
            case 2:
                npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.arthedain_pike));
                break;
            case 3:
            case 4:
                npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.arthedain_axe));
                break;
            case 5:
                npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.arthedain_spear));
                break;
            default:
                break;
        }
        if (rand.nextInt(6) == 0) {
            npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
            npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.arthedain_spear));
        }
        npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
        this.setCurrentItemOrArmor(1, new ItemStack(Items.leather_boots));
        this.setCurrentItemOrArmor(2, new ItemStack(Items.leather_leggings));
        setCurrentItemOrArmor(3, new ItemStack(DRRegistry.arthedain_chestplate));
        return data;
    }


    @Override
    public float getAlignmentBonus() {
        return 2.0f;
    }

    @Override
    public String getSpeechBank(EntityPlayer entityplayer) {
        if(this.isDrunkard()) {
            return "rangerNorth/drunkard/neutral";
        }
        if(this.isFriendly(entityplayer)) {
            return "rangerNorth/man/friendly";
        }
        return "rangerNorth/man/hostile";
    }
}
