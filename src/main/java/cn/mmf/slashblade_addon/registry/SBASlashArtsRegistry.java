package cn.mmf.slashblade_addon.registry;

import cn.mmf.slashblade_addon.SlashBladeAddon;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SBASlashArtsRegistry
{
    public static final DeferredRegister<SlashArts> SLASH_ARTS = DeferredRegister.create(SlashArts.REGISTRY_KEY, SlashBladeAddon.MODID);

    public static final RegistryObject<SlashArts> RAPID_BLISTERING_SWORDS = SLASH_ARTS.register("rapid_blistering_swords", () -> new SlashArts((e) -> SBAComboStateRegistry.RAPID_BLISTERING_SWORDS.getId()));
    public static final RegistryObject<SlashArts> SPIRAL_EDGE = SLASH_ARTS.register("spiral_edge", () -> new SlashArts((e) -> SBAComboStateRegistry.SPIRAL_EDGE.getId()));
    public static final RegistryObject<SlashArts> GALE_SWORDS = SLASH_ARTS.register("gale_swords", () -> new SlashArts((e) -> SBAComboStateRegistry.GALE_SWORDS.getId()));
}
