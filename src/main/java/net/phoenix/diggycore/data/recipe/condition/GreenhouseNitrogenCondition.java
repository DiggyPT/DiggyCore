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
public class GreenhouseNitrogenCondition extends RecipeCondition<GreenhouseNitrogenCondition> {

    // spotless:off
    public static final Codec<GreenhouseNitrogenCondition> CODEC =
            RecordCodecBuilder.create(instance -> instance.group(
                    Codec.INT.fieldOf("greenhouseNitrogenMin").forGetter(GreenhouseNitrogenCondition::getMinimumNitrogen),
                    Codec.INT.fieldOf("greenhouseNitrogenMax").forGetter(GreenhouseNitrogenCondition::getMaximumNitrogen)
            ).apply(instance, GreenhouseNitrogenCondition::new));
    // spotless:on

    public GreenhouseNitrogenCondition(int minimumNitrogen, int maximumNitrogen) {
        super();
        this.minimumNitrogen = minimumNitrogen;
        this.maximumNitrogen = maximumNitrogen;
    }

    @Getter
    private int minimumNitrogen = 0;
    @Getter
    private int maximumNitrogen = 0;

    @Override
    public RecipeConditionType<GreenhouseNitrogenCondition> getType() {
        return DiggyRecipeConditions.GREENHOUSE_NITROGEN;
    }

    @Override
    public Component getTooltips() {
        return Component.literal("Nitrogen range: " + this.minimumNitrogen + " - " + this.maximumNitrogen);
    }

    @Override
    protected boolean testCondition(@NotNull GTRecipe recipe, @NotNull RecipeLogic recipeLogic) {
        var machine = recipeLogic.machine;
        if (machine instanceof IGreenhouseMachine greenhouse) {
            return greenhouse.getGreenhouseNitrogen() ==
                    DiggyValues.clamp(greenhouse.getGreenhouseNitrogen(), this.minimumNitrogen, this.maximumNitrogen);
        }
        return false;
    }

    @Override
    public GreenhouseNitrogenCondition createTemplate() {
        return new GreenhouseNitrogenCondition();
    }
}
