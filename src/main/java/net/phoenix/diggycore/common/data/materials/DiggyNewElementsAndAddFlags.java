package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.OreProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;

import net.phoenix.diggycore.DiggyCore;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.phoenix.diggycore.common.data.materials.DiggyMaterialFlags.*;
import static net.phoenix.diggycore.common.data.materials.DiggyMetallurgicAndGems.*;

public class DiggyNewElementsAndAddFlags {

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
    public static Material CUANDAY;

    public static void register() {
        FEYNMANIUM = new Material.Builder(DiggyCore.id("feynmanium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(1521))
                .color(0x9999ff)
                .secondaryColor(0x6161b8)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .element(DiggyElements.FEYNMANIUM)
                .appendFlags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FOIL, GENERATE_FRAME,
                        GENERATE_VIAL)
                .buildAndRegister();

        ARMSTRONGIUM = new Material.Builder(DiggyCore.id("armstrongium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(1143))
                .color(0x339966)
                .secondaryColor(0x1fa69b)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .element(DiggyElements.ARMSTRONGIUM)
                .appendFlags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FOIL, GENERATE_FRAME,
                        GENERATE_VIAL)
                .buildAndRegister();

        HAWKINE = new Material.Builder(DiggyCore.id("hawkine"))
                .ingot()
                .liquid(new FluidBuilder().temperature(1492))
                .color(0x6dcab3)
                .secondaryColor(0x56e35d)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .element(DiggyElements.HAWKINE)
                .appendFlags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FOIL, GENERATE_FRAME,
                        GENERATE_VIAL)
                .buildAndRegister();

        KEPLERUM = new Material.Builder(DiggyCore.id("keplerum"))
                .ingot()
                .liquid(new FluidBuilder().temperature(1572))
                .color(0xcc9900)
                .secondaryColor(0xbf803d)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .element(DiggyElements.KEPLERUM)
                .appendFlags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FOIL, GENERATE_FRAME,
                        GENERATE_VIAL)
                .buildAndRegister();

        BELUSOVIUM = new Material.Builder(DiggyCore.id("belusovium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(711))
                .color(0xe8275b)
                .secondaryColor(0xed7474)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .element(DiggyElements.BELUSOVIUM)
                .appendFlags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FOIL, GENERATE_FRAME,
                        GENERATE_VIAL)
                .buildAndRegister();

        SONYA = new Material.Builder(DiggyCore.id("sonya"))
                .ingot()
                .liquid(new FluidBuilder().temperature(1200))
                .color(0x6b35e8)
                .secondaryColor(0x6e413a)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .element(DiggyElements.SONYA)
                .appendFlags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FOIL, GENERATE_FRAME,
                        GENERATE_VIAL)
                .buildAndRegister();

        UNIFON = new Material.Builder(DiggyCore.id("unifon"))
                .ingot()
                .liquid(new FluidBuilder().temperature(1776))
                .color(0xd47dd4)
                .secondaryColor(0xcbde3c)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .element(DiggyElements.UNIFON)
                .appendFlags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FOIL, GENERATE_FRAME,
                        GENERATE_VIAL)
                .buildAndRegister();

        BOHEMIUM = new Material.Builder(DiggyCore.id("bohemium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(933))
                .color(0xe06746)
                .secondaryColor(0xa62821)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .element(DiggyElements.BOHEMIUM)
                .appendFlags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FOIL, GENERATE_FRAME,
                        GENERATE_VIAL)
                .buildAndRegister();

        LUSITANIUM = new Material.Builder(DiggyCore.id("lusitanium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(1974))
                .color(0x95e381)
                .secondaryColor(0xbfc74c)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .element(DiggyElements.LUSITANIUM)
                .appendFlags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FOIL, GENERATE_FRAME,
                        GENERATE_VIAL)
                .buildAndRegister();

        MAGRABIYAH = new Material.Builder(DiggyCore.id("magrabiyah"))
                .ingot()
                .liquid(new FluidBuilder().temperature(1969))
                .color(0x353632)
                .secondaryColor(0x9c544e)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .element(DiggyElements.MAGRABIYAH)
                .appendFlags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FOIL, GENERATE_FRAME,
                        GENERATE_VIAL)
                .buildAndRegister();

        NICOSIUM = new Material.Builder(DiggyCore.id("nicosium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(2067))
                .color(0xebe652)
                .secondaryColor(0x694728)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .element(DiggyElements.NICOSIUM)
                .appendFlags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FOIL, GENERATE_FRAME,
                        GENERATE_VIAL)
                .buildAndRegister();

        CUANDAY = new Material.Builder(DiggyCore.id("cuanday"))
                .ingot()
                .liquid(new FluidBuilder().temperature(2929))
                .color(0xEBC2EB)
                .secondaryColor(0xC16AC1)
                .iconSet(MaterialIconSet.DULL)
                .element(DiggyElements.CUANDAY)
                .appendFlags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FOIL, GENERATE_FRAME,
                        GENERATE_VIAL)
                .buildAndRegister();
    }

