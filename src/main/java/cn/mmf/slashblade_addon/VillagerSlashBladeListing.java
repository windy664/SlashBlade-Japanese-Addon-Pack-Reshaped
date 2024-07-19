package cn.mmf.slashblade_addon;

import org.jetbrains.annotations.Nullable;

import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.init.SBItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.BasicItemListing;

public class VillagerSlashBladeListing extends BasicItemListing {
	private final ResourceLocation bladeName;
	public VillagerSlashBladeListing(int emeralds, ResourceLocation bladeName, int maxTrades, int xp, float mult) {
		super(emeralds, SBItems.slashblade.getDefaultInstance(), maxTrades, xp, mult);
		this.bladeName = bladeName;
	}
	
	public ResourceLocation getBladeName() {
		return bladeName;
	}

	@Override
	public @Nullable MerchantOffer getOffer(Entity entity, RandomSource random) {
		Level level = entity.level();
		ItemStack blade = SlashBlade.getSlashBladeDefinitionRegistry(level).get(this.getBladeName()).getBlade();
		
		return new MerchantOffer(this.price, ItemStack.EMPTY, blade, maxTrades, xp, priceMult);
	}
}
