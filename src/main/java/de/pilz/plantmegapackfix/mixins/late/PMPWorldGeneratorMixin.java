package de.pilz.plantmegapackfix.mixins.late;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.IChunkProvider;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;

import de.pilz.plantmegapackfix.PMPFix;
import plantmegapack.PlantMegaPack;

@Mixin(plantmegapack.worldgen.PMPWorldGenerator.class)
public abstract class PMPWorldGeneratorMixin {

    @Shadow(remap = false)
    private void generateNether(World world, Random random, int chunkX, int chunkZ) {}

    @Shadow(remap = false)
    private void generateSurface(World world, Random random, int chunkX, int chunkZ) {}

    @Shadow(remap = false)
    private void generateEnd(World world, Random random, int chunkX, int chunkZ) {}

    @Inject(method = "generate", at = @At("RETURN"), cancellable = false, remap = false)
    private void pmpfix$generate$checkWorldProviderSuface(Random random, int chunkX, int chunkZ, World world,
        IChunkProvider chunkGenerator, IChunkProvider chunkProvider, CallbackInfo callback) {
        if (world.provider.dimensionId == 0 || world.provider.dimensionId == -1 || world.provider.dimensionId == 1) {
            // Handled by original already
            return;
        }
        if (world.provider.isSurfaceWorld()) {
            if (PlantMegaPack.settings.worldgenOverworldRate > 0) {
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
            }
        } else if (world.provider instanceof WorldProviderHell) {
            if (PlantMegaPack.settings.worldgenNetherRate > 0) {
                generateNether(world, random, chunkX * 16, chunkZ * 16);
            }
        } else if (world.provider instanceof WorldProviderEnd) {
            if (PlantMegaPack.settings.worldgenOverworldRate > 0) {
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
            }
        }
    }

    @WrapMethod(method = "generate", remap = false)
    private void pmpfix$generate$fixCascadeWorldgen(Random random, int chunkX, int chunkZ, World world,
        IChunkProvider chunkGenerator, IChunkProvider chunkProvider, Operation original) {
        try {
            PMPFix.isDoingWorldGen = true;
            original.call(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
            PMPFix.isDoingWorldGen = false;
        } catch (Exception ex) {
            PMPFix.isDoingWorldGen = false;
            throw ex;
        }
    }
}
