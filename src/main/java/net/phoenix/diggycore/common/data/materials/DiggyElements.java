package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

public class DiggyElements {

    public static Element FEYNMANIUM;
    public static Element ARMSTRONGIUM;
    public static Element HAWKINE;
    public static Element KEPLERUM;
    public static Element BELUSOVIUM;
    public static Element SONYA;
    public static Element UNIFON;
    public static Element BOHEMIUM;

    public static void init() {
        FEYNMANIUM = create("feynmanium", 173L, 570L, -1L, null, "Feynmanium", "Fn", false);
        ARMSTRONGIUM = create("armstrongium", 121L, 178L, -1L, null, "Armstrongium", "Ao", false);
        HAWKINE = create("hawkine", 122L, 179L, -1L, null, "Hawkine", "Hw", false);
        KEPLERUM = create("keplerum", 123L, 181L, -1L, null, "Keplerum", "Kp", false);
        BELUSOVIUM = create("belusovium", 124L, 182L, -1L, null, "Belusovium", "Bv", false);
    }

    private static Element create(String name, long protons, long neutrons, String symbol) {
        return create(name, protons, neutrons, -1L, (String) null, name, symbol, false);
    }

    private static Element create(String id, long protons, long neutrons, long halfLife, String decayTo, String name,
                                  String symbol, boolean isIsotope) {
        Element element = new Element(protons, neutrons, halfLife, decayTo, name, symbol, isIsotope);
        GTRegistries.ELEMENTS.register(id, element);
        return element;
    }
}
