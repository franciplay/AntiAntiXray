package me.constantindev.antiantixray.GUI;

import me.constantindev.antiantixray.Etc.Config;
import me.constantindev.antiantixray.Etc.ConfigHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;
import com.mojang.blaze3d.vertex.PoseStack;

import java.io.IOException;

public class ConfigScreen extends Screen {
    
    private Button radiusBtn;
    private Button autoBtn;
    private Button autoIntervalBtn;
    private Button scanAllBtn;
    private Button delayBtn;

    public ConfigScreen() {
        super(Component.literal("AntiAntiXray Configuration"));
    }

    @Override
    protected void init() {
        int cx = this.width / 2;
        int cy = this.height / 2;

        this.addRenderableWidget(Button.builder(Component.literal("Radius -"), b -> {
            if (Config.rad > 1) {
                Config.rad--;
                updateButtons();
                saveConfig();
            }
        }).bounds(cx - 105, cy - 80, 100, 20).build());

        this.radiusBtn = this.addRenderableWidget(Button.builder(Component.literal("Radius: " + Config.rad), b -> {})
            .bounds(cx + 5, cy - 80, 100, 20).build());
        this.radiusBtn.active = false;

        this.addRenderableWidget(Button.builder(Component.literal("Radius +"), b -> {
            if (Config.rad < 64) {
                Config.rad++;
                updateButtons();
                saveConfig();
            }
        }).bounds(cx + 115, cy - 80, 100, 20).build());


        this.autoBtn = this.addRenderableWidget(Button.builder(Component.literal(""), b -> {
            Config.auto = !Config.auto;
            updateButtons();
            saveConfig();
        }).bounds(cx - 100, cy - 50, 200, 20).build());

        this.addRenderableWidget(Button.builder(Component.literal("Interval -"), b -> {
            if (Config.autoInterval > 1) {
                Config.autoInterval--;
                updateButtons();
                saveConfig();
            }
        }).bounds(cx - 105, cy - 20, 100, 20).build());

        this.autoIntervalBtn = this.addRenderableWidget(Button.builder(Component.literal("Interval: " + Config.autoInterval + "s"), b -> {})
            .bounds(cx + 5, cy - 20, 100, 20).build());
        this.autoIntervalBtn.active = false;

        this.addRenderableWidget(Button.builder(Component.literal("Interval +"), b -> {
            if (Config.autoInterval < 300) {
                Config.autoInterval++;
                updateButtons();
                saveConfig();
            }
        }).bounds(cx + 115, cy - 20, 100, 20).build());


        this.scanAllBtn = this.addRenderableWidget(Button.builder(Component.literal(""), b -> {
            Config.scanAll = !Config.scanAll;
            updateButtons();
            saveConfig();
        }).bounds(cx - 100, cy + 10, 200, 20).build());

        this.delayBtn = this.addRenderableWidget(Button.builder(Component.literal(""), b -> {
            if (Config.delay == 0) Config.delay = 10;
            else if (Config.delay == 10) Config.delay = 50;
            else if (Config.delay == 50) Config.delay = 100;
            else Config.delay = 0;
            updateButtons();
            saveConfig();
        }).bounds(cx - 100, cy + 40, 200, 20).build());

        this.addRenderableWidget(Button.builder(Component.literal("Close"), b -> {
            Minecraft.getInstance().setScreen(null);
        }).bounds(cx - 100, cy + 80, 200, 20).build());

        updateButtons();
    }

    private void updateButtons() {
        this.radiusBtn.setMessage(Component.literal("Radius: " + Config.rad));
        this.autoBtn.setMessage(Component.literal("Continuous Scan (Auto): " + (Config.auto ? "ON" : "OFF")));
        this.autoIntervalBtn.setMessage(Component.literal("Interval: " + Config.autoInterval + "s"));
        this.scanAllBtn.setMessage(Component.literal("Scan All Blocks (No Filter): " + (Config.scanAll ? "ON" : "OFF")));
        this.delayBtn.setMessage(Component.literal("Scan Delay: " + Config.delay + "ms"));
    }

    private void saveConfig() {
        try {
            ConfigHelper.setRadiusToFile(Config.rad);
            ConfigHelper.setDelayToFile(Config.delay);
            ConfigHelper.setBooleanToFile("auto.bin", Config.auto);
            ConfigHelper.setIntToFile("autoInterval.bin", Config.autoInterval);
            ConfigHelper.setBooleanToFile("scanall.bin", Config.scanAll);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
