package net.phoenix.diggycore;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.sound.SoundEntry;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;

import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.phoenix.diggycore.common.DiggyPlanetUtils;
import net.phoenix.diggycore.common.block.DiggyBlocks;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;
import net.phoenix.diggycore.common.data.materials.*;
import net.phoenix.diggycore.common.data.recipe.DiggyCraftingComponents;
import net.phoenix.diggycore.common.item.DiggyItems;
import net.phoenix.diggycore.common.machine.DiggyMachines;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;
import com.tterrag.registrate.util.entry.RegistryEntry;
import earth.terrarium.adastra.api.client.events.AdAstraClientEvents;
import earth.terrarium.adastra.client.utils.DimensionRenderingUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static earth.terrarium.adastra.client.screens.PlanetsScreen.drawCircles;
import static net.phoenix.diggycore.common.registry.DiggyRegistration.REGISTRATE;

@Mod(DiggyCore.MOD_ID)
@SuppressWarnings("removal")
public class DiggyCore {

    public static final String MOD_ID = "diggycore";
    public static final Logger LOGGER = LogManager.getLogger();
    // public static GTRegistrate EXAMPLE_REGISTRATE = GTRegistrate.create(DiggyCore.MOD_ID);

    public static RegistryEntry<CreativeModeTab> DIGGY_CREATIVE_TAB = REGISTRATE
            .defaultCreativeTab(DiggyCore.MOD_ID,
                    builder -> builder
                            .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(DiggyCore.MOD_ID,
                                    REGISTRATE))
                            .title(REGISTRATE.addLang("itemGroup", DiggyCore.id("creative_tab"),
                                    "DiggyCore"))
                            .icon(() -> new ItemStack(Blocks.IRON_BLOCK))
                            .build())
            .register();

    public DiggyCore() {
        init();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        modEventBus.addListener(this::addMaterialRegistries);
        modEventBus.addListener(this::addMaterials);
        modEventBus.addListener(this::modifyMaterials);

        modEventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        modEventBus.addGenericListener(MachineDefinition.class, this::registerMachines);
        modEventBus.addGenericListener(SoundEntry.class, this::registerSounds);

        // Most other events are fired on Forge's bus.
        // If we want to use annotations to register event listeners,
        // we need to register our object like this!
        MinecraftForge.EVENT_BUS.register(this);

        // EXAMPLE_REGISTRATE.registerRegistrate();
    }

    public static ResourceLocation resourceLocation(String path) {
        return new ResourceLocation(DiggyCore.MOD_ID, path);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("Hello from common setup! This is *after* registries are done, so we can do this:");
            LOGGER.info("Look, I found a {}!", Items.DIAMOND);
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Hey, we're on Minecraft version {}!", Minecraft.getInstance().getLaunchedVersion());
    }

    /**
     * Create a ResourceLocation in the format "modid:path"
     *
     * @param path
     * @return ResourceLocation with the namespace of your mod
     */
    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static void init() {
        // Then register everything else.
        // PhoenixConfigs.init();
        REGISTRATE.registerRegistrate();
        DiggyBlocks.init();
        DiggyItems.init();
        DiggyMaterialFlags.init();
        //DiggyCraftingComponents.init();

        // PhoenixDatagen.init();
    }

    /**
     * Create a material manager for your mod using GT's API.
     * You MUST have this if you have custom materials.
     * Remember to register them not to GT's namespace, but your own.
     *
     * @param event
     */
    private void addMaterialRegistries(MaterialRegistryEvent event) {
        GTCEuAPI.materialManager.createRegistry(DiggyCore.MOD_ID);
    }

    /**
     * You will also need this for registering custom materials
     * Call init() from your Material class(es) here
     *
     * @param event
     */
    private void addMaterials(MaterialEvent event) {
        // CustomMaterials.init();
        DiggyNewElementsAndAddFlags.register();
        ElementMaterials.register();
        AdvancedChemMaterials.register();
        BasicChemistryMaterials.register();
        DiggyMetallurgicAndGems.register();
    }

    /**
     * (Optional) Used to modify pre-existing materials from GregTech
     *
     * @param event
     */
    private void modifyMaterials(PostMaterialEvent event) {
        DiggyNewElementsAndAddFlags.modifyMaterials();
    }

    /**
     * Used to register your own new RecipeTypes.
     * Call init() from your RecipeType class(es) here
     *
     * @param event
     */
    private void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        DiggyRecipeTypes.init();
    }

    /**
     * Used to register your own new machines.
     * Call init() from your Machine class(es) here
     *
     * @param event
     */
    private void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        DiggyMachines.init();
    }

    /**
     * Used to register your own new sounds
     * Call init from your Sound class(es) here
     *
     * @param event
     */
    public void registerSounds(GTCEuAPI.RegisterEvent<ResourceLocation, SoundEntry> event) {
        // CustomSounds.init();
    }

    static {
        AdAstraClientEvents.RenderSolarSystemEvent.register((graphics, solarSystem, width, height) -> {
            if (DiggyPlanetUtils.TAU_CETI.equals(solarSystem)) {
                Tesselator tessellator = Tesselator.getInstance();
                BufferBuilder bufferBuilder = tessellator.getBuilder();
                RenderSystem.setShader(GameRenderer::getPositionColorShader);
                bufferBuilder.begin(VertexFormat.Mode.DEBUG_LINES, DefaultVertexFormat.POSITION_COLOR);
                drawCircles(1, 1, -16744320, bufferBuilder, width, height);
                tessellator.end();
                graphics.blit(DimensionRenderingUtils.SUN, width / 2 - 8, height / 2 - 8, 0.0F, 0.0F, 16, 16, 16, 16);
                float rotation = (float) Util.getMillis() / 100.0F % 360.0F;

                for(int i = 1; i < 4; ++i) {
                    graphics.pose().pushPose();
                    graphics.pose().translate((float)width / 2.0F, (float)height / 2.0F, 0.0F);
                    graphics.pose().mulPose(Axis.ZP.rotationDegrees(rotation * (float)(4 - i) / 2.0F));
                    graphics.pose().translate((float)(31 * i - 10), 0.0F, 0.0F);
                    graphics.blit(DiggyPlanetUtils.TAU_CETI_TEXTURES.get(i - 1), 0, 0, 0.0F, 0.0F, 12, 12, 12, 12);
                    graphics.pose().popPose();
                }
            }
        });
    }
}
