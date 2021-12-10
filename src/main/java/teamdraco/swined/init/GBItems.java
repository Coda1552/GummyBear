package teamdraco.swined.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import teamdraco.swined.GummyBear;

public class GBItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GummyBear.MOD_ID);

    public static final RegistryObject<Item> GUMMY_BEAR_SPAWN_EGG = ITEMS.register("gummy_bear_spawn_egg", () -> new ForgeSpawnEggItem(GBEntities.GUMMY_BEAR, 0xe03843, 0x991212, new Item.Properties().tab(GummyBear.GROUP)));
}
