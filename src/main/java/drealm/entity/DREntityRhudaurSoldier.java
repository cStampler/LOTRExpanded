package drealm.entity;

import drealm.database.DRRegistry;
import drealm.database.DRShields;
import lotr.common.LOTRMod;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityRhudaurSoldier extends DREntityRhudaurMan {
    private static ItemStack[] weapons = new ItemStack[] {new ItemStack(DRRegistry.rhudaur_sword), new ItemStack(DRRegistry.rhudaur_pike), new ItemStack(DRRegistry.rhudaur_spear)};
    private static ItemStack[] helmets = new ItemStack[] {new ItemStack(DRRegistry.rhudaur_helmet), new ItemStack(LOTRMod.helmetFur)};
    private static ItemStack[] bodies = new ItemStack[] {new ItemStack(DRRegistry.rhudaur_chestplate), new ItemStack(DRRegistry.rhudaur_chestplate), new ItemStack(DRRegistry.rhudaur_chestplate), new ItemStack(DRRegistry.rhudaur_chestplate)};
    private static ItemStack[] legs = new ItemStack[] {new ItemStack(DRRegistry.rhudaur_leggings), new ItemStack(DRRegistry.rhudaur_leggings), new ItemStack(DRRegistry.rhudaur_leggings), new ItemStack(DRRegistry.rhudaur_leggings)};
    private static ItemStack[] boots = new ItemStack[] {new ItemStack(DRRegistry.rhudaur_boots), new ItemStack(DRRegistry.rhudaur_boots), new ItemStack(DRRegistry.rhudaur_boots), new ItemStack(DRRegistry.rhudaur_boots)};

    public DREntityRhudaurSoldier(World world) {
        super(world);
        this.npcShield = DRShields.ALIGNMENT_RHUDAUR;
    }

    @Override
    public EntityAIBase getHillmanAttackAI() {
        return new LOTREntityAIAttackOnCollide(this, 1.6, false);
    }

    @Override
    public void setupNPCGender() {
        this.familyInfo.setMale(true);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        data = super.onSpawnWithEgg(data);
        int i = this.rand.nextInt(weapons.length);
        this.npcItemsInv.setMeleeWeapon(weapons[i].copy());
        this.npcItemsInv.setIdleItem(this.npcItemsInv.getMeleeWeapon());
        i = this.rand.nextInt(boots.length);
        this.setCurrentItemOrArmor(1, boots[i].copy());
        i = this.rand.nextInt(legs.length);
        this.setCurrentItemOrArmor(2, legs[i].copy());
        i = this.rand.nextInt(bodies.length);
        this.setCurrentItemOrArmor(3, bodies[i].copy());
        if(this.rand.nextInt(5) != 0) {
            i = this.rand.nextInt(helmets.length);
            this.setCurrentItemOrArmor(4, helmets[i].copy());
        }
        return data;
    }

    @Override
    public float getAlignmentBonus() {
        return 2.0f;
    }

    @Override
    public void dropHillmanItems(boolean flag, int i) {
    }
}