package io.github.itsilya.nobbdupe.nobbdupe.mixin;

import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinBrain.class)
public class PiglinBrainMixin {
    @Inject(method = "canGather", at = @At(value = "HEAD", target = "Lnet/minecraft/entity/mob/AbstractPiglinEntity;zombify(Lnet/minecraft/server/world/ServerWorld;)V"), cancellable = true)
    private static void modify$canGather(PiglinEntity piglin, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (piglin.isBaby()) {
            cir.setReturnValue(false);
        }
    }
}
