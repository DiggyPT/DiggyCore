package net.phoenix.diggycore.common;

import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class DiggyPlanetUtils {

    public static final ResourceLocation TAU_CETI = ResourceLocation.fromNamespaceAndPath("diggyfactory", "tau_ceti");
    // you can also use ResourceLocation.parse() to write only 1 thing ("diggyfactory:tau_ceti")
    public static final ResourceLocation TAU_CETI_E = ResourceLocation.fromNamespaceAndPath("diggycore",
            "textures/environment/tauceti_e.png");
    public static final ResourceLocation TAU_CETI_F = ResourceLocation.fromNamespaceAndPath("diggycore",
            "textures/environment/tauceti_f.png");
    public static final ResourceLocation TAU_CETI_G = ResourceLocation.fromNamespaceAndPath("diggycore",
            "textures/environment/tauceti_g.png");
    public static final ResourceLocation TAU_CETI_H = ResourceLocation.fromNamespaceAndPath("diggycore",
            "textures/environment/tauceti_h.png");
    public static final List<ResourceLocation> TAU_CETI_TEXTURES;

    static {
        TAU_CETI_TEXTURES = List.of(TAU_CETI_G, TAU_CETI_H, TAU_CETI_E, TAU_CETI_F);
    }
}
