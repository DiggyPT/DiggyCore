package net.phoenix.diggycore.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
import com.gregtechceu.gtceu.common.machine.multiblock.part.DualHatchPartMachine;

import net.minecraftforge.fluids.FluidType;

import org.jetbrains.annotations.NotNull;

public class AgronomyInputHatch extends DualHatchPartMachine {

    public static final int INITIAL_TANK_CAPACITY = 16 * FluidType.BUCKET_VOLUME;

    public AgronomyInputHatch(IMachineBlockEntity holder, int tier, IO io, Object... args) {
        super(holder, tier, io, args);
    }

    @NotNull
    @Override
    protected NotifiableFluidTank createTank(int initialCapacity, int slots, Object... args) {
        return super.createTank(initialCapacity, slots, args);
        // .setFilter(fluidStack -> fluidStack.getFluid().is(CustomTags.PLASMA_FLUIDS));
    }
}
