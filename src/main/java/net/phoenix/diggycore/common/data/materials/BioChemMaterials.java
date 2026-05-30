package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import net.phoenix.diggycore.DiggyCore;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class BioChemMaterials {

    public static Material ATP;
    public static Material ADP;
    public static Material NADPH;
    public static Material NADP_MAIS;
    public static Material RUBP;
    public static Material _3_PGA;
    public static Material _1_3_BPG;
    public static Material PGAL;
    public static Material GLUCOSE;
    public static Material H_MAIS;
    public static Material ORGANICS_EXTRACTION_FLUID;

    public static void register() {
        ATP = new Material.Builder(DiggyCore.id("atp"))
                .fluid()
                .langValue("Adenosine Triphosphate (ATP)")
                .color(0xDDE330)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16, Oxygen, 13, Phosphorus, 3)
                .buildAndRegister();

        ADP = new Material.Builder(DiggyCore.id("adp"))
                .fluid()
                .langValue("Adenosine Diphosphate (ADP)")
                .color(0xE2BF30)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 15, Oxygen, 19, Phosphorus, 2)
                .buildAndRegister();

        NADPH = new Material.Builder(DiggyCore.id("nadph"))
                .fluid()
                .langValue("Reduced Nicotinamide Adenine Dinucleotide Phosphate (NADPH)")
                .color(0x308CE3)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 21, Hydrogen, 29, Nitrogen, 7, Oxygen, 17, Phosphorus, 3)
                .buildAndRegister();

        NADP_MAIS = new Material.Builder(DiggyCore.id("nadp_mais"))
                .fluid()
                .langValue("Oxidized Nicotinamide Adenine Dinucleotide Phosphate (NADP+)")
                .color(0x103EE6)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 21, Hydrogen, 28, Nitrogen, 7, Oxygen, 17, Phosphorus, 3)
                .buildAndRegister();

        RUBP = new Material.Builder(DiggyCore.id("rubp"))
                .fluid()
                .langValue("Ribulose 1,5-bisphosphate (RuBP)")
                .color(0xD97EA5)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 5, Hydrogen, 12, Oxygen, 11, Phosphorus, 2)
                .buildAndRegister();

        _3_PGA = new Material.Builder(DiggyCore.id("3_pga"))
                .fluid()
                .langValue("3-Phosphoglyceric acid (3-PGA)")
                .color(0xC96783)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 7, Oxygen, 7, Phosphorus, 1)
                .buildAndRegister();
    }
}
