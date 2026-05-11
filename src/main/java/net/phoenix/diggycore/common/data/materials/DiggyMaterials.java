package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IngotProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.phoenix.diggycore.DiggyCore;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Dysprosium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Iron;

public class DiggyMaterials {
    public static Material BELUSOVIUM;

    public static void register() {

        BELUSOVIUM = new Material.Builder(DiggyCore.id("belusovium"))
                .ingot()
                .color(0xe8275b)
                .secondaryColor(0xed7474)
                .iconSet(MaterialIconSet.RADIOACTIVE)
                .formula("Bv")
                .buildAndRegister();
    }

    public static void modifyMaterials() {
        Iron.addFlags(DiggyMaterialFlags.GENERATE_NANITES);
        Dysprosium.addFlags(DiggyMaterialFlags.GENERATE_NANITES);
    }
}
