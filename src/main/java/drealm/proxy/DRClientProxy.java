package drealm.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.*;
import drealm.entity.*;
import drealm.render.*;
import drealm.util.DRCommander;
import lotr.client.fx.LOTREntityAlignmentBonus;
import lotr.client.render.entity.LOTRRenderAngmarHillman;
import lotr.client.render.entity.LOTRRenderDaleMan;
import lotr.client.render.entity.LOTRRenderGondorMan;
import lotr.common.entity.npc.LOTREntityGondorMan;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.*;
import net.minecraft.util.ResourceLocation;

public class DRClientProxy extends DRServerProxy implements IResourceManagerReloadListener {

	@Override
	public void onInit(FMLInitializationEvent event) {
		((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new DRClientProxy());
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		DRCommander.setClientMapImage(new ResourceLocation("drealm:map/map.png"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		DRRendererManager.preInit();
		RenderingRegistry.registerEntityRenderingHandler(DREntityRedDwarf.class, new DRRenderDwarf());
		RenderingRegistry.registerEntityRenderingHandler(DREntityRedDwarfSmith.class, new DRRenderDwarfSmith());
		RenderingRegistry.registerEntityRenderingHandler(DREntityRedDwarfCommander.class, new DRRenderDwarfCommander());
		RenderingRegistry.registerEntityRenderingHandler(DREntityRedDwarfMerchant.class, new DRRenderDwarfCommander());
		RenderingRegistry.registerEntityRenderingHandler(DREntityWindDwarf.class, new DRRenderDwarf());
		RenderingRegistry.registerEntityRenderingHandler(DREntityWindDwarfSmith.class, new DRRenderDwarfSmith());
		RenderingRegistry.registerEntityRenderingHandler(DREntityWindDwarfCommander.class, new DRRenderDwarfCommander());
		RenderingRegistry.registerEntityRenderingHandler(DREntityWindDwarfMerchant.class, new DRRenderDwarfCommander());
		RenderingRegistry.registerEntityRenderingHandler(DREntityArthedain.class, new DRRenderMan());
		RenderingRegistry.registerEntityRenderingHandler(DREntityCardolan.class, new DRRenderCMan());
		RenderingRegistry.registerEntityRenderingHandler(DREntityRhudaurMan.class, new DRRenderHillman(false));
	}
}
