package website.skylorbeck.minecraft.moonbasegamma.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import website.skylorbeck.minecraft.moonbasegamma.Registrar;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;isSubmergedIn(Lnet/minecraft/tag/Tag;)Z"), method = "baseTick")
    public boolean injected(LivingEntity livingEntity, Tag<Fluid> fluidTag) {
        BlockPos blockPos = new BlockPos(((LivingEntity) (Object) this).getX(), ((LivingEntity) (Object) this).getEyeY(), ((LivingEntity) (Object) this).getZ());
        return livingEntity.isSubmergedIn(fluidTag) || ((LivingEntity) (Object) this).world.getBlockState(blockPos).isOf(Registrar.spaceblock);
    }
}
