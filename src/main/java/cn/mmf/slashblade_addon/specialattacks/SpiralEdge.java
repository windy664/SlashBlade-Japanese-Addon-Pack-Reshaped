package cn.mmf.slashblade_addon.specialattacks;

import cn.mmf.slashblade_addon.entity.SpiralEdgeSwordsEntity;
import cn.mmf.slashblade_addon.registry.SBAEntitiesRegistry;
import mods.flammpfeil.slashblade.capability.concentrationrank.CapabilityConcentrationRank;
import mods.flammpfeil.slashblade.capability.concentrationrank.IConcentrationRank;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class SpiralEdge
{
    public static void doSlash(LivingEntity playerIn, boolean critical, double damage, float speed)
    {
        int colorCode = playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(ISlashBladeState::getColorCode).orElse(0xFF3333FF);
        doSlash(playerIn, colorCode, critical, damage, speed);
    }

    public static void doSlash(LivingEntity playerIn, int colorCode, boolean critical, double damage, float speed)
    {
        if (playerIn.level().isClientSide()) return;
        Level worldIn = playerIn.level();

        int rank = playerIn.getCapability(CapabilityConcentrationRank.RANK_POINT).map(r -> r.getRank(worldIn.getGameTime()).level).orElse(0);
        float rounds = IConcentrationRank.ConcentrationRanks.S.level <= rank ? 2f : 1.5f;
        int count = (int) (24 * rounds);
        playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).ifPresent
        (
            (state) ->
            {
                for (int i = 0; i < count; i++)
                {
                    SpiralEdgeSwordsEntity ss = new SpiralEdgeSwordsEntity(SBAEntitiesRegistry.SpiralEdgeSwords, worldIn);

                    worldIn.addFreshEntity(ss);

                    ss.setSpeed(speed);
                    ss.setIsCritical(critical);
                    ss.setOwner(playerIn);
                    ss.setColor(colorCode);
                    ss.setRoll(0);
                    ss.setDamage(damage);
                    // force riding
                    ss.startRiding(playerIn, true);
                    ss.setDelay(20 + i);

                    double yOffset = i * 0.005 + 0.5;
                    double zOffset = -1.0;

                    ss.setPos(playerIn.position().add(0, yOffset, zOffset));
                    ss.setOffset(new Vec3(0, yOffset, zOffset));

                    playerIn.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 0.2F, 1.45F);
                }
            }
        );
    }
}
