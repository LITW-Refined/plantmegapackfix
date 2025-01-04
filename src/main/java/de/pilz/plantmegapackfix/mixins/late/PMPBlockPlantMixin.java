package de.pilz.plantmegapackfix.mixins.late;

import net.minecraft.block.Block;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;

import plantmegapack.block.PMPBlockPlant;
import plantmegapack.common.PMPPlantGrowthType;

@Mixin(PMPBlockPlant.class)
public abstract class PMPBlockPlantMixin {

    @ModifyExpressionValue(
        method = "onNeighborBlockChange",
        at = @At(
            value = "INVOKE",
            target = "Lplantmegapack/block/PMPBlockPlant;canBlockStay(Lnet/minecraft/world/World;III)Z"),
        remap = false)
    private boolean pmpfix$onNeighborBlockChange$ignoreSweared(boolean original, World world, int x, int y, int z,
        @Local Block block) {
        return original || (block instanceof PMPBlockPlant
            && ((PMPBlockPlant) block).plantData.attributes.growthType == PMPPlantGrowthType.SEAWEED);
    }
}
