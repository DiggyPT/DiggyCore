package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;

import net.phoenix.diggycore.DiggyCore;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class BasicChemistryMaterials {

    public static Material CALCIUM_FLUORIDE;
    public static Material HYDRAZINE;
    public static Material AEROZINE;
    public static Material CHANGESITE;
    public static Material MOON_GANGUE;
    public static Material AMMONIUM_BIFLUORIDE;
    public static Material AMMONIUM_FLUORIDE;
    public static Material THORTVEITITE;
    public static Material SCANDIUM_FLUORIDE;
    public static Material HYDROGEN_FLUORIDE;

    public static void register() {
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

        AEROZINE = new Material.Builder(DiggyCore.id("aerozine"))
                .liquid(new FluidBuilder().customStill())
                .langValue("Aerozine 50")
                .color(0xFF9170).iconSet(MaterialIconSet.FLUID)
                .flags(DISABLE_DECOMPOSITION)
                .components(HYDRAZINE, 1, Dimethylhydrazine, 1)
                .buildAndRegister();

        CHANGESITE = new Material.Builder(DiggyCore.id("changesite"))
                .ore()
                .langValue("Changesite-(Y)")
                .color(0xA472AD).iconSet(MaterialIconSet.FINE)
                .formula("(Ca₈Y)□Fe²⁺(PO₄)₇")
                .buildAndRegister();

        MOON_GANGUE = new Material.Builder(DiggyCore.id("moon_gangue"))
                .dust()
                .langValue("Moon Gangue")
                .color(0x828282).iconSet(MaterialIconSet.ROUGH)
                .buildAndRegister();

        AMMONIUM_BIFLUORIDE = new Material.Builder(DiggyCore.id("ammonium_bifluoride"))
                .liquid()
                .langValue("Ammonium Bifluoride")
                .color(0xA672FF).iconSet(MaterialIconSet.FLUID)
                .formula("[NH₄][HF₂]")
                .buildAndRegister();

        AMMONIUM_FLUORIDE = new Material.Builder(DiggyCore.id("ammonium_fluoride"))
                .liquid()
                .langValue("Ammonium Fluoride")
                .color(0x611C96).iconSet(MaterialIconSet.FLUID)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Hydrogen, 4, Fluorine, 1)
                .buildAndRegister();

        THORTVEITITE = new Material.Builder(DiggyCore.id("thortveitite"))
                .ore()
                .langValue("Thortveitite")
                .color(0xB7AE49).iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .formula("(Sc,Y)₂Si₂O₇")
                .buildAndRegister();

        SCANDIUM_FLUORIDE = new Material.Builder(DiggyCore.id("scandium_fluoride"))
                .dust()
                .langValue("Scandium Fluoride")
                .color(0xE5979C).iconSet(MaterialIconSet.DULL)
                .components(Scandium, 1, Fluorine, 3)
                .buildAndRegister();

        HYDROGEN_FLUORIDE = new Material.Builder(DiggyCore.id("hydrogen_fluoride"))
                .liquid()
                .langValue("Hydrogen Fluoride")
                .color(0x2FC62F).iconSet(MaterialIconSet.FLUID)
                .components(Hydrogen, 1, Fluorine, 3)
                .buildAndRegister();
    }
}
