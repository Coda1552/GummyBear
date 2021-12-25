package coda.gummybear.client.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import coda.gummybear.common.entities.GummyBearEntity;

import java.util.Collections;

@OnlyIn(Dist.CLIENT)
public class GummyBearModel<T extends GummyBearEntity> extends AgeableListModel<T> {
    public ModelPart body;
    public ModelPart head;
    public ModelPart armRight;
    public ModelPart armLeft;
    public ModelPart legRight;
    public ModelPart legLeft;
    public ModelPart snout;
    public ModelPart earRight;
    public ModelPart earLeft;

    public GummyBearModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
        this.snout = this.head.getChild("snout");
        this.earLeft = this.head.getChild("earLeft");
        this.earRight = this.head.getChild("earRight");
        this.armRight = this.body.getChild("armRight");
        this.legLeft = this.body.getChild("legLeft");
        this.armLeft = this.body.getChild("armLeft");
        this.legRight = this.body.getChild("legRight");
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 34).addBox(-7.5F, -6.0F, -9.0F, 15.0F, 12.0F, 18.0F, false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 17).addBox(-5.5F, -4.5F, -7.0F, 11.0F, 9.0F, 7.0F, false), PartPose.offsetAndRotation(0.0F, -0.5F, -9.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(0, 43).addBox(-2.5F, -2.5F, -3.0F, 5.0F, 5.0F, 3.0F, false), PartPose.offsetAndRotation(0.0F, 2.0F, -7.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition earLeft = head.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(0, 39).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 1.0F, 2.0F, false), PartPose.offsetAndRotation(4.0F, -4.5F, -3.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition earRight = head.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(0, 39).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 1.0F, 2.0F, false), PartPose.offsetAndRotation(-4.0F, -4.5F, -3.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition armRight = body.addOrReplaceChild("armRight", CubeListBuilder.create().texOffs(0, 5).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 6.0F, 5.0F, false), PartPose.offsetAndRotation(-5.0F, 7.0F, -6.5F, 0.0F, 0.0F, 0.0F));
        PartDefinition legLeft = body.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(21, 5).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 6.0F, 5.0F, false), PartPose.offsetAndRotation(5.0F, 7.0F, 6.5F, 0.0F, 0.0F, 0.0F));
        PartDefinition armLeft = body.addOrReplaceChild("armLeft", CubeListBuilder.create().texOffs(0, 5).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 6.0F, 5.0F, false), PartPose.offsetAndRotation(5.0F, 7.0F, -6.5F, 0.0F, 0.0F, 0.0F));
        PartDefinition legRight = body.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(21, 5).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 6.0F, 5.0F, false), PartPose.offsetAndRotation(-5.0F, 7.0F, 6.5F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return Collections.emptyList();
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(body);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        if (entity.isInSittingPose()) {
            this.head.xRot = 0F;
            this.head.yRot = 0F;

            this.legRight.x = -7.0F;
            this.legRight.y = 3.5F;
            this.legRight.z = 7.5F;
            this.legRight.xRot = 1.5708F;
            this.legRight.yRot = -0.8726F;

            this.armRight.x = -7.0F;
            this.armRight.y = 3.5F;
            this.armRight.z = -7.5F;
            this.armRight.xRot = -1.5708F;
            this.armRight.yRot = 0.8726F;

            this.legLeft.x = 7.0F;
            this.legLeft.y = 3.5F;
            this.legLeft.z = 7.5F;
            this.legLeft.xRot = 1.5708F;
            this.legLeft.yRot = 0.8726F;

            this.armLeft.x = 7.0F;
            this.armLeft.y = 3.5F;
            this.armLeft.z = -7.5F;
            this.armLeft.xRot = -1.5708F;
            this.armLeft.yRot = -0.8726F;

            this.body.y = 18F;
        }
        else {
            this.head.xRot = headPitch * ((float)Math.PI / 180F);
            this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
            this.legRight.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
            this.legRight.yRot = 0F;
            this.legLeft.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
            this.legLeft.yRot = 0F;
            this.armRight.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
            this.armRight.yRot = 0F;
            this.armLeft.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
            this.armLeft.yRot = 0F;

            this.armLeft.x = 5F;
            this.armLeft.y = 7F;
            this.armLeft.z = -6.5F;

            this.legLeft.x = 5F;
            this.legLeft.y = 7F;
            this.legLeft.z = 6.5F;

            this.armRight.x = -5F;
            this.armRight.y = 7F;
            this.armRight.z = -6.5F;

            this.legRight.x = -5F;
            this.legRight.y = 7F;
            this.legRight.z = 6.5F;

            this.body.y = 12F;
        }
    }
}
