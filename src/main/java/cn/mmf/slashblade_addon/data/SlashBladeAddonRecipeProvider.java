package cn.mmf.slashblade_addon.data;

import baguchan.tofucraft.registry.TofuBlocks;
import baguchan.tofucraft.registry.TofuItems;
import cn.mmf.slashblade_addon.SlashBladeAddon;
import cn.mmf.slashblade_addon.compat.SBATofuCraftItems;
import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.recipe.SlashBladeShapedRecipeBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class SlashBladeAddonRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public SlashBladeAddonRecipeProvider(PackOutput output) {
        super(output);
    }

    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, SBItems.slashblade_wood).pattern("  L").pattern(" L ").pattern("B  ").define('B', Items.WOODEN_SWORD).define('L', ItemTags.LOGS).unlockedBy(getHasName(Items.WOODEN_SWORD), has(Items.WOODEN_SWORD)).save(consumer);
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(TofuItems.TOFU_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(getItem(SBATofuCraftItems.TOFUMETAL_SLASHBLADE)), Ingredient.of(TofuBlocks.DIAMONDTOFU.get()), RecipeCategory.COMBAT, getItem(SBATofuCraftItems.TOFUDIAMOND_SLASHBLADE)).save(consumer, SlashBladeAddon.prefix("tofu_diamond_blade"));
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

    }

    public Item getItem(ResourceLocation item) {
        return BuiltInRegistries.ITEM.get(item);
    }
}
