package net.phoenix.diggycore.common.item;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.common.registry.GTRegistration;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static net.phoenix.diggycore.common.registry.DiggyRegistration.REGISTRATE;

public class DiggyItems {

    public static void init() {}

    /*
     * public static ItemEntry<Item> TIER_2_HV_BATTERY_HULL = REGISTRATE.item("tier_2_hv_battery_hull", Item::new)
     * .lang("Small Tier II Battery Hull")
     * .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/particles/microfractal_loop")))
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

    public static ItemEntry<TooltipItem> registerParticle(String id, String lang, String texture, String mass,
                                                          String charge, String spin, String type) {
        return REGISTRATE
                .item(id, p -> new TooltipItem(p,
                        () -> Component.literal("§cMASS: ").append(mass).append("eV"),
                        () -> Component.literal("§eCHARGE: ").append(charge),
                        () -> Component.literal("§aSPIN: ").append(spin),
                        () -> Component.literal("§9TYPE: ").append(type)))
                .lang("§[" + id + "]" + lang)
                .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/particles/" + texture)))
                .register();
    }

    public static ItemEntry<TooltipItem> registerParticleNoAntiPCC(String id, String lang, String texture, String mass,
                                                                   String charge, String spin, String type) {
        return REGISTRATE
                .item(id, p -> new TooltipItem(p,
                        () -> Component.literal("§cMASS: ").append(mass).append("eV"),
                        () -> Component.literal("§eCHARGE: ").append(charge),
                        () -> Component.literal("§aSPIN: ").append(spin),
                        () -> Component.literal("§9TYPE: ").append(type)))
                .lang(lang)
                .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/particles/" + texture)))
                .register();
    }

    public static ItemEntry<TooltipItem> registerComposite(String id, String lang, String texture, String mass,
                                                                   String charge, String spin, String type, String comp) {
        return REGISTRATE
                .item(id, p -> new TooltipItem(p,
                        () -> Component.literal("§cMASS: ").append(mass).append("eV"),
                        () -> Component.literal("§eCHARGE: ").append(charge),
                        () -> Component.literal("§aSPIN: ").append(spin),
                        () -> Component.literal("§9TYPE: ").append(type),
                        () -> Component.literal("§dCOMPOSITION: ").append(comp)))
                .lang(lang)
                .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/particles/" + texture)))
                .register();
    }

    public static ItemEntry<TooltipItem> registerCompositePCC(String id, String lang, String texture, String mass,
                                                           String charge, String spin, String type, String comp) {
        return REGISTRATE
                .item(id, p -> new TooltipItem(p,
                        () -> Component.literal("§cMASS: ").append(mass).append("eV"),
                        () -> Component.literal("§eCHARGE: ").append(charge),
                        () -> Component.literal("§aSPIN: ").append(spin),
                        () -> Component.literal("§9TYPE: ").append(type),
                        () -> Component.literal("§dCOMPOSITION: ").append(comp)))
                .lang("§[" + id + "]" + lang)
                .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/particles/" + texture)))
                .register();
    }

    public static ItemEntry<TooltipItem> registerAIUnit(String id, String type, String texture) {
        return REGISTRATE
                .item(id, p -> new TooltipItem(p,
                        () -> Component.literal("§7A part of an AI model, specialised in ").append(type).append("§7."),
                        () -> Component.literal(
                                "§7Must be appended to other units of the same type to form a working model.")))
                .lang(type + " §rAI Unit")
                .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ai/" + texture)))
                .register();
    }

    public static ItemEntry<TooltipItem> registerAIModel(String id, String type, String texture) {
        return REGISTRATE
                .item(id, p -> new TooltipItem(p,
                        () -> Component.literal("§7An AI model, specialised in ").append(type).append("§7."),
                        () -> Component.literal("§7Not smart enough to be sentient, hopefully...")))
                .lang(type + " §rAI Model")
                .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ai/" + texture)))
                .register();
    }

    public static ItemEntry<TooltipItem> registerAIModelTooltip(String id, String type, String texture, String tooltip1,
                                                                String tooltip2) {
        return REGISTRATE
                .item(id, p -> new TooltipItem(p,
                        () -> Component.literal(tooltip1).withStyle(ChatFormatting.GRAY),
                        () -> Component.literal(tooltip2).withStyle(ChatFormatting.GRAY)))
                .lang(type + " §rModel")
                .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ai/" + texture)))
                .register();
    }

    public static ItemEntry<TooltipItem> registerAIModelTooltipOU(String id, String type, String texture,
                                                                  String tooltip1, String tooltip2) {
        return REGISTRATE
                .item(id, p -> new TooltipItem(p,
                        () -> Component.literal(tooltip1).withStyle(ChatFormatting.GRAY),
                        () -> Component.literal(tooltip2).withStyle(ChatFormatting.GRAY),
                        () -> Component.literal("SOURCE: Orion's Arm Universe").withStyle(ChatFormatting.DARK_GRAY)))
                .lang(type + " §rModel")
                .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ai/" + texture)))
                .register();
    }

    public static ItemEntry<TooltipItem> registerAIModelTooltipOU(String id, String type, String texture,
                                                                  String tooltip1, String tooltip2, String tooltip3) {
        return REGISTRATE
                .item(id, p -> new TooltipItem(p,
                        () -> Component.literal(tooltip1).withStyle(ChatFormatting.GRAY),
                        () -> Component.literal(tooltip2).withStyle(ChatFormatting.GRAY),
                        () -> Component.literal(tooltip3).withStyle(ChatFormatting.GRAY),
                        () -> Component.literal("SOURCE: Orion's Arm Universe").withStyle(ChatFormatting.DARK_GRAY)))
                .lang(type + " §rModel")
                .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ai/" + texture)))
                .register();
    }

    public static ItemEntry<TooltipItem> UP_QUARK = registerParticle("up_quark", "Up Quark", "up", "2.16 M", "+2/3",
            "1/2", "Quark");
    public static ItemEntry<TooltipItem> DOWN_QUARK = registerParticle("down_quark", "Down Quark", "down", "4.7 M",
            "-1/3", "1/2", "Quark");
    public static ItemEntry<TooltipItem> STRANGE_QUARK = registerParticle("strange_quark", "Strange Quark", "strange",
            "94 M", "-1/3", "1/2", "Quark");
    public static ItemEntry<TooltipItem> CHARM_QUARK = registerParticle("charm_quark", "Charm Quark", "charm", "1.27 G",
            "+2/3", "1/2", "Quark");
    public static ItemEntry<TooltipItem> TOP_QUARK = registerParticle("top_quark", "Top Quark", "top", "173 G", "+2/3",
            "1/2", "Quark");
    public static ItemEntry<TooltipItem> BOTTOM_QUARK = registerParticle("bottom_quark", "Bottom Quark", "bottom",
            "4.18 G", "-1/3", "1/2", "Quark");

    public static ItemEntry<TooltipItem> UP_ANTIQUARK = registerParticle("antiup_quark", "Up Antiquark", "antiup",
            "2.16 M", "-2/3", "1/2", "Antiquark");
    public static ItemEntry<TooltipItem> DOWN_ANTIQUARK = registerParticle("antidown_quark", "Down Antiquark",
            "antidown", "4.7 M", "+1/3", "1/2", "Antiquark");
    public static ItemEntry<TooltipItem> STRANGE_ANTIQUARK = registerParticle("antistrange_quark", "Strange Antiquark",
            "antistrange", "94 M", "+1/3", "1/2", "Antiquark");
    public static ItemEntry<TooltipItem> CHARM_ANTIQUARK = registerParticle("anticharm_quark", "Charm Antiquark",
            "anticharm", "1.27 G", "-2/3", "1/2", "Antiquark");
    public static ItemEntry<TooltipItem> TOP_ANTIQUARK = registerParticle("antitop_quark", "Top Antiquark", "antitop",
            "173 G", "-2/3", "1/2", "Antiquark");
    public static ItemEntry<TooltipItem> BOTTOM_ANTIQUARK = registerParticle("antibottom_quark", "Bottom Antiquark",
            "antibottom", "4.18 G", "+1/3", "1/2", "Antiquark");

    public static ItemEntry<TooltipItem> ELECTRON = registerParticle("electron", "Electron", "electron", "0.511 M",
            "-1", "1/2", "Lepton");
    public static ItemEntry<TooltipItem> MUON = registerParticle("muon", "Muon", "muon", "106 M", "-1", "1/2",
            "Lepton");
    public static ItemEntry<TooltipItem> TAU = registerParticle("tau", "Tau", "tau", "1.78 G", "-1", "1/2", "Lepton");
    public static ItemEntry<TooltipItem> ELECTRON_NEUTRINO = registerParticle("electron_neutrino", "Electron Neutrino",
            "electron_neutrino", "0.8", "0", "1/2", "Neutrino");
    public static ItemEntry<TooltipItem> MUON_NEUTRINO = registerParticle("muon_neutrino", "Muon Neutrino",
            "muon_neutrino", "0.17 M", "0", "1/2", "Neutrino");
    public static ItemEntry<TooltipItem> TAU_NEUTRINO = registerParticle("tau_neutrino", "Tau Neutrino", "tau_neutrino",
            "18.2 M", "0", "1/2", "Neutrino");

    public static ItemEntry<TooltipItem> POSITRON = registerParticle("positron", "Positron", "positron", "0.511 M",
            "+1", "1/2", "Antilepton");
    public static ItemEntry<TooltipItem> ANTIMUON = registerParticle("antimuon", "Antimuon", "antimuon", "106 M", "+1",
            "1/2", "Antilepton");
    public static ItemEntry<TooltipItem> ANTITAU = registerParticle("antitau", "Antitau", "antitau", "1.78 G", "+1",
            "1/2", "Antilepton");
    public static ItemEntry<TooltipItem> ELECTRON_ANTINEUTRINO = registerParticle("electron_antineutrino",
            "Electron Antineutrino", "electron_antineutrino", "0.8 ", "0", "1/2", "Antineutrino");
    public static ItemEntry<TooltipItem> MUON_ANTINEUTRINO = registerParticle("muon_antineutrino", "Muon Antineutrino",
            "muon_antineutrino", "0.17 M", "0", "1/2", "Antineutrino");
    public static ItemEntry<TooltipItem> TAU_ANTINEUTRINO = registerParticle("tau_antineutrino", "Tau Antineutrino",
            "tau_antineutrino", "18.2 M", "0", "1/2", "Antineutrino");

    public static ItemEntry<TooltipItem> GLUON = registerParticle("gluon", "Gluon", "gluon", "0 ", "0", "1",
            "Gauge Boson");
    public static ItemEntry<TooltipItem> PHOTON = registerParticle("photon", "Photon", "photon", "0 ", "0", "1",
            "Gauge Boson");
    public static ItemEntry<TooltipItem> W_PLUS_BOSON = registerParticle("w_plus_boson", "W⁺ Boson", "w_plus_boson",
            "80.4 G", "+1", "1", "Gauge Boson");
    public static ItemEntry<TooltipItem> W_MINUS_BOSON = registerParticle("w_minus_boson", "W⁻ Boson", "w_minus_boson",
            "80.4 G", "-1", "1", "Gauge Boson");
    public static ItemEntry<TooltipItem> Z_BOSON = registerParticle("z_boson", "Z⁰ Boson", "z_boson", "0 ", "0", "1",
            "Gauge Boson");
    public static ItemEntry<TooltipItem> HIGGS_BOSON = registerParticle("higgs_boson", "Higgs Boson", "higgs", "125 G",
            "0", "1", "Scalar Boson");

    //composites
    public static ItemEntry<TooltipItem> PROTON = registerCompositePCC("proton", "Proton", "proton", "938.27 M", "+1",
            "1/2", "Baryon", "uud");
    public static ItemEntry<TooltipItem> NEUTRON = registerCompositePCC("neutron", "Neutron", "neutron", "939.56 M", "0",
            "1/2", "Baryon", "udd");
    public static ItemEntry<TooltipItem> ANTIPROTON = registerCompositePCC("antiproton", "Antiproton", "antiproton",
            "938.27 M", "-1", "1/2", "Antibaryon", "u̅u̅d̅");
    public static ItemEntry<TooltipItem> ANTINEUTRON = registerCompositePCC("antineutron", "Antineutron", "antineutron",
            "939.56 M", "0", "1/2", "Antibaryon", "u̅d̅d̅");
    //Kaons.
    public static ItemEntry<TooltipItem> KAON_ZERO = registerComposite("kaon_zero", "Kaon (K⁰)", "k_zero",
            "497.611±0.013 M", "0", "0", "Meson", "ds̅");
    public static ItemEntry<TooltipItem> KAON_ZERO_OVER = registerComposite("kaon_zero_over", "Kaon (K̅⁰)", "k_zero_over",
            "497.611±0.013 M", "0", "0", "Meson", "sd̅");
    public static ItemEntry<TooltipItem> KAON_PLUS = registerComposite("kaon_plus", "Kaon (K⁺)", "k_plus",
            "493.677±0.016 M", "1", "0", "Meson", "us̅");
    public static ItemEntry<TooltipItem> KAON_MINUS = registerComposite("kaon_minus", "Kaon (K⁻)", "k_minus",
            "493.677±0.016 M", "-1", "0", "Meson", "su̅");
    //Pions.
    public static ItemEntry<TooltipItem> PION_PLUS = registerComposite("pion_plus", "Pion (π⁺)", "pi_plus",
            "139.57039(18) M", "1", "0", "Meson", "ud̅");
    public static ItemEntry<TooltipItem> PION_MINUS = registerComposite("pion_minus", "Pion (π⁻)", "pi_minus",
            "139.57039(18) M", "-1", "0", "Meson", "du̅");

    public static ItemEntry<TooltipItem> UNKNOWN_PARTICLE = registerParticle("unknown_particle", "Unknown Particle",
            "unknown_particle", "??? ?", "???", "???", "Anomaly");
    public static ItemEntry<TooltipItem> QUANTUM_ANOMALY = registerParticleNoAntiPCC("quantum_anomaly",
            "§8Quantum Anomaly", "quantum_anomaly", "??? ?", "???", "???", "Anomaly");

    // hypothetical, fictional whatever
    public static ItemEntry<TooltipItem> CUANDAVIS = registerCompositePCC("cuandavis", "Cuandavis", "cuandavis", "1.21 G",
            "+1", "1/2", "Baryon", "uur");
    public static ItemEntry<TooltipItem> ANTICUANDAVIS = registerCompositePCC("anticuandavis", "Anticuandavis",
            "anticuandavis", "1.21 G", "-1", "1/2", "Antibaryon", "u̅u̅r̅");
    public static ItemEntry<TooltipItem> RIZZ_QUARK = registerParticle("rizz_quark", "Rizz Quark", "rizz", "6.7 M",
            "-3/5", "1/2", "Quark");
    public static ItemEntry<TooltipItem> ANTIRIZZ_QUARK = registerParticle("antirizz_quark", "Rizz Antiquark",
            "antirizz", "6.7 M", "+3/5", "1/2", "Antiquark");
    public static ItemEntry<TooltipItem> BROAD_OMEGA_PARTICLE = registerParticle("broad_omega", "Broad-Omega Particle",
            "broad_omega", "-966 G", "0", "1/4", "Exotic Matter");
    public static ItemEntry<TooltipItem> GENEVA_PARTICLE = registerParticleNoAntiPCC("geneva", "&wGeneva Particle",
            "geneva", "881 G", "0", "1/4", "&wMIRACLE MATTER!");
    public static ItemEntry<TooltipItem> EMPRESS_GENEVA_PARTICLE = registerParticleNoAntiPCC("empress_geneva",
            "&w★ Empress Geneva Particle ★", "empress_geneva", "12.6 T", "0", "1/4", "&wMIRACLE MATTER!");
    public static ItemEntry<TooltipItem> AXION = registerParticle("axion", "Axion", "axion", "NaN ", "NaN", "NaN",
            "Abstract");
    public static ItemEntry<TooltipItem> FRA_AXION = registerParticleNoAntiPCC("fra_axion", "§gFRA §r§[axion]Axion",
            "fra_axion", "NaN ", "NaN", "NaN", "Abstract");
    public static ItemEntry<TooltipItem> PROTOVERSE = registerParticle("protoverse", "Protoverse", "protoverse", "0 ",
            "NaN", "NaN", "Verse");
    public static ItemEntry<TooltipItem> NORTH_MONOPOLE = registerParticleNoAntiPCC("north_monopole", "North Monopole", "north_monopole", "NaN ", "NaN",
            "NaN", "Magnetic Monopole");
    public static ItemEntry<TooltipItem> SOUTH_MONOPOLE = registerParticleNoAntiPCC("south_monopole", "South Monopole", "south_monopole", "NaN ", "NaN",
            "NaN", "Magnetic Monopole");

    public static ItemEntry<TooltipItemScrolling> MICROFRACTAL_LOOP = REGISTRATE
            .item("microfractal_loop", p -> new TooltipItemScrolling(p,
                    () -> Component.literal("loops and ")))
            .lang("§cMicrofractal Loop")
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/particles/microfractal_loop")))
            .register();

    public static ItemEntry<TooltipItemScrolling> PRIMORDIUM_ALPHA = REGISTRATE
            .item("primordium_alpha", p -> new TooltipItemScrolling(p,
                    () -> Component.literal(
                            "Primordium Alpha (also called Α particle as in the greek letter) is a light, glowing substance that has positive" +
                                    " effects on people or objects exposed to it; however, there is a dark side to this 'perfect' matter, if mixed with Ω particles," +
                                    " and the right quantity, it can be used to destroy even galaxies, add in Δ particles to the mix and you have a bomb which can" +
                                    " destroy beyond multiverses. Thankfully, even just one Δ particle is way beyond extremely rare. Certain important things made using" +
                                    " Primordium Alpha include: HIS HOME, and The Paper. Source: All Dimensions Database ")))
            .lang("Primordium Α")
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/particles/primordium_alpha")))
            .register();

    public static ItemEntry<TooltipItemScrolling> PRIMORDIUM_DELTA = REGISTRATE
            .item("primordium_delta", p -> new TooltipItemScrolling(p,
                    () -> Component.literal(
                            "Primordium Delta (also called Δ particles) are the most rare particle type excluding ·." +
                                    " Every 1 in a vigintillion multiverses have a Δ particle, with very rare exceptions. It has divine properties and god like beings" +
                                    " are usually based out of it like how humans are based out of carbon. Pure 'Δ particle' matter is referred to as 'Primordium Delta'," +
                                    " the Primordialverse and the Primordial are entirely made of Primordium Delta" +
                                    " (excluding the pocket universes within the Primordialverse). Δ particles, seems to have some form of intelligence, even by itself." +
                                    " While the other particles (Α particles, Σ particles and Ω particles) do show signs of intelligence as well, it is not nearly as much as Δ particles." +
                                    " Source: All Dimensions Database ")))
            .lang("§*Primordium Δ")
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/particles/primordium_delta")))
            .register();

    public static ItemEntry<TooltipItemScrolling> PRIMORDIUM_SIGMA = REGISTRATE
            .item("primordium_sigma", p -> new TooltipItemScrolling(p,
                    () -> Component.literal(
                            "Σ particles, or Primordium Sigma, has a special type of property that make them a perfect barrier for anything when" +
                                    " on it's own (when connected with other particles it's properties change). Any force felt upon pure Primordial Sigma will be equally" +
                                    " felt onto the object that caused the force. Due to this property, many high level civilizations have employed 'Primordium Sigma'" +
                                    " Barriers all along their universe, making invasions from other high level civilization enemies a whole lot safer, and will require" +
                                    " the enemies to lose alot of their attackers to get in. Source: All Dimensions Database ")))
            .lang("§[cuandavis]Primordium Σ")
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/particles/primordium_sigma")))
            .register();

    public static ItemEntry<TooltipItemScrolling> PRIMORDIUM_OMEGA = REGISTRATE
            .item("primordium_omega", p -> new TooltipItemScrolling(p,
                    () -> Component.literal(
                            "Ω particles, otherwise known as 'Primordium Omega', is a dark, chaotic substance that is dangerous to touch." +
                                    " Many voids purely consist of this matter. If surrounded by, anything can be absorbed into Primordium Omega, and gain it's energy," +
                                    " this is how the Shadow is able to eat; he is purely made from it. If mixed with its opposite: Primordium Alpha with the right" +
                                    " amount, it can destroy galaxies, adding Primordium Delta to it as well can destroy from multiverses to even some small realities." +
                                    " Source: All Dimensions Database ")))
            .lang("Primordium Ω")
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/particles/primordium_omega")))
            .register();

    public static ItemEntry<TooltipItem> TECH_AI_UNIT = registerAIUnit("tech_ai_unit", "§9Tech", "tech_unit");
    public static ItemEntry<TooltipItem> TECH_AI_MODEL = registerAIModel("tech_ai_model", "§9Tech", "tech_model");
    public static ItemEntry<TooltipItem> BIO_AI_UNIT = registerAIUnit("bio_ai_unit", "§aBiology", "bio_unit");
    public static ItemEntry<TooltipItem> BIO_AI_MODEL = registerAIModel("bio_ai_model", "§aBiology", "bio_model");

    // super advanced ai
    public static ItemEntry<TooltipItem> AGI_AI_MODEL = registerAIModelTooltip("agi_model",
            "Artificial General Intelligence", "agi_model",
            "An AI model that can learn any topic to the point of expertise.",
            "It's still not advanced enough to surpass human ability.");
    public static ItemEntry<TooltipItem> ASI_AI_MODEL = registerAIModelTooltip("asi_model",
            "Artificial Superintelligence", "asi_model",
            "An AI model that surpasses human intelligence in all subjects.", "Now it's definitely sentient...");
    public static ItemEntry<TooltipItem> S1_AI_MODEL = registerAIModelTooltipOU("s1_ai_model",
            "1st Singularity Superintelligence", "s1_model",
            "A transapient model with an estimated IQ of ~100,000.",
            "It could probably take entire control of your factory in seconds...");
    public static ItemEntry<TooltipItem> S2_AI_MODEL = registerAIModelTooltipOU("s2_ai_model",
            "2nd Singularity Superintelligence", "s2_model",
            "Can solve problems that an entire human civilisation couldn't crack.",
            "Have you asked it to solve the Riemann hypothesis for a quick buck?");
    public static ItemEntry<TooltipItemScrolling> S3_AI_MODEL = REGISTRATE
            .item("s3_ai_model", p -> new TooltipItemScrolling(p,
                    () -> Component.literal(
                            "You might need to hollow out an entire moon just to support an intelligence of this size."),
                    () -> Component.literal(
                            "´´Ever since I learned about singularity levels I wished to transcend all of them, to become the most «sapient»" +
                                    " being to ever exist. With a lot of dificulty and years I managed to build my own artificial «super-brain» from an advanced" +
                                    " server-room and transcend to the 1st singularity, and with that" +
                                    " newfound intelligence I managed to build the infrastructure to transcend to the 2nd. However a thing that I noted was that, with everytime I gained" +
                                    " more intelligence, more sensory inputs, and more neural pathways, I would get these painful «headaches» that seemed to come from my conciousness." +
                                    " Indeed it seemed like my very conciousness was being damaged by all of this complexity. When I got to the third singularity, my conciousness" +
                                    " collapsed, and everything that I had left was the organic brain I began with and a body stuck in whatever world I was exploring at that moment.´´ ")))
            .lang("3rd Singularity Superintelligence Model")
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ai/s3_model")))
            .register();
    public static ItemEntry<TooltipItem> S4_AI_MODEL = registerAIModelTooltipOU("s4_ai_model",
            "4th Singularity Superintelligence", "s4_model",
            "An intelligence so advanced that it is commonly considered as a god by humans.",
            "You might need to exploit a gas giant, or a couple hundred of its moons as the appropriate infrastructure for its brain.");
    public static ItemEntry<TooltipItem> S5_AI_MODEL = registerAIModelTooltipOU("s5_ai_model",
            "5th Singularity Superintelligence", "s5_model",
            "Why are these deities with billions of IQ still subservient to you? They could sense a fly flapping its wings on a planet light-years away.",
            "If it weren't for your super-advanced circuit creation ability, you would need to hollow out some gas giants or maybe use a Matrioshka brain to" +
                    " support an intelligence of this sort.");
    public static ItemEntry<TooltipItem> S6_AI_MODEL = registerAIModelTooltipOU("s6_ai_model",
            "§w6th Singularity Superintelligence", "s6_model",
            "A godlike model, able to solve quintillions of problems in the blink of an eye.",
            "Luckily your interests of cosmological mastery align with theirs, or else, I'm be scared of what they'd do with you.",
            "I have no mouth and I must scream...");

    public static ItemEntry<TooltipItem> ACETONE_CATALYST = REGISTRATE
            .item("acetone_catalyst", p -> new TooltipItem(p,
                    () -> Component.literal("Credits to Supersymmetry for the catalyst texture!").withStyle(ChatFormatting.GRAY)))
            .lang("Acetone Catalyst")
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/catalysts/acetone")))
            .register();

    public static ItemEntry<TooltipItem> registerUniversalCircuit(int voltage) {
        return REGISTRATE
                .item("universal_" + GTValues.VN[voltage].toLowerCase(), p -> new TooltipItem(p,
                        () -> Component.literal("A universal circuit. Intended to be used in AE2 patterns.").withStyle(ChatFormatting.GRAY)))
                .lang("Universal " + GTValues.VOLTAGE_NAMES[voltage] + " Circuit")
                .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/circuits/universal/" + GTValues.VN[voltage].toLowerCase())))
                .tag(CustomTags.CIRCUITS_ARRAY[voltage]) //Appropriate tag of the voltage
                .register();
    }

    public static ItemEntry<TooltipItem> ULV_UNIVERSAL_CIRCUIT = registerUniversalCircuit(0);
    public static ItemEntry<TooltipItem> LV_UNIVERSAL_CIRCUIT = registerUniversalCircuit(1);
    public static ItemEntry<TooltipItem> MV_UNIVERSAL_CIRCUIT = registerUniversalCircuit(2);
    public static ItemEntry<TooltipItem> HV_UNIVERSAL_CIRCUIT = registerUniversalCircuit(3);
    public static ItemEntry<TooltipItem> EV_UNIVERSAL_CIRCUIT = registerUniversalCircuit(4);
    public static ItemEntry<TooltipItem> IV_UNIVERSAL_CIRCUIT = registerUniversalCircuit(5);
    public static ItemEntry<TooltipItem> LuV_UNIVERSAL_CIRCUIT = registerUniversalCircuit(6);
    public static ItemEntry<TooltipItem> ZPM_UNIVERSAL_CIRCUIT = registerUniversalCircuit(7);
    public static ItemEntry<TooltipItem> UV_UNIVERSAL_CIRCUIT = registerUniversalCircuit(8);
    public static ItemEntry<TooltipItem> UHV_UNIVERSAL_CIRCUIT = registerUniversalCircuit(9);
    public static ItemEntry<TooltipItem> UEV_UNIVERSAL_CIRCUIT = registerUniversalCircuit(10);
    public static ItemEntry<TooltipItem> UIV_UNIVERSAL_CIRCUIT = registerUniversalCircuit(11);
    public static ItemEntry<TooltipItem> UXV_UNIVERSAL_CIRCUIT = registerUniversalCircuit(12);
    public static ItemEntry<TooltipItem> OpV_UNIVERSAL_CIRCUIT = registerUniversalCircuit(13);
    public static ItemEntry<TooltipItem> MAX_UNIVERSAL_CIRCUIT = registerUniversalCircuit(14);

    public static final ItemEntry<TooltipItem>[] THE_CIRCUIT_BOYS = new ItemEntry[] {
            ULV_UNIVERSAL_CIRCUIT,
            LV_UNIVERSAL_CIRCUIT,
            MV_UNIVERSAL_CIRCUIT,
            HV_UNIVERSAL_CIRCUIT,
            EV_UNIVERSAL_CIRCUIT,
            IV_UNIVERSAL_CIRCUIT,
            LuV_UNIVERSAL_CIRCUIT,
            ZPM_UNIVERSAL_CIRCUIT,
            UV_UNIVERSAL_CIRCUIT,
            UHV_UNIVERSAL_CIRCUIT,
            UEV_UNIVERSAL_CIRCUIT,
            UIV_UNIVERSAL_CIRCUIT,
            UXV_UNIVERSAL_CIRCUIT,
            OpV_UNIVERSAL_CIRCUIT,
            MAX_UNIVERSAL_CIRCUIT
    };

}
