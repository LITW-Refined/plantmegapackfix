package de.pilz.plantmegapackfix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;

@Mod(
    modid = PMPFix.MODID,
    version = Tags.VERSION,
    name = "PlantMegaPack Fixes",
    acceptedMinecraftVersions = "[1.7.10]",
    dependencies = "required-after:plantmegapack",
    acceptableRemoteVersions = "*")
public class PMPFix {

    public static final String MODID = "plantmegapackfix";
    public static final Logger LOG = LogManager.getLogger(MODID);
}
