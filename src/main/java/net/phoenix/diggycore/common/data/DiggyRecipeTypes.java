package net.phoenix.diggycore.common.data;

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.sound.ExistingSoundEntry;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;

import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.phoenix.diggycore.common.data.materials.AdvancedChemMaterials;

import java.util.Collections;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.lowdragmc.lowdraglib.gui.texture.ProgressTexture.FillDirection.LEFT_TO_RIGHT;

public class DiggyRecipeTypes {

    public static GTRecipeType APIARY_RECIPES;
    public static GTRecipeType GC_COMPRESSOR_RECIPES;
    public static GTRecipeType CYCLOTRON_RECIPES;
    public static GTRecipeType PARTICLE_BEAM_ENGRAVER_RECIPES;
    public static GTRecipeType AI_TRAINING_CENTER_RECIPES;
    public static GTRecipeType CHEMICAL_PLANT_RECIPES;
    public static GTRecipeType VIBRATION_SIEVE_RECIPES;
    public static GTRecipeType CASIMIR_GENERATOR_FUELS;
    public static GTRecipeType GREENHOUSE_RECIPES;
    public static GTRecipeType BIO_REACTOR_RECIPES;
    public static GTRecipeType ION_EXCHANGER_RECIPES;

    public static String GREENHOUSE_NITROGEN_USED = "greenhouse_nitrogen_used";
    public static String GREENHOUSE_TEMPERATURE_USED = "greenhouse_temperature_used";
    public static String GREENHOUSE_MOISTURE_USED = "greenhouse_moisture_used";
    public static String GREENHOUSE_PH_USED = "greenhouse_ph_used";
    public static String GREENHOUSE_RADIOACTIVITY_USED = "greenhouse_radioactivity_used";
    public static String GREENHOUSE_EMC_USED = "greenhouse_emc_used";

