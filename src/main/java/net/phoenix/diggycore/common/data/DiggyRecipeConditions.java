package net.phoenix.diggycore.common.data;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

import net.phoenix.diggycore.data.recipe.condition.*;

public class DiggyRecipeConditions {

    public static RecipeConditionType<GreenhouseNitrogenCondition> GREENHOUSE_NITROGEN;
    public static RecipeConditionType<GreenhouseTemperatureCondition> GREENHOUSE_TEMPERATURE;
    public static RecipeConditionType<GreenhouseMoistureCondition> GREENHOUSE_MOISTURE;
    public static RecipeConditionType<GreenhousePHCondition> GREENHOUSE_PH;
    public static RecipeConditionType<GreenhouseRadioactivityCondition> GREENHOUSE_RADIOACTIVITY;
    public static RecipeConditionType<GreenhouseEMCCondition> GREENHOUSE_EMC;

    public static void registerConditions(GTCEuAPI.RegisterEvent<String, RecipeConditionType<?>> event) {
        GREENHOUSE_NITROGEN = GTRegistries.RECIPE_CONDITIONS.register("greenhouse_nitrogen", //
                new RecipeConditionType<>(GreenhouseNitrogenCondition::new, GreenhouseNitrogenCondition.CODEC));
        GREENHOUSE_TEMPERATURE = GTRegistries.RECIPE_CONDITIONS.register("greenhouse_temperature", //
                new RecipeConditionType<>(GreenhouseTemperatureCondition::new, GreenhouseTemperatureCondition.CODEC));
        GREENHOUSE_MOISTURE = GTRegistries.RECIPE_CONDITIONS.register("greenhouse_moisture", //
                new RecipeConditionType<>(GreenhouseMoistureCondition::new, GreenhouseMoistureCondition.CODEC));
        GREENHOUSE_PH = GTRegistries.RECIPE_CONDITIONS.register("greenhouse_ph", //
                new RecipeConditionType<>(GreenhousePHCondition::new, GreenhousePHCondition.CODEC));
        GREENHOUSE_RADIOACTIVITY = GTRegistries.RECIPE_CONDITIONS.register("greenhouse_radioactivity", //
                new RecipeConditionType<>(GreenhouseRadioactivityCondition::new,
                        GreenhouseRadioactivityCondition.CODEC));
        GREENHOUSE_EMC = GTRegistries.RECIPE_CONDITIONS.register("greenhouse_emc", //
                new RecipeConditionType<>(GreenhouseEMCCondition::new, GreenhouseEMCCondition.CODEC));
    }
}
