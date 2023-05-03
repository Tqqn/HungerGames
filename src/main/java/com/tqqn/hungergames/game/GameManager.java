package com.tqqn.hungergames.game;

import com.tqqn.hungergames.HungerGames;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class GameManager {

    private GameState gameState = GameState.LOBBY;

    private final HungerGames plugin;
    //TODO: PlayerManager
    //TODO: ScoreboardManager

    public GameManager(HungerGames plugin) {
        this.plugin = plugin;
        registerEvents();
    }

    public void setGameState(GameState gameState) {
        //Checks if the new gameState is the same as the old gameState.
        if (this.gameState == gameState) return;
        //Checks if the current gameState is active and the new gameState is not lobby or starting.
        if (this.gameState == GameState.ACTIVE && (gameState == GameState.LOBBY || gameState == GameState.STARTING)) return;

        switch (gameState) {
            case STARTING ->
        }
    }

    private void registerEvents() {
        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
    }

    private void startCountdownToStartGame() {
        this.countdownTask = new CountdownTask(this);
        this.countdownTask.runTaskTimer(plugin, 0, 20);
    }
}
