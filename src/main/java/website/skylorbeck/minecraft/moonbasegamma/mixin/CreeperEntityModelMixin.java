package website.skylorbeck.minecraft.moonbasegamma.mixin;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreeperEntityModel.class)
public class CreeperEntityModelMixin {
    private ModelPart leftLeg;
    private ModelPart rightLeg;


    @Inject(at = @At(value = "RETURN"), method = "<init>")
    public void injected(ModelPart root, CallbackInfo ci){
        this.rightLeg = root.getChild(EntityModelPartNames.RIGHT_LEG);
        this.leftLeg = root.getChild(EntityModelPartNames.LEFT_LEG);
    }

    @Inject(at = @At(value = "RETURN"), method = "setAngles")
    public void injected(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, CallbackInfo ci){
        this.leftLeg.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
        this.rightLeg.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
    }
}
