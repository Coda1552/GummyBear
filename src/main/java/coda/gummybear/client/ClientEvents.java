package coda.gummybear.client;

import coda.gummybear.GummyBear;
import coda.gummybear.client.model.GummyBearModel;
import coda.gummybear.client.renderer.GummyBearRenderer;
import coda.gummybear.init.GBEntities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = GummyBear.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {
        EntityRenderers.register(GBEntities.GUMMY_BEAR.get(), GummyBearRenderer::new);
        ForgeHooksClient.registerLayerDefinition(GummyBearRenderer.MODEL_LAYER, GummyBearModel::createLayerDefinition);
    }

}