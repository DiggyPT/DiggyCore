package net.phoenix.diggycore.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.ingredient.EnergyStack;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraftforge.fluids.FluidStack;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Greenhouse extends WorkableElectricMultiblockMachine {

    private static final FluidStack NITROGEN_STACK = GTMaterials.Nitrogen.getFluid(1000);

    private int runningTimer = 0;
    private int nitrogenAmount = 0;

    public Greenhouse(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    // GUI
    @Override
    public void addDisplayText(List<Component> textList) {
        MultiblockDisplayText.Builder builder = MultiblockDisplayText.builder(textList, isFormed())
                .setWorkingStatus(recipeLogic.isWorkingEnabled(), recipeLogic.isActive());
        builder.addWorkingStatusLine();
        textList.add(Component.literal("Nitrogen percentage: ").withStyle(ChatFormatting.GREEN)
                .append(Integer.toString(nitrogenAmount * 10)).append("%"));
        textList.add(Component.literal(progressBar(nitrogenAmount)).withStyle(ChatFormatting.GREEN));
    }

    // Returns the appropriate character for a progress bar
    public String progressBarComponent(int amount, int index) {
        if (amount >= index) {
            return "#";
        } else {
            return " ";
        }
    }

    // Returns a progress bar
    public String progressBar(int amount) {
        StringBuilder bar = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            bar.append(progressBarComponent(amount, i));
        }
        return bar.toString();
    }

    public static ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (!(machine instanceof Greenhouse engineMachine)) {
            return RecipeModifier.nullWrongType(Greenhouse.class, machine);
        }
        EnergyStack EUt = recipe.getOutputEUt();
        // has lubricant
        if (!EUt.isEmpty() &&
                RecipeHelper.matchRecipe(engineMachine, engineMachine.getNitrogenRecipe()).isSuccess()) {
            int maxParallel = (int) (engineMachine.getOverclockVoltage() / EUt.getTotalEU()); // get maximum parallel
            int actualParallel = ParallelLogic.getParallelAmount(engineMachine, recipe, maxParallel);

            return ModifierFunction.builder()
                    .inputModifier(ContentModifier.multiplier(actualParallel))
                    .outputModifier(ContentModifier.multiplier(actualParallel))
                    .eutMultiplier(actualParallel)
                    .parallels(actualParallel)
                    .build();
        }
        return ModifierFunction.NULL;
    }

    protected GTRecipe getNitrogenRecipe() {
        return GTRecipeBuilder.ofRaw().inputFluids(NITROGEN_STACK).buildRawRecipe();
    }

    @Override
    public boolean onWorking() {
        boolean value = super.onWorking();
        // check lubricant

        if (runningTimer % 72 == 0) {
            // insufficient lubricant
            if (!RecipeHelper.handleRecipeIO(this, getNitrogenRecipe(), IO.IN, this.recipeLogic.getChanceCaches())
                    .isSuccess()) {
                recipeLogic.interruptRecipe();
                return false;
            } else if (nitrogenAmount < 10) {
                nitrogenAmount += 1;
            }
        }

        runningTimer++;
        if (runningTimer > 72000) runningTimer %= 72000; // reset once every hour of running

        return value;
    }
}
