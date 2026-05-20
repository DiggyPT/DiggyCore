package net.phoenix.diggycore.common.item;

import static com.gregtechceu.gtceu.common.data.GTItems.*;

public class DiggyItems {

    public static void init() {}
    /*
     * public static ItemEntry<Item> TIER_2_HV_BATTERY_HULL = REGISTRATE.item("tier_2_hv_battery_hull", Item::new)
     * .lang("Small Tier II Battery Hull")
     * .onRegister(materialInfo(new ItemMaterialInfo(new MaterialStack(GTMaterials.BatteryAlloy, GTValues.M * 9))))
     * .register();
     * 
     * public static ItemEntry<ComponentItem> ATP_BATTERY_HV = REGISTRATE
     * .item("atp_battery_hv", ComponentItem::create)
     * .lang("Small ATP Battery")
     * .model((ctx, prov) -> prov.generated(ctx))
     * .onRegister(modelPredicate(GTCEu.id("battery"), ElectricStats::getStoredPredicate))
     * .onRegister(attach(ElectricStats.createRechargeableBattery(250_000_000L, GTValues.HV)))
     * .tag(CustomTags.HV_BATTERIES).register();
     */
}
