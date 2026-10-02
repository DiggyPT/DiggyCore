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
public class GreenhousePHCondition extends RecipeCondition<GreenhousePHCondition> {

    // spotless:off
    public static final Codec<GreenhousePHCondition> CODEC =
            RecordCodecBuilder.create(instance -> instance.group(
                    Codec.INT.fieldOf("greenhousePhMin").forGetter(GreenhousePHCondition::getMinimumPH),
                    Codec.INT.fieldOf("greenhousePhMax").forGetter(GreenhousePHCondition::getMaximumPH)
            ).apply(instance, GreenhousePHCondition::new));
    // spotless:on

    public GreenhousePHCondition(int minumumPH, int maximumPH) {
        super();
        this.minimumPH = minumumPH;
        this.maximumPH = maximumPH;
    }

    @Getter
    private int minimumPH = 0;
    @Getter
    private int maximumPH = 0;

    @Override
    public RecipeConditionType<GreenhousePHCondition> getType() {
        return DiggyRecipeConditions.GREENHOUSE_PH;
    }

    @Override
    public Component getTooltips() {
        return Component.literal("pH range: " + this.minimumPH + " - " + this.maximumPH);
    }

    @Override
    protected boolean testCondition(@NotNull GTRecipe recipe, @NotNull RecipeLogic recipeLogic) {
        var machine = recipeLogic.machine;
        if (machine instanceof IGreenhouseMachine greenhouse) {
            return greenhouse.getGreenhousePH() ==
                    DiggyValues.clamp(greenhouse.getGreenhousePH(), this.minimumPH, this.maximumPH);
        }
        return false;
    }

    @Override
    public GreenhousePHCondition createTemplate() {
        return new GreenhousePHCondition();
    }
}
