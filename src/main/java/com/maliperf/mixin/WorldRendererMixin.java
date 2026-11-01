package com.maliperf.mixin;

import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    // Cancela a renderização de nuvens para economizar processamento na GPU Mali
    @Inject(method = "renderClouds", at = @At("HEAD"), cancellable = true)
    private void cancelClouds(CallbackInfo ci) {
        ci.cancel();
    }
}
