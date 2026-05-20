package me.constantindev.antiantixray;

import me.constantindev.antiantixray.Etc.*;
import me.constantindev.antiantixray.GUI.ProgressBar;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;

public class AntiAntiXray implements ClientModInitializer {
    public static KeyBind rvn = new KeyBind(Config.kcScan);
    public static KeyBind removeBlockBeta = new KeyBind(Config.kcRemove);
    public static KeyBind openMenu = new KeyBind(Config.kcMenu);
    public static List<RefreshingJob> jobs = new ArrayList<>();

    public static void revealNewBlocks(int rad, long delayInMS) {
        ProgressBar pbar = new ProgressBar(rad);
        pbar.updateDisplay();
        RefreshingJob rfj = new RefreshingJob(new Runner(rad, delayInMS, pbar), pbar);
        jobs.add(rfj);
    }

    @Override
    public void onInitializeClient() {
        Logger.info("Loading and initializing AAX...");

    }
}




