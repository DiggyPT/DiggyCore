package net.phoenix.diggycore.data.recipe;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.common.data.GCYMBlocks;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.common.Tags;
import net.phoenix.diggycore.common.block.DiggyBlocks;
import net.phoenix.diggycore.common.data.materials.DiggyMaterialFlags;
import net.phoenix.diggycore.common.machine.DiggyMachines;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.GTValues.EV;
import static com.gregtechceu.gtceu.api.GTValues.HV;
import static com.gregtechceu.gtceu.api.GTValues.IV;
import static com.gregtechceu.gtceu.api.GTValues.LuV;
import static com.gregtechceu.gtceu.api.GTValues.MAX;
import static com.gregtechceu.gtceu.api.GTValues.OpV;
import static com.gregtechceu.gtceu.api.GTValues.UEV;
import static com.gregtechceu.gtceu.api.GTValues.UHV;
import static com.gregtechceu.gtceu.api.GTValues.UIV;
import static com.gregtechceu.gtceu.api.GTValues.UV;
import static com.gregtechceu.gtceu.api.GTValues.UXV;
import static com.gregtechceu.gtceu.api.GTValues.ZPM;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.data.recipe.GTCraftingComponents.*;
import static com.gregtechceu.gtceu.data.recipe.misc.MetaTileEntityLoader.*;

public class MachineMakeRecipes {

    public static CraftingComponent HULL_4_UP;
    public static CraftingComponent CIRCUIT_4_UP;

    public static void init(Consumer<FinishedRecipe> provider) {
        HULL_4_UP = CraftingComponent.of("hull_4_up", GTMachines.HULL[MV].asStack())
                .add(ULV, GTMachines.HULL[HV].asStack())
                .add(LV, GTMachines.HULL[EV].asStack())
                .add(MV, GTMachines.HULL[IV].asStack())
                .add(HV, GTMachines.HULL[LuV].asStack())
                .add(EV, GTMachines.HULL[ZPM].asStack())
                .add(IV, GTMachines.HULL[UV].asStack())
                .add(LuV, GTMachines.HULL[UHV].asStack())
                .add(ZPM, GTMachines.HULL[UEV].asStack())
                .add(UV, GTMachines.HULL[UIV].asStack())
                .add(UHV, GTMachines.HULL[UXV].asStack())
                .add(UEV, GTMachines.HULL[OpV].asStack())
                .add(UIV, GTMachines.HULL[MAX].asStack())
                .add(UXV, GTMachines.HULL[MAX].asStack())
                .add(OpV, GTMachines.HULL[MAX].asStack())
                .add(MAX, GTMachines.HULL[MAX].asStack());

        CIRCUIT_4_UP = CraftingComponent.of("circuit_4_up", CustomTags.ULV_CIRCUITS)
                .add(ULV, CustomTags.HV_CIRCUITS)
                .add(LV, CustomTags.EV_CIRCUITS)
                .add(MV, CustomTags.IV_CIRCUITS)
                .add(HV, CustomTags.LuV_CIRCUITS)
                .add(EV, CustomTags.ZPM_CIRCUITS)
                .add(IV, CustomTags.UV_CIRCUITS)
                .add(LuV, CustomTags.UHV_CIRCUITS)
                .add(ZPM, CustomTags.UEV_CIRCUITS)
                .add(UV, CustomTags.UIV_CIRCUITS)
                .add(UHV, CustomTags.UXV_CIRCUITS)
                .add(UEV, CustomTags.OpV_CIRCUITS)
                .add(UIV, CustomTags.MAX_CIRCUITS)
                .add(UXV, CustomTags.MAX_CIRCUITS)
                .add(OpV, CustomTags.MAX_CIRCUITS)
                .add(MAX, CustomTags.MAX_CIRCUITS);

        // MACHINES
        registerMachineRecipe(provider, DiggyMachines.APIARY,
                "ECE",
                "CMC",
                "WPW",
                'M', HULL,
                'E', CIRCUIT,
                'W', CABLE,
                'C', Tags.Items.FENCES_WOODEN,
                'P', PLATE);

        registerMachineRecipe(provider, DiggyMachines.PARTICLE_BEAM_ENGRAVER,
                "PCP",
                "EME",
                "WEW",
                'M', HULL,
                'E', CIRCUIT,
                'W', CABLE,
                'C', EMITTER,
                'P', FIELD_GENERATOR);

        registerMachineRecipe(provider, DiggyMachines.CASIMIR,
                "WPW",
                "EME",
                "WEW",
                'M', HULL_4_UP,
                'E', CIRCUIT_4_UP,
                'W', CABLE,
                'P', FIELD_GENERATOR);

        VanillaRecipeHelper.addShapedRecipe(provider, true, "vibration_sieve", DiggyMachines.VIBRATION_SIEVE.asStack(),
                "PCP",
                "BXB",
                "MKM",
                'C', CustomTags.IV_CIRCUITS,
                'P', new MaterialEntry(plate, Scandium),
                'B', ELECTRIC_PISTON_EV.asStack(),
                'M', ELECTRIC_MOTOR_EV.asStack(),
                'X', GTMachines.SIFTER[EV].asStack(),
                'K', new MaterialEntry(cableGtSingle, BlackSteel));

        VanillaRecipeHelper.addShapedRecipe(provider, true, "chemical_plant", DiggyMachines.CHEMICAL_PLANT.asStack(),
                "CPC",
                "BXB",
                "MKM",
                'C', CustomTags.EV_CIRCUITS,
                'P', new MaterialEntry(plate, Scandium),
                'B', ELECTRIC_PISTON_EV.asStack(),
                'M', ELECTRIC_MOTOR_EV.asStack(),
                'X', GTMachines.CHEMICAL_REACTOR[EV].asStack(),
                'K', new MaterialEntry(DiggyMaterialFlags.double_ingot, Zinc));

        VanillaRecipeHelper.addShapedRecipe(provider, true, "greenhouse", DiggyMachines.GREENHOUSE.asStack(),
                "CCC",
                "AXA",
                "APA",
                'C', CustomTags.MV_CIRCUITS,
                'A', DiggyBlocks.GREENHOUSE_CASING.asStack(),
                'P', ELECTRIC_PISTON_MV.asStack(),
                'X', GTMachines.HULL[MV].asStack());

        VanillaRecipeHelper.addShapedRecipe(provider, true, "ion_exchanger", DiggyMachines.ION_EXCHANGER.asStack(),
                "PPP",
                "CAC",
                "BDB",
                'C', CustomTags.EV_CIRCUITS,
                'A', GCYMBlocks.CASING_REACTION_SAFE.asStack(),
                'D', ELECTRIC_PISTON_EV.asStack(),
                'P', new MaterialEntry(wireGtSingle, Platinum),
                'B', GTBlocks.CASING_LAMINATED_GLASS.asStack());
    }
}
