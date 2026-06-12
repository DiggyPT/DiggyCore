package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;

import net.phoenix.diggycore.DiggyCore;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.phoenix.diggycore.common.data.materials.DiggyNewElementsAndAddFlags.*;

public class DiggyMetallurgicAndGems {

    // Overworld ores.
    public static Material COVELLITE;
    public static Material ENARGITE;

    // Moon ores.
    public static Material METEORIC_IRON;
    public static Material LUNAR_SAPPHIRE;

    // Mars ores.
    public static Material SEA_CRYSTAL;
    public static Material FOSSIL_RECENT;
    public static Material FOSSIL_OLD;
    public static Material FOSSIL_ANCIENT;

    // Venus ores.
    public static Material CALORITE;

    // Proxima ores.
    public static Material ISAACMANITE;
    public static Material GUNNERITE;
    public static Material CENTAURITE;

    // Heavy-duty plating.
    public static Material HEAVY_DUTY_PLATING_TIER_1;
    public static Material HEAVY_DUTY_PLATING_TIER_2;
    public static Material HEAVY_DUTY_PLATING_TIER_3;
    public static Material HEAVY_DUTY_PLATING_TIER_4;
    public static Material HEAVY_DUTY_PLATING_TIER_5;
    public static Material HEAVY_DUTY_PLATING_TIER_6;
    public static Material HEAVY_DUTY_PLATING_TIER_7;
    public static Material HEAVY_DUTY_PLATING_TIER_8;
    public static Material HEAVY_DUTY_PLATING_TIER_9;
    public static Material HEAVY_DUTY_PLATING_TIER_10;
    public static Material HEAVY_DUTY_PLATING_TIER_11;

    // Other alloys.
    public static Material MARAGING_STEEL_200;

