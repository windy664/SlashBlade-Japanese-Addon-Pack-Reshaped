package cn.mmf.slashblade_addon.compat;

import baguchan.tofucraft.registry.TofuItemTier;
import cn.mmf.slashblade_addon.SlashBladeAddon;
import cn.mmf.slashblade_addon.item.TofuSlashBladeItem;
import mods.flammpfeil.slashblade.SlashBladeCreativeGroup;
import mods.flammpfeil.slashblade.client.ClientHandler;
import mods.flammpfeil.slashblade.client.renderer.model.BladeModel;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import org.jetbrains.annotations.Nullable;

public class SBATofuCraftItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SlashBladeAddon.MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final ResourceLocation TOFUISHI_SLASHBLADE = new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_ishi");
    public static final ResourceLocation TOFUMETAL_SLASHBLADE = new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_metal");
    public static final ResourceLocation TOFUDIAMOND_SLASHBLADE = new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_diamond");

    public static void register(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.ITEMS, helper -> {

            helper.register(new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_ishi"),
                    new TofuSlashBladeItem(TofuItemTier.SOLID, 3, -2.4F, 200, new Item.Properties()).setTexture(SlashBladeAddon.prefix("model/tofuishi_katana.png")));
            helper.register(new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_metal"),
                    new TofuSlashBladeItem(TofuItemTier.METAL, 5, -2.4F, 500, new Item.Properties()).setTexture(SlashBladeAddon.prefix("model/tofumetal_katana.png")));
            helper.register(new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_diamond"),
                    new TofuSlashBladeItem(TofuItemTier.TOFUDIAMOND, 9, -2.4F, 1200, new Item.Properties()).setTexture(SlashBladeAddon.prefix("model/tofudiamond_katana.png")));

        });
    }

    public static void doClientStuff(final FMLClientSetupEvent event) {
        ItemProperties.register(getItem(TOFUISHI_SLASHBLADE), new ResourceLocation("slashblade:user"), new ClampedItemPropertyFunction() {
            @Override
            public float unclampedCall(ItemStack p_174564_, @Nullable ClientLevel p_174565_, @Nullable LivingEntity p_174566_, int p_174567_) {
                BladeModel.user = p_174566_;
                return 0;
            }
        });
        ItemProperties.register(getItem(TOFUMETAL_SLASHBLADE), new ResourceLocation("slashblade:user"), new ClampedItemPropertyFunction() {
            @Override
            public float unclampedCall(ItemStack p_174564_, @Nullable ClientLevel p_174565_, @Nullable LivingEntity p_174566_, int p_174567_) {
                BladeModel.user = p_174566_;
                return 0;
            }
        });
        ItemProperties.register(getItem(TOFUDIAMOND_SLASHBLADE), new ResourceLocation("slashblade:user"), new ClampedItemPropertyFunction() {
            @Override
            public float unclampedCall(ItemStack p_174564_, @Nullable ClientLevel p_174565_, @Nullable LivingEntity p_174566_, int p_174567_) {
                BladeModel.user = p_174566_;
                return 0;
            }
        });
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == SlashBladeCreativeGroup.SLASHBLADE_GROUP.getKey()) {
            event.accept(getItem(TOFUISHI_SLASHBLADE));
            event.accept(getItem(TOFUMETAL_SLASHBLADE));
            event.accept(getItem(TOFUDIAMOND_SLASHBLADE));
        }
    }

    public static Item getItem(ResourceLocation item) {
        return BuiltInRegistries.ITEM.get(item);
    }

    public static void baked(ModelEvent.ModifyBakingResult event) {
        ClientHandler.bakeBlade(getItem(TOFUISHI_SLASHBLADE), event);
        ClientHandler.bakeBlade(getItem(TOFUMETAL_SLASHBLADE), event);
        ClientHandler.bakeBlade(getItem(TOFUDIAMOND_SLASHBLADE), event);
    }
}
