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
    private final GameManager gameManager;

    public final List<Listener> listeners = new ArrayList<>();

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

    public abstract void registerGameState();

    public abstract void registerEvents();

    public void deRegisterEvents() {
        for (Listener listener : listeners) {
            HandlerList.unregisterAll(listener);
        }
        listeners.clear();
    }
}
