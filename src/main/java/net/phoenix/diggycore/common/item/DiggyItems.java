package net.phoenix.diggycore.common.item;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import static net.phoenix.diggycore.common.registry.DiggyRegistration.REGISTRATE;

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

    public static ItemEntry<TooltipItem> registerParticle(String id, String lang, String texture, String mass, String charge, String spin, String type)
    {
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

    public static ItemEntry<TooltipItem> registerParticlePair(String id, String lang, String texture, String mass, String charge, String spin, String type)
    {
        return REGISTRATE // Positive quark
                .item(id, p -> new TooltipItem(p,
                        () -> Component.literal("§cMASS: ").append(mass).append("eV"),
                        () -> Component.literal("§eCHARGE: ").append(charge),
                        () -> Component.literal("§aSPIN: ").append(spin),
                        () -> Component.literal("§9TYPE: ").append(type)))
                .lang("§[" + id + "]" + lang)
                .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/particles/" + texture)))
                .register();
    }

    public static ItemEntry<TooltipItem> registerParticleNoAntiPCC(String id, String lang, String texture, String mass, String charge, String spin, String type)
    {
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

    public static ItemEntry<TooltipItem> UP_QUARK = registerParticle("up_quark", "Up Quark", "up", "2.16 M", "+2/3", "1/2", "Quark");
    public static ItemEntry<TooltipItem> DOWN_QUARK = registerParticle("down_quark", "Down Quark", "down", "4.7 M", "-1/3", "1/2", "Quark");
    public static ItemEntry<TooltipItem> STRANGE_QUARK = registerParticle("strange_quark", "Strange Quark", "strange", "94 M", "-1/3", "1/2", "Quark");
    public static ItemEntry<TooltipItem> CHARM_QUARK = registerParticle("charm_quark", "Charm Quark", "charm", "1.27 G", "+2/3", "1/2", "Quark");
    public static ItemEntry<TooltipItem> TOP_QUARK = registerParticle("top_quark", "Top Quark", "top", "173 G", "+2/3", "1/2", "Quark");
    public static ItemEntry<TooltipItem> BOTTOM_QUARK = registerParticle("bottom_quark", "Bottom Quark", "bottom", "4.18 G", "-1/3", "1/2", "Quark");

    public static ItemEntry<TooltipItem> UP_ANTIQUARK = registerParticle("antiup_quark", "Up Antiquark", "antiup", "2.16 M", "-2/3", "1/2", "Antiquark");
    public static ItemEntry<TooltipItem> DOWN_ANTIQUARK = registerParticle("antidown_quark", "Down Antiquark", "antidown", "4.7 M", "+1/3", "1/2", "Antiquark");
    public static ItemEntry<TooltipItem> STRANGE_ANTIQUARK = registerParticle("antistrange_quark", "Strange Antiquark", "antistrange", "94 M", "+1/3", "1/2", "Antiquark");
    public static ItemEntry<TooltipItem> CHARM_ANTIQUARK = registerParticle("anticharm_quark", "Charm Antiquark", "anticharm", "1.27 G", "-2/3", "1/2", "Antiquark");
    public static ItemEntry<TooltipItem> TOP_ANTIQUARK = registerParticle("antitop_quark", "Top Antiquark", "antitop", "173 G", "-2/3", "1/2", "Antiquark");
    public static ItemEntry<TooltipItem> BOTTOM_ANTIQUARK = registerParticle("antibottom_quark", "Bottom Antiquark", "antibottom", "4.18 G", "+1/3", "1/2", "Antiquark");

    public static ItemEntry<TooltipItem> ELECTRON = registerParticle("electron", "Electron", "electron", "0.511 M", "-1", "1/2", "Lepton");
    public static ItemEntry<TooltipItem> MUON = registerParticle("muon", "Muon", "muon", "106 M", "-1", "1/2", "Lepton");
    public static ItemEntry<TooltipItem> TAU = registerParticle("tau", "Tau", "tau", "1.78 G", "-1", "1/2", "Lepton");
    public static ItemEntry<TooltipItem> ELECTRON_NEUTRINO = registerParticle("electron_neutrino", "Electron Neutrino", "electron_neutrino", "0.8", "0", "1/2", "Neutrino");
    public static ItemEntry<TooltipItem> MUON_NEUTRINO = registerParticle("muon_neutrino", "Muon Neutrino", "muon_neutrino", "0.17 M", "0", "1/2", "Neutrino");
    public static ItemEntry<TooltipItem> TAU_NEUTRINO = registerParticle("tau_neutrino", "Tau Neutrino", "tau_neutrino", "18.2 M", "0", "1/2", "Neutrino");

    public static ItemEntry<TooltipItem> POSITRON = registerParticle("positron", "Positron", "positron", "0.511 M", "+1", "1/2", "Antilepton");
    public static ItemEntry<TooltipItem> ANTIMUON = registerParticle("antimuon", "Antimuon", "antimuon", "106 M", "+1", "1/2", "Antilepton");
    public static ItemEntry<TooltipItem> ANTITAU = registerParticle("antitau", "Antitau", "antitau", "1.78 G", "+1", "1/2", "Antilepton");
    public static ItemEntry<TooltipItem> ELECTRON_ANTINEUTRINO = registerParticle("electron_antineutrino", "Electron Antineutrino", "electron_antineutrino", "0.8 ", "0", "1/2", "Antineutrino");
    public static ItemEntry<TooltipItem> MUON_ANTINEUTRINO = registerParticle("muon_antineutrino", "Muon Antineutrino", "muon_antineutrino", "0.17 M", "0", "1/2", "Antineutrino");
    public static ItemEntry<TooltipItem> TAU_ANTINEUTRINO = registerParticle("tau_antineutrino", "Tau Antineutrino", "tau_antineutrino", "18.2 M", "0", "1/2", "Antineutrino");

    public static ItemEntry<TooltipItem> GLUON = registerParticle("gluon", "Gluon", "gluon", "0 ", "0", "1", "Gauge Boson");
    public static ItemEntry<TooltipItem> PHOTON = registerParticle("photon", "Photon", "photon", "0 ", "0", "1", "Gauge Boson");
    public static ItemEntry<TooltipItem> W_PLUS_BOSON = registerParticle("w_plus_boson", "W⁺ Boson", "w_plus_boson", "80.4 G", "+1", "1", "Gauge Boson");
    public static ItemEntry<TooltipItem> W_MINUS_BOSON = registerParticle("w_minus_boson", "W⁻ Boson", "w_minus_boson", "80.4 G", "-1", "1", "Gauge Boson");
    public static ItemEntry<TooltipItem> Z_BOSON = registerParticle("z_boson", "Z⁰ Boson", "z_boson", "0 ", "0", "1", "Gauge Boson");
    public static ItemEntry<TooltipItem> HIGGS_BOSON = registerParticle("higgs_boson", "Higgs Boson", "higgs", "125 G", "0", "1", "Gauge Boson");

    public static ItemEntry<TooltipItem> PROTON = registerParticle("proton", "Proton", "proton", "938.27 M", "+1", "1/2", "Baryon");
    public static ItemEntry<TooltipItem> NEUTRON = registerParticle("neutron", "Neutron", "neutron", "939.56 M", "0", "1/2", "Baryon");
    public static ItemEntry<TooltipItem> ANTIPROTON = registerParticle("antiproton", "Antiproton", "antiproton", "938.27 M", "-1", "1/2", "Antibaryon");
    public static ItemEntry<TooltipItem> ANTINEUTRON = registerParticle("antineutron", "Antineutron", "antineutron", "939.56 M", "0", "1/2", "Antibaryon");

    public static ItemEntry<TooltipItem> UNKNOWN_PARTICLE = registerParticle("unknown_particle", "Unknown Particle", "unknown_particle", "??? ?", "???", "???", "Anomaly");
    public static ItemEntry<TooltipItem> QUANTUM_ANOMALY = registerParticleNoAntiPCC("quantum_anomaly", "§8Quantum Anomaly", "quantum_anomaly", "??? ?", "???", "???", "Anomaly");

    public static ItemEntry<TooltipItem> CUANDAVIS = registerParticle("cuandavis", "Cuandavis", "cuandavis", "1.21 G", "+1", "1/2", "Baryon");
    public static ItemEntry<TooltipItem> ANTICUANDAVIS = registerParticle("anticuandavis", "Anticuandavis", "anticuandavis", "1.21 G", "-1", "1/2", "Antibaryon");
    public static ItemEntry<TooltipItem> RIZZ_QUARK = registerParticle("rizz_quark", "Rizz Quark", "rizz", "6.7 M", "-3/5", "1/2", "Quark");
    public static ItemEntry<TooltipItem> ANTIRIZZ_QUARK = registerParticle("antirizz_quark", "Rizz Antiquark", "antirizz", "6.7 M", "+3/5", "1/2", "Antiquark");
    public static ItemEntry<TooltipItem> BROAD_OMEGA_PARTICLE = registerParticle("broad_omega", "Broad-Omega Particle", "broad_omega", "-966 G", "0", "1/4", "Exotic Matter");
    public static ItemEntry<TooltipItem> GENEVA_PARTICLE = registerParticleNoAntiPCC("geneva", "&wGeneva Particle", "geneva", "881 G", "0", "1/4", "&wMIRACLE MATTER!");
    public static ItemEntry<TooltipItem> EMPRESS_GENEVA_PARTICLE = registerParticleNoAntiPCC("empress_geneva", "&w★ Empress Geneva Particle ★", "empress_geneva", "12.6 T", "0", "1/4", "&wMIRACLE MATTER!");
}
