package me.constantindev.antiantixray.Commands;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class CommandNotFound extends Base {
    public CommandNotFound() {
        super("cmdnotfound", new String[]{"cmdnotfound"}, "");
    }

    @Override
    public void run(String[] args) {
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Command not found. Please refer to help command"));
        super.run(args);
    }
}