    public static void register() {
        ISAACMANITE = new Material.Builder(DiggyCore.id("isaacmanite"))
                .gem(3).ore(3, 1)
                .color(0x41f2a6)
                .secondaryColor(0x2799b0)
                .iconSet(MaterialIconSet.OPAL)
                .components(Thulium, 5, Holmium, 7, Oxygen, 4, BOHEMIUM, 15)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        GUNNERITE = new Material.Builder(DiggyCore.id("gunnerite"))
                .gem(3).ore(3, 1)
                .color(0xe81ec6)
                .secondaryColor(0xaa1dd1)
                .iconSet(MaterialIconSet.EMERALD)
                .components(Gadolinium, 5, Boron, 7, Hydrogen, 4, HAWKINE, 15)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        COVELLITE = new Material.Builder(DiggyCore.id("covellite"))
                .ore()
                .color(0x4673a0)
                .iconSet(MaterialIconSet.FINE)
                .components(Copper, 1, Sulfur, 1)
                .buildAndRegister();

        ENARGITE = new Material.Builder(DiggyCore.id("enargite"))
                .ore()
                .color(0xc2b9a8)
                .iconSet(MaterialIconSet.FINE)
                .components(Copper, 3, Arsenic, 1, Sulfur, 4)
                .buildAndRegister();

        CENTAURITE = new Material.Builder(DiggyCore.id("centaurite"))
                .ore()
                .color(0xc97871)
                .iconSet(MaterialIconSet.ROUGH)
                .components(CENTAURIUM, 15, DESH, 4, TricalciumPhosphate, 5, Zeolite, 2)
                .buildAndRegister();

        SEA_CRYSTAL = new Material.Builder(DiggyCore.id("sea_crystal"))
                .gem(3).ore(1, 1)
                .color(0x26a4ed)
                .secondaryColor(0x2662ed)
                .iconSet(MaterialIconSet.DIAMOND)
                .formula("C₆₄Π")
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        METEORIC_IRON = new Material.Builder(DiggyCore.id("meteoric_iron"))
                .ingot().ore(1, 1)
                .color(0x877c6d)
                .iconSet(MaterialIconSet.METALLIC)
                .formula("Fe?")
                .appendFlags(EXT_METAL)
                .langValue("Meteoric Iron")
                .buildAndRegister();

        LUNAR_SAPPHIRE = new Material.Builder(DiggyCore.id("lunar_sapphire"))
                .gem().ore(1, 1)
                .color(0x2803fc)
                .iconSet(MaterialIconSet.EMERALD)
                .components(Sapphire, 1, METEORIC_IRON, 1)
                .flags(HIGH_SIFTER_OUTPUT, GENERATE_LENS)
                .langValue("Lunar Sapphire")
                .buildAndRegister();

        CALORITE = new Material.Builder(DiggyCore.id("calorite"))
                .ingot().ore(1, 1)
                .color(0xDB5656)
                .iconSet(MaterialIconSet.SHINY)
                .components(COVELLITE, 4, Quartzite, 7, METEORIC_IRON, 2, PHOENICIUM, 23, Oxygen, 5)
                .flags(DISABLE_DECOMPOSITION)
                .langValue("Calorite")
                .buildAndRegister();

        MARAGING_STEEL_200 = new Material.Builder(DiggyCore.id("maraging_steel_200"))
                .ingot()
                .color(0x626EAD)
                .iconSet(DiggyMaterialSet.MARINE)
                .components(Iron, 16, Titanium, 1, Aluminium, 1, Nickel, 2, Cobalt, 1)
                .langValue("Maraging Steel 200")
                .appendFlags(EXT2_METAL)
                .blastTemp(3214, BlastProperty.GasTier.MID)
                .buildAndRegister();

        // Heavy-duty plating
        HEAVY_DUTY_PLATING_TIER_1 = new Material.Builder(DiggyCore.id("heavy_duty_plating_tier_1"))
                .ingot()
                .color(0x7d8388)
                .secondaryColor(0x4b271f)
                .iconSet(DiggyMaterialSet.HEAVY_DUTY)
                .components(Steel, 1, Aluminium, 1, Bronze, 1)
                .blastTemp(2000, BlastProperty.GasTier.LOW)
                .langValue("Heavy-Duty (Tier I)")
                .appendFlags(EXT_METAL)
                .buildAndRegister();

        // Heavy-duty plating tier 2
        HEAVY_DUTY_PLATING_TIER_2 = new Material.Builder(DiggyCore.id("heavy_duty_plating_tier_2"))
                .ingot()
                .color(0x685c4e)
                .secondaryColor(0x695f51)
                .iconSet(DiggyMaterialSet.HEAVY_DUTY)
                .components(HEAVY_DUTY_PLATING_TIER_1, 1, METEORIC_IRON, 1, DESH, 1)
                .blastTemp(2000, BlastProperty.GasTier.LOW)
                .langValue("Heavy-Duty (Tier II)")
                .appendFlags(EXT_METAL)
                .buildAndRegister();

        // Heavy-duty plating tier 3
        HEAVY_DUTY_PLATING_TIER_3 = new Material.Builder(DiggyCore.id("heavy_duty_plating_tier_3"))
                .ingot()
                .color(0x995D5F)
                .secondaryColor(0x5A4252)
                .iconSet(DiggyMaterialSet.HEAVY_DUTY)
                .components(HEAVY_DUTY_PLATING_TIER_2, 1, OSTRUM, 1)
                .blastTemp(3000, BlastProperty.GasTier.MID)
                .langValue("Heavy-Duty (Tier III)")
                .appendFlags(EXT_METAL)
                .buildAndRegister();

        // Heavy-duty plating tier 4
        HEAVY_DUTY_PLATING_TIER_4 = new Material.Builder(DiggyCore.id("heavy_duty_plating_tier_4"))
                .ingot()
                .color(0xDB5656)
                .secondaryColor(0xB42A43)
                .iconSet(DiggyMaterialSet.HEAVY_DUTY)
                .components(HEAVY_DUTY_PLATING_TIER_3, 1, CALORITE, 1)
                .blastTemp(3000, BlastProperty.GasTier.MID)
                .langValue("Heavy-Duty (Tier IV)")
                .appendFlags(EXT_METAL)
                .buildAndRegister();

        // Heavy-duty plating tier 5
        HEAVY_DUTY_PLATING_TIER_5 = new Material.Builder(DiggyCore.id("heavy_duty_plating_tier_5"))
                .ingot()
                .color(0x4395C8)
                .secondaryColor(0xB6E3FF)
                .iconSet(DiggyMaterialSet.HEAVY_DUTY)
                // .components(HEAVY_DUTY_PLATING_TIER_3, 1, CALORITE, 1)
                .blastTemp(3000, BlastProperty.GasTier.MID)
                .langValue("Heavy-Duty (Tier V)")
                .appendFlags(EXT_METAL)
                .buildAndRegister();

        // Heavy-duty plating tier 6
        HEAVY_DUTY_PLATING_TIER_6 = new Material.Builder(DiggyCore.id("heavy_duty_plating_tier_6"))
                .ingot()
                .color(0x9825E1)
                .secondaryColor(0x4801B1)
                .iconSet(DiggyMaterialSet.HEAVY_DUTY)
                // .components(HEAVY_DUTY_PLATING_TIER_3, 1, CALORITE, 1)
                .blastTemp(3000, BlastProperty.GasTier.MID)
                .langValue("Heavy-Duty (Tier VI)")
                .appendFlags(EXT_METAL)
                .buildAndRegister();

        // Heavy-duty plating tier 7
        HEAVY_DUTY_PLATING_TIER_7 = new Material.Builder(DiggyCore.id("heavy_duty_plating_tier_7"))
                .ingot()
                .color(0x59C16B)
                .secondaryColor(0x4C6B20)
                .iconSet(DiggyMaterialSet.HEAVY_DUTY)
                // .components(HEAVY_DUTY_PLATING_TIER_3, 1, CALORITE, 1)
                .blastTemp(3000, BlastProperty.GasTier.MID)
                .langValue("Heavy-Duty (Tier VII)")
                .appendFlags(EXT_METAL)
                .buildAndRegister();

        // Heavy-duty plating tier 8
        HEAVY_DUTY_PLATING_TIER_8 = new Material.Builder(DiggyCore.id("heavy_duty_plating_tier_8"))
                .ingot()
                .color(0x82A86C)
                .secondaryColor(0x697753)
                .iconSet(DiggyMaterialSet.HEAVY_DUTY)
                // .components(HEAVY_DUTY_PLATING_TIER_3, 1, CALORITE, 1)
                .blastTemp(3000, BlastProperty.GasTier.MID)
                .langValue("Heavy-Duty (Tier VIII)")
                .appendFlags(EXT_METAL)
                .buildAndRegister();

        // Heavy-duty plating tier 9
        HEAVY_DUTY_PLATING_TIER_9 = new Material.Builder(DiggyCore.id("heavy_duty_plating_tier_9"))
                .ingot()
                .color(0x7CFE8B)
                .secondaryColor(0xEDFFDE)
                .iconSet(DiggyMaterialSet.HEAVY_DUTY)
                // .components(HEAVY_DUTY_PLATING_TIER_3, 1, CALORITE, 1)
                .blastTemp(3000, BlastProperty.GasTier.MID)
                .langValue("Heavy-Duty (Tier IX)")
                .appendFlags(EXT_METAL)
                .buildAndRegister();

        // Heavy-duty plating tier 10
        HEAVY_DUTY_PLATING_TIER_10 = new Material.Builder(DiggyCore.id("heavy_duty_plating_tier_10"))
                .ingot()
                .color(0xFFFF00)
                .secondaryColor(0xFF7C00)
                .iconSet(DiggyMaterialSet.HEAVY_DUTY)
                // .components(HEAVY_DUTY_PLATING_TIER_3, 1, CALORITE, 1)
                .blastTemp(3000, BlastProperty.GasTier.MID)
                .langValue("Heavy-Duty (Tier X)")
                .appendFlags(EXT_METAL)
                .buildAndRegister();

        // Heavy-duty plating tier 11
        HEAVY_DUTY_PLATING_TIER_11 = new Material.Builder(DiggyCore.id("heavy_duty_plating_tier_11"))
                .ingot()
                .color(0x0601BD)
                .secondaryColor(0x000055)
                .iconSet(DiggyMaterialSet.HEAVY_DUTY)
                // .components(HEAVY_DUTY_PLATING_TIER_3, 1, CALORITE, 1)
                .blastTemp(3000, BlastProperty.GasTier.MID)
                .langValue("Heavy-Duty (Tier XI)")
                .appendFlags(EXT_METAL)
                .buildAndRegister();
    }
}
