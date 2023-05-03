package com.tqqn.hungergames.messages;

import org.bukkit.ChatColor;
import org.bukkit.Color;

public enum SMessages {

    GAME_START_COUNTDOWN("&cGame is starting in &f%%SECONDS%%","%%SECONDS%%","","");

    private final String message;
    private final String placeholder1;
    private final String placeholder2;
    private final String placeholder3;

    SMessages(String message, String placeholder1, String placeholder2, String placeholder3) {
        this.message = message;
        this.placeholder1 = placeholder1;
        this.placeholder2 = placeholder2;
        this.placeholder3 = placeholder3;
    }


    public String getMessage(String replacePlaceHolderArgs1) {
        return ChatColor.translateAlternateColorCodes('&', (message.replace(this.placeholder1, replacePlaceHolderArgs1)));
    }

    public String getMessage(String replacePlaceHolderArgs1, String replacePlaceHolderArgs2) {
        return ChatColor.translateAlternateColorCodes('&', (message.replace(this.placeholder1, replacePlaceHolderArgs1).replace(this.placeholder2, replacePlaceHolderArgs2)));
    }

    public String getMessage(String replacePlaceHolderArgs1, String replacePlaceHolderArgs2, String replacePlaceHolderArgs3) {
        return ChatColor.translateAlternateColorCodes('&', (message.replace(this.placeholder1, replacePlaceHolderArgs1).replace(this.placeholder2, replacePlaceHolderArgs2).replace(this.placeholder3, replacePlaceHolderArgs3)));
    }


}
