package me.constantindev.antiantixray.Commands;

import me.constantindev.antiantixray.Etc.Config;
import me.constantindev.antiantixray.Etc.ConfigHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class AutoInterval extends Base {
    public AutoInterval() {
        super("autointerval", new String[]{"autointerval", "ai", "interval"}, "Sets the interval in seconds for continuous scanning");
    }

    @Override
    public void run(String[] args) {
        if (args.length == 0) {
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] You need to specify a number"));
            return;
        }
        int newInterval;
        try {
            newInterval = Integer.parseInt(args[0]);
        } catch (NumberFormatException exc) {
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] You need to specify a valid integer."));
            return;
        }

        if (newInterval < 1) newInterval = 1;
        Config.autoInterval = newInterval;
        try {
            ConfigHelper.setIntToFile("autoInterval.bin", newInterval);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Successfully changed auto interval to " + Config.autoInterval + "s."));
    }
}
