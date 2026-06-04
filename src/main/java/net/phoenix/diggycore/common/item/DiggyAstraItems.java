package net.phoenix.diggycore.common.item;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.adastra.common.items.vehicles.RocketItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.phoenix.diggycore.DiggyCore;

import java.util.function.Supplier;

/*public class DiggyAstraItems {
    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(BuiltInRegistries.ITEM, DiggyCore.MOD_ID);
    public static final ResourcefulRegistry<Item> BASIC_ITEMS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> VEHICLES = ResourcefulRegistries.create(ITEMS);
    // Rockets
    public static final RegistryEntry<Item> TIER_5_ROCKET = registerRocket(5, DiggyEntityTypes.TIER_5_ROCKET::get);
    public static final RegistryEntry<Item> TIER_6_ROCKET = registerRocket(6, DiggyEntityTypes.TIER_6_ROCKET::get);
    public static final RegistryEntry<Item> TIER_7_ROCKET = registerRocket(7, DiggyEntityTypes.TIER_7_ROCKET::get);
    public static final RegistryEntry<Item> TIER_8_ROCKET = registerRocket(8, DiggyEntityTypes.TIER_8_ROCKET::get);
    public static final RegistryEntry<Item> TIER_9_ROCKET = registerRocket(9, DiggyEntityTypes.TIER_9_ROCKET::get);
    public static final RegistryEntry<Item> TIER_10_ROCKET = registerRocket(10, DiggyEntityTypes.TIER_10_ROCKET::get);
    public static final RegistryEntry<Item> TIER_11_ROCKET = registerRocket(11, DiggyEntityTypes.TIER_11_ROCKET::get);
    public static final RegistryEntry<Item> TIER_12_ROCKET = registerRocket(12, DiggyEntityTypes.TIER_12_ROCKET::get);

    private static RegistryEntry<Item> registerBasicItem(String name) {
        return BASIC_ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    private static RegistryEntry<Item> registerRocket(int tier, Supplier<EntityType<?>> entity) {
        return VEHICLES.register("tier_" + tier + "_rocket", () -> new RocketItem(entity, new Item.Properties().stacksTo(1).fireResistant()));
    }
}
*/