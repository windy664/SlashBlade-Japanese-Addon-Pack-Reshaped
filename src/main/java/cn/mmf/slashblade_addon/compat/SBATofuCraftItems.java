package cn.mmf.slashblade_addon.compat;

import baguchan.tofucraft.registry.TofuItemTier;
import cn.mmf.slashblade_addon.SlashBladeAddon;
import cn.mmf.slashblade_addon.item.TofuSlashBladeItem;
import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

public class SBATofuCraftItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SlashBladeAddon.MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final ResourceLocation TOFUISHI_SLASHBLADE = new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_ishi");
    public static final ResourceLocation TOFUMETAL_SLASHBLADE = new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_metal");
    public static final ResourceLocation TOFUDIAMOND_SLASHBLADE = new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_diamond");

    public static void register(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.ITEMS, helper -> {

            helper.register(new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_ishi"),
                    new TofuSlashBladeItem(TofuItemTier.SOLID, 3, -2.4F, 300,new Item.Properties()).setTexture(SlashBlade.prefix("model/tofuishi_blade.png")));
            helper.register(new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_metal"),
                    new TofuSlashBladeItem(TofuItemTier.METAL, 4, -2.4F, 600,new Item.Properties()).setTexture(SlashBlade.prefix("model/tofumetal_blade.png")));
            helper.register(new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_diamond"),
                    new TofuSlashBladeItem(TofuItemTier.TOFUDIAMOND, 5, -2.4F, 1200,new Item.Properties()).setTexture(SlashBlade.prefix("model/tofudiamond_blade.png")));

        });
    }
}
