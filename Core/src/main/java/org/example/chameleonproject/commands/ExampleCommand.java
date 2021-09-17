package org.example.chameleonproject.commands;

import dev.hypera.chameleon.core.commands.Command;
import dev.hypera.chameleon.core.objects.Platform;
import dev.hypera.chameleon.core.users.ChatUser;
import java.util.Collections;
import java.util.List;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

public class ExampleCommand extends Command {

    @Override
    public void execute(ChatUser chatUser, String[] args) {
        chatUser.sendMessage(Component.text("You ran the example command!"));
    }

    @Override
    public List<String> tabComplete(ChatUser chatUser, String[] args) {
        return Collections.singletonList("tabcomplete");
    }

    @Override
    public @NotNull String getName() {
        return "example";
    }

    @Override
    public @NotNull List<String> getAliases() {
        return Collections.singletonList("ex");
    }

    @Override
    public @NotNull Platform getPlatform() {
        return Platform.ALL;
    }

}
