package de.pilz.plantmegapackfix.mixins.late;

import net.minecraft.block.Block;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;

import plantmegapack.block.PMPBlockPlant;
import plantmegapack.worldgen.PMPGenAquatic;

@Mixin(PMPGenAquatic.class)
public abstract class PMPGenAquaticMixin {

    @WrapWithCondition(
        method = "spawnRandomSeaweedCluster",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;setBlock(IIILnet/minecraft/block/Block;II)Z"),
        remap = false)
    private static boolean pmpfix$spawnRandomSeaweedCluster$checkForWaterAbove(World world, int x, int y, int z,
        Block blockIn, int metadataIn, int flags) {
        PMPBlockPlant plant = (PMPBlockPlant) blockIn;
        if (!plant.canPlaceBlockAt(world, x, y, z)) return false;
        return true;
    }
}
