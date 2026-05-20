package me.constantindev.antiantixray.Mixins;

import me.constantindev.antiantixray.AntiAntiXray;
import me.constantindev.antiantixray.Etc.Config;
import me.constantindev.antiantixray.Etc.Logger;
import me.constantindev.antiantixray.Etc.RefreshingJob;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.core.BlockPos;
import me.constantindev.antiantixray.GUI.ConfigScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(LocalPlayer.class)
public class TickMixin {

    public int ticks;

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {
        List<RefreshingJob> nl = new ArrayList<>();
        AntiAntiXray.jobs.forEach(refreshingJob -> {
            if (!refreshingJob.progress.done) {
                nl.add(refreshingJob);
            }
        });
        AntiAntiXray.jobs = nl;
        if (AntiAntiXray.openMenu.checkPressed()) {
            Minecraft.getInstance().setScreen(new ConfigScreen());
        }
        if (AntiAntiXray.rvn.checkPressed()) {
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.displayClientMessage(Component.literal("Refreshing blocks..."), true);
            AntiAntiXray.revealNewBlocks(Config.rad, Config.delay);
        }
        if (AntiAntiXray.removeBlockBeta.checkPressed()) {
            /*
             * */
            for (int cx = -3; cx <= 3; cx++) {
                for (int cy = -3; cy <= 3; cy++) {
                    for (int cz = -3; cz <= 3; cz++) {
                        assert Minecraft.getInstance().hitResult != null;
                        if (Minecraft.getInstance().hitResult instanceof BlockHitResult blockHitResult) {
                            BlockPos b2r = blockHitResult.getBlockPos();

                            assert Minecraft.getInstance().player != null;
                            
                            Block s = Block.byItem(Minecraft.getInstance().player.getMainHandItem().getItem());
                            BlockState b = Blocks.AIR.defaultBlockState();
                            if (s != null) b = s.defaultBlockState();

                            Minecraft.getInstance().level.setBlock(b2r.offset(cx, cy, cz), b, 3);
                        }
                    }
                }
            }
        }

        if (Config.auto) {
            try {
                assert Minecraft.getInstance().player != null;
                ticks++;

                if (ticks >= Config.autoInterval * 20) {
                    if (AntiAntiXray.jobs.size() == 0) {
                        BlockPos pos = Minecraft.getInstance().player.blockPosition();
                        AntiAntiXray.revealNewBlocks(Config.rad, Config.delay);
                        Logger.info("Scanning new pos: " + pos.toShortString());
                    }
                    ticks = 0;
                }
            } catch (NullPointerException e) {
                Logger.info("Null Error");
            }
        } else {
            ticks = 0; // reset when turned off
        }
    }
}




