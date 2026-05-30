package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_DENSE;

public class DiggyMaterialFlags {

    public static final MaterialFlag GENERATE_VIAL = new MaterialFlag.Builder("generate_vial")
            .requireFlags(GENERATE_DENSE).requireProps(PropertyKey.DUST).build();
    public static final MaterialFlag GENERATE_DOUBLE_INGOT = new MaterialFlag.Builder("generate_double_ingot")
            .requireProps(PropertyKey.INGOT).build();
    public static final MaterialFlag GENERATE_BEE_COMB = new MaterialFlag.Builder("generate_bee_comb")
            .requireProps(PropertyKey.DUST).build();

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

    public static final TagPrefix double_ingot = new TagPrefix("double_ingot")
            .idPattern("%s_double_ingot")
            .defaultTagPath("double_ingot/%s")
            .unformattedTagPath("double_ingot")
            .langValue("Double %s Ingot")
            .materialAmount(GTValues.M * 2)
            .unificationEnabled(true)
            .generateItem(true)
            .materialIconType(MaterialIconType.ingotDouble)
            .generationCondition(mat -> mat.hasFlag(DiggyMaterialFlags.GENERATE_DOUBLE_INGOT));

    public static final TagPrefix bee = new TagPrefix("bee")
            .idPattern("%s_bee")
            .defaultTagPath("bee/%s")
            .unformattedTagPath("bee")
            .langValue("%s Bee")
            .materialAmount(GTValues.M * 2)
            .unificationEnabled(true)
            .generateItem(true)
            .materialIconType(DiggyMaterialSet.bee)
            .generationCondition(mat -> mat.hasFlag(DiggyMaterialFlags.GENERATE_BEE_COMB));

    public static final TagPrefix comb = new TagPrefix("comb")
            .idPattern("%s_comb")
            .defaultTagPath("comb/%s")
            .unformattedTagPath("comb")
            .langValue("%s Comb")
            .materialAmount(GTValues.M)
            .unificationEnabled(true)
            .generateItem(true)
            .materialIconType(DiggyMaterialSet.comb)
            .generationCondition(mat -> mat.hasFlag(DiggyMaterialFlags.GENERATE_BEE_COMB));

    public static void init() {}
}
