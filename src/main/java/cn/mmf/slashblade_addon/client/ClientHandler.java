package cn.mmf.slashblade_addon.client;

import cn.mmf.slashblade_addon.compat.SBATofuCraftItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientHandler {
    @SubscribeEvent
    public static void doClientStuff(final FMLClientSetupEvent event) {
        SBATofuCraftItems.doClientStuff(event);
    }

    @SubscribeEvent
    public static void Baked(final ModelEvent.ModifyBakingResult event) {
        {
            SBATofuCraftItems.baked(event);
        }

    }
}
