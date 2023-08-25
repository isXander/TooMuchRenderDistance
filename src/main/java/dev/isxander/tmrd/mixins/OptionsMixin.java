package dev.isxander.tmrd.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Options.class)
public class OptionsMixin {
    @ModifyExpressionValue(
            method = "<init>",
            at = {
                    @At(value = "CONSTANT", args = "intValue=32", ordinal = 0),
                    @At(value = "CONSTANT", args = "intValue=16", ordinal = 0)
            },
            slice = @Slice(from = @At(value = "INVOKE", target = "Ljava/lang/Runtime;maxMemory()J")))
    private int modifyMaxRenderDistance(int original) {
        return 256;
    }
}
