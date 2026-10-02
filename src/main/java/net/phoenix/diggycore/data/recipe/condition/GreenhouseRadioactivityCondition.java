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
public class GreenhouseRadioactivityCondition extends RecipeCondition<GreenhouseRadioactivityCondition> {

    // spotless:off
    public static final Codec<GreenhouseRadioactivityCondition> CODEC =
            RecordCodecBuilder.create(instance -> instance.group(
                    Codec.INT.fieldOf("greenhouseRadioactivityMin").forGetter(GreenhouseRadioactivityCondition::getMinimumRadioactivity),
                    Codec.INT.fieldOf("greenhouseRadioactivityMax").forGetter(GreenhouseRadioactivityCondition::getMaximumRadioactivity)
            ).apply(instance, GreenhouseRadioactivityCondition::new));
    // spotless:on

    public GreenhouseRadioactivityCondition(int minumumRadioactivity, int maximumRadioactivity) {
        super();
        this.minimumRadioactivity = minumumRadioactivity;
        this.maximumRadioactivity = maximumRadioactivity;
    }

    @Getter
    private int minimumRadioactivity = 0;
    @Getter
    private int maximumRadioactivity = 0;

    @Override
    public RecipeConditionType<GreenhouseRadioactivityCondition> getType() {
        return DiggyRecipeConditions.GREENHOUSE_RADIOACTIVITY;
    }

    @Override
    public Component getTooltips() {
        return Component
                .literal("Radioactivity range: " + this.minimumRadioactivity + " - " + this.maximumRadioactivity);
    }

    @Override
    protected boolean testCondition(@NotNull GTRecipe recipe, @NotNull RecipeLogic recipeLogic) {
        var machine = recipeLogic.machine;
        if (machine instanceof IGreenhouseMachine greenhouse) {
            return greenhouse.getGreenhouseRadioactivity() == DiggyValues.clamp(greenhouse.getGreenhouseRadioactivity(),
                    this.minimumRadioactivity, this.maximumRadioactivity);
        }
        return false;
    }

    @Override
    public GreenhouseRadioactivityCondition createTemplate() {
        return new GreenhouseRadioactivityCondition();
    }
}
