package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.*;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Dysprosium;

public class ElementMaterials {

    public static void register() {
        GTMaterials.Dysprosium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Praseodymium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Protactinium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Neptunium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Scandium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Germanium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Selenium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Tellurium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Gadolinium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Terbium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Rubidium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Rhenium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Strontium.setProperty(PropertyKey.INGOT, new IngotProperty());
        // GTMaterials.Zirconium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Thallium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Polonium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Radium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Technetium.setProperty(PropertyKey.INGOT, new IngotProperty());
        // GTMaterials.Hafnium.setProperty(PropertyKey.INGOT, new IngotProperty());
        // Actinides and lanthanides
        GTMaterials.Actinium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Curium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Berkelium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Californium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Holmium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Erbium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Thulium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Ytterbium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Einsteinium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Fermium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Mendelevium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Nobelium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Lawrencium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Promethium.setProperty(PropertyKey.INGOT, new IngotProperty());
        // Superheavy elements (period 7)
        GTMaterials.Rutherfordium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Dubnium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Seaborgium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Bohrium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Hassium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Meitnerium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Roentgenium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Copernicium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Nihonium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Flerovium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Moscovium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Livermorium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Tennessine.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Francium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Astatine.setProperty(PropertyKey.DUST, new DustProperty());
        // GTMaterials.Oganesson.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Oganesson.setProperty(PropertyKey.WOOD, new WoodProperty());

        GTMaterials.Niobium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Dysprosium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Holmium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Praseodymium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Europium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Gadolinium.setProperty(PropertyKey.ORE, new OreProperty());
    }

    public static void modifyMaterials() {}
}
