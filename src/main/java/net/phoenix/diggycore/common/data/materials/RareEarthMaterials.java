package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;

import net.phoenix.diggycore.DiggyCore;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class RareEarthMaterials {

    public static Material MUDDY_MONAZITE_SOLUTION;
    public static Material MONAZITE_SOLUTION;
    public static Material THORIUM_DIOXIDE;
    public static Material ZIRCON;
    public static Material MONAZITE_SULFATE;
    public static Material MONAZITE_SULFATE_SOLUTION;
    public static Material AMMONIA_SOLUTION;
    public static Material NEUTRALISED_MONAZITE_SULFATE_SOLUTION;
    public static Material THORIUM_PHOSPHATE;
    public static Material RARE_EARTH_FILTRATE;
    public static Material NEUTRALISED_RARE_EARTH_FILTRATE;
    public static Material URANIUM_FILTRATE;
    public static Material NEUTRALISED_URANIUM_FILTRATE;
    public static Material RARE_EARTH_HYDROXIDE_CONCENTRATE;
    public static Material RARE_EARTH_SALT;

    // hydrocarbons
    public static Material I_BUTANAL;
    public static Material ISOBUTANOL;
    public static Material N_BUTANOL;
    public static Material PHOSPHORYL_CHLORIDE;
    public static Material PHOSPHORUS_TRICHLORIDE;
    public static Material KEROSENE;
    public static Material TRIBUTYL_PHOSPHATE;

    // rare earths groups
    public static Material LIGHT_RARE_EARTHS;
    public static Material MIDDLE_RARE_EARTHS;
    public static Material HEAVY_RARE_EARTHS;

    // precipitates
    public static Material LANTHANUM_PRECIPITATE;
    public static Material CERIUM_PRECIPITATE;
    public static Material PRASEODYMIUM_PRECIPITATE;
    public static Material NEODYMIUM_PRECIPITATE;
    public static Material SAMARIUM_PRECIPITATE;
    public static Material EUROPIUM_PRECIPITATE;
    public static Material GADOLINIUM_PRECIPITATE;
    public static Material TERBIUM_PRECIPITATE;
    public static Material DYSPROSIUM_PRECIPITATE;
    public static Material HOLMIUM_PRECIPITATE;
    public static Material ERBIUM_PRECIPITATE;
    public static Material THULIUM_PRECIPITATE;
    public static Material YTTERBIUM_PRECIPITATE;
    public static Material LUTETIUM_PRECIPITATE;

    // oxides
    public static Material LANTHANUM_OXIDE;
    public static Material CERIUM_OXIDE;
    public static Material PRASEODYMIUM_OXIDE;
    public static Material NEODYMIUM_OXIDE;
    public static Material SAMARIUM_OXIDE;
    public static Material EUROPIUM_OXIDE;
    public static Material GADOLINIUM_OXIDE;
    public static Material TERBIUM_OXIDE;
    public static Material DYSPROSIUM_OXIDE;
    public static Material HOLMIUM_OXIDE;
    public static Material ERBIUM_OXIDE;
    public static Material THULIUM_OXIDE;
    public static Material YTTERBIUM_OXIDE;
    public static Material LUTETIUM_OXIDE;

    public static void register() {
        MUDDY_MONAZITE_SOLUTION = new Material.Builder(DiggyCore.id("muddy_monazite_solution"))
                .liquid(new FluidBuilder().customStill())
                .langValue("Muddy Monazite Solution")
                .buildAndRegister();

        MONAZITE_SOLUTION = new Material.Builder(DiggyCore.id("monazite_solution"))
                .liquid(new FluidBuilder().customStill())
                .langValue("Monazite Solution")
                .buildAndRegister();

        THORIUM_DIOXIDE = new Material.Builder(DiggyCore.id("thorium_dioxide"))
                .dust()
                .langValue("Thorium Dioxide")
                .colorAverage().iconSet(MaterialIconSet.ROUGH)
                .components(Thorium, 1, Oxygen, 2)
                .buildAndRegister();

        ZIRCON = new Material.Builder(DiggyCore.id("zircon"))
                .gem()
                .langValue("Zircon")
                .color(0xB0402A).iconSet(MaterialIconSet.EMERALD)
                .components(Zirconium, 1, Silicon, 1, Oxygen, 4)
                .buildAndRegister();

        MONAZITE_SULFATE = new Material.Builder(DiggyCore.id("monazite_sulfate"))
                .dust()
                .langValue("Monazite Sulfate")
                .colorAverage().iconSet(MaterialIconSet.QUARTZ)
                .components(Monazite, 1, Sulfur, 1, Oxygen, 4)
                .buildAndRegister();

        MONAZITE_SULFATE_SOLUTION = new Material.Builder(DiggyCore.id("monazite_sulfate_solution"))
                .liquid(new FluidBuilder().customStill())
                .langValue("Monazite Sulfate Solution")
                .components(MONAZITE_SULFATE, 2, Water, 13)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        AMMONIA_SOLUTION = new Material.Builder(DiggyCore.id("ammonia_solution"))
                .liquid(new FluidBuilder().customStill())
                .langValue("Ammonia Solution")
                .components(Ammonia, 1, Water, 1)
                .buildAndRegister();

        NEUTRALISED_MONAZITE_SULFATE_SOLUTION = new Material.Builder(
                DiggyCore.id("neutralised_monazite_sulfate_solution"))
                .liquid(new FluidBuilder().customStill())
                .langValue("Neutralised Monazite Sulfate Solution")
                // .components(MONAZITE_SULFATE_SOLUTION)
                .buildAndRegister();

        THORIUM_PHOSPHATE = new Material.Builder(DiggyCore.id("thorium_phosphate"))
                .dust()
                .langValue("Thorium Phosphate")
                .colorAverage().iconSet(MaterialIconSet.DULL)
                .components(Thorium, 1, Phosphate, 1)
                .buildAndRegister();

        RARE_EARTH_FILTRATE = new Material.Builder(DiggyCore.id("rare_earth_filtrate"))
                .dust()
                .langValue("Rare Earth Filtrate")
                .color(0xFF9082).iconSet(MaterialIconSet.SHINY)
                .buildAndRegister();

        NEUTRALISED_RARE_EARTH_FILTRATE = new Material.Builder(DiggyCore.id("neutralised_rare_earth_filtrate"))
                .dust()
                .langValue("Neutralised Rare Earth Filtrate")
                .color(0xFF7079).iconSet(MaterialIconSet.DULL)
                .buildAndRegister();

        RARE_EARTH_HYDROXIDE_CONCENTRATE = new Material.Builder(DiggyCore.id("rare_earth_hydroxide_concentrate"))
                .dust()
                .langValue("Rare Earth Hydroxide Concentrate")
                .color(0xE54061).iconSet(MaterialIconSet.ROUGH)
                .formula("RE(OH)3")
                .buildAndRegister();

        RARE_EARTH_SALT = new Material.Builder(DiggyCore.id("rare_earth_salt"))
                .dust()
                .langValue("Rare Earth Salt")
                .color(0xAF034E).iconSet(MaterialIconSet.SAND)
                .formula("RE2(SO4)3")
                .buildAndRegister();

        URANIUM_FILTRATE = new Material.Builder(DiggyCore.id("uranium_filtrate"))
                .dust()
                .langValue("Uranium Filtrate")
                .color(0x7C8718).iconSet(MaterialIconSet.SHINY)
                .formula("U???")
                .buildAndRegister();

        NEUTRALISED_URANIUM_FILTRATE = new Material.Builder(DiggyCore.id("neutralised_uranium_filtrate"))
                .dust()
                .langValue("Neutralised Uranium Filtrate")
                .color(0x178460).iconSet(MaterialIconSet.DULL)
                .formula("U???")
                .buildAndRegister();

        I_BUTANAL = new Material.Builder(DiggyCore.id("i_butanal"))
                .liquid(new FluidBuilder().customStill())
                .langValue("Isobutyraldehyde")
                .formula("C4H8O")
                .buildAndRegister();

        ISOBUTANOL = new Material.Builder(DiggyCore.id("isobutanol"))
                .liquid(new FluidBuilder().customStill())
                .langValue("Isobutanol")
                .formula("C4H10O")
                .buildAndRegister();

        N_BUTANOL = new Material.Builder(DiggyCore.id("n_butanol"))
                .liquid(new FluidBuilder().customStill())
                .langValue("Butanol")
                .formula("C4H10O")
                .buildAndRegister();

        KEROSENE = new Material.Builder(DiggyCore.id("kerosene"))
                .liquid(new FluidBuilder().customStill())
                .langValue("Kerosene")
                .buildAndRegister();

        PHOSPHORUS_TRICHLORIDE = new Material.Builder(DiggyCore.id("phosphorus_trichloride"))
                .liquid(new FluidBuilder().customStill())
                .langValue("Phosphorus Trichloride")
                .components(Phosphorus, 1, Chlorine, 3)
                .buildAndRegister();

        PHOSPHORYL_CHLORIDE = new Material.Builder(DiggyCore.id("phosphoryl_chloride"))
                .liquid(new FluidBuilder().customStill())
                .langValue("Phosphoryl Chloride")
                .components(Phosphorus, 1, Oxygen, 1, Chlorine, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        TRIBUTYL_PHOSPHATE = new Material.Builder(DiggyCore.id("tributyl_phosphate"))
                .liquid(new FluidBuilder().customStill())
                .langValue("Tributyl Phosphate")
                .components(Carbon, 12, Hydrogen, 27, Oxygen, 4, Phosphorus, 1)
                .buildAndRegister();

        LIGHT_RARE_EARTHS = new Material.Builder(DiggyCore.id("light_rare_earths"))
                .dust()
                .color(0xFFDB66).iconSet(MaterialIconSet.SHINY)
                .langValue("Light Rare Earth")
                .components(Lanthanum, 1, Cerium, 1, Praseodymium, 1, Neodymium, 1)
                .buildAndRegister();

        MIDDLE_RARE_EARTHS = new Material.Builder(DiggyCore.id("middle_rare_earths"))
                .dust()
                .color(0xE09341).iconSet(MaterialIconSet.SHINY)
                .langValue("Middle Rare Earth")
                .components(Samarium, 1, Europium, 1, Gadolinium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        HEAVY_RARE_EARTHS = new Material.Builder(DiggyCore.id("heavy_rare_earths"))
                .dust()
                .color(0xE05C1A).iconSet(MaterialIconSet.SHINY)
                .langValue("Heavy Rare Earth")
                .components(Terbium, 1, Dysprosium, 1, Holmium, 1, Erbium, 1, Thulium, 1, Ytterbium, 1, Lutetium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        LANTHANUM_PRECIPITATE = makePrecipitate(Lanthanum).buildAndRegister();
        CERIUM_PRECIPITATE = makePrecipitate(Cerium).buildAndRegister();
        PRASEODYMIUM_PRECIPITATE = makePrecipitate(Praseodymium).buildAndRegister();
        NEODYMIUM_PRECIPITATE = makePrecipitate(Neodymium).buildAndRegister();
        SAMARIUM_PRECIPITATE = makePrecipitate(Samarium).buildAndRegister();
        EUROPIUM_PRECIPITATE = makePrecipitate(Europium).buildAndRegister();
        GADOLINIUM_PRECIPITATE = makePrecipitate(Gadolinium).buildAndRegister();
        TERBIUM_PRECIPITATE = makePrecipitate(Terbium).buildAndRegister();
        DYSPROSIUM_PRECIPITATE = makePrecipitate(Dysprosium).buildAndRegister();
        HOLMIUM_PRECIPITATE = makePrecipitate(Holmium).buildAndRegister();
        ERBIUM_PRECIPITATE = makePrecipitate(Erbium).buildAndRegister();
        THULIUM_PRECIPITATE = makePrecipitate(Thulium).buildAndRegister();
        YTTERBIUM_PRECIPITATE = makePrecipitate(Ytterbium).buildAndRegister();
        LUTETIUM_PRECIPITATE = makePrecipitate(Lutetium).buildAndRegister();

        LANTHANUM_OXIDE = makeOxide(Lanthanum).buildAndRegister();
        CERIUM_OXIDE = makeOxide(Cerium).buildAndRegister();
        PRASEODYMIUM_OXIDE = makeOxide(Praseodymium).buildAndRegister();
        NEODYMIUM_OXIDE = makeOxide(Neodymium).buildAndRegister();
        SAMARIUM_OXIDE = makeOxide(Samarium).buildAndRegister();
        EUROPIUM_OXIDE = makeOxide(Europium).buildAndRegister();
        GADOLINIUM_OXIDE = makeOxide(Gadolinium).buildAndRegister();
        TERBIUM_OXIDE = makeOxide(Terbium).buildAndRegister();
        DYSPROSIUM_OXIDE = makeOxide(Dysprosium).buildAndRegister();
        HOLMIUM_OXIDE = makeOxide(Holmium).buildAndRegister();
        ERBIUM_OXIDE = makeOxide(Erbium).buildAndRegister();
        THULIUM_OXIDE = makeOxide(Thulium).buildAndRegister();
        YTTERBIUM_OXIDE = makeOxide(Ytterbium).buildAndRegister();
        LUTETIUM_OXIDE = makeOxide(Lutetium).buildAndRegister();
    }

    public static Material.Builder makePrecipitate(Material element) {
        // makes a precipitate out of the element
        return new Material.Builder(DiggyCore.id(element.getName().toLowerCase() + "_precipitate"))
                .dust()
                .colorAverage().iconSet(MaterialIconSet.FINE)
                .langValue(capitalise(element.getName()) + " Precipitate")
                .components(element, 1)
                .formula(element.getChemicalFormula() + "2(C2O4)3")
                .flags(DISABLE_DECOMPOSITION);
    }

    public static Material.Builder makeOxide(Material element) {
        // makes an oxide out of the element
        return new Material.Builder(DiggyCore.id(element.getName().toLowerCase() + "_oxide"))
                .dust()
                .colorAverage().iconSet(MaterialIconSet.DULL)
                .langValue(capitalise(element.getName()) + " Oxide")
                .components(element, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION);
    }

    public static String capitalise(String string) {
        String firstLetter = string.substring(0, 1);
        String restOfWord = string.substring(1);
        return firstLetter.toUpperCase() + restOfWord; // just capitalises a word
    }
}
