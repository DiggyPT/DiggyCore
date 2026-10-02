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
public class GreenhouseEMCCondition extends RecipeCondition<GreenhouseEMCCondition> {

    // spotless:off
    public static final Codec<GreenhouseEMCCondition> CODEC =
            RecordCodecBuilder.create(instance -> instance.group(
                    Codec.INT.fieldOf("greenhouseEMCMin").forGetter(GreenhouseEMCCondition::getMinimumEMC),
                    Codec.INT.fieldOf("greenhouseEMCMax").forGetter(GreenhouseEMCCondition::getMaximumEMC)
            ).apply(instance, GreenhouseEMCCondition::new));
    // spotless:on

    public GreenhouseEMCCondition(int minumumEMC, int maximumEMC) {
        super();
        this.minimumEMC = minumumEMC;
        this.maximumEMC = maximumEMC;
    }

    @Getter
    private int minimumEMC = 0;
    @Getter
    private int maximumEMC = 0;

    @Override
    public RecipeConditionType<GreenhouseEMCCondition> getType() {
        return DiggyRecipeConditions.GREENHOUSE_EMC;
    }

    @Override
    public Component getTooltips() {
        return Component.literal("EMC range: " + this.minimumEMC + " - " + this.maximumEMC);
    }

    @Override
    protected boolean testCondition(@NotNull GTRecipe recipe, @NotNull RecipeLogic recipeLogic) {
        var machine = recipeLogic.machine;
        if (machine instanceof IGreenhouseMachine greenhouse) {
            return greenhouse.getGreenhouseEMC() ==
                    DiggyValues.clamp(greenhouse.getGreenhouseEMC(), this.minimumEMC, this.maximumEMC);
        }
        return false;
    }

    @Override
    public GreenhouseEMCCondition createTemplate() {
        return new GreenhouseEMCCondition();
    }
}
