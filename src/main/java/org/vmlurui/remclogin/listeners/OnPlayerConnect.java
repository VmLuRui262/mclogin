package org.vmlurui.remclogin.listeners;

import org.vmlurui.remclogin.LoginMod;
import org.vmlurui.remclogin.PlayerLogin;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;

public class OnPlayerConnect {
    public static void listen(ServerPlayerEntity player) {
        PlayerLogin playerLogin = LoginMod.getPlayer(player);
        String username = ctx.getSource().getPlayer().getEntityName();

        playerLogin.setLoggedIn(false);
        player.setInvulnerable(true);
        player.sendMessage(new LiteralText("§9Welcome to the server, in order to play, you must log in.\n§eLog in using /login and register using /register"), false);
        player.sendMessage(new LiteralText("§9欢迎来到(回到)本服务器\n§e登陆请使用指令 /l 注册请使用 /reg 。"), false);
        player.networkHandler.sendPacket(new TitleS2CPacket(new LiteralText("§a" + username + "Welcome Back!")));
    }
}
