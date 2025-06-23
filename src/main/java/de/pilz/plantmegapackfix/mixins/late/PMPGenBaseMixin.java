package de.pilz.plantmegapackfix.mixins.late;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

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
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;"))
    private static Block isAdjacentToBlockMaterial$checkBlockExists(World world, int x, int y, int z,
        Operation<Block> original) {
        if (!world.blockExists(x, y, z)) {
            return null;
        }
        return original.call(world, x, y, z);
    }

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
        method = "isLogBlock(Lnet/minecraft/world/World;III)Z",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;"))
    private static Block isLogBlock$checkBlockExists(World world, int x, int y, int z, Operation<Block> original) {
        if (!world.blockExists(x, y, z)) {
            return null;
        }
        return original.call(world, x, y, z);
    }

    @WrapOperation(
        method = "isSurroundedByBlock",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;"))
    private static Block isSurroundedByBlock$checkBlockExists(World world, int x, int y, int z,
        Operation<Block> original) {
        if (!world.blockExists(x, y, z)) {
            return null;
        }
        return original.call(world, x, y, z);
    }

    @WrapOperation(
        method = "isVanillaPlant",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;"))
    private static Block isVanillaPlant$checkBlockExists(World world, int x, int y, int z, Operation<Block> original) {
        if (!world.blockExists(x, y, z)) {
            return null;
        }
        return original.call(world, x, y, z);
    }

    @WrapOperation(
        method = "isAdjacentToAirBlock",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;"))
    private static Block isAdjacentToAirBlock$checkBlockExists(World world, int x, int y, int z,
        Operation<Block> original) {
        if (!world.blockExists(x, y, z)) {
            return null;
        }
        return original.call(world, x, y, z);
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
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;"))
    private static Block isAdjacentToAirOrLeafBlock$checkBlockExists(World world, int x, int y, int z,
        Operation<Block> original) {
        if (!world.blockExists(x, y, z)) {
            return null;
        }
        return original.call(world, x, y, z);
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
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;"))
    private static Block isAdjacentToPlantSpawnBlock$checkBlockExists(World world, int x, int y, int z,
        Operation<Block> original) {
        if (!world.blockExists(x, y, z)) {
            return null;
        }
        return original.call(world, x, y, z);
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
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;"))
    private static Block isAdjacentToAirOrVineBlock$checkBlockExists(World world, int x, int y, int z,
        Operation<Block> original) {
        if (!world.blockExists(x, y, z)) {
            return null;
        }
        return original.call(world, x, y, z);
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

    @WrapOperation(
        method = "surroundPlantWithGrass",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockTallGrass;canPlaceBlockAt(Lnet/minecraft/world/World;III)Z"))
    private static boolean surroundPlantWithGrass$checkBlockExists(BlockTallGrass block, World world, int x, int y,
        int z, Operation<Boolean> original) {
        if (!world.blockExists(x, y, z)) {
            return false;
        }
        return original.call(block, world, x, y, z);
    }

    @WrapOperation(
        method = "checkAndAdjustSpawnForBlock",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;"))
    private static Block checkAndAdjustSpawnForBlock$checkBlockExists(World world, int x, int y, int z,
        Operation<Block> original) {
        if (!world.blockExists(x, y, z)) {
            return null;
        }
        return original.call(world, x, y, z);
    }

    @WrapOperation(
        method = "isGroundBlock(Lnet/minecraft/world/World;III)Z",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;"))
    private static Block isGroundBlock$checkBlockExists(World world, int x, int y, int z, Operation<Block> original) {
        if (!world.blockExists(x, y, z)) {
            return null;
        }
        return original.call(world, x, y, z);
    }

    @WrapOperation(
        method = "isLargeMushroomBlock(Lnet/minecraft/world/World;III)Z",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;"))
    private static Block isLargeMushroomBlock$checkBlockExists(World world, int x, int y, int z,
        Operation<Block> original) {
        if (!world.blockExists(x, y, z)) {
            return null;
        }
        return original.call(world, x, y, z);
    }

    @WrapOperation(
        method = "isLeafBlock(Lnet/minecraft/world/World;III)Z",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;"))
    private static Block isLeafBlock$checkBlockExists(World world, int x, int y, int z, Operation<Block> original) {
        if (!world.blockExists(x, y, z)) {
            return null;
        }
        return original.call(world, x, y, z);
    }

    @Inject(method = "isLeafBlock(Lnet/minecraft/block/Block;)Z", cancellable = true, remap = false, at = @At("INVOKE"))
    private static void isLeafBlock$ignoreNullBlock(Block block, CallbackInfoReturnable<Boolean> ci) {
        if (block == null) {
            ci.setReturnValue(false);
            ci.cancel();
        }
    }

    @WrapOperation(
        method = "spawnRandomBambooPlantCluster",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;"))
    private static Block spawnRandomBambooPlantCluster$checkBlockExists(World world, int x, int y, int z,
        Operation<Block> original) {
        if (!world.blockExists(x, y, z)) {
            return null;
        }
        return original.call(world, x, y, z);
    }

    @WrapOperation(
        method = "canReplaceBlockWithPlant(Lnet/minecraft/world/World;IIIZ)Z",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;"))
    private static Block canReplaceBlockWithPlant$checkBlockExists(World world, int x, int y, int z,
        Operation<Block> original) {
        if (!world.blockExists(x, y, z)) {
            return null;
        }
        return original.call(world, x, y, z);
    }
}
