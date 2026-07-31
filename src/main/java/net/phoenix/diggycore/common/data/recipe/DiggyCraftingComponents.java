package net.phoenix.diggycore.common.data.recipe;

import com.gregtechceu.gtceu.api.GTCEuAPI;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.data.recipe.GTCraftingComponents.*;
import static net.phoenix.diggycore.common.data.materials.DiggyNewElementsAndAddFlags.*;

public class DiggyCraftingComponents
{
    public static void init()
    {
        if (GTCEuAPI.isHighTier())
        {
            PLATE.add(UEV, plate, ARMSTRONGIUM); //this is placeholder material
        }
    }
}
