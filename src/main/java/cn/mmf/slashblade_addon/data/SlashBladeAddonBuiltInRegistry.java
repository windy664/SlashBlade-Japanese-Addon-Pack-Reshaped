package cn.mmf.slashblade_addon.data;

import cn.mmf.slashblade_addon.SlashBladeAddon;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.registry.slashblade.RenderDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import org.apache.commons.compress.utils.Lists;

public class SlashBladeAddonBuiltInRegistry {

    public static void registerAll(BootstapContext<SlashBladeDefinition> bootstrap) {

    }

    private static ResourceKey<SlashBladeDefinition> register(String id) {
        ResourceKey<SlashBladeDefinition> loc = ResourceKey.create(SlashBladeDefinition.REGISTRY_KEY, SlashBladeAddon.prefix(id));
        return loc;
    }
}
