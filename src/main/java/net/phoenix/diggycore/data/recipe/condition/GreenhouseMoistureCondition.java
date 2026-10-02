package net.phoenix.diggycore.data.recipe.condition;

import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;

import net.minecraft.network.chat.Component;
import net.phoenix.diggycore.api.machine.IGreenhouseMachine;
import net.phoenix.diggycore.common.data.DiggyRecipeConditions;
import net.phoenix.diggycore.common.utils.DiggyValues;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public class GreenhouseMoistureCondition extends RecipeCondition<GreenhouseMoistureCondition> {

    // spotless:off
    public static final Codec<GreenhouseMoistureCondition> CODEC =
            RecordCodecBuilder.create(instance -> instance.group(
                    Codec.INT.fieldOf("greenhouseMoistureMin").forGetter(GreenhouseMoistureCondition::getMinimumMoisture),
                    Codec.INT.fieldOf("greenhouseMoistureMax").forGetter(GreenhouseMoistureCondition::getMaximumMoisture)
            ).apply(instance, GreenhouseMoistureCondition::new));
    // spotless:on

    public GreenhouseMoistureCondition(int minimumMoisture, int maximumMoisture) {
        super();
        this.minimumMoisture = minimumMoisture;
        this.maximumMoisture = maximumMoisture;
    }

    @Getter
    private int minimumMoisture = 0;
    @Getter
    private int maximumMoisture = 0;

    @Override
    public RecipeConditionType<GreenhouseMoistureCondition> getType() {
        return DiggyRecipeConditions.GREENHOUSE_MOISTURE;
    }

    @Override
    public Component getTooltips() {
        return Component.literal("Moisture range: " + this.minimumMoisture + " - " + this.maximumMoisture);
    }

    @Override
    protected boolean testCondition(@NotNull GTRecipe recipe, @NotNull RecipeLogic recipeLogic) {
        var machine = recipeLogic.machine;
        if (machine instanceof IGreenhouseMachine greenhouse) {
            return greenhouse.getGreenhouseMoisture() ==
                    DiggyValues.clamp(greenhouse.getGreenhouseMoisture(), this.minimumMoisture, this.maximumMoisture);
        }
        return false;
    }

    @Override
    public GreenhouseMoistureCondition createTemplate() {
        return new GreenhouseMoistureCondition();
    }
}
