package net.phoenix.diggycore.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class TooltipItemScrolling extends Item {

    private final Supplier<Component>[] tooltipBuilders;

    @SafeVarargs
    public TooltipItemScrolling(Properties properties, Supplier<Component>... tooltipBuilders) {
        super(properties);
        this.tooltipBuilders = tooltipBuilders;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level,
                                @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag isAdvanced) {
        for (Supplier<Component> builder : tooltipBuilders) {
            if (builder != null) {
                long time = System.currentTimeMillis();
                String message = builder.get().getString();

                int point = (int) ((time / 250) % message.length());

                String doubledMessage = message + message;
                tooltipComponents.add(Component.literal(doubledMessage.substring(point, point + 16)));
            }
        }

        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }
}