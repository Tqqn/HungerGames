package com.tqqn.hungergames.game.states;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;
import java.util.List;

public abstract class GameState {

    private final String name;

    public GameState(String name) {
        this.name = name;
        onEnable();
    }

    public void init() {
        onEnable();
    }

    private void onEnable() {
        Bukkit.getLogger().info("Activated Game-State: " + name);
    }

    public void onDisable() {
        Bukkit.getLogger().info("Disabled Game-State: " + name);
    }
}
