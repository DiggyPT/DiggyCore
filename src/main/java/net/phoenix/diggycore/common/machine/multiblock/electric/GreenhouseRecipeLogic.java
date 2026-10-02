package net.phoenix.diggycore.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;

import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

public class GreenhouseRecipeLogic extends RecipeLogic {

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            GreenhouseRecipeLogic.class,
            RecipeLogic.MANAGED_FIELD_HOLDER);

    public GreenhouseRecipeLogic(IRecipeLogicMachine machine) {
        this(machine, 1, 1);
    }

    public GreenhouseRecipeLogic(IRecipeLogicMachine machine, int capacityFactor, int rateFactor) {
        super(machine);
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
