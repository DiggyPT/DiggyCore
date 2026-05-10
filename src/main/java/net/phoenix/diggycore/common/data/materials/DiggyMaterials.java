package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IngotProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.phoenix.diggycore.DiggyCore;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Dysprosium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Iron;

public class DiggyMaterials {
    public static Material QuantumCoolant;
    public static Material ExtremelyModifiedSpaceGradeSteel;
    public static Material EightyFivePercentPureNevvonianSteel;
    public static Material PHOENIX_ENRICHED_TRITANIUM;
    public static Material PHOENIX_ENRICHED_NAQUADAH;

    public static void register() {
        QuantumCoolant = new Material.Builder(DiggyCore.resourceLocation("quantum_coolant"))
                .ingot()
                .color(0xfd8151)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
    }

    public static void modifyMaterials() {
        Iron.addFlags(DiggyMaterialFlags.GENERATE_NANITES);
        Dysprosium.addFlags(DiggyMaterialFlags.GENERATE_NANITES);
    }
}
