package com.baublelicious;

import com.baublelicious.config.Config;
import com.baublelicious.network.NetworkRegister;
import com.baublelicious.items.BaubleliciousItems;
import com.baublelicious.network.GuiHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "required-after:Baubles@[1.0.1.4,);", guiFactory = ModInfo.GUI_FACTORY_CLASS)
public class Baublelicious {
  @Instance(ModInfo.MOD_ID)
  public static Baublelicious instance;

  @SidedProxy(clientSide = "com.baublelicious.client.ClientProxy", serverSide = "com.baublelicious.CommonProxy")
  public static CommonProxy proxy;

  public static CreativeTabs tabBaublelicious = new CreativeTabs("Baublelicious") {
    @Override
    public Item getTabIconItem() {
      return BaubleliciousItems.ItemNecklaceDiving;
    }
  };

  public static Logger log;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    Config.init(event.getSuggestedConfigurationFile());
    log = event.getModLog();

    proxy.registerRenderThings();

    proxy.preInit(event);

    NetworkRegister.registerMessages();
    FMLCommonHandler.instance().bus().register(new Config());
  }


  @EventHandler
  public void init(FMLInitializationEvent event) {
    NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    proxy.init();
  }

  @EventHandler
  public void load(FMLInitializationEvent event) {
    proxy.registerRenderThings();
  }
}