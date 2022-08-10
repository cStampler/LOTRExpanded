package drealm.render;

import drealm.entity.DREntityArthedain;
import drealm.entity.DREntityCardolan;
import lotr.client.model.LOTRModelHuman;
import lotr.client.render.entity.LOTRRandomSkins;
import lotr.client.render.entity.LOTRRenderBiped;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class DRRenderCMan extends LOTRRenderBiped {
    private static LOTRRandomSkins skinsMale;
    private static LOTRRandomSkins skinsFemale;
    private static LOTRRandomSkins skinsSoldier;
    private static LOTRRandomSkins skinsShieldmaiden;
    protected ModelBiped outfitModel = new LOTRModelHuman(0.6f, false);

    public DRRenderCMan() {
        super(new LOTRModelHuman(), 0.5f);
        this.setRenderPassModel(this.outfitModel);
        skinsMale = LOTRRandomSkins.loadSkinsList("drealm:mob/man/rohan_male");
        skinsFemale = LOTRRandomSkins.loadSkinsList("drealm:mob/man/rohan_female");
        skinsSoldier = LOTRRandomSkins.loadSkinsList("drealm:mob/man/warrior");
        skinsShieldmaiden = LOTRRandomSkins.loadSkinsList("drealm:mob/man/shieldmaiden");
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity) {
        DREntityCardolan cardolan = (DREntityCardolan) entity;
            if(cardolan instanceof DREntityCardolan) {
                return skinsSoldier.getRandomSkin(cardolan);
            }
            return skinsMale.getRandomSkin(cardolan);
    }


    @Override
    public int shouldRenderPass(EntityLiving entity, int pass, float f) {
        if (pass == 0) {
            DREntityCardolan cardolan = (DREntityCardolan) entity;
            return super.shouldRenderPass(cardolan, pass, f);
        }
        return super.shouldRenderPass(entity, pass, f);
    }
}