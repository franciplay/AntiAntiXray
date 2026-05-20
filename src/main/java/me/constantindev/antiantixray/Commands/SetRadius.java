package me.constantindev.antiantixray.Commands;

import me.constantindev.antiantixray.Etc.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class SetRadius extends Base {
    public SetRadius() {
        super("SetRadius", new String[]{"setradius", "sradius", "radius", "r"}, "Set the radius");
    }

    @Override
    public void run(String[] args) {
        if (args.length < 2) {
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Please provide a number as argument."));
            return;
        }
        String newrad = args[1];
        int newradI;
        try {
            newradI = Integer.parseInt(newrad);
        } catch (Exception ex) {
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Please provide a VALID number as argument."));
            return;
        }
        Config.rad = newradI;
        try {
            me.constantindev.antiantixray.Etc.ConfigHelper.setRadiusToFile(newradI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Set new radius to " + newradI));
        super.run(args);
    }
}




