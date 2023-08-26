package dev.isxander.tmrd.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import me.jellysquid.mods.sodium.client.gui.SodiumGameOptionPages;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;

@Pseudo
@Mixin(value = SodiumGameOptionPages.class, remap = false)
public class SodiumGameOptionPagesMixin {
    @ModifyExpressionValue(
            method = "lambda$general$0", // lambda of setControl in general()
            at = @At(value = "CONSTANT", args = "intValue=32", ordinal = 0)
    )
    private static int modifyMaxRenderDistance(int original) {
        return 256;
    }
}
