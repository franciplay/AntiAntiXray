package me.constantindev.antiantixray.Etc;

import me.constantindev.antiantixray.GUI.ProgressBar;
import net.minecraft.world.level.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public class Runner implements Runnable {
    boolean isRunning = true;
    long delay;
    int rad;
    ProgressBar pbar;

    public Runner(int rad, long delay, ProgressBar pbar) {
        this.rad = rad;
        this.delay = delay;
        this.pbar = pbar;
    }

    @SuppressWarnings("BusyWait")
    @Override
    public void run() {
        ClientPacketListener conn = Minecraft.getInstance().getConnection();
        if (conn == null) return;
        assert Minecraft.getInstance().player != null;
        BlockPos pos = Minecraft.getInstance().player.blockPosition();


        // Blocks that aren't ores but still needs to be checked
        Block[] checkblocks = Config.checkblocks;

        for (int cx = -rad; cx <= rad; cx++) {
            for (int cy = -rad; cy <= rad; cy++) {
                for (int cz = -rad; cz <= rad; cz++) {
                    if (!isRunning) break;
                    pbar.progress++;
                    if (pbar.progress % 100 == 0) {
                        pbar.updateDisplay(); // Update the toast!
                    }
                    BlockPos currblock = new BlockPos(pos.getX() + cx, pos.getY() + cy, pos.getZ() + cz);

                    Block block = Minecraft.getInstance().level.getBlockState(currblock).getBlock();

                    boolean good = Config.scanAll; // cool for else man

                    // only check if block is a ore or in checkblocks (obsidian for example)
                    for (Block checkblock : checkblocks) {
                        if (block.equals(checkblock)) {
                            //Logger.info(block.toString() + " Is in checkbloks or a ore");
                            good = true;
                            break;
                        }
                    }

                    if (!good) {
                        continue;
                    }


                    //Logger.info("Checking " + block.toString() + " at " + currblock.toShortString());


                    ServerboundPlayerActionPacket packet = new ServerboundPlayerActionPacket(
                            ServerboundPlayerActionPacket.Action.ABORT_DESTROY_BLOCK,
                            currblock,
                            Direction.UP
                    );
                    conn.send(packet);
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }
            }
        }
        pbar.done = true;
        pbar.updateDisplay();
    }
}




