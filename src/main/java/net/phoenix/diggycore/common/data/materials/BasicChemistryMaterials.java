package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import net.phoenix.diggycore.DiggyCore;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class BasicChemistryMaterials {

    public static Material DYSPROSIUM_CATION;
    public static Material DYSPROSIUM_TRIFLUORIDE;
    public static Material DYSPROSIUM_TRICHLORIDE;
    public static Material CALCIUM_FLUORIDE;
    public static Material HYDRAZINE;

    public static void register() {
        DYSPROSIUM_CATION = new Material.Builder(DiggyCore.id("dysprosium_cation"))
                .dust()
                .langValue("Dysprosium Cation")
                .color(0x609147)
                .flags(DISABLE_DECOMPOSITION)
                .formula("Dy⁺")
                .buildAndRegister();

        DYSPROSIUM_TRIFLUORIDE = new Material.Builder(DiggyCore.id("dysprosium_trifluoride"))
                .dust()
                .langValue("Dysprosium Trifluoride")
                .color(0xf7f7ed).iconSet(MaterialIconSet.SAND)
                .flags(DISABLE_DECOMPOSITION)
                .components(Dysprosium, 1, Fluorine, 3)
                .buildAndRegister();

        DYSPROSIUM_TRICHLORIDE = new Material.Builder(DiggyCore.id("dysprosium_trichloride"))
                .dust()
                .langValue("Dysprosium Trichloride")
                .color(0xffffd6).iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Dysprosium, 1, Chlorine, 3)
                .buildAndRegister();

        CALCIUM_FLUORIDE = new Material.Builder(DiggyCore.id("calcium_fluoride"))
                .dust()
                .langValue("Calcium Fluoride")
                .color(0xc7c1ab).iconSet(MaterialIconSet.FINE)
                .components(Calcium, 1, Fluorine, 2)
                .buildAndRegister();

        HYDRAZINE = new Material.Builder(DiggyCore.id("hydrazine"))
                .liquid()
                .langValue("Hydrazine")
                .color(0xFC472F).iconSet(MaterialIconSet.FLUID)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 4)
                .buildAndRegister();
    }
}
