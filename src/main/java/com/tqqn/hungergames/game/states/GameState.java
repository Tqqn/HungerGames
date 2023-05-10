package com.tqqn.hungergames.game.states;

import com.tqqn.hungergames.HungerGames;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

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
        registerEvents();
        Bukkit.getLogger().info("Activated Game-State: " + name);
    }

    public void onDisable() {
        deRegisterEvents();
        Bukkit.getLogger().info("Disabled Game-State: " + name);
    }

    public abstract void registerEvents();

    public abstract void deRegisterEvents();
}
