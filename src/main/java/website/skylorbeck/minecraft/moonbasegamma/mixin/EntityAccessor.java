package website.skylorbeck.minecraft.moonbasegamma.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Random;

@Mixin(Entity.class)
public interface EntityAccessor {
    @Accessor
    Random getRandom();
}
