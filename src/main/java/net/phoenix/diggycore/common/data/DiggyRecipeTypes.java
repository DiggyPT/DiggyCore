package net.phoenix.diggycore.common.data;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;

import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class DiggyRecipeTypes {

    public static GTRecipeType APIARY_RECIPES;
    public static GTRecipeType GC_COMPRESSOR_RECIPES;
    public static GTRecipeType CYCLOTRON_RECIPES;
    public static GTRecipeType PARTICLE_BEAM_ENGRAVER_RECIPES;

    public static void init() {
        APIARY_RECIPES = register("apiary", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(3, 3, 1, 0)
                .setSlotOverlay(true, false, GuiTextures.CRYSTAL_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.REPLICATOR);

        GC_COMPRESSOR_RECIPES = register("gc_compressor", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(6, 1, 0, 0)
                .setSlotOverlay(false, false, GuiTextures.HAMMER_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_HAMMER, ProgressTexture.FillDirection.UP_TO_DOWN)
                .setSound(GTSoundEntries.FORGE_HAMMER);

        CYCLOTRON_RECIPES = register("cyclotron", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(9, 9, 1, 0)
                .setSlotOverlay(false, false, GuiTextures.ATOMIC_OVERLAY_1)
                .setSlotOverlay(true, false, GuiTextures.ATOMIC_OVERLAY_2)
                .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.REPLICATOR);

        PARTICLE_BEAM_ENGRAVER_RECIPES = register("particle_beam_engraver", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(3, 1, 0, 0)
                .setSlotOverlay(false, false, true, GuiTextures.LENS_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.REPLICATOR);
    }
}
