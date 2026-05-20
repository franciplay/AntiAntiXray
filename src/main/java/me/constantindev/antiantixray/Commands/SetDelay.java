package me.constantindev.antiantixray.Commands;

import me.constantindev.antiantixray.Etc.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class SetDelay extends Base {
    public SetDelay() {
        super("SetDelay", new String[]{"setdelay", "sdelay", "delay", "d"}, "Sets the delay between packets sent");
    }

    @Override
    public void run(String[] args) {
        if (args.length < 2) {
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Please provide a number as argument."));
            return;
        }
        String newdelay = args[1];
        long newdelayI;
        try {
            newdelayI = Long.parseLong(newdelay);
        } catch (Exception ex) {
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Please provide a VALID number as argument."));
            return;
        }
        Config.delay = newdelayI;
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Set new delay to " + newdelayI));
        super.run(args);
    }
}




