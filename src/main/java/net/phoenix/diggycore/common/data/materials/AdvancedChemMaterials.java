package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import net.phoenix.diggycore.DiggyCore;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class AdvancedChemMaterials {

    public static Material UPSILON;
    public static Material BROAD_OMEGA_MATTER;
    public static Material BROAD_OMEGA_FUEL;
    public static Material FRA_CODED_MATTER;
    public static Material METHANE_ION;
    public static Material METHANIUM;
    public static Material METHYL_RADICAL;
    public static Material AI_SLOP; // Son i'm crine
    public static Material FX_COOLANT;
    public static Material WARP_COOLANT;

    public static void register() {
        UPSILON = new Material.Builder(DiggyCore.id("upsilon"))
                .liquid(0)
                .langValue("Upsilon Fluid")
                .color(0x03fcbe)
                .flags(DISABLE_DECOMPOSITION)
                .formula("Υ")
                .buildAndRegister();

        FRA_CODED_MATTER = new Material.Builder(DiggyCore.id("fra_coded_matter"))
                .liquid(0).dust()
                .langValue("§gFRA Coded Matter")
                .color(0x40ab22)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .formula("§kabcdef")
                .buildAndRegister();

        METHANE_ION = new Material.Builder(DiggyCore.id("methane_ion"))
                .liquid()
                .langValue("Methane Ion")
                .color(0xf0414f)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.FLUID)
                .formula("CH₄⁺")
                .buildAndRegister();

        METHANIUM = new Material.Builder(DiggyCore.id("methanium"))
                .liquid()
                .langValue("Methanium")
                .color(0xf05841)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.FLUID)
                .formula("CH₅⁺")
                .buildAndRegister();

        METHYL_RADICAL = new Material.Builder(DiggyCore.id("methyl_radical"))
                .liquid()
                .langValue("Methyl Radical")
                .color(0xf041ea)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.FLUID)
                .formula("CH₃•")
                .buildAndRegister();

        AI_SLOP = new Material.Builder(DiggyCore.id("ai_slop"))
                .liquid()
                .langValue("AI Slop")
                .color(0xab9a84)
                .iconSet(MaterialIconSet.FLUID)
                .formula("...What?")
                .buildAndRegister();

        FX_COOLANT = new Material.Builder(DiggyCore.id("fx_coolant"))
                .liquid()
                .langValue("FX Coolant")
                .color(0xFF8EA1)
                .iconSet(MaterialIconSet.FLUID)
                .formula("Σ₆Φ₄H₃(???)")
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        WARP_COOLANT = new Material.Builder(DiggyCore.id("warp_coolant"))
                .liquid()
                .langValue("Warp Coolant")
                .color(0x1000FF)
                .iconSet(MaterialIconSet.FLUID)
                .formula("Ꙍ₆ↈ⑽Δ(???)")
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
    }
}
