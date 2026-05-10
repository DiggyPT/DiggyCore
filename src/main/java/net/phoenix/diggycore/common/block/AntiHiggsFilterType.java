package net.phoenix.diggycore.common.block;

import com.gregtechceu.gtceu.api.block.IFilterType;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import lombok.Getter;
import net.phoenix.diggycore.common.machine.multiblock.AntiHiggsRoom;
import org.jetbrains.annotations.NotNull;

public enum AntiHiggsFilterType implements IFilterType {

    // Define the custom filter type entry, linking it to your BlazingCleanroom class.
    FILTER_CASING_ANTI_HIGGS("anti_higgs_filter_casing", 1, AntiHiggsRoom.ANTI_HIGGS_ROOM);

    private final String name;
    private final int tier;
    @Getter
    private final CleanroomType cleanroomType;

    /**
     * Constructs a new BlazingFilterType enum entry.
     * * @param name The unique name of the filter type.
     *
     * @param tier          The tier of the filter type.
     * @param cleanroomType The custom cleanroom type associated with this filter.
     */
    AntiHiggsFilterType(String name, int tier, CleanroomType cleanroomType) {
        this.name = name;
        this.tier = tier;
        this.cleanroomType = cleanroomType;
    }

    @NotNull
    @Override
    public String getSerializedName() {
        return this.name;
    }

    @NotNull
    @Override
    public String toString() {
        return getSerializedName();
    }
}
