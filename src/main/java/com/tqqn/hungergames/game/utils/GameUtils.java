package com.tqqn.hungergames.game.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class GameUtils {

    public static void broadcastMessage(String message) {
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
