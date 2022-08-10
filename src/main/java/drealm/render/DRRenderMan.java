package drealm.render;

import drealm.entity.DREntityArthedain;
import drealm.entity.DREntityRhudaurMan;
import lotr.client.model.LOTRModelHuman;
import lotr.client.render.entity.LOTRRandomSkins;
import lotr.client.render.entity.LOTRRenderBiped;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.*;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.*;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class DRRenderMan extends LOTRRenderBiped {
    private static LOTRRandomSkins skinsMale;
    private static LOTRRandomSkins skinsFemale;
    private static LOTRRandomSkins skinsSoldier;
    private static LOTRRandomSkins skinsShieldmaiden;
    protected ModelBiped outfitModel = new LOTRModelHuman(0.6f, false);

    public DRRenderMan() {
        super(new LOTRModelHuman(), 0.5f);
        this.setRenderPassModel(this.outfitModel);
        skinsMale = LOTRRandomSkins.loadSkinsList("drealm:mob/man/rohan_male");
        skinsFemale = LOTRRandomSkins.loadSkinsList("drealm:mob/man/rohan_female");
        skinsSoldier = LOTRRandomSkins.loadSkinsList("drealm:mob/man/warrior");
        skinsShieldmaiden = LOTRRandomSkins.loadSkinsList("drealm:mob/man/shieldmaiden");
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity) {
        DREntityArthedain arthedain = (DREntityArthedain) entity;
            if(arthedain instanceof DREntityArthedain) {
                return skinsSoldier.getRandomSkin(arthedain);
            }
            return skinsMale.getRandomSkin(arthedain);
    }


    @Override
    public int shouldRenderPass(EntityLiving entity, int pass, float f) {
        if (pass == 0) {
            DREntityArthedain arthedain = (DREntityArthedain) entity;
            return super.shouldRenderPass(arthedain, pass, f);
        }
        return super.shouldRenderPass(entity, pass, f);
    }
}