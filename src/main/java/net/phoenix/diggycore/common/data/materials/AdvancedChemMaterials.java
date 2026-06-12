package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import net.phoenix.diggycore.DiggyCore;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class AdvancedChemMaterials {

    public static Material UPSILON;
    public static Material BROAD_OMEGA_MATTER;
    public static Material BROAD_OMEGA_FUEL;
    public static Material FRA_CODED_MATTER;

    public static void register() {
        UPSILON = new Material.Builder(DiggyCore.id("upsilon"))
                .liquid(0)
                .langValue("Upsilon Fluid")
                .color(0x03fcbe)
                .flags(DISABLE_DECOMPOSITION)
                .formula("Υ")
                .buildAndRegister();

        FRA_CODED_MATTER = new Material.Builder(DiggyCore.id("fra_coded_matter"))
                .liquid(0)
                .langValue("§gFRA Coded Matter")
                .color(0x40ab22)
                .flags(DISABLE_DECOMPOSITION)
                .formula("§kabcdef")
                .buildAndRegister();
    }
}
