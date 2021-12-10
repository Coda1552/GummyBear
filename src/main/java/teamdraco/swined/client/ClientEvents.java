package teamdraco.swined.client;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import teamdraco.swined.GummyBear;
import teamdraco.swined.client.model.GummyBearModel;
import teamdraco.swined.client.renderer.GummyBearRenderer;
import teamdraco.swined.init.GBEntities;

@Mod.EventBusSubscriber(modid = GummyBear.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {
        EntityRenderers.register(GBEntities.GUMMY_BEAR.get(), GummyBearRenderer::new);
        ForgeHooksClient.registerLayerDefinition(GummyBearRenderer.MODEL_LAYER, GummyBearModel::createLayerDefinition);
    }

}