package website.skylorbeck.minecraft.moonbasegamma.mixin;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.EntityModels;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityModels.class)
public class EntityModelsMixin {
    @Redirect(at = @At(value = "INVOKE",target = "Lnet/minecraft/client/render/entity/model/CreeperEntityModel;getTexturedModelData(Lnet/minecraft/client/model/Dilation;)Lnet/minecraft/client/model/TexturedModelData;"), method = "getModels")
    private static TexturedModelData injected(Dilation dilation) {
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
        modelPartBuilder = ModelPartBuilder.create().uv(0, 16).cuboid(0.0f, 0.0F, 0.0F, 1.0F, 6.0F, 1.0F, dilation);
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.LEFT_FIN, modelPartBuilder, ModelTransform.pivot(-3.0F, -14f, -2.0F));
        modelPartData.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.RIGHT_FIN, modelPartBuilder, ModelTransform.pivot(2.0F, -14f, -2.0F));
        return TexturedModelData.of(modelData, 64, 32);
    }
}
