package coda.gummybear;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import coda.gummybear.common.entities.GummyBearEntity;
import coda.gummybear.init.GBEntities;
import coda.gummybear.init.GBItems;

@Mod(GummyBear.MOD_ID)
public class GummyBear {
    public static final String MOD_ID = "gummybear";
    public final static CreativeModeTab GROUP = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(GBItems.GUMMY_BEAR.get());
        }
    };

    public GummyBear() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        GBItems.ITEMS.register(bus);
        GBEntities.ENTITIES.register(bus);

        bus.addListener(this::registerAttributes);
    }

    private void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(GBEntities.GUMMY_BEAR.get(), GummyBearEntity.createAttributes().build());
    }
}
