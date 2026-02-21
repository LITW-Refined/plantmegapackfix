package de.pilz.plantmegapackfix.mixins.late;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import plantmegapack.worldgen.PMPGenBase;

@Mixin(PMPGenBase.class)
public class PMPGenBaseMixin {

    @WrapOperation(
        method = "isAdjacentToBlockMaterial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getMaterial()Lnet/minecraft/block/material/Material;"))
    private static Material isAdjacentToBlockMaterial$avoidNullPointerException(Block block,
        Operation<Material> original) {
        if (block == null) {
            return null;
        }
        return original.call(block);
    }

    @WrapOperation(
        method = "isAdjacentToAirBlock",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getMaterial()Lnet/minecraft/block/material/Material;"))
    private static Material isAdjacentToAirBlock$avoidNullPointerException(Block block, Operation<Material> original) {
        if (block == null) {
            return null;
        }
        return original.call(block);
    }

    @WrapOperation(
        method = "isAdjacentToAirOrLeafBlock",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getMaterial()Lnet/minecraft/block/material/Material;"))
    private static Material isAdjacentToAirOrLeafBlock$avoidNullPointerException(Block block,
        Operation<Material> original) {
        if (block == null) {
            return null;
        }
        return original.call(block);
    }

    @WrapOperation(
        method = "isAdjacentToPlantSpawnBlock",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getMaterial()Lnet/minecraft/block/material/Material;"))
    private static Material isAdjacentToPlantSpawnBlock$avoidNullPointerException(Block block,
        Operation<Material> original) {
        if (block == null) {
            return null;
        }
        return original.call(block);
    }

    @WrapOperation(
        method = "isAdjacentToAirOrVineBlock",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getMaterial()Lnet/minecraft/block/material/Material;"))
    private static Material isAdjacentToAirOrVineBlock$avoidNullPointerException(Block block,
        Operation<Material> original) {
        if (block == null) {
            return null;
        }
        return original.call(block);
    }

    @Inject(method = "isLeafBlock(Lnet/minecraft/block/Block;)Z", cancellable = true, remap = false, at = @At("INVOKE"))
    private static void isLeafBlock$ignoreNullBlock(Block block, CallbackInfoReturnable<Boolean> ci) {
        if (block == null) {
            ci.setReturnValue(false);
            ci.cancel();
        }
    }
}
