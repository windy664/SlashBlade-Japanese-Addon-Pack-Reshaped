package cn.mmf.slashblade_addon.data;

import baguchan.tofucraft.registry.TofuBlocks;
import baguchan.tofucraft.registry.TofuItems;
import cn.mmf.slashblade_addon.SlashBladeAddon;
import cn.mmf.slashblade_addon.compat.SBATofuCraftItems;
import mods.flammpfeil.slashblade.data.builtin.SlashBladeBuiltInRegistry;
import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.item.SwordType;
import mods.flammpfeil.slashblade.recipe.RequestDefinition;
import mods.flammpfeil.slashblade.recipe.SlashBladeIngredient;
import mods.flammpfeil.slashblade.recipe.SlashBladeShapedRecipeBuilder;
import mods.flammpfeil.slashblade.registry.slashblade.EnchantmentDefinition;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

public class SlashBladeAddonRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public SlashBladeAddonRecipeProvider(PackOutput output) {
        super(output);
    }

    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, SBItems.slashblade_wood).pattern("  L").pattern(" L ").pattern("B  ").define('B', Items.WOODEN_SWORD).define('L', ItemTags.LOGS).unlockedBy(getHasName(Items.WOODEN_SWORD), has(Items.WOODEN_SWORD)).save(consumer);
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(TofuItems.TOFU_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(getItem(SBATofuCraftItems.TOFUMETAL_SLASHBLADE)), Ingredient.of(TofuBlocks.DIAMONDTOFU.get()), RecipeCategory.COMBAT, getItem(SBATofuCraftItems.TOFUDIAMOND_SLASHBLADE)).unlocks("has_item", has(getItem(SBATofuCraftItems.TOFUMETAL_SLASHBLADE))).save(consumer, SlashBladeAddon.prefix("tofu_diamond_blade"));
        SlashBladeShapedRecipeBuilder.shaped(SBATofuCraftItems.TOFUMETAL_SLASHBLADE)
                .pattern(" ST")
                .pattern("ST ")
                .pattern("WR ")
                .define('S', TofuItems.TOFUISHI.get())
                .define('R', Tags.Items.STRING)
                .define('W', Tags.Items.RODS_WOODEN)
                .define('T', TofuItems.TOFUMETAL.get())
                .unlockedBy(getHasName(SBItems.slashblade_wood), has(SBItems.slashblade_wood)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(SBATofuCraftItems.TOFUISHI_SLASHBLADE)
                .pattern(" SS")
                .pattern("SS ")
                .pattern("WR ")
                .define('S', TofuItems.TOFUISHI.get())
                .define('R', Tags.Items.STRING)
                .define('W', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(SBItems.slashblade_wood), has(SBItems.slashblade_wood)).save(consumer);

        //nihil
        SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.NIHIL.location())
                .pattern("SIS")
                .pattern("IBI")
                .pattern("SIS")
                .define('S', SBItems.proudsoul_sphere)
                .define('I', SBItems.proudsoul_ingot)
                .define('B', SBItems.slashblade)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.NIHILEX.location())
                .pattern("SNS")
                .pattern("IBI")
                .pattern("SDS")
                .define('S', SBItems.proudsoul_sphere)
                .define('I', SBItems.proudsoul_ingot)
                .define('N', Items.NETHER_STAR)
                .define('D', Items.DIAMOND_BLOCK)
                .define('B', SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
                     .name(SlashBladeAddonBuiltInRegistry.NIHIL.location())
                     .killCount(1000)
                     .proudSoul(100)
                     .refineCount(1)
                     .build()))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.NIHILUL.location())
                .pattern("SNS")
                .pattern("DBD")
                .pattern("SYS")
                .define('S', SBItems.slashblade)
                .define('Y', SlashBladeIngredient.of(RequestDefinition.Builder.newInstance().name(SlashBladeBuiltInRegistry.YAMATO.location()).build()))
                .define('N', Items.NETHER_STAR)
                .define('D', Items.DIAMOND_BLOCK)
                .define('B', SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
                     .name(SlashBladeAddonBuiltInRegistry.NIHILEX.location())
                     .killCount(3000)
                     .proudSoul(6500)
                     .refineCount(3)
                     .build()))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.CRIMSONCHERRY.location())
                .pattern("DUD")
                .pattern("DED")
                .pattern("DDD")
                .define('E', SlashBladeIngredient.of(RequestDefinition.Builder.newInstance().name(SlashBladeAddonBuiltInRegistry.NIHIL.location()).build()))
                .define('D', Items.DIAMOND_BLOCK)
                .define('U', SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
                     .name(SlashBladeAddonBuiltInRegistry.NIHILEX.location())
                     .killCount(3000)
                     .proudSoul(6500)
                     .refineCount(3)
                     .build()))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.NIHILBX.location())
                .pattern("DDD")
                .pattern("CSU")
                .pattern("DDD")
                .define('S', SBItems.slashblade)
                .define('D', Items.DIAMOND_BLOCK)
                .define('C', SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
                     .name(SlashBladeAddonBuiltInRegistry.CRIMSONCHERRY.location())
                     .killCount(3000)
                     .proudSoul(6500)
                     .refineCount(3)
                     .build()))
                .define('U', SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
                     .name(SlashBladeAddonBuiltInRegistry.NIHILUL.location())
                     .killCount(3000)
                     .proudSoul(6500)
                     .refineCount(3)
                     .build()))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        //WA
        SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.KATANA.location())
                .pattern("  P")
                .pattern(" B ")
                .pattern("S  ")
                .define('P', SBItems.proudsoul_ingot)
                .define('S', Items.IRON_SWORD)
                .define('B', SlashBladeIngredient.of(SBItems.slashblade_silverbamboo, RequestDefinition.Builder.newInstance().addSwordType(SwordType.BROKEN).build()))
                .unlockedBy(getHasName(SBItems.slashblade_silverbamboo), has(SBItems.slashblade_silverbamboo)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.TACHI.location())
                .pattern("  P")
                .pattern(" B ")
                .pattern("S  ")
                .define('P', SBItems.proudsoul_sphere)
                .define('S', Items.IRON_SWORD)
                .define('B', SlashBladeIngredient.of(SBItems.slashblade_silverbamboo, RequestDefinition.Builder.newInstance().addSwordType(SwordType.BROKEN).build()))
                .unlockedBy(getHasName(SBItems.slashblade_silverbamboo), has(SBItems.slashblade_silverbamboo)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.BLUE.location())
                .pattern("BCI")
                .pattern("CI ")
                .pattern("SL ")
                .define('B', Items.BLUE_DYE)
                .define('C', Items.COAL_BLOCK)
                .define('I', SBItems.proudsoul_ingot)
                .define('S', Items.STICK)
                .define('L', Items.STRING)
                .unlockedBy(getHasName(SBItems.proudsoul_ingot), has(SBItems.proudsoul_ingot)).save(consumer);

        //BladeMaster
        SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.GREEN_MIST.location())
            .pattern("PRE")
            .pattern("RE ")
            .pattern("BGC")
            .define('P', SBItems.proudsoul_sphere)
            .define('R', Items.REDSTONE_BLOCK)
            .define('E', Items.EMERALD_BLOCK)
            .define('G', Items.GOLD_BLOCK)
            .define('C', Items.CHERRY_LEAVES)
            .define('B', SlashBladeIngredient.of
            (
                RequestDefinition.Builder.newInstance()
                .name(SlashBladeBuiltInRegistry.MURAMASA.location())
                .killCount(1000)
                .proudSoul(10000)
                .refineCount(25)
                .addEnchantment
                (
                    new EnchantmentDefinition(ForgeRegistries.ENCHANTMENTS.getKey(Enchantments.POWER_ARROWS), 3)
                )
                .build()
            ))
            .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.AQUABLAZE.location())
            .pattern("PRW")
            .pattern("RL ")
            .pattern("BGC")
            .define('P', SBItems.proudsoul_sphere)
            .define('R', Items.REDSTONE_BLOCK)
            .define('W', Items.WATER_BUCKET)
            .define('L', Items.LAVA_BUCKET)
            .define('G', Items.GOLD_BLOCK)
            .define('C', Items.CHERRY_LEAVES)
            .define('B', SlashBladeIngredient.of
            (
                RequestDefinition.Builder.newInstance()
                .name(SlashBladeBuiltInRegistry.MURAMASA.location())
                .killCount(1000)
                .proudSoul(10000)
                .refineCount(25)
                .addEnchantment
                (
                    new EnchantmentDefinition(ForgeRegistries.ENCHANTMENTS.getKey(Enchantments.FIRE_PROTECTION), 1)
                )
                .build()
            ))
            .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.MOONLIGHT_CHERRY.location())
            .pattern("PRQ")
            .pattern("RL ")
            .pattern("BGC")
            .define('P', SBItems.proudsoul_sphere)
            .define('R', Items.REDSTONE_BLOCK)
            .define('Q', Items.QUARTZ_BLOCK)
            .define('L', Items.GLOWSTONE)
            .define('G', Items.GOLD_BLOCK)
            .define('C', Items.CHERRY_LEAVES)
            .define('B', SlashBladeIngredient.of
            (
                RequestDefinition.Builder.newInstance()
                .name(SlashBladeBuiltInRegistry.MURAMASA.location())
                .killCount(1000)
                .proudSoul(10000)
                .refineCount(25)
                .addEnchantment
                (
                    new EnchantmentDefinition(ForgeRegistries.ENCHANTMENTS.getKey(Enchantments.THORNS), 1)
                )
              .build()
            ))
            .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        //Dark Raven:Snow Crow

        SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.SNOW_CROW.location())
                .pattern(" FQ")
                .pattern("SQ ")
                .pattern("B  ")
                .define('F', Items.FEATHER)
                .define('S', Items.SNOWBALL)
                .define('Q', Items.QUARTZ_BLOCK)
                .define('B', SlashBladeIngredient.of(RequestDefinition.Builder.newInstance().name(SlashBladeBuiltInRegistry.DOUTANUKI.location()).build()))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        }

        public Item getItem(ResourceLocation item) {
            return ForgeRegistries.ITEMS.getValue(item);
        }
}
