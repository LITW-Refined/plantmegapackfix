package de.pilz.plantmegapackfix.mixins.early;

import net.minecraft.world.gen.ChunkProviderServer;

import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import de.pilz.plantmegapackfix.PMPFix;

@Mixin(ChunkProviderServer.class)
public abstract class MixinChunkProviderServer {

    @ModifyExpressionValue(
        method = "provideChunk",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/world/gen/ChunkProviderServer;loadChunkOnProvideRequest:Z",
            opcode = Opcodes.GETFIELD))
    private boolean alternativechunkloading$provideChunk$allowChunkload(boolean original) {
        return original && !PMPFix.isDoingWorldGen;
    }
}
