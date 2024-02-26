package de.pilz.plantmegapackfix;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

@LateMixin
public class PMPFixMixinLoaderLate implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.plantmegapackfix.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        List<String> list = new ArrayList<String>();

        // Mystcraft
        if (loadedMods.contains("plantmegapack")) {
            list.add("PMPGenVineMixin");
        }

        return list;
    }
}
