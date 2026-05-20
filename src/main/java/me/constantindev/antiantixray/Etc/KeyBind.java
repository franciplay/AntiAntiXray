package me.constantindev.antiantixray.Etc;

import net.minecraft.client.Minecraft;
import com.mojang.blaze3d.platform.InputConstants;

public class KeyBind {
    int kc;
    boolean flag3 = false;

    public KeyBind(int kc) {
        this.kc = kc;
    }

    public void setKeyCode(int kc) {
        this.kc = kc;
    }

    public boolean checkPressed() {
        if (Minecraft.getInstance().screen != null) return false;
        boolean flag2 = InputConstants.isKeyDown(Minecraft.getInstance().getWindow(), kc);
        if (!flag2) {
            flag3 = false;
            return false;
        }
        if (flag3) {
            return false;
        }
        flag3 = true;
        return true;
    }
}




