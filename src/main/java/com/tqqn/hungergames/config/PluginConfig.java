package com.tqqn.hungergames.config;

import com.tqqn.hungergames.HungerGames;

public class PluginConfig {

    private final HungerGames plugin;

    public PluginConfig(HungerGames plugin) {
        this.plugin = plugin;
    }

    public String getPrefix() {
        return plugin.getConfig().getString("prefix");
    }

    public int getMaxPlayers() {
        return plugin.getConfig().getInt("max-players");
    }

    public int getMinPlayers() {
        return plugin.getConfig().getInt("min-players");
    }
}
