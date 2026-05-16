package net.phoenix.diggycore.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.common.machine.multiblock.part.DualHatchPartMachine;

public class AgronomyInputHatch extends DualHatchPartMachine {
    public AgronomyInputHatch(IMachineBlockEntity holder, int tier, IO io, Object... args) {
        super(holder, tier, io, args);
    }
}
