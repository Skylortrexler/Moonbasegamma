package website.skylorbeck.minecraft.moonbasegamma.mixin;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.EntityModels;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityModels.class)
public class EntityModelsMixin {
    @Redirect(at = @At(value = "INVOKE",target = "Lnet/minecraft/client/render/entity/model/CreeperEntityModel;getTexturedModelData(Lnet/minecraft/client/model/Dilation;)Lnet/minecraft/client/model/TexturedModelData;"), method = "getModels")
    private static TexturedModelData injectedCreeper(Dilation dilation) {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, dilation), ModelTransform.pivot(0.0F, 6.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, dilation), ModelTransform.pivot(0.0F, 6.0F, 0.0F));
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, dilation);
        modelPartData.addChild(EntityModelPartNames.RIGHT_HIND_LEG, modelPartBuilder, ModelTransform.pivot(-2.0F, 18.0F, 4.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_HIND_LEG, modelPartBuilder, ModelTransform.pivot(2.0F, 18.0F, 4.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_FRONT_LEG, modelPartBuilder, ModelTransform.pivot(-2.0F, 18.0F, -4.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_FRONT_LEG, modelPartBuilder, ModelTransform.pivot(2.0F, 18.0F, -4.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, modelPartBuilder, ModelTransform.pivot(-4.0F, 18.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_LEG, modelPartBuilder, ModelTransform.pivot(4.0F, 18.0F, 0.0F));
        modelPartBuilder = ModelPartBuilder.create().uv(16, 0).cuboid(0.0f, 0.0F, 0.0F, 1.0F, 6.0F, 1.0F, dilation);
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.LEFT_FIN, modelPartBuilder, ModelTransform.pivot(-3.0F, -14f, -2.0F));
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.RIGHT_FIN, modelPartBuilder, ModelTransform.pivot(2.0F, -14f, -2.0F));
        return TexturedModelData.of(modelData, 64, 32);
    }
    @Redirect(at = @At(value = "INVOKE",target = "Lnet/minecraft/client/render/entity/model/EndermanEntityModel;getTexturedModelData()Lnet/minecraft/client/model/TexturedModelData;"), method = "getModels")
    private static TexturedModelData injectedEnderman() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, -14.0F);
        ModelPartData modelPartData = modelData.getRoot();
        ModelTransform modelTransform = ModelTransform.pivot(0.0F, -13.0F, 0.0F);
        modelPartData.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(-0.5F)), modelTransform);
        modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), modelTransform);
        modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(32, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F), ModelTransform.pivot(0.0F, -14.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(56, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 30.0F, 2.0F), ModelTransform.pivot(-5.0F, -12.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 30.0F, 2.0F), ModelTransform.pivot(5.0F, -12.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(56, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F), ModelTransform.pivot(-2.0F, -5.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F), ModelTransform.pivot(2.0F, -5.0F, 0.0F));
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(57, 1).cuboid(0.0f, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F);
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.LEFT_FIN, modelPartBuilder, ModelTransform.pivot(-3.0F, -16f, -2.0F));
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.RIGHT_FIN, modelPartBuilder, ModelTransform.pivot(2.0F, -16f, -2.0F));
        return TexturedModelData.of(modelData, 64, 32);
    }
    @Redirect(at = @At(value = "INVOKE",target = "Lnet/minecraft/client/render/entity/model/ZombieVillagerEntityModel;getTexturedModelData()Lnet/minecraft/client/model/TexturedModelData;"), method = "getModels")
    private static TexturedModelData injectedVillager() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0.0F);
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EntityModelPartNames.HEAD, (new ModelPartBuilder()).uv(0, 0).cuboid(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F).uv(24, 0).cuboid(-1.0F, -3.0F, -6.0F, 2.0F, 4.0F, 2.0F), ModelTransform.NONE);
        ModelPartData modelPartData2 = modelPartData.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new Dilation(0.5F)), ModelTransform.NONE);
        modelPartData2.addChild(EntityModelPartNames.HAT_RIM, ModelPartBuilder.create().uv(30, 47).cuboid(-8.0F, -8.0F, -6.0F, 16.0F, 16.0F, 1.0F), ModelTransform.rotation(-1.5707964F, 0.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(16, 20).cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F).uv(0, 38).cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 18.0F, 6.0F, new Dilation(0.05F)), ModelTransform.NONE);
        modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(44, 22).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(44, 22).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(5.0F, 2.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(0, 22).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(-2.0F, 12.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(0, 22).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(2.0F, 12.0F, 0.0F));
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(16,0).cuboid(0.0f, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F);
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.LEFT_FIN, modelPartBuilder, ModelTransform.pivot(-3.0F, -14f, -2.0F));
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.RIGHT_FIN, modelPartBuilder, ModelTransform.pivot(2.0F, -14f, -2.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Redirect(at = @At(value = "INVOKE",target = "Lnet/minecraft/client/render/entity/model/PiglinEntityModel;getModelData(Lnet/minecraft/client/model/Dilation;)Lnet/minecraft/client/model/ModelData;"), method = "getModels")
    private static ModelData injectedPiglin(Dilation dilation) {
        ModelData modelData = PlayerEntityModel.getTexturedModelData(dilation, false);
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, dilation), ModelTransform.NONE);
        ModelPartData modelPartData2 = modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -8.0F, -4.0F, 10.0F, 8.0F, 8.0F, dilation).uv(31, 1).cuboid(-2.0F, -4.0F, -5.0F, 4.0F, 4.0F, 1.0F, dilation).uv(2, 4).cuboid(2.0F, -2.0F, -5.0F, 1.0F, 2.0F, 1.0F, dilation).uv(2, 0).cuboid(-3.0F, -2.0F, -5.0F, 1.0F, 2.0F, 1.0F, dilation), ModelTransform.NONE);
        modelPartData2.addChild(EntityModelPartNames.LEFT_EAR, ModelPartBuilder.create().uv(51, 6).cuboid(0.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, dilation), ModelTransform.of(4.5F, -6.0F, 0.0F, 0.0F, 0.0F, -0.5235988F));
        modelPartData2.addChild(EntityModelPartNames.RIGHT_EAR, ModelPartBuilder.create().uv(39, 6).cuboid(-1.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, dilation), ModelTransform.of(-4.5F, -6.0F, 0.0F, 0.0F, 0.0F, 0.5235988F));
        modelPartData.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create(), ModelTransform.NONE);
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(16,0).cuboid(0.0f, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F);
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.LEFT_FIN, modelPartBuilder, ModelTransform.pivot(-3.0F, -12f, -2.0F));
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.RIGHT_FIN, modelPartBuilder, ModelTransform.pivot(2.0F, -12f, -2.0F));
        return modelData;
    }
}
