package net.phoenix.diggycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

public class DiggyElements {

    // Periodic elements. (Integer atomic number)
    public static Element FEYNMANIUM;
    public static Element ARMSTRONGIUM;
    public static Element HAWKINE;
    public static Element KEPLERUM;
    public static Element BELUSOVIUM;
    public static Element SONYA;
    public static Element UNIFON;
    public static Element BOHEMIUM;
    public static Element LUSITANIUM;
    public static Element MAGRABIYAH;
    public static Element NICOSIUM;

    // Non-periodic elements. (Non-integer atomic number)
    public static Element CUANDAY;
    public static Element CUANDAY_QUAY;
    public static Element PHOENICIUM;
    public static Element CENTAURIUM;
    public static Element DESH;
    public static Element OSTRUM;

    public static void init() {
        // Neutron amount: n = 0.12522539p^2 - 29.278236p + 1887.26392
        FEYNMANIUM = create("feynmanium", 173L, 570L, -1L, null, "Feynmanium", "Fn", false);
        ARMSTRONGIUM = create("armstrongium", 121L, 178L, -1L, null, "Armstrongium", "Ao", false);
        HAWKINE = create("hawkine", 122L, 179L, -1L, null, "Hawkine", "Hw", false);
        KEPLERUM = create("keplerum", 123L, 181L, -1L, null, "Keplerum", "Kp", false);
        BELUSOVIUM = create("belusovium", 124L, 182L, -1L, null, "Belusovium", "Bv", false);
        SONYA = create("sonya", 136L, -1L, null, "Sonya", "Sy", false);
        UNIFON = create("unifon", 137L, -1L, null, "Unifon", "Uf", false);
        BOHEMIUM = create("bohemium", 138L, -1L, null, "Bohemium", "Bh", false);
        LUSITANIUM = create("lusitanium", 139L, -1L, null, "Lusitanium", "L", false);
        MAGRABIYAH = create("magrabiyah", 140L, -1L, null, "Magrabiyah", "Ma", false);
        NICOSIUM = create("nicosium", 141L, -1L, null, "Nicosium", "Ns", false);

        CUANDAY = create("cuanday", 23L, 26L, -1L, null, "Cuanday", "Cn", false);
        CUANDAY_QUAY = create("cuanday_quay", 24L, 29L, -1L, null, "Cuanday Quay", "Cq", false);

        PHOENICIUM = create("phoenicium", 32L, -1L, null, "Phoenicium", "Φ", false);
        CENTAURIUM = create("centaurium", 33L, -1L, null, "Centaurium", "Cχ", false);
        DESH = create("desh", 34L, -1L, null, "Desh", "Dδ", false);
        OSTRUM = create("ostrum", 62L, -1L, null, "Desh", "Ωs", false);
    }

    private static Element create(String name, long protons, long neutrons, String symbol) {
        return create(name, protons, neutrons, -1L, (String) null, name, symbol, false);
    }

    private static Element create(String name, long protons, String symbol) {
        return create(name, protons, protonsToNeutrons(protons), -1L, (String) null, name, symbol, false);
    }

    private static Element create(String id, long protons, long neutrons, long halfLife, String decayTo, String name,
                                  String symbol, boolean isIsotope) {
        Element element = new Element(protons, neutrons, halfLife, decayTo, name, symbol, isIsotope);
        GTRegistries.ELEMENTS.register(id, element);
        return element;
    }

    private static Element create(String id, long protons, long halfLife, String decayTo, String name,
                                  String symbol, boolean isIsotope) {
        Element element = new Element(protons, protonsToNeutrons(protons), halfLife, decayTo, name, symbol, isIsotope);
        GTRegistries.ELEMENTS.register(id, element);
        return element;
    }

    private static long protonsToNeutrons(long protons) {
        return (long) Math.floor(0.12522539 * (protons ^ 2) - 29.278236 * (protons) + 1887.26392); // this is the output
                                                                                                   // of a linear
                                                                                                   // regression
    }
}
