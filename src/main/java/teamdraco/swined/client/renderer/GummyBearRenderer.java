package teamdraco.swined.client.renderer;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teamdraco.swined.GummyBear;
import teamdraco.swined.client.model.GummyBearModel;
import teamdraco.swined.common.entities.GummyBearEntity;

@OnlyIn(Dist.CLIENT)
public class GummyBearRenderer extends LivingEntityRenderer<GummyBearEntity, GummyBearModel<GummyBearEntity>> {
    public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(new ResourceLocation(GummyBear.MOD_ID, "gummy_bear"), "main");
    private static final ResourceLocation GUMMY_BEAR = new ResourceLocation(GummyBear.MOD_ID, "textures/entity/gummy_bear.png");

    public GummyBearRenderer(EntityRendererProvider.Context p_174354_) {
        super(p_174354_, new GummyBearModel<>(p_174354_.bakeLayer(MODEL_LAYER)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(GummyBearEntity p_114482_) {
        return GUMMY_BEAR;
    }
}
