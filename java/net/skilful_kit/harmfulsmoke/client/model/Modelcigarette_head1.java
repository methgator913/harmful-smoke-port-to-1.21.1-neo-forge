package net.skilful_kit.harmfulsmoke.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.skilful_kit.harmfulsmoke.HarmfulsmokeMod;

public class Modelcigarette_head1<T extends Entity> extends EntityModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(new ResourceLocation(HarmfulsmokeMod.MODID, "cigarette_head"), "main");

    private final ModelPart cigarette;

    public Modelcigarette_head1(ModelPart root) {
        this.cigarette = root.getChild("cigarette");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition cigarette = partdefinition.addOrReplaceChild("cigarette",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-0.5F, -0.5F, -5.0F, 1, 1, 6),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        cigarette.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