    public static void init() {
        APIARY_RECIPES = register("apiary", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(3, 3, 1, 0)
                .setSlotOverlay(true, false, GuiTextures.CRYSTAL_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.REPLICATOR);

        GC_COMPRESSOR_RECIPES = register("gc_compressor", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(6, 1, 0, 0)
                .setSlotOverlay(false, false, GuiTextures.HAMMER_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_HAMMER, ProgressTexture.FillDirection.UP_TO_DOWN)
                .setSound(GTSoundEntries.FORGE_HAMMER);

        CYCLOTRON_RECIPES = register("cyclotron", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(9, 9, 1, 0)
                .setSlotOverlay(false, false, GuiTextures.ATOMIC_OVERLAY_1)
                .setSlotOverlay(true, false, GuiTextures.ATOMIC_OVERLAY_2)
                .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.SCIENCE);

        PARTICLE_BEAM_ENGRAVER_RECIPES = register("particle_beam_engraver", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(3, 1, 0, 0)
                .setSlotOverlay(false, false, true, GuiTextures.LENS_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.ELECTROLYZER);

        AI_TRAINING_CENTER_RECIPES = register("ai_training_center", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(9, 1, 1, 1)
                .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
                .setSlotOverlay(true, false, false, GuiTextures.DATA_ORB_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.COMPUTATION)
                .onRecipeBuild((recipeBuilder, provider) -> { // copy circuit assembler thing lol
                    if (recipeBuilder.input.getOrDefault(FluidRecipeCapability.CAP, Collections.emptyList())
                            .isEmpty() &&
                            recipeBuilder.tickInput.getOrDefault(FluidRecipeCapability.CAP, Collections.emptyList())
                                    .isEmpty()) {
                        recipeBuilder.copy(ResourceLocation.parse(recipeBuilder.id.toString() + "_fx_coolant"))
                                .inputFluids(AdvancedChemMaterials.FX_COOLANT
                                        .getFluid(Math.max(1, (1000 / 4) * recipeBuilder.getSolderMultiplier())))
                                .save(provider);

                        recipeBuilder.copy(ResourceLocation.parse(recipeBuilder.id.toString() + "_warp_coolant"))
                                .inputFluids(AdvancedChemMaterials.WARP_COOLANT
                                        .getFluid(Math.max(1, (1000 * recipeBuilder.getSolderMultiplier()) / 16)))
                                .save(provider);

                        // Don't call buildAndRegister as we are mutating the original recipe and already in the middle
                        // of a
                        // buildAndRegister call.
                        // Adding a second call will result in duplicate recipe generation attempts
                        recipeBuilder.inputFluids(
                                GTMaterials.PCBCoolant
                                        .getFluid(Math.max(1, 1000 * recipeBuilder.getSolderMultiplier())));
                        /*
                         * Basically different tiers of coolant.
                         * -PCB coolant: 16x requirement
                         * -FX coolant: 4x requirement
                         * -Warp coolant: 1x requirement
                         */
                    }
                });

        CHEMICAL_PLANT_RECIPES = register("chemical_plant", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(6, 6, 6, 6)
                .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
                .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSlotOverlay(true, false, false, GuiTextures.VIAL_OVERLAY_1)
                .setSlotOverlay(true, true, false, GuiTextures.VIAL_OVERLAY_2)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.CHEMICAL);

        VIBRATION_SIEVE_RECIPES = register("vibration_sieve", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(3, 9, 1, 0)
                .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
                .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressTexture.FillDirection.UP_TO_DOWN)
                .setSound(new ExistingSoundEntry(SoundEvents.SAND_PLACE, SoundSource.BLOCKS));

        CASIMIR_GENERATOR_FUELS = register("casimir_generator", GENERATOR)
                .setMaxIOSize(1, 0, 0, 0).setEUIO(IO.OUT)
                .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.JET_ENGINE);

        GREENHOUSE_RECIPES = register("greenhouse", MULTIBLOCK)
                .setMaxIOSize(3, 6, 1, 3)
                .setEUIO(IO.IN)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.BATH)
                .addDataInfo((data) -> {
                    String info = "";
                    if (data.contains(GREENHOUSE_NITROGEN_USED)) {
                        info = Component.literal("Nitrogen used: " + data.getInt(GREENHOUSE_NITROGEN_USED)).getString();
                    }
                    if (data.contains(GREENHOUSE_TEMPERATURE_USED)) {
                        if (info.isEmpty()) {
                            info = info + "\nTemperature used: " + data.getInt(GREENHOUSE_TEMPERATURE_USED);
                        } else {
                            info = Component.literal("Temperature used: " + data.getInt(GREENHOUSE_TEMPERATURE_USED))
                                    .getString();
                        }
                    }
                    if (data.contains(GREENHOUSE_MOISTURE_USED)) {
                        if (info.isEmpty()) {
                            info = info + "\nMoisture used: " + data.getInt(GREENHOUSE_MOISTURE_USED);
                        } else {
                            info = Component.literal("Moisture used: " + data.getInt(GREENHOUSE_MOISTURE_USED))
                                    .getString();
                        }
                    }
                    if (data.contains(GREENHOUSE_PH_USED)) {
                        if (info.isEmpty()) {
                            info = info + "\npH used: " + data.getInt(GREENHOUSE_PH_USED);
                        } else {
                            info = Component.literal("pH used: " + data.getInt(GREENHOUSE_PH_USED)).getString();
                        }
                    }
                    if (data.contains(GREENHOUSE_RADIOACTIVITY_USED)) {
                        if (info.isEmpty()) {
                            info = info + "\nRadioactivity used: " + data.getInt(GREENHOUSE_RADIOACTIVITY_USED);
                        } else {
                            info = Component
                                    .literal("Radioactivity used: " + data.getInt(GREENHOUSE_RADIOACTIVITY_USED))
                                    .getString();
                        }
                    }
                    if (data.contains(GREENHOUSE_EMC_USED)) {
                        if (info.isEmpty()) {
                            info = info + "\nEMC used: " + data.getInt(GREENHOUSE_EMC_USED);
                        } else {
                            info = Component.literal("EMC used: " + data.getInt(GREENHOUSE_EMC_USED)).getString();
                        }
                    }
                    return Component.literal(info).getString();
                });

        BIO_REACTOR_RECIPES = register("bio_reactor", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(3, 3, 6, 6)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_1)
                .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.CHEMICAL);

        ION_EXCHANGER_RECIPES = register("ion_exchanger", MULTIBLOCK)
                .setEUIO(IO.IN)
                .setMaxIOSize(1, 9, 1, 3)
                .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.ELECTROLYZER);
    }
}
