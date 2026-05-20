package me.constantindev.antiantixray.Commands;

import me.constantindev.antiantixray.Etc.Config;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class Optimize extends Base {
    public Optimize() {
        super("optimize", new String[]{"optimize", "o"}, "Optimizes for either diamond, redstone ore or stone");
    }

    @Override
    public void run(String[] args) {
        if (args.length < 2) {
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Please provide a ore block to optimize for as argument. Currently: diamond, redstone ore or stone"));
            return;
        }
        String newblock = args[1];
        assert Minecraft.getInstance().player != null;
        switch (newblock) {
            case "diamond":
                Config.checkblocks = new Block[]{Blocks.DIAMOND_ORE};

                Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Set optimization to diamond"));
                break;


            case "redstone":
                Config.checkblocks = new Block[]{Blocks.REDSTONE_ORE};
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Set optimization to redstone"));
                break;

            case "stone":
                Config.checkblocks = new Block[]{Blocks.STONE};
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] Set optimization to stone"));
                break;

            default:
                Config.checkblocks = new Block[]{Blocks.OBSIDIAN, Blocks.CLAY, Blocks.MOSSY_COBBLESTONE,
                        Blocks.DIAMOND_ORE, Blocks.REDSTONE_ORE, Blocks.IRON_ORE, Blocks.COAL_ORE, Blocks.LAPIS_ORE,
                        Blocks.GOLD_ORE, Blocks.EMERALD_ORE, Blocks.NETHER_GOLD_ORE, Blocks.NETHER_QUARTZ_ORE};
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("[AAX] optimization reset to all ores"));
        }

        assert Minecraft.getInstance().player != null;
        super.run(args);
    }
}




