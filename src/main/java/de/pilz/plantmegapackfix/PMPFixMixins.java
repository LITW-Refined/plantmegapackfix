package de.pilz.plantmegapackfix;

import java.util.function.Supplier;

import com.gtnewhorizon.gtnhmixins.builders.IMixins;
import com.gtnewhorizon.gtnhmixins.builders.MixinBuilder;

public enum PMPFixMixins implements IMixins {

    FIX_GENERAL(Side.COMMON, Phase.LATE, () -> true, "PMPGenVineMixin", "PMPWorldGeneratorMixin", "PMPGenBaseMixin",
        "PMPGenAquaticMixin", "PMPBlockPlantMixin"),
    FIX_CASCADE_CHUNKLOADING(Side.COMMON, Phase.EARLY, () -> true, "MixinChunkProviderServer");

    private final MixinBuilder builder;

    PMPFixMixins(Side side, Phase phase, String... mixins) {
        builder = new MixinBuilder().addSidedMixins(side, mixins)
            .setPhase(phase);
    }

    PMPFixMixins(Side side, Phase phase, Supplier<Boolean> applyIf, String... mixins) {
        builder = new MixinBuilder().addSidedMixins(side, mixins)
            .setPhase(phase)
            .setApplyIf(applyIf);
    }

    @Override
    public MixinBuilder getBuilder() {
        return builder;
    }
}
