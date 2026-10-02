package net.phoenix.diggycore.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.phoenix.diggycore.api.machine.IGreenhouseMachine;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;
import net.phoenix.diggycore.common.utils.DiggyValues;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Greenhouse extends WorkableElectricMultiblockMachine implements IGreenhouseMachine {

    public int nitrogenAmount = 0; // Measured in %
    public int temperature = 20; // Measured in ºC (-20ºC - 80 ºC, default 20)
    public int moisture = 0; // Measured in %
    public int pH = 7; // Measured in pH (0 pH - 14 pH, default 7)
    public int radioactivity = 0; // Measured in rads (0 rads - 100 rads, default 0) (70 rads: radiation poisoning btw)
    public int emc = 0; // Soil EMC, measured in, well, EMC (0 EMC - 10,000 EMC, default 0)

    public Greenhouse(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    // GUI
    @Override
    public void addDisplayText(List<Component> textList) {
        MultiblockDisplayText.Builder builder = MultiblockDisplayText.builder(textList, isFormed())
                .setWorkingStatus(recipeLogic.isWorkingEnabled(), recipeLogic.isActive());
        builder.addWorkingStatusLine();
        textList.add(environmentText("Soil nitrogen", ChatFormatting.GREEN, nitrogenAmount, "%"));
        textList.add(progressbarFinalised(nitrogenAmount / 10, ChatFormatting.GREEN));
        textList.add(environmentText("Temperature", ChatFormatting.GOLD, temperature, " ºC"));
        textList.add(progressbarFinalised((temperature + 20) / 10, ChatFormatting.GOLD));
        textList.add(environmentText("Moisture", ChatFormatting.BLUE, moisture, "%"));
        textList.add(progressbarFinalised(moisture / 10, ChatFormatting.BLUE));
        textList.add(environmentText("pH", ChatFormatting.RED, pH, "pH"));
        textList.add(progressbarFinalised(pH * 10 / 14, ChatFormatting.RED));
        textList.add(environmentText("Radioactivity", ChatFormatting.DARK_GREEN, radioactivity, " rads"));
        textList.add(progressbarFinalised(radioactivity / 10, ChatFormatting.DARK_GREEN));
        textList.add(environmentText("Soil EMC", ChatFormatting.LIGHT_PURPLE, emc, " EMC"));
        textList.add(progressbarFinalised(emc / 100, ChatFormatting.LIGHT_PURPLE));
    }

    public MutableComponent environmentText(String variable, ChatFormatting colour, int value, String unit) {
        return Component.literal(variable + ": ").withStyle(colour).append(Integer.toString(value)).append(unit);
    }

    public MutableComponent progressbarFinalised(int variable, ChatFormatting colour) {
        return Component.literal(progressBar(variable)).withStyle(colour);
    }

    // Returns the appropriate character for a progress bar
    public String progressBarComponent(int amount, int index) {
        if (amount >= index) {
            return "|";
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

    // Wtf is happening lol
    public static @NotNull ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (!(machine instanceof Greenhouse greenhouseMachine)) return ModifierFunction.NULL;
        if (recipe.getType() != DiggyRecipeTypes.GREENHOUSE_RECIPES) return ModifierFunction.NULL;
        // Here we are going to calculate max parallels for this recipe just now
        /*
         * var maximumParallels = (int) (greenhouseMachine.getOverclockVoltage() / recipe.getInputEUt().getTotalEU());
         * var realParallels = ParallelLogic.getParallelAmountWithoutEU(greenhouseMachine, recipe, maximumParallels);
         * if (realParallels == 0) return ModifierFunction.NULL;
         * return ModifierFunction.builder().modifyAllContents(ContentModifier.multiplier(realParallels))
         * .parallels(realParallels).durationMultiplier(0.1).build();
         */
        return ModifierFunction.builder().modifyAllContents(ContentModifier.multiplier(1))
                .parallels(1).durationMultiplier(0.1).build();
    }

    @Override
    public @NotNull GreenhouseRecipeLogic getRecipeLogic() {
        return (GreenhouseRecipeLogic) super.getRecipeLogic();
    }

    /*
     * @Override
     * public boolean onWorking() {
     * boolean value = super.onWorking();
     * // check lubricant
     * 
     * if (runningTimer % 72 == 0) {
     * // insufficient lubricant
     * if (!RecipeHelper.handleRecipeIO(this, getNitrogenRecipe(), IO.IN, this.recipeLogic.getChanceCaches())
     * .isSuccess()) {
     * recipeLogic.interruptRecipe();
     * return false;
     * } else if (nitrogenAmount < 100) {
     * nitrogenAmount += 1;
     * System.out.println(nitrogenAmount);
     * }
     * }
     * 
     * runningTimer++;
     * if (runningTimer > 72000) runningTimer %= 72000; // reset once every hour of running
     * 
     * return value;
     * }
     */

    public int getGreenhouseNitrogen() {
        return nitrogenAmount;
    }

    public int getGreenhouseTemperature() {
        return temperature;
    }

    public int getGreenhouseMoisture() {
        return moisture;
    }

    public int getGreenhousePH() {
        return pH;
    }

    public int getGreenhouseRadioactivity() {
        return radioactivity;
    }

    public int getGreenhouseEMC() {
        return emc;
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new GreenhouseRecipeLogic(this);
    }

    // Decreases the appropriate values
    @Override
    public void afterWorking() {
        super.afterWorking();
        var recipeLogic = getRecipeLogic();
        var lastRecipe = recipeLogic.getLastRecipe();
        if (lastRecipe != null) {
            // This is totally the best way to do this uwu
            if (lastRecipe.data.contains(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED)) {
                var consumedValue = lastRecipe.data.getInt(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED);// *
                                                                                                      // lastRecipe.parallels;
                nitrogenAmount = DiggyValues.clamp(nitrogenAmount - consumedValue, 0, 100);
            }
            if (lastRecipe.data.contains(DiggyRecipeTypes.GREENHOUSE_TEMPERATURE_USED)) {
                var consumedValue = lastRecipe.data.getInt(DiggyRecipeTypes.GREENHOUSE_TEMPERATURE_USED);// *
                                                                                                         // lastRecipe.parallels;
                temperature = DiggyValues.clamp(temperature - consumedValue, -20, 80);
            }
            if (lastRecipe.data.contains(DiggyRecipeTypes.GREENHOUSE_MOISTURE_USED)) {
                var consumedValue = lastRecipe.data.getInt(DiggyRecipeTypes.GREENHOUSE_MOISTURE_USED);// *
                                                                                                      // lastRecipe.parallels;
                moisture = DiggyValues.clamp(moisture - consumedValue, 0, 100);
            }
            if (lastRecipe.data.contains(DiggyRecipeTypes.GREENHOUSE_PH_USED)) {
                var consumedValue = lastRecipe.data.getInt(DiggyRecipeTypes.GREENHOUSE_PH_USED);// *
                                                                                                // lastRecipe.parallels;
                pH = DiggyValues.clamp(pH - consumedValue, 0, 14);
            }
            if (lastRecipe.data.contains(DiggyRecipeTypes.GREENHOUSE_RADIOACTIVITY_USED)) {
                var consumedValue = lastRecipe.data.getInt(DiggyRecipeTypes.GREENHOUSE_RADIOACTIVITY_USED);// *
                                                                                                           // lastRecipe.parallels;
                radioactivity = DiggyValues.clamp(radioactivity - consumedValue, 0, 100);
            }
            if (lastRecipe.data.contains(DiggyRecipeTypes.GREENHOUSE_EMC_USED)) {
                var consumedValue = lastRecipe.data.getInt(DiggyRecipeTypes.GREENHOUSE_EMC_USED);// *
                                                                                                 // lastRecipe.parallels;
                emc = DiggyValues.clamp(emc - consumedValue, 0, 10000);
            }
        }
    }
}
