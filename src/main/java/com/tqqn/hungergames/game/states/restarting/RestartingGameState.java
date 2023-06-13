package com.tqqn.hungergames.game.states.restarting;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;
import org.bukkit.Bukkit;

public class RestartingGameState extends GameState {

    private final HungerGames plugin;

    public RestartingGameState(HungerGames plugin) {
        super("RestartingGameState");
        this.plugin = plugin;
        super.init();
        Bukkit.getLogger().info("Game ended. System is shutting down.");
        Bukkit.getServer().shutdown();
    }
}
