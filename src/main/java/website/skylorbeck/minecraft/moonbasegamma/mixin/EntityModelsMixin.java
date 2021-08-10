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
    private static TexturedModelData injectedZombieVillager() {
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
    @Redirect(at = @At(value = "INVOKE",target = "Lnet/minecraft/client/render/entity/EnderDragonEntityRenderer;getTexturedModelData()Lnet/minecraft/client/model/TexturedModelData;"), method = "getModels")
    private static TexturedModelData injectedEnderDragon() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild(EntityModelPartNames.HEAD,
                ModelPartBuilder.create().cuboid("upperlip", -6.0F, -1.0F, -24.0F, 12, 5, 16, 176, 44)
                        .cuboid("upperhead", -8.0F, -8.0F, -10.0F, 16, 16, 16, 112, 30)
                        .cuboid("scale", -1.0F, -21.0F, -3.0F, 2, 16, 6, 112,144)
                        .cuboid("nostril", -5.0F, -3.0F, -22.0F, 2, 2, 4, 112, 0)
                        .cuboid("nostril", 3.0F, -3.0F, -22.0F, 2, 2, 4, 112, 0),
                ModelTransform.NONE);

        modelPartData2.addChild(EntityModelPartNames.JAW,
                ModelPartBuilder.create()
                        .cuboid(EntityModelPartNames.JAW, -6.0F, 0.0F, -16.0F, 12, 4, 16, 176, 65),
                ModelTransform.pivot(0.0F, 4.0F, -8.0F));

        modelPartData.addChild(EntityModelPartNames.NECK,
                ModelPartBuilder.create()
                        .cuboid("box", -5.0F, -5.0F, -5.0F, 10, 10, 10, 192, 104)
                        .cuboid("scale", -1.0F, -21.0F, -3.0F, 2, 16, 6, 112,144),
                ModelTransform.NONE);

        modelPartData.addChild(EntityModelPartNames.BODY,
                ModelPartBuilder.create()
                        .cuboid(EntityModelPartNames.BODY, -12.0F, 0.0F, -16.0F, 24, 24, 64, 0, 0)
//                        .cuboid("scale", -4.0F, -10.0F, -10.0F, 2, 12, 8, 226, 57)
                        .cuboid("scale", -4.0F, -16.0F, -10.0F, 2, 16, 6, 112,144)
                        .cuboid("scale", 2.0F, -16.0F, -10.0F, 2, 16, 6, 112,144)
                        .cuboid("scale", -4.0F, -16.0F, 0.0F, 2, 16, 6, 112,144)
                        .cuboid("scale", 2.0F, -16.0F, 0.0F, 2, 16, 6, 112,144)
                        .cuboid("scale", -4.0F, -16.0F, 10.0F, 2, 16, 6, 112,144)
                        .cuboid("scale", 2.0F, -16.0F, 10.0F, 2, 16, 6, 112,144)
                        .cuboid("scale", -4.0F, -16.0F, 20.0F, 2, 16, 6, 112,144)
                        .cuboid("scale", 2.0F, -16.0F, 20.0F, 2, 16, 6, 112,144)
                        .cuboid("scale", -4.0F, -16.0F, 30.0F, 2, 16, 6, 112,144)
                        .cuboid("scale", 2.0F, -16.0F, 30.0F, 2, 16, 6, 112,144),
                ModelTransform.pivot(0.0F, 4.0F, 8.0F));

        ModelPartData modelPartData3 = modelPartData.addChild(EntityModelPartNames.LEFT_WING,
                ModelPartBuilder.create()
                .mirrored().cuboid("bone", 0.0F, -4.0F, -4.0F, 56, 8, 8, 112, 88)
                .cuboid("skin", 0.0F, 0.0F, 2.0F, 56, 0, 56, -56, 88),
                ModelTransform.pivot(12.0F, 5.0F, 2.0F));

        modelPartData3.addChild(EntityModelPartNames.LEFT_WING_TIP,
                ModelPartBuilder.create()
                        .mirrored().cuboid("bone", 0.0F, -2.0F, -2.0F, 56, 4, 4, 112, 136)
                        .cuboid("skin", 0.0F, 0.0F, 2.0F, 56, 0, 56, -56, 144),
                ModelTransform.pivot(56.0F, 0.0F, 0.0F));

        ModelPartData modelPartData4 = modelPartData.addChild(EntityModelPartNames.LEFT_FRONT_LEG,
                ModelPartBuilder.create()
                .cuboid("main", -4.0F, -4.0F, -4.0F, 8, 24, 8, 112, 104),
                ModelTransform.pivot(12.0F, 20.0F, 2.0F));

        ModelPartData modelPartData5 = modelPartData4.addChild(EntityModelPartNames.LEFT_FRONT_LEG_TIP,
                ModelPartBuilder.create()
                .cuboid("main", -3.0F, -1.0F, -3.0F, 6, 24, 6, 226, 138),
                ModelTransform.pivot(0.0F, 20.0F, -1.0F));

        modelPartData5.addChild(EntityModelPartNames.LEFT_FRONT_FOOT,
                ModelPartBuilder.create().cuboid("main", -4.0F, 0.0F, -12.0F, 8, 4, 16, 144, 104),
                ModelTransform.pivot(0.0F, 23.0F, 0.0F));

        ModelPartData modelPartData6 = modelPartData.addChild(EntityModelPartNames.LEFT_HIND_LEG,
                ModelPartBuilder.create().cuboid("main", -8.0F, -4.0F, -8.0F, 16, 32, 16, 0, 0),
                ModelTransform.pivot(16.0F, 16.0F, 42.0F));

        ModelPartData modelPartData7 = modelPartData6.addChild(EntityModelPartNames.LEFT_HIND_LEG_TIP,
                ModelPartBuilder.create().cuboid("main", -6.0F, -2.0F, 0.0F, 12, 32, 12, 196, 0),
                ModelTransform.pivot(0.0F, 32.0F, -4.0F));

        modelPartData7.addChild(EntityModelPartNames.LEFT_HIND_FOOT,
                ModelPartBuilder.create().cuboid("main", -9.0F, 0.0F, -20.0F, 18, 6, 24, 112, 0),
                ModelTransform.pivot(0.0F, 31.0F, 4.0F));

        ModelPartData modelPartData8 = modelPartData.addChild(EntityModelPartNames.RIGHT_WING,
                ModelPartBuilder.create().cuboid("bone", -56.0F, -4.0F, -4.0F, 56, 8, 8, 112, 88)
                        .cuboid("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56, -56, 88),
                ModelTransform.pivot(-12.0F, 5.0F, 2.0F));

        modelPartData8.addChild(EntityModelPartNames.RIGHT_WING_TIP,
                ModelPartBuilder.create().cuboid("bone", -56.0F, -2.0F, -2.0F, 56, 4, 4, 112, 136)
                        .cuboid("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56, -56, 144),
                ModelTransform.pivot(-56.0F, 0.0F, 0.0F));

        ModelPartData modelPartData9 = modelPartData.addChild(EntityModelPartNames.RIGHT_FRONT_LEG,
                ModelPartBuilder.create().cuboid("main", -4.0F, -4.0F, -4.0F, 8, 24, 8, 112, 104),
                ModelTransform.pivot(-12.0F, 20.0F, 2.0F));

        ModelPartData modelPartData10 = modelPartData9.addChild(EntityModelPartNames.RIGHT_FRONT_LEG_TIP,
                ModelPartBuilder.create().cuboid("main", -3.0F, -1.0F, -3.0F, 6, 24, 6, 226, 138),
                ModelTransform.pivot(0.0F, 20.0F, -1.0F));

        modelPartData10.addChild(EntityModelPartNames.RIGHT_FRONT_FOOT,
                ModelPartBuilder.create().cuboid("main", -4.0F, 0.0F, -12.0F, 8, 4, 16, 144, 104),
                ModelTransform.pivot(0.0F, 23.0F, 0.0F));

        ModelPartData modelPartData11 = modelPartData.addChild(EntityModelPartNames.RIGHT_HIND_LEG,
                ModelPartBuilder.create().cuboid("main", -8.0F, -4.0F, -8.0F, 16, 32, 16, 0, 0),
                ModelTransform.pivot(-16.0F, 16.0F, 42.0F));

        ModelPartData modelPartData12 = modelPartData11.addChild(EntityModelPartNames.RIGHT_HIND_LEG_TIP,
                ModelPartBuilder.create().cuboid("main", -6.0F, -2.0F, 0.0F, 12, 32, 12, 196, 0),
                ModelTransform.pivot(0.0F, 32.0F, -4.0F));
        modelPartData12.addChild(EntityModelPartNames.RIGHT_HIND_FOOT,
                ModelPartBuilder.create().cuboid("main", -9.0F, 0.0F, -20.0F, 18, 6, 24, 112, 0),
                ModelTransform.pivot(0.0F, 31.0F, 4.0F));

        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(16, 0).cuboid(0.0f, 0.0F, 0.0F, 2.0F, 20.0F, 2.0F);
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.LEFT_FIN, modelPartBuilder, ModelTransform.pivot(-6.0F, -28f, -8.0F));
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.RIGHT_FIN, modelPartBuilder, ModelTransform.pivot(4.0F, -28f, -8.0F));
        return TexturedModelData.of(modelData, 256, 256);
    }
    @Redirect(at = @At(value = "INVOKE",target = "Lnet/minecraft/client/render/entity/model/BipedEntityModel;getModelData(Lnet/minecraft/client/model/Dilation;F)Lnet/minecraft/client/model/ModelData;"), method = "getModels")
    private static ModelData injectedBiped(Dilation dilation, float pivotOffsetY) {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, dilation), ModelTransform.pivot(0.0F, 0.0F + pivotOffsetY, 0.0F));
        modelPartData.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, dilation.add(0.5F)), ModelTransform.pivot(0.0F, 0.0F + pivotOffsetY, 0.0F));
        modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, dilation), ModelTransform.pivot(0.0F, 0.0F + pivotOffsetY, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation), ModelTransform.pivot(-5.0F, 2.0F + pivotOffsetY, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(40, 16).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation), ModelTransform.pivot(5.0F, 2.0F + pivotOffsetY, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation), ModelTransform.pivot(-1.9F, 12.0F + pivotOffsetY, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation), ModelTransform.pivot(1.9F, 12.0F + pivotOffsetY, 0.0F));
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(0, 8).cuboid(0.0f, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F);
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.LEFT_FIN, modelPartBuilder, ModelTransform.pivot(-3.0F, -14f, -2.0F));
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.RIGHT_FIN, modelPartBuilder, ModelTransform.pivot(2.0F, -14f, -2.0F));
        return modelData;
    }
    @Redirect(at = @At(value = "INVOKE",target = "Lnet/minecraft/client/render/entity/model/VillagerResemblingModel;getModelData()Lnet/minecraft/client/model/ModelData;"), method = "getModels")
    private static ModelData injectedVillager() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F), ModelTransform.NONE);
        ModelPartData modelPartData3 = modelPartData2.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new Dilation(0.5F)), ModelTransform.NONE);
        modelPartData3.addChild(EntityModelPartNames.HAT_RIM, ModelPartBuilder.create().uv(30, 47).cuboid(-8.0F, -8.0F, -6.0F, 16.0F, 16.0F, 1.0F), ModelTransform.rotation(-1.5707964F, 0.0F, 0.0F));
        modelPartData2.addChild(EntityModelPartNames.NOSE, ModelPartBuilder.create().uv(24, 0).cuboid(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F), ModelTransform.pivot(0.0F, -2.0F, 0.0F));
        ModelPartData modelPartData4 = modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(16, 20).cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F), ModelTransform.NONE);
        modelPartData4.addChild(EntityModelPartNames.JACKET, ModelPartBuilder.create().uv(0, 38).cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 18.0F, 6.0F, new Dilation(0.5F)), ModelTransform.NONE);
        modelPartData.addChild(EntityModelPartNames.ARMS, ModelPartBuilder.create().uv(44, 22).cuboid(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F).uv(44, 22).cuboid(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, true).uv(40, 38).cuboid(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F), ModelTransform.of(0.0F, 3.0F, -1.0F, -0.75F, 0.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(0, 22).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(-2.0F, 12.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(0, 22).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(2.0F, 12.0F, 0.0F));
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(0,8).cuboid(0.0f, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F);
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.LEFT_FIN, modelPartBuilder, ModelTransform.pivot(-3.0F, -16f, -2.0F));
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.RIGHT_FIN, modelPartBuilder, ModelTransform.pivot(2.0F, -16f, -2.0F));
        return modelData;
    }
    @Redirect(at = @At(value = "INVOKE",target = "Lnet/minecraft/client/render/entity/model/IllagerEntityModel;getTexturedModelData()Lnet/minecraft/client/model/TexturedModelData;"), method = "getModels")
    private static TexturedModelData injectedIllager() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData2.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -10.0F, -4.0F, 8.0F, 12.0F, 8.0F, new Dilation(0.45F)), ModelTransform.NONE);
        modelPartData2.addChild(EntityModelPartNames.NOSE, ModelPartBuilder.create().uv(24, 0).cuboid(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F), ModelTransform.pivot(0.0F, -2.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(16, 20).cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F).uv(0, 38).cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 18.0F, 6.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData modelPartData3 = modelPartData.addChild(EntityModelPartNames.ARMS, ModelPartBuilder.create().uv(44, 22).cuboid(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F).uv(40, 38).cuboid(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F), ModelTransform.of(0.0F, 3.0F, -1.0F, -0.75F, 0.0F, 0.0F));
        modelPartData3.addChild("left_shoulder", ModelPartBuilder.create().uv(44, 22).mirrored().cuboid(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F), ModelTransform.NONE);
        modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(0, 22).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(-2.0F, 12.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(0, 22).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(2.0F, 12.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(40, 46).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(40, 46).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(5.0F, 2.0F, 0.0F));
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(0,8).cuboid(0.0f, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F);
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.LEFT_FIN, modelPartBuilder, ModelTransform.pivot(-3.0F, -16f, -2.0F));
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.RIGHT_FIN, modelPartBuilder, ModelTransform.pivot(2.0F, -16f, -2.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Redirect(at = @At(value = "INVOKE",target = "Lnet/minecraft/client/render/entity/model/SpiderEntityModel;getTexturedModelData()Lnet/minecraft/client/model/TexturedModelData;"), method = "getModels")
    private static TexturedModelData injectedSpider() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(32, 4).cuboid(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F), ModelTransform.pivot(0.0F, 15.0F, -3.0F));
        modelPartData.addChild("body0", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F), ModelTransform.pivot(0.0F, 15.0F, 0.0F));
        modelPartData.addChild("body1", ModelPartBuilder.create().uv(0, 12).cuboid(-5.0F, -4.0F, -6.0F, 10.0F, 8.0F, 12.0F), ModelTransform.pivot(0.0F, 15.0F, 9.0F));
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(18, 0).cuboid(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F);
        ModelPartBuilder modelPartBuilder2 = ModelPartBuilder.create().uv(18, 0).cuboid(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F);
        modelPartData.addChild(EntityModelPartNames.RIGHT_HIND_LEG, modelPartBuilder, ModelTransform.pivot(-4.0F, 15.0F, 2.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_HIND_LEG, modelPartBuilder2, ModelTransform.pivot(4.0F, 15.0F, 2.0F));
        modelPartData.addChild("right_middle_hind_leg", modelPartBuilder, ModelTransform.pivot(-4.0F, 15.0F, 1.0F));
        modelPartData.addChild("left_middle_hind_leg", modelPartBuilder2, ModelTransform.pivot(4.0F, 15.0F, 1.0F));
        modelPartData.addChild("right_middle_front_leg", modelPartBuilder, ModelTransform.pivot(-4.0F, 15.0F, 0.0F));
        modelPartData.addChild("left_middle_front_leg", modelPartBuilder2, ModelTransform.pivot(4.0F, 15.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_FRONT_LEG, modelPartBuilder, ModelTransform.pivot(-4.0F, 15.0F, -1.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_FRONT_LEG, modelPartBuilder2, ModelTransform.pivot(4.0F, 15.0F, -1.0F));
        modelPartBuilder = ModelPartBuilder.create().uv(7,0).cuboid(0.0f, 0.0F, 0.0F, 1.0F, 6.0F, 1.0F);
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.LEFT_FIN, modelPartBuilder, ModelTransform.pivot(-2.0F, -8f, -2.0F));
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.RIGHT_FIN, modelPartBuilder, ModelTransform.pivot(1.0F, -8f, -2.0F));
        return TexturedModelData.of(modelData, 64, 32);
    }
    @Redirect(at = @At(value = "INVOKE",target = "Lnet/minecraft/client/render/entity/model/HorseEntityModel;getModelData(Lnet/minecraft/client/model/Dilation;)Lnet/minecraft/client/model/ModelData;"), method = "getModels")
    private static ModelData injectedHorse(Dilation dilation) {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 32).cuboid(-5.0F, -8.0F, -17.0F, 10.0F, 10.0F, 22.0F, new Dilation(0.05F)), ModelTransform.pivot(0.0F, 11.0F, 5.0F));
        ModelPartData modelPartData3 = modelPartData.addChild("head_parts", ModelPartBuilder.create().uv(0, 35).cuboid(-2.05F, -6.0F, -2.0F, 4.0F, 12.0F, 7.0F), ModelTransform.of(0.0F, 4.0F, -12.0F, 0.5235988F, 0.0F, 0.0F));
        ModelPartData modelPartData4 = modelPartData3.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 13).cuboid(-3.0F, -11.0F, -2.0F, 6.0F, 5.0F, 7.0F, dilation), ModelTransform.NONE);
        modelPartData3.addChild(EntityModelPartNames.MANE, ModelPartBuilder.create().uv(56, 36).cuboid(-1.0F, -11.0F, 5.01F, 2.0F, 16.0F, 2.0F, dilation), ModelTransform.NONE);
        modelPartData3.addChild("upper_mouth", ModelPartBuilder.create().uv(0, 25).cuboid(-2.0F, -11.0F, -7.0F, 4.0F, 5.0F, 5.0F, dilation), ModelTransform.NONE);
        modelPartData.addChild(EntityModelPartNames.LEFT_HIND_LEG, ModelPartBuilder.create().uv(48, 21).mirrored().cuboid(-3.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, dilation), ModelTransform.pivot(4.0F, 14.0F, 7.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_HIND_LEG, ModelPartBuilder.create().uv(48, 21).cuboid(-1.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, dilation), ModelTransform.pivot(-4.0F, 14.0F, 7.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_FRONT_LEG, ModelPartBuilder.create().uv(48, 21).mirrored().cuboid(-3.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, dilation), ModelTransform.pivot(4.0F, 14.0F, -12.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_FRONT_LEG, ModelPartBuilder.create().uv(48, 21).cuboid(-1.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, dilation), ModelTransform.pivot(-4.0F, 14.0F, -12.0F));
        Dilation dilation2 = dilation.add(0.0F, 5.5F, 0.0F);
        modelPartData.addChild("left_hind_baby_leg", ModelPartBuilder.create().uv(48, 21).mirrored().cuboid(-3.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, dilation2), ModelTransform.pivot(4.0F, 14.0F, 7.0F));
        modelPartData.addChild("right_hind_baby_leg", ModelPartBuilder.create().uv(48, 21).cuboid(-1.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, dilation2), ModelTransform.pivot(-4.0F, 14.0F, 7.0F));
        modelPartData.addChild("left_front_baby_leg", ModelPartBuilder.create().uv(48, 21).mirrored().cuboid(-3.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, dilation2), ModelTransform.pivot(4.0F, 14.0F, -12.0F));
        modelPartData.addChild("right_front_baby_leg", ModelPartBuilder.create().uv(48, 21).cuboid(-1.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, dilation2), ModelTransform.pivot(-4.0F, 14.0F, -12.0F));
        modelPartData2.addChild(EntityModelPartNames.TAIL, ModelPartBuilder.create().uv(42, 36).cuboid(-1.5F, 0.0F, 0.0F, 3.0F, 14.0F, 4.0F, dilation), ModelTransform.of(0.0F, -5.0F, 2.0F, 0.5235988F, 0.0F, 0.0F));
        modelPartData2.addChild("saddle", ModelPartBuilder.create().uv(26, 0).cuboid(-5.0F, -8.0F, -9.0F, 10.0F, 9.0F, 9.0F, new Dilation(0.5F)), ModelTransform.NONE);
        modelPartData3.addChild("left_saddle_mouth", ModelPartBuilder.create().uv(29, 5).cuboid(2.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, dilation), ModelTransform.NONE);
        modelPartData3.addChild("right_saddle_mouth", ModelPartBuilder.create().uv(29, 5).cuboid(-3.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, dilation), ModelTransform.NONE);
        modelPartData3.addChild("left_saddle_line", ModelPartBuilder.create().uv(32, 2).cuboid(3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F, dilation), ModelTransform.rotation(-0.5235988F, 0.0F, 0.0F));
        modelPartData3.addChild("right_saddle_line", ModelPartBuilder.create().uv(32, 2).cuboid(-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F, dilation), ModelTransform.rotation(-0.5235988F, 0.0F, 0.0F));
        modelPartData3.addChild("head_saddle", ModelPartBuilder.create().uv(1, 1).cuboid(-3.0F, -11.0F, -1.9F, 6.0F, 5.0F, 6.0F, new Dilation(0.2F)), ModelTransform.NONE);
        modelPartData3.addChild("mouth_saddle_wrap", ModelPartBuilder.create().uv(19, 0).cuboid(-2.0F, -11.0F, -4.0F, 4.0F, 5.0F, 2.0F, new Dilation(0.2F)), ModelTransform.NONE);
        modelPartData4.addChild(EntityModelPartNames.LEFT_EAR, ModelPartBuilder.create().uv(19, 16).cuboid(0.55F, -13.0F, 4.0F, 2.0F, 3.0F, 1.0F, new Dilation(-0.001F)), ModelTransform.NONE);
        modelPartData4.addChild(EntityModelPartNames.RIGHT_EAR, ModelPartBuilder.create().uv(19, 16).cuboid(-2.55F, -13.0F, 4.0F, 2.0F, 3.0F, 1.0F, new Dilation(-0.001F)), ModelTransform.NONE);
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(13,13).cuboid(0.0f, 0.0F, 0.0F, 1.0F, 6.0F, 1.0F);
        modelPartData3.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.LEFT_FIN, modelPartBuilder, ModelTransform.pivot(-2.0F, -16, 2.0F));
        modelPartData3.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.RIGHT_FIN, modelPartBuilder, ModelTransform.pivot(1.0F, -16f, 2.0F));
        return modelData;
    }
}
