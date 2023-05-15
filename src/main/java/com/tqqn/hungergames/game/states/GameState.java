package com.tqqn.hungergames.game.states;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public abstract class GameState {

    private final String name;
    private final GameManager gameManager;

    public GameState(String name, GameManager gameManager) {
        this.name = name;
        this.gameManager = gameManager;
        onEnable();
    }

    public void init() {
        onEnable();
    }

    private void onEnable() {
        gameManager.unRegisterPreviousGameState();
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
