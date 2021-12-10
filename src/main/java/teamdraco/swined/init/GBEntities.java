package teamdraco.swined.init;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import teamdraco.swined.GummyBear;
import teamdraco.swined.common.entities.GummyBearEntity;

public class GBEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, GummyBear.MOD_ID);

    public static final RegistryObject<EntityType<GummyBearEntity>> GUMMY_BEAR = create("gummy_bear", EntityType.Builder.of(GummyBearEntity::new, MobCategory.CREATURE).sized(1.0F, 1.0F));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(GummyBear.MOD_ID + "." + name));
    }
}
