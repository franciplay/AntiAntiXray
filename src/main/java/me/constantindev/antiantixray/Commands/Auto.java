package me.constantindev.antiantixray.Commands;

import me.constantindev.antiantixray.Etc.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class Auto extends Base {
    public Auto() {
        super("auto", new String[]{"auto", "a"}, "Sets whether to continually scan surroundings based on the set time interval");
    }

    @Override
    public void run(String[] args) {
        Config.auto = !Config.auto;
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] " + (Config.auto ? "En" : "Dis") + "abled continually scanning."));
        super.run(args);
    }
}




