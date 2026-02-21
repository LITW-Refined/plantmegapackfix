package de.pilz.plantmegapackfix.core;

import java.util.List;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;
import com.gtnewhorizon.gtnhmixins.builders.IMixins;

import de.pilz.plantmegapackfix.PMPFixMixins;

@LateMixin
public class PMPFixMixinLoaderLate implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.plantmegapackfix.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        return IMixins.getLateMixins(PMPFixMixins.class, loadedMods);
    }
}
