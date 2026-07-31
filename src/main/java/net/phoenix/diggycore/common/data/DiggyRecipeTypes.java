package net.phoenix.diggycore.common.data;

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;

import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

import net.minecraft.resources.ResourceLocation;
import net.phoenix.diggycore.common.data.materials.AdvancedChemMaterials;

import java.util.Collections;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class DiggyRecipeTypes {

    public static GTRecipeType APIARY_RECIPES;
    public static GTRecipeType GC_COMPRESSOR_RECIPES;
    public static GTRecipeType CYCLOTRON_RECIPES;
    public static GTRecipeType PARTICLE_BEAM_ENGRAVER_RECIPES;
    public static GTRecipeType AI_TRAINING_CENTER_RECIPES;
    public static GTRecipeType CHEMICAL_PLANT_RECIPES;
    public static GTRecipeType ASTRO_MINER_RECIPES;

    public static void init() {
        APIARY_RECIPES = register("apiary", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(3, 3, 1, 0)
                .setSlotOverlay(true, false, GuiTextures.CRYSTAL_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
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
                .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.SCIENCE);

        PARTICLE_BEAM_ENGRAVER_RECIPES = register("particle_beam_engraver", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(3, 1, 0, 0)
                .setSlotOverlay(false, false, true, GuiTextures.LENS_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.ELECTROLYZER);

        AI_TRAINING_CENTER_RECIPES = register("ai_training_center", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(9, 1, 1, 1)
                .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
                .setSlotOverlay(true, false, false, GuiTextures.DATA_ORB_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
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
                                GTMaterials.PCBCoolant.getFluid(Math.max(1, 1000 * recipeBuilder.getSolderMultiplier())));
                        /*Basically different tiers of coolant.
                            -PCB coolant: 16x requirement
                            -FX coolant: 4x requirement
                            -Warp coolant: 1x requirement */
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
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.CHEMICAL);

        ASTRO_MINER_RECIPES = register("astro_miner_recipes", ELECTRIC)
                .setEUIO(IO.IN)
                .setMaxIOSize(3, 3, 1, 0)
                .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.CHEMICAL);
    }
}
