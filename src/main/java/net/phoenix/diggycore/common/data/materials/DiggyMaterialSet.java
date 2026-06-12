package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;

public class DiggyMaterialSet {

    public static final MaterialIconType vial = new MaterialIconType("vial");
    public static final MaterialIconType bee = new MaterialIconType("bee");
    public static final MaterialIconType comb = new MaterialIconType("comb");

    public static final MaterialIconSet MARINE = new MaterialIconSet("marine", METALLIC);
    public static final MaterialIconSet HEAVY_DUTY = new MaterialIconSet("heavy_duty", MARINE);

    public static void init() {}
}
