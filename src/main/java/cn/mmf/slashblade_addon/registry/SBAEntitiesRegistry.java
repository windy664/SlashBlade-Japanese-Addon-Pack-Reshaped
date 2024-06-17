package cn.mmf.slashblade_addon.registry;

import cn.mmf.slashblade_addon.SlashBladeAddon;
import cn.mmf.slashblade_addon.entity.BlisteringSwordsEntity;
import com.google.common.base.CaseFormat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class SBAEntitiesRegistry
{
    public static final ResourceLocation BlisteringSwordsLoc = new ResourceLocation(SlashBladeAddon.MODID, classToString(BlisteringSwordsEntity.class));
    public static EntityType<BlisteringSwordsEntity> BlisteringSwords;

    public static void register(RegisterEvent event)
    {
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper ->
        {
            {
                EntityType<BlisteringSwordsEntity> entity = BlisteringSwords = EntityType.Builder
                .of(BlisteringSwordsEntity::new, MobCategory.MISC)
                .sized(0.9F, 0.9F)
                .setTrackingRange(4)
                .setUpdateInterval(20).setCustomClientFactory(BlisteringSwordsEntity::createInstance)
                .build(BlisteringSwordsLoc.toString());
                helper.register(BlisteringSwordsLoc, entity);
            }
        });
    }

    private static String classToString(Class<? extends Entity> entityClass)
    {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityClass.getSimpleName())
        .replace("entity_", "");
    }
}
