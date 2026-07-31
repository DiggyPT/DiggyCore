package net.phoenix.diggycore.common.item;

import net.minecraft.ChatFormatting;
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

    int stringSize = 32;
    private final Supplier<Component>[] tooltipBuilders;
    boolean done = false;

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
                done = false;

                if (builder != tooltipBuilders[tooltipBuilders.length - 1]) {
                    tooltipComponents.add(Component.literal(builder.get().getString()).withStyle(ChatFormatting.GRAY));
                    done = true;
                }

                long time = System.currentTimeMillis();
                String message = builder.get().getString();

                int point = (int) ((time / 100) % message.length());

                message = message + message;
                while (message.length() <= stringSize * 2) {
                    message = message + message;
                }

                if (!done) {
                    tooltipComponents.add(Component.literal(message.substring(point, point + stringSize))
                            .withStyle(ChatFormatting.GRAY)); // 16 is the size of the string to show
                }
            }
        }

        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }
}