package net.phoenix.diggycore.common.data.recipe.processinglines;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class DiggyProcessingLinesInit {

    public static void init(Consumer<FinishedRecipe> provider) {
        DysprosiumLine.init(provider);
    }
}
