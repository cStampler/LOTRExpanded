package drealm.proxy;

import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.IGuiHandler;
import drealm.block.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class DRServerProxy implements IGuiHandler {

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer entityplayer, World world, int i, int j, int k) {
		if (ID == 0) {
			return new DRBlockTableRedDwarven.Gui(entityplayer.inventory, world, i, j, k);
		}
		if (ID == 1) {
			return new DRBlockTableWindDwarven.Gui(entityplayer.inventory, world, i, j, k);
		}
		if(ID == 2){
			return new DRBlockTableArthedain.Gui(entityplayer.inventory, world, i, j, k);
		}
		if(ID == 3){
			return new DRBlockTableRhudaur.Gui(entityplayer.inventory, world, i, j, k);
		}
		if(ID == 4){
			return new DRBlockTableCardolan.Gui(entityplayer.inventory, world, i, j, k);
		}
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer entityplayer, World world, int i, int j, int k) {
		if (ID == 0) {
			return new DRBlockTableRedDwarven.Container(entityplayer.inventory, world, i, j, k);
		}
		if (ID == 1) {
			return new DRBlockTableWindDwarven.Container(entityplayer.inventory, world, i, j, k);
		}
		if(ID == 2) {
			return new DRBlockTableArthedain.Container(entityplayer.inventory, world, i, j, k);
		}
		if(ID == 3) {
			return new DRBlockTableRhudaur.Container(entityplayer.inventory, world, i, j, k);
		}
		if(ID == 4){
			return new DRBlockTableCardolan.Container(entityplayer.inventory, world, i, j, k);
		}
		return null;
	}

	public void onInit(FMLInitializationEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
	}
}