    public static void addBasicFlags(Material material) {
        material.addFlags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_BOLT_SCREW, GENERATE_FOIL);
        addDiggyFlags(material);
    }

    public static void addDiggyFlags(Material material) {
        material.addFlags(GENERATE_VIAL, GENERATE_DOUBLE_INGOT);
    }

    public static void addBeeFlags(Material material) {
        material.addFlags(GENERATE_BEE_COMB);
    }

    public static void modifyMaterials() {
        addDiggyFlags(Iron);
        addDiggyFlags(Copper);
        addDiggyFlags(Tin);
        addDiggyFlags(Zinc);
        addDiggyFlags(Zirconium);
        addDiggyFlags(Hafnium);

        addBasicFlags(Dysprosium);
        addBasicFlags(Praseodymium);
        addBasicFlags(Protactinium);
        addBasicFlags(Neptunium);
        addBasicFlags(Scandium);
        addBasicFlags(Germanium);
        addBasicFlags(Selenium);
        addBasicFlags(Tellurium);
        addBasicFlags(Gadolinium);
        addBasicFlags(Terbium);
        addBasicFlags(Rubidium);
        addBasicFlags(Rhenium);
        addBasicFlags(Strontium);
        addBasicFlags(Thallium);
        addBasicFlags(Polonium);
        addBasicFlags(Radium);
        addBasicFlags(Technetium);
        // actinides + lanthanides
        addBasicFlags(Actinium);
        addBasicFlags(Curium);
        addBasicFlags(Berkelium);
        addBasicFlags(Californium);
        addBasicFlags(Holmium);
        addBasicFlags(Erbium);
        addBasicFlags(Thulium);
        addBasicFlags(Ytterbium);
        addBasicFlags(Einsteinium);
        addBasicFlags(Fermium);
        addBasicFlags(Mendelevium);
        addBasicFlags(Nobelium);
        addBasicFlags(Lawrencium);
        addBasicFlags(Promethium);
        // superheavy elements
        addBasicFlags(Rutherfordium);
        addBasicFlags(Dubnium);
        addBasicFlags(Seaborgium);
        addBasicFlags(Bohrium);
        addBasicFlags(Hassium);
        addBasicFlags(Meitnerium);
        addBasicFlags(Roentgenium);
        addBasicFlags(Copernicium);
        addBasicFlags(Nihonium);
        addBasicFlags(Flerovium);
        addBasicFlags(Moscovium);
        addBasicFlags(Livermorium);
        addBasicFlags(Tennessine);
        addBasicFlags(Francium);
        addBasicFlags(Astatine);

        // AHHHHHHHHHHHHHHHHHHHHHHHHHH
        addBeeFlags(Iron);
        addBeeFlags(Copper);
        addBeeFlags(Gold);
        addBeeFlags(Cassiterite);
        addBeeFlags(Trona);
        addBeeFlags(Ruby);
        addBeeFlags(Stibnite);
        addBeeFlags(BlueTopaz);
        addBeeFlags(RockSalt);
        addBeeFlags(Tantalite);
        addBeeFlags(Sphalerite);
        addBeeFlags(Garnierite);
        addBeeFlags(Spessartine);
        addBeeFlags(Chalcocite);
        addBeeFlags(Asbestos);
        addBeeFlags(GlauconiteSand);
        addBeeFlags(Quartzite);
        addBeeFlags(Thorium);
        addBeeFlags(GraniticMineralSand);
        addBeeFlags(Cinnabar);
        addBeeFlags(Lazurite);
        addBeeFlags(Pyrope);
        addBeeFlags(Kyanite);
        addBeeFlags(BasalticMineralSand);
        addBeeFlags(Pitchblende);
        addBeeFlags(Cobalt);
        addBeeFlags(Topaz);
        addBeeFlags(Graphite);
        addBeeFlags(Neodymium);
        addBeeFlags(GarnetRed);
        addBeeFlags(Lithium);
        addBeeFlags(Chalcopyrite);
        addBeeFlags(TricalciumPhosphate);
        addBeeFlags(Palladium);
        addBeeFlags(Pollucite);
        addBeeFlags(Amethyst);
        addBeeFlags(Alunite);
        addBeeFlags(Beryllium);
        addBeeFlags(Wulfenite);
        addBeeFlags(Barite);
        addBeeFlags(Opal);
        addBeeFlags(Pyrochlore);
        addBeeFlags(Oilsands);
        addBeeFlags(Coal);
        addBeeFlags(Electrotine);
        addBeeFlags(Pyrite);
        addBeeFlags(Tungstate);
        addBeeFlags(Chromite);
        addBeeFlags(Saltpeter);
        addBeeFlags(Apatite);
        addBeeFlags(Redstone);
        addBeeFlags(Soapstone);
        addBeeFlags(Ilmenite);
        addBeeFlags(Olivine);
        addBeeFlags(Scheelite);
        addBeeFlags(Lead);
        addBeeFlags(Emerald);
        addBeeFlags(Diatomite);
        addBeeFlags(Molybdenum);
        addBeeFlags(FullersEarth);
        addBeeFlags(Bentonite);
        addBeeFlags(Magnesite);
        addBeeFlags(Limonite);
        addBeeFlags(Cooperite);
        addBeeFlags(Powellite);
        addBeeFlags(Sodalite);
        addBeeFlags(Calcite);
        addBeeFlags(Almandine);
        addBeeFlags(Gypsum);
        addBeeFlags(Naquadah);
        addBeeFlags(Magnetite);
        addBeeFlags(VanadiumMagnetite);
        addBeeFlags(Diamond);
        addBeeFlags(Bauxite);
        addBeeFlags(Zeolite);
        addBeeFlags(Aluminium);
        addBeeFlags(Plutonium239);
        addBeeFlags(CassiteriteSand);
        addBeeFlags(Sulfur);
        addBeeFlags(Hematite);
        addBeeFlags(Pyrolusite);
        addBeeFlags(Galena);
        addBeeFlags(GarnetYellow);
        addBeeFlags(Mica);
        addBeeFlags(Platinum);
        addBeeFlags(Nickel);
        addBeeFlags(Salt);
        addBeeFlags(Spodumene);
        addBeeFlags(Lapis);
        addBeeFlags(GarnetSand);
        addBeeFlags(Uraninite);
        addBeeFlags(Molybdenite);
        addBeeFlags(Lepidolite);
        addBeeFlags(Talc);
        addBeeFlags(Realgar);
        addBeeFlags(GreenSapphire);
        addBeeFlags(Bastnasite);
        addBeeFlags(Tin);
        addBeeFlags(NetherQuartz);
        addBeeFlags(Monazite);
        addBeeFlags(Goethite);
        addBeeFlags(Cobaltite);
        addBeeFlags(Malachite);
        addBeeFlags(Sapphire);
        addBeeFlags(Bornite);
        addBeeFlags(Pentlandite);
        addBeeFlags(Grossular);
        addBeeFlags(CertusQuartz);
        addBeeFlags(Silver);
        addBeeFlags(Tetrahedrite);

        //ores
        OreProperty oreProp = COVELLITE.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(Copper);
        oreProp.setOreByProducts(ENARGITE, Pyrite, Chalcocite);

        oreProp = ENARGITE.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(Copper);
        oreProp.setOreByProducts(Barite, Pyrite, Sphalerite);

        oreProp = Niobium.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Tantalite, Pyrochlore, Titanium);

        oreProp = Dysprosium.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Monazite, Cooperite, Holmium);

        oreProp = Gadolinium.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Monazite, Cooperite, Dysprosium);

        oreProp = Europium.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Monazite, Cooperite, Gadolinium);

        oreProp = Holmium.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Monazite, Cooperite, Dysprosium);
    }
}
