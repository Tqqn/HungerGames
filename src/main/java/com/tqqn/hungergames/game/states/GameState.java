package com.tqqn.hungergames.game.states;

import com.tqqn.hungergames.HungerGames;
import org.bukkit.plugin.PluginManager;

public abstract class GameState {

    private HungerGames plugin;

    public GameState(HungerGames plugin) {
        this.plugin = plugin;
    }


    public abstract void onEnable();

    public abstract void onDisable();
}
