package de.pilz.plantmegapackfix.mixins;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import plantmegapack.block.PMPBlockPlant;
import plantmegapack.worldgen.PMPSpawnLocation;

@Mixin(plantmegapack.worldgen.PMPGenVine.class)
public abstract class PMPGenVineMixin {

    @Inject(
        method = "spawnVine(Lnet/minecraft/world/World;Ljava/util/Random;Lplantmegapack/worldgen/PMPSpawnLocation;ILplantmegapack/block/PMPBlockPlant;)Z",
        at = @At("HEAD"),
        cancellable = true,
        remap = false)
    private static void spawnVine(World world, Random random, PMPSpawnLocation locationData, int metaData,
        PMPBlockPlant plant, CallbackInfoReturnable<Boolean> clb) {
        int height = 0;
        int y;
        Block block;

        do {
            ++height;
            y = locationData.y - height;
            block = world.getBlock(locationData.x, y, locationData.z);
        } while (y > 1 && block.getMaterial() == Material.air);

        if (y > 1) {
            for (int actualHeight = locationData.y - random.nextInt(Math.max(1, height)); actualHeight
                <= locationData.y; ++actualHeight) {
                world.setBlock(locationData.x, actualHeight, locationData.z, plant, metaData, 3);
            }
        }

        clb.setReturnValue(true);
        clb.cancel();
    }
}
