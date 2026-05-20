package me.constantindev.antiantixray.Commands;

import me.constantindev.antiantixray.Etc.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class ScanAll extends Base {
    public ScanAll() {
        super("ScanAll", new String[]{"sall", "scanall", "sa"}, "Sets whether to scan all blocks or only ores");
    }

    @Override
    public void run(String[] args) {
        Config.scanAll = !Config.scanAll;
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] " + (Config.scanAll ? "En" : "Dis") + "abled scanning all blocks."));
        super.run(args);
    }
}




