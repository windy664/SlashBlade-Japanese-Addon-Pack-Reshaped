package cn.mmf.slashblade_addon.registry;

import cn.mmf.slashblade_addon.SlashBladeAddon;
import mods.flammpfeil.slashblade.registry.ComboStateRegistry;
import mods.flammpfeil.slashblade.specialattack.SlashArts;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class SBASlashArtsRegistry
{
    public static final DeferredRegister<SlashArts> SLASH_ARTS = DeferredRegister.create(SlashArts.REGISTRY_KEY, SlashBladeAddon.MODID);

    public static final Supplier<IForgeRegistry<SlashArts>> REGISTRY = SLASH_ARTS.makeRegistry(RegistryBuilder::new);

    public static final RegistryObject<SlashArts> RAPIDBLISTERINGSWORDS = SLASH_ARTS.register("rapid_blistering_swords", () -> new SlashArts((e) -> SBAComboStateRegistry.RAPID_BLISTERING_SWORDS.getId()));
}
