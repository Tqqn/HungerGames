package com.tqqn.hungergames.game.utils;

import org.bukkit.ChatColor;

public class GameUtils {

    public static void broadcastMessage(String message) {
        ChatColor.translateAlternateColorCodes('&', message);
    }

}
