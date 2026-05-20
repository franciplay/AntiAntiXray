package me.constantindev.antiantixray.GUI;

import me.constantindev.antiantixray.Etc.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.network.chat.Component;

public class ProgressBar {

    public boolean done = false;
    public int progress = 1;
    public double todo;
    private String lastText = "";
    
    public ProgressBar(int rad) {
        this.todo = Math.pow(rad * 2 + 1, 3);
    }

    private static final SystemToast.SystemToastId TOAST_ID = new SystemToast.SystemToastId(10000L); // 10s default

    private static double round(double value) {
        int scale = (int) Math.pow(10, 2);
        return (double) Math.round(value * scale) / scale;
    }

    public void updateDisplay() {
        if (done) {
            SystemToast.forceHide(Minecraft.getInstance().getToastManager(), TOAST_ID);
        } else {
            String text = round((progress / todo) * 100) + "%";
            if (!text.equals(lastText)) {
                lastText = text;
                SystemToast.addOrUpdate(Minecraft.getInstance().getToastManager(), TOAST_ID, Component.literal("Refreshing blocks..."), Component.literal(text));
            }
        }
    }
}




