package coda.gummybear.init;

import coda.gummybear.GummyBear;
import coda.gummybear.common.items.GummyBearItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GBItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GummyBear.MOD_ID);

    public static final RegistryObject<Item> GUMMY_BEAR_SPAWN_EGG = ITEMS.register("gummy_bear_spawn_egg", () -> new ForgeSpawnEggItem(GBEntities.GUMMY_BEAR, 0xe03843, 0x991212, new Item.Properties().tab(GummyBear.GROUP)));
    public static final RegistryObject<Item> GUMMY_BEAR = ITEMS.register("gummy_bear", () -> new GummyBearItem(new Item.Properties().tab(GummyBear.GROUP).stacksTo(1)));
    public static final RegistryObject<Item> HEART_OF_GUMMY = ITEMS.register("heart_of_gummy", () -> new Item(new Item.Properties().tab(GummyBear.GROUP)) {
        @Override
        public Component getName(ItemStack p_41458_) {
            return new TranslatableComponent(this.getDescriptionId(p_41458_)).withStyle(ChatFormatting.RED);
        }
    });
}
