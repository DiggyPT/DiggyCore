package net.phoenix.diggycore.common.data;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;

import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class DiggyRecipeTypes {

    public static GTRecipeType APIARY_RECIPES;

    public static void init() {
        APIARY_RECIPES = register("apiary", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(3, 3, 1, 0)
                .setSlotOverlay(true, false, GuiTextures.CRYSTAL_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.REPLICATOR);
    }
}
