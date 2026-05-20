package me.constantindev.antiantixray.Etc;

import me.constantindev.antiantixray.Commands.Manager;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.io.IOException;

public class Config {
    public static int rad = 16;
    public static long delay = 10;
    public static Manager cmdmanager = new Manager();
    public static boolean scanAll = false;
    public static boolean auto = false;
    public static int autoInterval = 10;
    public static int movethreshhold = 5;
    public static Block[] checkblocks = {Blocks.OBSIDIAN, Blocks.CLAY, Blocks.MOSSY_COBBLESTONE,
            Blocks.DIAMOND_ORE, Blocks.REDSTONE_ORE, Blocks.IRON_ORE, Blocks.COAL_ORE, Blocks.LAPIS_ORE,
            Blocks.GOLD_ORE, Blocks.EMERALD_ORE, Blocks.NETHER_GOLD_ORE, Blocks.NETHER_QUARTZ_ORE};
    public static int kcScan;
    public static int kcRemove;
    public static int kcMenu;

    static {
        try {
            kcScan = ConfigHelper.getScanKBFromFile();
            kcRemove = ConfigHelper.getRemoveKBFromFile();
            kcMenu = ConfigHelper.getMenuKBFromFile();
            rad = ConfigHelper.getRadiusFromFile();
            delay = ConfigHelper.getDelayFromFile();
            auto = ConfigHelper.getBooleanFromFile("auto.bin", false);
            autoInterval = ConfigHelper.getIntFromFile("autoInterval.bin", 10);
            scanAll = ConfigHelper.getBooleanFromFile("scanall.bin", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}






