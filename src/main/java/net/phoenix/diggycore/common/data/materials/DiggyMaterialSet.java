package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.SHINY;

public class DiggyMaterialSet {
    public static final MaterialIconType nanites = new MaterialIconType("nanites");
    public static final MaterialIconSet DIDDYBLUD = new MaterialIconSet("diddyblud",
            SHINY);

    public static void init() {}
}
