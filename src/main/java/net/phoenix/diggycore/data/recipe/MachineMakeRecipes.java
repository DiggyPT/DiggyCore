package net.phoenix.diggycore.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.common.Tags;
import net.phoenix.diggycore.common.machine.DiggyMachines;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.data.recipe.GTCraftingComponents.*;
import static com.gregtechceu.gtceu.data.recipe.misc.MetaTileEntityLoader.*;

public class MachineMakeRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        // MACHINES
        registerMachineRecipe(provider, DiggyMachines.APIARY,
                "ECE",
                "CMC",
                "WPW",
                'M', HULL,
                'E', CIRCUIT,
                'W', CABLE,
                'C', Tags.Items.FENCES_WOODEN,
                'P', PLATE);
    }
}
