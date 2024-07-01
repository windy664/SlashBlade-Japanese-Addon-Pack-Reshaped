package cn.mmf.slashblade_addon.data;

import cn.mmf.slashblade_addon.SlashBladeAddon;
import cn.mmf.slashblade_addon.registry.SBASlashArtsRegistry;
import mods.flammpfeil.slashblade.item.SwordType;
import mods.flammpfeil.slashblade.registry.SlashArtsRegistry;
import mods.flammpfeil.slashblade.registry.slashblade.EnchantmentDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.PropertiesDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.RenderDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class SlashBladeAddonBuiltInRegistry {

    //nihil
    public static final ResourceKey<SlashBladeDefinition> NIHIL = register("nihil");
    public static final ResourceKey<SlashBladeDefinition> NIHILEX = register("nihilex");
    public static final ResourceKey<SlashBladeDefinition> NIHILBX = register("nihilbx");
    public static final ResourceKey<SlashBladeDefinition> NIHILUL = register("nihilul");
    public static final ResourceKey<SlashBladeDefinition> CRIMSONCHERRY = register("crimsoncherry");

    //WA
    public static final ResourceKey<SlashBladeDefinition> KATANA = register("katana");
    public static final ResourceKey<SlashBladeDefinition> TACHI = register("tachi");
    public static final ResourceKey<SlashBladeDefinition> BLUE = register("blue");

    //BladeMaster
    public static final ResourceKey<SlashBladeDefinition> GREEN_MIST = register("green_mist");
    public static final ResourceKey<SlashBladeDefinition> AQUABLAZE = register("aquablaze");
    public static final ResourceKey<SlashBladeDefinition> MOONLIGHT_CHERRY = register("moonlight_cherry");

    public static void registerAll(BootstapContext<SlashBladeDefinition> bootstrap) {
        //nihil
        bootstrap.register(NIHIL,
           new SlashBladeDefinition(SlashBladeAddon.prefix("nihil"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/nihil/nihil.png"))
                .modelName(SlashBladeAddon.prefix("model/nihil/nihil.obj")).build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(8.0F)
                .maxDamage(45)
                .slashArtsType(SlashArtsRegistry.DRIVE_HORIZONTAL.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 2),
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 1),
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 1))));

        bootstrap.register(NIHILEX,
           new SlashBladeDefinition(SlashBladeAddon.prefix("nihilex"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/nihil/nihilex.png"))
                .modelName(SlashBladeAddon.prefix("model/nihil/nihil.obj")).build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(10.0F)
                .maxDamage(60)
                .slashArtsType(SlashArtsRegistry.WAVE_EDGE.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 2),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 2),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 1),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 2),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 1))));

        bootstrap.register(NIHILUL,
           new SlashBladeDefinition(SlashBladeAddon.prefix("nihilul"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/nihil/nihilul.png"))
                .modelName(SlashBladeAddon.prefix("model/nihil/nihil.obj")).build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(12.0F)
                .maxDamage(70)
                .slashArtsType(SlashArtsRegistry.WAVE_EDGE.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 3),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 2),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 2),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 3))));

        bootstrap.register(CRIMSONCHERRY,
           new SlashBladeDefinition(SlashBladeAddon.prefix("crimsoncherry"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/nihil/crimsoncherry.png"))
                .modelName(SlashBladeAddon.prefix("model/nihil/nihil.obj")).build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(11.0F)
                .maxDamage(65)
                .slashArtsType(SlashArtsRegistry.SAKURA_END.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 3),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 3),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 2))));

        bootstrap.register(NIHILBX,
           new SlashBladeDefinition(SlashBladeAddon.prefix("nihilbx"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/nihil/nihil_bx.png"))
                .modelName(SlashBladeAddon.prefix("model/nihil/nihil.obj")).build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(13.0F)
                .maxDamage(240)
                .slashArtsType(SlashArtsRegistry.SAKURA_END.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 2))));

        //WA
        bootstrap.register(KATANA,
           new SlashBladeDefinition(SlashBladeAddon.prefix("katana"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/wa/katana.png"))
                .modelName(SlashBladeAddon.prefix("model/wa/wa.obj")).build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(3.0F)
                .maxDamage(457)
                .defaultSwordType(List.of(SwordType.NONE)).build(), List.of()));

        bootstrap.register(TACHI,
           new SlashBladeDefinition(SlashBladeAddon.prefix("tachi"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/wa/tachi.png"))
                .modelName(SlashBladeAddon.prefix("model/wa/tachi.obj")).build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(3.0F)
                .maxDamage(457)
                .defaultSwordType(List.of(SwordType.NONE)).build(), List.of()));

        bootstrap.register(BLUE,
           new SlashBladeDefinition(SlashBladeAddon.prefix("blue"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/wa/blue.png"))
                .modelName(SlashBladeAddon.prefix("model/wa/wa.obj")).build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(7.0F)
                .maxDamage(75)
                .defaultSwordType(List.of(SwordType.NONE)).build(), List.of()));

        //BladeMaster
        bootstrap.register(GREEN_MIST,
           new SlashBladeDefinition(SlashBladeAddon.prefix("green_mist"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/blademaster/green_mist.png"))
                .modelName(SlashBladeAddon.prefix("model/blademaster/blademaster.obj")).build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(4.0F + Tiers.DIAMOND.getAttackDamageBonus())
                .maxDamage(60)
                .slashArtsType(SBASlashArtsRegistry.RAPID_BLISTERING_SWORDS.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 3),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 3))));

        bootstrap.register
        (
            AQUABLAZE,
            new SlashBladeDefinition
            (
                SlashBladeAddon.prefix("aquablaze"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/blademaster/aquablaze.png"))
                .modelName(SlashBladeAddon.prefix("model/blademaster/blademaster.obj")).build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(4.0F + Tiers.DIAMOND.getAttackDamageBonus())
                .maxDamage(60)
                .slashArtsType(SBASlashArtsRegistry.SPIRAL_EDGE.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of
                (
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 2),
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 1)
                )
            )
        );

        bootstrap.register
        (
            MOONLIGHT_CHERRY,
            new SlashBladeDefinition
            (
                SlashBladeAddon.prefix("moonlight_cherry"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/blademaster/moonlightcherry.png"))
                .modelName(SlashBladeAddon.prefix("model/blademaster/blademaster.obj")).build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(4.0F + Tiers.DIAMOND.getAttackDamageBonus())
                .maxDamage(60)
                .slashArtsType(SBASlashArtsRegistry.GALE_SWORDS.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of
                (
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 1),
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5)
                )
            )
        );
    }

    private static ResourceKey<SlashBladeDefinition> register(String id) {
        return ResourceKey.create(SlashBladeDefinition.REGISTRY_KEY, SlashBladeAddon.prefix(id));
    }

    private static ResourceLocation getEnchantmentID(Enchantment enchantment) {
        return ForgeRegistries.ENCHANTMENTS.getKey(enchantment);
    }
}
