package me.constantindev.antiantixray.Mixins;

import me.constantindev.antiantixray.Commands.Base;
import me.constantindev.antiantixray.Etc.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPacketListener.class)
public class NetworkHandlerMixin {

    @Inject(method = "sendChat(Ljava/lang/String;)V", at = @At("HEAD"), cancellable = true)
    public void sendChat(String msg, CallbackInfo ci) {
        if (msg.toLowerCase().startsWith(":")) {
            ci.cancel();
            String[] args = msg.substring(1).trim().split(" +");
            String cmd = args[0].toLowerCase();
            Base cmd2r = Config.cmdmanager.getByName(cmd);
            if (cmd2r != null) {
                cmd2r.run(args);
            }
        }
        if (msg.toLowerCase().startsWith("@aax")) {
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("New prefix is :"));
            ci.cancel();
        }
    }
}




