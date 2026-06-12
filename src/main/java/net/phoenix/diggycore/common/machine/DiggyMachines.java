package net.phoenix.diggycore.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.data.*;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.LargeBoilerMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;
import com.gregtechceu.gtceu.common.registry.GTRegistration;
import com.gregtechceu.gtceu.config.ConfigHolder;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fluids.FluidType;
import net.phoenix.diggycore.DiggyCore;
import net.phoenix.diggycore.api.machine.DiggyPartAbility;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;
import net.phoenix.diggycore.common.machine.multiblock.electric.Greenhouse;
import net.phoenix.diggycore.common.machine.multiblock.electric.MegaSolarBoiler;
import net.phoenix.diggycore.common.machine.multiblock.part.AgronomyInputHatch;
import net.phoenix.diggycore.common.machine.multiblock.steam.SteamLunarBoiler;
import net.phoenix.diggycore.common.registry.DiggyRegistration;

import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import it.unimi.dsi.fastutil.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.BiFunction;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.STEAM_BOILER_RECIPES;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.ELECTRIC_TIERS;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.registerSimpleMachines;
import static net.phoenix.diggycore.common.block.DiggyBlocks.*;
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
                                                             BiFunction<Integer, MachineBuilder<MachineDefinition, ?>, MachineDefinition> builder,
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
            .recipeModifiers(Greenhouse::recipeModifier)
            .appearanceBlock(GREENHOUSE_CASING)
            .blockModel(NonNullBiConsumer.noop())
            .tooltips(Component.literal("A green Solution to your Problems"),
                    Component.literal(
                            "Control the environment inside by pumping in fluids / items through the Agronomy Hatch."))
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("FFFFFFF", "F#####F", "F#####F", "F#####F", "#######", "#######")
                    .aisle("FXXXXXF", "#CCCCC#", "#CCCCC#", "#CCCCC#", "#FXXXF#", "##F####")
                    .aisle("FXXXXXF", "#CGGGX#", "#C###X#", "#C###X#", "#XCCCX#", "###F#F#")
                    .aisle("FXXXXXF", "#CGGGX#", "#C###X#", "#C###X#", "#XCCCX#", "##FFF##")
                    .aisle("FXXXXXF", "#CGGGX#", "#C###X#", "#C###X#", "#XCCCX#", "#F#F###")
                    .aisle("FXXSXXF", "#CCCCC#", "#CCCCC#", "#CCCCC#", "#FXXXF#", "####F##")
                    .aisle("F#####F", "F#####F", "F#####F", "F#####F", "#######", "#######")
                    .where('S', controller(blocks(definition.get())))
                    .where('X', blocks(GREENHOUSE_CASING.get()).setMinGlobalLimited(9)
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(abilities(DiggyPartAbility.AGRONOMY_INPUT).setExactLimit(1))
                            .or(autoAbilities(true, false, false)))
                    .where('M', abilities(PartAbility.MUFFLER))
                    .where('C', blocks(CASING_TEMPERED_GLASS.get()))
                    .where('G', blocks(GREENHOUSE_DIRT.get()))
                    .where('F', Predicates.frames(GTMaterials.StainlessSteel))
                    .where('#', Predicates.any())
                    .build())
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                var builder = MultiblockShapeInfo.builder()
                        .aisle("FFFFFFF", "F#####F", "F#####F", "F#####F", "#######", "#######")
                        .aisle("FEEXXXF", "#CCCCC#", "#CCCCC#", "#CCCCC#", "#FXXXF#", "##F####")
                        .aisle("FXXXXXF", "#CGGGX#", "#C###X#", "#C###X#", "#XCCCX#", "###F#F#")
                        .aisle("FXXXXXF", "#CGGGX#", "#C###X#", "#C###X#", "#XCCCX#", "##FFF##")
                        .aisle("FXXXXXF", "#CGGGX#", "#C###X#", "#C###X#", "#XCCCX#", "#F#F###")
                        .aisle("FMISOXF", "#CCCCC#", "#CCCCC#", "#CCCCC#", "#FXXXF#", "####F##")
                        .aisle("F#####F", "F#####F", "F#####F", "F#####F", "#######", "#######")
                        .where('S', definition, Direction.NORTH)
                        .where('E', ENERGY_INPUT_HATCH[GTValues.LV], Direction.SOUTH)
                        .where('I', ITEM_IMPORT_BUS[GTValues.LV], Direction.NORTH)
                        .where('O', ITEM_EXPORT_BUS[GTValues.LV], Direction.NORTH)
                        .where('M', MAINTENANCE_HATCH, Direction.NORTH)
                        .where('X', GREENHOUSE_CASING)
                        .where('C', CASING_TEMPERED_GLASS)
                        .where('G', GREENHOUSE_DIRT)
                        .where('#', Blocks.AIR.defaultBlockState());
                return shapeInfo;
            })
            .workableCasingModel(DiggyCore.id("block/casings/greenhouse_casing"),
                    GTCEu.id("block/multiblock/multi_furnace"))
            .register();

    public static final Pair<MachineDefinition, MachineDefinition> STEAM_LUNAR_BOILER = registerSteamMachines(
            "steam_lunar_boiler",
            SteamLunarBoiler::new,
            (pressure, builder) -> builder.rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(STEAM_BOILER_RECIPES)
                    .recipeModifier(SteamLunarBoiler::recipeModifier)
                    .workableSteamHullModel(pressure, GTCEu.id("block/generators/boiler/solar"))
                    .tooltips(Component.translatable("gtceu.universal.tooltip.produces_fluid",
                            (pressure ? ConfigHolder.INSTANCE.machines.smallBoilers.hpSolarBoilerBaseOutput :
                                    ConfigHolder.INSTANCE.machines.smallBoilers.solarBoilerBaseOutput) *
                                    FluidType.BUCKET_VOLUME / 20000))
                    .blockModel(NonNullBiConsumer.noop()) // dont datagen the model pls
                    .register());

    public static Pair<MachineDefinition, MachineDefinition> registerSteamMachines(String name,
                                                                                   BiFunction<IMachineBlockEntity, Boolean, MetaMachine> factory,
                                                                                   BiFunction<Boolean, MachineBuilder<MachineDefinition, ?>, MachineDefinition> builder) {
        return GTMachineUtils.registerSteamMachines(REGISTRATE, name, factory, builder);
    }

    public static final MachineDefinition[] APIARY = registerSimpleMachines(DiggyRegistration.REGISTRATE, "apiary",
            DiggyRecipeTypes.APIARY_RECIPES);
    public static final MachineDefinition[] PARTICLE_BEAM_ENGRAVER = registerSimpleMachines(DiggyRegistration.REGISTRATE, "particle_beam_engraver",
            DiggyRecipeTypes.PARTICLE_BEAM_ENGRAVER_RECIPES);

    public static final MultiblockMachineDefinition GALACTICRAFT_COMPRESSOR = REGISTRATE
            .multiblock("galacticraft_compressor", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(DiggyRecipeTypes.GC_COMPRESSOR_RECIPES)
            .recipeModifiers(GTRecipeModifiers.BATCH_MODE)
            .appearanceBlock(GALAXYSPACE_GRADE_CASING)
            .langValue("GC Compressor")
            .tooltips(Component.literal("´´Galacticraft Compressor´´"),
                    Component.literal("A High-Performace Press to make Heavy-Duty Plating"))
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("##F##", "##F##", "##F##", "##F##", "#####")
                    .aisle("#XXX#", "#CCC#", "#CCC#", "#CCC#", "#####")
                    .aisle("FXXXF", "FC#CF", "FCGCF", "FCGCF", "##G##")
                    .aisle("#XXX#", "#CSC#", "#CCC#", "#CCC#", "#####")
                    .where('S', controller(blocks(definition.get())))
                    .where('X', blocks(CASING_TITANIUM_STABLE.get()))
                    .where('C', blocks(GALAXYSPACE_GRADE_CASING.get())
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(autoAbilities(true, false, false)))
                    .where('G', blocks(CASING_TITANIUM_GEARBOX.get()))
                    .where('F', Predicates.frames(GTMaterials.StainlessSteel))
                    .where('#', Predicates.any())
                    .build())
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                var builder = MultiblockShapeInfo.builder()
                        .aisle("##F##", "##F##", "##F##", "##F##", "#####")
                        .aisle("#XXX#", "#CCE#", "#CCC#", "#CCC#", "#####")
                        .aisle("FXXXF", "FC#CF", "FCGCF", "FCGCF", "##G##")
                        .aisle("#XXX#", "#CSC#", "#IMO#", "#CCC#", "#####")
                        .where('S', definition, Direction.NORTH)
                        .where('E', ENERGY_INPUT_HATCH[GTValues.HV], Direction.SOUTH)
                        .where('I', ITEM_IMPORT_BUS[GTValues.LV], Direction.NORTH)
                        .where('O', ITEM_EXPORT_BUS[GTValues.LV], Direction.NORTH)
                        .where('M', MAINTENANCE_HATCH, Direction.SOUTH)
                        .where('X', CASING_TITANIUM_STABLE)
                        .where('C', GALAXYSPACE_GRADE_CASING)
                        .where('G', CASING_TITANIUM_GEARBOX)
                        .where('F', ChemicalHelper.getBlock(TagPrefix.frameGt, GTMaterials.StainlessSteel))
                        .where('#', Blocks.AIR.defaultBlockState());
                return shapeInfo;
            })
            .workableCasingModel(DiggyCore.id("block/casings/galaxyspace_grade_casing"),
                    GTCEu.id("block/machines/forge_hammer"))
            .register();

    public static final MultiblockMachineDefinition MEGA_SOLAR_BOILER = REGISTRATE
            .multiblock("mega_solar_boiler",
                    holder -> new MegaSolarBoiler(holder,
                            ConfigHolder.INSTANCE.machines.largeBoilers.bronzeBoilerMaxTemperature,
                            ConfigHolder.INSTANCE.machines.largeBoilers.bronzeBoilerHeatSpeed))
            .rotationState(RotationState.ALL)
            .recipeTypes(GTRecipeTypes.STEAM_BOILER_RECIPES)
            .recipeModifiers(SteamParallelMultiblockMachine::recipeModifier)
            .appearanceBlock(CASING_BRONZE_BRICKS)
            .langValue("Mega Solar Boiler")
            .tooltips(Component.literal("A new Generation of Boiling"))
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CCC", "CCC", "CCC")
                    .aisle("CCC", "C#C", "CSC")
                    .aisle("CCC", "CCC", "CCC")
                    .where('S', controller(blocks(definition.get())))
                    .where('#', Predicates.any())
                    .where('C', blocks(CASING_BRONZE_BRICKS.get())
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1)))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    GTCEu.id("block/generators/boiler/solar"))
            .register();

    public static final MultiblockMachineDefinition STEAM_PRESS = REGISTRATE
            .multiblock("steam_press", SteamParallelMultiblockMachine::new)
            .langValue("Steam Press")
            .tooltips(Component.literal("Multiblock Forge Hammer"))
            .rotationState(RotationState.ALL)
            .appearanceBlock(CASING_BRONZE_BRICKS)
            .recipeType(GTRecipeTypes.FORGE_HAMMER_RECIPES)
            .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
            .addOutputLimit(ItemRecipeCapability.CAP, 1)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXX", "XXX", "XXX")
                    .aisle("XXX", "X#X", "XXX")
                    .aisle("XXX", "XSX", "XXX")
                    .where('S', Predicates.controller(blocks(definition.getBlock())))
                    .where('#', Predicates.air())
                    .where('X', blocks(CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(14)
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    GTCEu.id("block/machines/forge_hammer"))
            .register();

    public static final MultiblockMachineDefinition CYCLOTRON = REGISTRATE
            .multiblock("cyclotron", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(DiggyRecipeTypes.CYCLOTRON_RECIPES)
            .recipeModifiers(GTRecipeModifiers.PARALLEL_HATCH)
            .appearanceBlock(CYCLOTRON_CASING)
            .langValue("Cyclotron")
            .tooltips(Component.literal("Lightweight alternative to the Fusion Reactor. Allows fusing of elements to create heavier ones, and the manipulation of quantum particles."))
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("...........", "....CCC....", "...........")
                    .aisle("....CCC....", "..CC...CC..", "....CCC....")
                    .aisle("..CC...CC..", ".C..CCC..C.", "..CC...CC..")
                    .aisle("..C.....C..", ".C.C...C.C.", "..C.....C..")
                    .aisle(".C.......C.", "C.C.....C.C", ".C.......C.")
                    .aisle(".C.......C.", "C.C.....C.C", ".C.......C.")
                    .aisle(".C.......C.", "C.C.....C.C", ".C.......C.")
                    .aisle("..C.....C..", ".C.C...C.C.", "..C.....C..")
                    .aisle("..CC...CC..", ".C..CCC..C.", "..CC...CC..")
                    .aisle("....CCC....", "..CC...CC..", "....CCC....")
                    .aisle("...........", "....CSC....", "...........")
                    .where('S', controller(blocks(definition.get())))
                    .where('C', blocks(CYCLOTRON_CASING.get())
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(autoAbilities(true, false, false)))
                    .where('.', Predicates.any())
                    .build())
            /*.shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                var builder = MultiblockShapeInfo.builder()
                        .aisle("##F##", "##F##", "##F##", "##F##", "#####")
                        .aisle("#XXX#", "#CCE#", "#CCC#", "#CCC#", "#####")
                        .aisle("FXXXF", "FC#CF", "FCGCF", "FCGCF", "##G##")
                        .aisle("#XXX#", "#CSC#", "#IMO#", "#CCC#", "#####")
                        .where('S', definition, Direction.NORTH)
                        .where('E', ENERGY_INPUT_HATCH[GTValues.HV], Direction.SOUTH)
                        .where('I', ITEM_IMPORT_BUS[GTValues.LV], Direction.NORTH)
                        .where('O', ITEM_EXPORT_BUS[GTValues.LV], Direction.NORTH)
                        .where('M', MAINTENANCE_HATCH, Direction.SOUTH)
                        .where('X', CASING_TITANIUM_STABLE)
                        .where('C', GALAXYSPACE_GRADE_CASING)
                        .where('G', CASING_TITANIUM_GEARBOX)
                        .where('F', ChemicalHelper.getBlock(TagPrefix.frameGt, GTMaterials.StainlessSteel))
                        .where('#', Blocks.AIR.defaultBlockState());
                return shapeInfo;
            })*/
            .workableCasingModel(DiggyCore.id("block/casings/cyclotron_casing"),
                    GTCEu.id("block/multiblock/fusion_reactor"))
            .register();
}
