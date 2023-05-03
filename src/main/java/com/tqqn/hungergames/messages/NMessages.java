package com.tqqn.hungergames.messages;

import org.bukkit.ChatColor;

public enum NMessages {

    NOPERMISSION("&cYou have no permission to use this command."),
    GAME_START("&cGame started!");

    private final String message;

    NMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
