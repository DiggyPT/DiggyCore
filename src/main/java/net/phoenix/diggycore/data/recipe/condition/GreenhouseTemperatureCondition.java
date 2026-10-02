package net.phoenix.diggycore.data.recipe.condition;

import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;

import net.minecraft.network.chat.Component;
import net.phoenix.diggycore.api.machine.IGreenhouseMachine;
import net.phoenix.diggycore.common.data.DiggyRecipeConditions;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public class GreenhouseTemperatureCondition extends RecipeCondition<GreenhouseTemperatureCondition> {

    // spotless:off
    public static final Codec<GreenhouseTemperatureCondition> CODEC =
            RecordCodecBuilder.create(instance -> instance.group(
                    Codec.INT.fieldOf("greenhouseTemperatureMin").forGetter(GreenhouseTemperatureCondition::getMinimumTemperature),
                    Codec.INT.fieldOf("greenhouseTemperatureMax").forGetter(GreenhouseTemperatureCondition::getMaximumTemperature)
            ).apply(instance, GreenhouseTemperatureCondition::new));
    // spotless:on

    public GreenhouseTemperatureCondition(int minimumTemperature, int maximumTemperature) {
        super();
        this.minimumTemperature = minimumTemperature;
        this.maximumTemperature = maximumTemperature;
    }

    @Getter
    private int minimumTemperature = 0;
    @Getter
    private int maximumTemperature = 0;

    @Override
    public RecipeConditionType<GreenhouseTemperatureCondition> getType() {
        return DiggyRecipeConditions.GREENHOUSE_TEMPERATURE;
    }

    @Override
    public Component getTooltips() {
        return Component.literal("Temperature range: " + this.minimumTemperature + " - " + this.maximumTemperature);
    }

    @Override
    protected boolean testCondition(@NotNull GTRecipe recipe, @NotNull RecipeLogic recipeLogic) {
        var machine = recipeLogic.machine;
        if (machine instanceof IGreenhouseMachine greenhouse) {
            if (greenhouse.getGreenhouseTemperature() >= this.minimumTemperature) {
                return greenhouse.getGreenhouseTemperature() <= this.maximumTemperature;
            }
        }
        return false;
    }

    @Override
    public GreenhouseTemperatureCondition createTemplate() {
        return new GreenhouseTemperatureCondition();
    }
}
