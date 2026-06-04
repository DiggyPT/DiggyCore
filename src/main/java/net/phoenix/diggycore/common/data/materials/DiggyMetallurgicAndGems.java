package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import net.phoenix.diggycore.DiggyCore;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.phoenix.diggycore.common.data.materials.DiggyNewElementsAndAddFlags.*;

public class DiggyMetallurgicAndGems {

    //Overworld ores.
    public static Material COVELLITE;
    public static Material ENARGITE;

    //Moon ores.
    public static Material METEORIC_IRON;
    public static Material LUNAR_SAPPHIRE;
    public static Material DESH;

    //Mars ores.
    public static Material OSTRUM;
    public static Material SEA_CRYSTAL;
    public static Material FOSSIL_RECENT;
    public static Material FOSSIL_OLD;
    public static Material FOSSIL_ANCIENT;

    //Venus ores.
    public static Material PHOENICIUM;
    public static Material CALORITE;

    //Proxima ores.
    public static Material ISAACMANITE;
    public static Material GUNNERITE;
    public static Material CENTAURITE;

    public static void register() {
        ISAACMANITE = new Material.Builder(DiggyCore.id("isaacmanite"))
                .gem(3).ore(3, 1)
                .color(0x41f2a6)
                .secondaryColor(0x2799b0)
                .iconSet(MaterialIconSet.OPAL)
                .components(Thulium, 5, Holmium, 7, Oxygen, 4, BOHEMIUM, 15)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        GUNNERITE = new Material.Builder(DiggyCore.id("gunnerite"))
                .gem(3).ore(3, 1)
                .color(0xe81ec6)
                .secondaryColor(0xaa1dd1)
                .iconSet(MaterialIconSet.EMERALD)
                .components(Gadolinium, 5, Boron, 7, Hydrogen, 4, HAWKINE , 15)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        COVELLITE = new Material.Builder(DiggyCore.id("covellite"))
                .ore()
                .color(0x4673a0)
                .iconSet(MaterialIconSet.FINE)
                .components(Copper, 1, Sulfur, 1)
                .buildAndRegister();

        ENARGITE = new Material.Builder(DiggyCore.id("enargite"))
                .ore()
                .color(0xc2b9a8)
                .iconSet(MaterialIconSet.FINE)
                .components(Copper, 3, Arsenic, 1, Sulfur, 4)
                .buildAndRegister();
    }
}
