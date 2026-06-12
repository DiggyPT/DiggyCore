package net.phoenix.diggycore.common.data;

import com.gregtechceu.gtceu.api.data.worldgen.GTOreDefinition;
import com.gregtechceu.gtceu.api.data.worldgen.WorldGenLayers;
import com.gregtechceu.gtceu.api.data.worldgen.generator.indicators.SurfaceIndicatorGenerator;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.phoenix.diggycore.DiggyCore;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.common.data.GTOres.*;
import static net.phoenix.diggycore.common.data.materials.DiggyMetallurgicAndGems.*;

public class DiggyOres {

    private static final Map<ResourceLocation, GTOreDefinition> toReRegister = new HashMap<>();

    private static GTOreDefinition create(String name, Consumer<GTOreDefinition> config) {
        return create(DiggyCore.id(name), config);
    }

    public static GTOreDefinition create(ResourceLocation name, Consumer<GTOreDefinition> config) {
        GTOreDefinition def = blankOreDefinition();
        config.accept(def);

        def.register(name);
        toReRegister.put(name, def);

        return def;
    }

    public static void init() {
        toReRegister.forEach(GTRegistries.ORE_VEINS::registerOrOverride);
    }

    public static final GTOreDefinition ISAACMANITE_VEIN = create(DiggyCore.id("isaacmanite_vein"), vein -> vein
            .clusterSize(UniformInt.of(48, 80)).density(0.25f).weight(30)
            .layer(WorldGenLayers.ENDSTONE)
            .heightRangeUniform(10, 90)
            .biomes(BiomeTags.IS_END)
            .cuboidVeinGenerator(generator -> generator
                    .top(b -> b.mat(ISAACMANITE).size(2))
                    .middle(b -> b.mat(GUNNERITE).size(3))
                    .bottom(b -> b.mat(ISAACMANITE).size(2))
                    .spread(b -> b.mat(GUNNERITE)))
            .surfaceIndicatorGenerator(indicator -> indicator
                    .surfaceRock(ISAACMANITE)
                    .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE)));
}
