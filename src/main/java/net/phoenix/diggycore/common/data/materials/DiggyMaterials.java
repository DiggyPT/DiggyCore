package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import net.phoenix.diggycore.DiggyCore;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Dysprosium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Iron;

public class DiggyMaterials {

    public static Material FEYNMANIUM;
    public static Material ARMSTRONGIUM;
    public static Material HAWKINE;
    public static Material KEPLERUM;
    public static Material BELUSOVIUM;
    public static Material SONYA;
    public static Material UNIFON;
    public static Material BOHEMIUM;
    public static Material LUSITANIUM;
    public static Material MAGRABIYAH;
    public static Material NICOSIUM;

    public static void register() {
        FEYNMANIUM = new Material.Builder(DiggyCore.id("feynmanium"))
                .ingot()
                .color(0x9999ff)
                .secondaryColor(0x6161b8)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .formula("Fn")
                .buildAndRegister();

        ARMSTRONGIUM = new Material.Builder(DiggyCore.id("armstrongium"))
                .ingot()
                .color(0x339966)
                .secondaryColor(0x1fa69b)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .formula("Ao")
                .buildAndRegister();

        HAWKINE = new Material.Builder(DiggyCore.id("hawkine"))
                .ingot()
                .color(0x6dcab3)
                .secondaryColor(0x56e35d)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .formula("Hw")
                .buildAndRegister();

        KEPLERUM = new Material.Builder(DiggyCore.id("keplerum"))
                .ingot()
                .color(0xcc9900)
                .secondaryColor(0xbf803d)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .formula("Kp")
                .buildAndRegister();

        BELUSOVIUM = new Material.Builder(DiggyCore.id("belusovium"))
                .ingot()
                .color(0xe8275b)
                .secondaryColor(0xed7474)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .formula("Bv")
                .buildAndRegister();

        SONYA = new Material.Builder(DiggyCore.id("sonya"))
                .ingot()
                .color(0x9999ff)
                .secondaryColor(0x6161b8)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .formula("Sy")
                .buildAndRegister();

        UNIFON = new Material.Builder(DiggyCore.id("unifon"))
                .ingot()
                .color(0xd47dd4)
                .secondaryColor(0xcbde3c)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .formula("Uf")
                .buildAndRegister();

        BOHEMIUM = new Material.Builder(DiggyCore.id("bohemium"))
                .ingot()
                .color(0xe06746)
                .secondaryColor(0xa62821)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .formula("Bh")
                .buildAndRegister();

        LUSITANIUM = new Material.Builder(DiggyCore.id("lusitanium"))
                .ingot()
                .color(0x95e381)
                .secondaryColor(0xbfc74c)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .formula("L")
                .buildAndRegister();

        MAGRABIYAH = new Material.Builder(DiggyCore.id("magrabiyah"))
                .ingot()
                .color(0x353632)
                .secondaryColor(0x9c544e)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .formula("Ma")
                .buildAndRegister();

        NICOSIUM = new Material.Builder(DiggyCore.id("nicosium"))
                .ingot()
                .color(0xebe652)
                .secondaryColor(0x694728)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .formula("Ns")
                .buildAndRegister();
    }

    public static void modifyMaterials() {
        Iron.addFlags(DiggyMaterialFlags.GENERATE_VIAL);
        Dysprosium.addFlags(DiggyMaterialFlags.GENERATE_VIAL);
    }
}
