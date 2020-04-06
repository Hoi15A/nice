package moe.neat;

import com.mojang.brigadier.CommandDispatcher;
import io.github.cottonmc.clientcommands.ArgumentBuilders;
import io.github.cottonmc.clientcommands.ClientCommandPlugin;
import io.github.cottonmc.clientcommands.CottonClientCommandSource;
import net.minecraft.client.MinecraftClient;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;
import static io.github.cottonmc.clientcommands.ArgumentBuilders.argument;

// TODO: Refactor shrug into own class + document stuff
public class Commands implements ClientCommandPlugin {
    @Override
    public void registerCommands(CommandDispatcher<CottonClientCommandSource> dispatcher) {
        dispatcher.register(ArgumentBuilders.literal("shrug")
                .then(argument("message", greedyString())
                        .executes(ctx -> {
                            System.out.println(getString(ctx, "message"));
                            if (MinecraftClient.getInstance().player != null) {
                                MinecraftClient.getInstance().player.sendChatMessage(getString(ctx, "message") + " ¯\\_(ツ)_/¯");
                            }
                            return 1;
                        })
                )
                .executes(ctx -> {
                    System.out.println(ctx.getInput());
                    if (MinecraftClient.getInstance().player != null) {
                        MinecraftClient.getInstance().player.sendChatMessage("¯\\_(ツ)_/¯");
                    }

                    return 1;
                })
        );

    }
}
