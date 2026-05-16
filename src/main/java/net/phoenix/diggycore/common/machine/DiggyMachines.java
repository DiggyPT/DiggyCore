package net.phoenix.diggycore.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.data.*;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import net.phoenix.diggycore.DiggyCore;
import net.phoenix.diggycore.api.machine.DiggyPartAbility;
import net.phoenix.diggycore.common.machine.multiblock.electric.Greenhouse;
import net.phoenix.diggycore.common.machine.multiblock.part.AgronomyInputHatch;
import com.gregtechceu.gtceu.api.capability.recipe.IO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.BiFunction;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_INVAR_HEATPROOF;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeModifiers.BATCH_MODE;
import static com.gregtechceu.gtceu.common.data.GTRecipeModifiers.OC_NON_PERFECT_SUBTICK;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.ELECTRIC_TIERS;
import static net.phoenix.diggycore.common.registry.DiggyRegistration.REGISTRATE;

public class DiggyMachines {

    public static void init() {}

    public static MachineDefinition[] registerAgronomyInputHatch(String name, String displayName) {
        return registerTieredMachines(name,
                (holder, tier) -> new AgronomyInputHatch(holder, tier, IO.IN), // Clean constructor
                (tier, builder) -> builder
                        .langValue(GTValues.VNF[tier] + ' ' + displayName)
                        .abilities(PartAbility.IMPORT_ITEMS, PartAbility.IMPORT_FLUIDS, DiggyPartAbility.AGRONOMY_INPUT)
                        .rotationState(RotationState.ALL)
                        .overlayTieredHullModel("agronomy_input_hatch")
                        .register(),
                ELECTRIC_TIERS);
    }

    public final static MachineDefinition[] AGRONOMY_INPUT_HATCH = registerAgronomyInputHatch("agronomy_input_hatch",
            "Agronomy Input Hatch");

    public static MachineDefinition[] registerTieredMachines(String name,
                                                             BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory,
                                                             BiFunction<Integer, MachineBuilder<MachineDefinition>, MachineDefinition> builder,
                                                             int... tiers) {
        MachineDefinition[] definitions = new MachineDefinition[GTValues.TIER_COUNT];
        for (int tier : tiers) {
            var register = REGISTRATE
                    .machine(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_" + name,
                            holder -> factory.apply(holder, tier))
                    .tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }

    public static final MultiblockMachineDefinition GREENHOUSE = REGISTRATE
            .multiblock("greenhouse", Greenhouse::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(GTRecipeTypes.FURNACE_RECIPES, GTRecipeTypes.ALLOY_SMELTER_RECIPES)
            .recipeModifiers(GTRecipeModifiers::multiSmelterParallel, BATCH_MODE)
            .appearanceBlock(CASING_INVAR_HEATPROOF)
            .tooltips(Component.translatable("gtceu.machine.available_recipe_map_2.tooltip",
                    Component.translatable("gtceu.electric_furnace"), Component.translatable("gtceu.alloy_smelter")))
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXX", "CCC", "XXX")
                    .aisle("XXX", "C#C", "XMX")
                    .aisle("XSX", "CCC", "XXX")
                    .where('S', controller(blocks(definition.get())))
                    .where('X', blocks(CASING_INVAR_HEATPROOF.get()).setMinGlobalLimited(9)
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(abilities(DiggyPartAbility.AGRONOMY_INPUT).setExactLimit(1))
                            .or(autoAbilities(true, false, false)))
                    .where('M', abilities(PartAbility.MUFFLER))
                    .where('C', heatingCoils())
                    .where('#', air())
                    .build())
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                var builder = MultiblockShapeInfo.builder()
                        .aisle("ISO", "CCC", "XMX")
                        .aisle("XXX", "C#C", "XHX")
                        .aisle("EEX", "CCC", "XXX")
                        .where('S', definition, Direction.NORTH)
                        .where('X', CASING_INVAR_HEATPROOF.getDefaultState())
                        .where('E', ENERGY_INPUT_HATCH[GTValues.LV], Direction.SOUTH)
                        .where('I', ITEM_IMPORT_BUS[GTValues.LV], Direction.NORTH)
                        .where('O', ITEM_EXPORT_BUS[GTValues.LV], Direction.NORTH)
                        .where('H', MUFFLER_HATCH[GTValues.LV], Direction.SOUTH)
                        .where('M', MAINTENANCE_HATCH, Direction.NORTH)
                        .where('#', Blocks.AIR.defaultBlockState());
                GTCEuAPI.HEATING_COILS.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().getTier()))
                        .forEach(
                                coil -> shapeInfo.add(builder.shallowCopy().where('C', coil.getValue().get()).build()));
                return shapeInfo;
            })
            .recoveryItems(
                    () -> new ItemLike[] {
                            GTMaterialItems.MATERIAL_ITEMS.get(TagPrefix.dustTiny, GTMaterials.Ash).get() })
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_heatproof"),
                    GTCEu.id("block/multiblock/multi_furnace"))
            .additionalDisplay((controller, components) -> {
                if (controller instanceof CoilWorkableElectricMultiblockMachine coilMachine && controller.isFormed()) {
                    components.add(Component.translatable("gtceu.multiblock.multi_furnace.heating_coil_level",
                            coilMachine.getCoilType().getLevel()));
                    components.add(Component.translatable("gtceu.multiblock.multi_furnace.heating_coil_discount",
                            coilMachine.getCoilType().getEnergyDiscount()));
                }
            })
            .register();
}
