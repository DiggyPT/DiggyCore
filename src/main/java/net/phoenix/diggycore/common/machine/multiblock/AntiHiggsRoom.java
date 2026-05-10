package net.phoenix.diggycore.common.machine.multiblock;

import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import org.jetbrains.annotations.NotNull;

public class AntiHiggsRoom extends CleanroomType {
    // This public static final instance ensures the constructor is called
    // when the class is loaded, which registers the new cleanroom type
    // with GTCEu's CleanroomType system.
    public static final CleanroomType ANTI_HIGGS_ROOM = new CleanroomType(
            "anti_higgs_room",
            "gtceu.recipe.room_anti_higgs.display_name");

    /**
     * Constructs a new CleanroomType instance.
     *
     * @param name           The unique name of the cleanroom type.
     * @param translationKey The translation key for the cleanroom's display name.
     */
    public AntiHiggsRoom(@NotNull String name, @NotNull String translationKey) {
        // The super() call triggers the registration logic in the parent class.
        super(name, translationKey);
    }
}
