package me.constantindev.antiantixray.Commands;

import me.constantindev.antiantixray.AntiAntiXray;
import me.constantindev.antiantixray.Etc.ConfigHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

import java.io.IOException;

public class SetBind extends Base {
    public SetBind() {
        super("setbind", new String[]{"setbind", "sb", "bind"}, "Sets custom binds for either scanning or removing blocks");
    }

    @Override
    public void run(String[] args) {
        assert Minecraft.getInstance().player != null;
        if (args.length < 3) {

            Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Please provide the property you want to chage as 2nd argument and the key to change it to as 3rd argument."));
            return;
        }
        int kc = args[2].toUpperCase().charAt(0);
        switch (args[1].toLowerCase()) {
            case "scan":
                AntiAntiXray.rvn.setKeyCode(kc);
                try {
                    ConfigHelper.setScanKBToFile(kc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Set scanning keybind to " + ((char) kc)));
                break;
            case "remove":
                AntiAntiXray.removeBlockBeta.setKeyCode(kc);
                try {
                    ConfigHelper.setRemoveKBToFile(kc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Set removing keybind to " + ((char) kc)));
                break;
            default:
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Invalid property. Please choose either \"scan\" or \"remove\"."));
                return;
        }
        super.run(args);
    }
}




