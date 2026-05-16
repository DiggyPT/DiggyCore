package net.phoenix.diggycore.api.machine;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.IFilterType;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.common.data.models.GTModels;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.phoenix.diggycore.DiggyCore;
import net.phoenix.diggycore.common.block.AntiHiggsFilterType;
import org.jetbrains.annotations.NotNull;

import static net.phoenix.diggycore.common.registry.DiggyRegistration.REGISTRATE;

public class DiggyPartAbility extends PartAbility {

    private DiggyPartAbility() {
        super("");
    }

    public static final PartAbility AGRONOMY_INPUT = new PartAbility("input_agronomy");
}
