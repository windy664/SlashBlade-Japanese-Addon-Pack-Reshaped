package cn.mmf.slashblade_addon.specialattacks;

import cn.mmf.slashblade_addon.entity.BlisteringSwordsEntity;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.capability.concentrationrank.CapabilityConcentrationRank;
import mods.flammpfeil.slashblade.capability.concentrationrank.IConcentrationRank;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class RapidBlisteringSwords
{
    public static void doSlash(LivingEntity playerIn, boolean critical, double damage, float speed)
    {
        int colorCode = playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(state -> state.getColorCode()).orElse(0xFF3333FF);
        doSlash(playerIn, colorCode, critical, damage, speed);
    }

    public static void doSlash(LivingEntity playerIn, int colorCode, boolean critical, double damage, float speed)
    {
        if (playerIn.level().isClientSide()) return;

        playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).ifPresent((state) -> {

            Level worldIn = playerIn.level();

            int rank = playerIn.getCapability(CapabilityConcentrationRank.RANK_POINT).map(r -> r.getRank(worldIn.getGameTime()).level).orElse(0);
            int count = IConcentrationRank.ConcentrationRanks.S.level <= rank ? 24 : 12;

            for (int i = 0; i < count; i++)
            {
                BlisteringSwordsEntity ss = new BlisteringSwordsEntity(SlashBlade.RegistryEvents.BlisteringSwords, worldIn);

                worldIn.addFreshEntity(ss);

                ss.setSpeed(speed);
                ss.setIsCritical(critical);
                ss.setOwner(playerIn);
                ss.setColor(colorCode);
                ss.setRoll(0);
                ss.setDamage(damage);
                // force riding
                ss.startRiding(playerIn, true);

                ss.setDelay(i);

                playerIn.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 0.2F, 1.45F);
            }
        });
    }
}
