package com.baublelicious.network;

import com.baublelicious.blocks.baubleliciousBlocks;
import com.baublelicious.entity.TileentityPedestal;
import com.baublelicious.handler.KeyHandler;
import com.baublelicious.renderer.ItemRendererPedestalBlock;
import com.baublelicious.renderer.PedestalRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;


public class ClientProxy extends CommonProxy {

  @Override
  public void init() {
    FMLCommonHandler.instance().bus().register(new KeyHandler());
  }


  @Override
  public void registerRenderThings() {
    ClientRegistry.bindTileEntitySpecialRenderer(TileentityPedestal.class, new PedestalRenderer());
    MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(baubleliciousBlocks.BlockPedestal), new ItemRendererPedestalBlock());
  }

}