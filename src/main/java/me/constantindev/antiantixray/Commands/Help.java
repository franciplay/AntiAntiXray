package me.constantindev.antiantixray.Commands;

import me.constantindev.antiantixray.Etc.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class Help extends Base {
    public Help() {
        super("Help", new String[]{"help", "?", "h", ""}, "Lists all commands");
    }

    @Override
    public void run(String[] args) {
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] All commands you can use:"));
        Config.cmdmanager.get().forEach(base -> Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX]  - " + base.name + " (" + String.join(", ", base.aliases) + "): " + base.description)));
        super.run(args);
    }
}




