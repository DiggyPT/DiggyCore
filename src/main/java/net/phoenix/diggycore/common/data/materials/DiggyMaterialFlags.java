package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_DENSE;

public class DiggyMaterialFlags {

    public static final MaterialFlag GENERATE_VIAL = new MaterialFlag.Builder("generate_vial")
            .requireFlags(GENERATE_DENSE).requireProps(PropertyKey.DUST).build();

    public static final TagPrefix vial = new TagPrefix("vial")
            .idPattern("%s_vial")
            .defaultTagPath("vial/%s")
            .unformattedTagPath("vial")
            .langValue("%s Vial")
            .materialAmount(GTValues.M / 4)
            .unificationEnabled(true)
            .generateItem(true)
            .materialIconType(DiggyMaterialSet.vial)
            .generationCondition(mat -> mat.hasFlag(DiggyMaterialFlags.GENERATE_VIAL));

    public static void init() {}
}
