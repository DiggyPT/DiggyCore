package net.phoenix.diggycore.datagen.models;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.machine.electric.ChargerMachine;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.phoenix.diggycore.DiggyCore;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;

import static com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties.CHARGER_STATE;
import static com.gregtechceu.gtceu.common.data.models.GTMachineModels.SIDED_SIDED_OVERLAY_MODEL;
import static com.gregtechceu.gtceu.common.data.models.GTMachineModels.tieredHullTextures;

public class DiggyMachineModels {

    public static MachineBuilder.ModelInitializer createOverlayCasingMachineModel(
            String overlayName,
            String casingTexturePath) {
        return (ctx, prov, builder) -> {
            builder.forAllStatesModels(state -> {
                BlockModelBuilder model = prov.models().nested()
                        .parent(prov.models().getExistingFile(
                                GTCEu.id("block/overlay/2_layer/front_emissive")));
                casingTextures(model, casingTexturePath);

                model.texture("overlay",
                        DiggyCore.id("block/overlay/machine/" + overlayName + "_base"));

                model.texture("overlay_emissive",
                        DiggyCore.id("block/overlay/machine/" + overlayName + "_emissive"));

                return model;
            });

            builder.addReplaceableTextures("bottom", "top", "side");
        };
    }

    public static void casingTextures(BlockModelBuilder model, String casingTexturePath) {
        ResourceLocation casing = DiggyCore.id("block/" + casingTexturePath);
        model.texture("bottom", casing);
        model.texture("top", casing);
        model.texture("side", casing);
    }
}
