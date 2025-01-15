package de.pilz.plantmegapackfix.mixins.late;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;

import plantmegapack.block.PMPBlockPlant;
import plantmegapack.data.PMPDataPlantSpawnParams;
import plantmegapack.worldgen.PMPSpawnLocation;

@Mixin(plantmegapack.worldgen.PMPGenVine.class)
public abstract class PMPGenVineMixin {

    @WrapOperation(
        method = "spawnVine",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getMaterial()Lnet/minecraft/block/material/Material;"),
        remap = false)
    private static Material pmpfix$spawnVine$ensurePositiveHeight(Block block, Operation<Material> original, World world, Random random, PMPSpawnLocation locationData, PMPDataPlantSpawnParams params, PMPBlockPlant plant, @Local int height) {
        if (locationData.y - height > 1) {
            return original.call(block);
        }
        return null;
    }

    @Inject(
        method = "spawnVine",
        at = @At(value = "INVOKE", shift = Shift.BEFORE, target = "Ljava/util/Random;nextInt(I)I"),
        cancellable = true,
        remap = false)
    private static void pmpfix$spawnVine$checkHeight(World world, Random random, PMPSpawnLocation locationData, int metaData,
        PMPBlockPlant plant, CallbackInfoReturnable<Boolean> clb, @Local int height) {
        if (locationData.y - height <= 1) {
            clb.setReturnValue(true);
            clb.cancel();
        }
    }
}
