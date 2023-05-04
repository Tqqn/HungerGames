package com.tqqn.hungergames.game;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.arena.Arena;
import com.tqqn.hungergames.game.states.startingstate.StartingGameState;
import com.tqqn.hungergames.game.states.waitingstate.WaitingGameState;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class GameManager {

    private GameStates gameStates = GameStates.RESTARTING;

    private final HungerGames plugin;
    @Getter
    private final Arena arena;
    //TODO: PlayerManager
    //TODO: ScoreboardManager

    public GameManager(HungerGames plugin) {
        this.plugin = plugin;
        this.arena = new Arena(plugin.getPluginConfig().getMinPlayers(), plugin.getPluginConfig().getMaxPlayers(), plugin.getPluginConfig().getSpawnLocations());
    }

    public void setGameState(GameStates gameState) {
        //Checks if the new gameState is the same as the old gameState.
        if (this.gameStates == gameState) return;
        //Checks if the current gameState is active and the new gameState is not lobby or starting.
        if (this.gameStates == GameStates.ACTIVE && (gameState == GameStates.RESTARTING || gameState == GameStates.STARTING)) return;

        switch (gameState) {
            case STARTING:
                StartingGameState startingGameState = new StartingGameState(plugin);
                startingGameState.init();
                break;
            case WAITING:
                WaitingGameState waitingGameState = new WaitingGameState(plugin);

        }
    }

    public GameStates getGameStates() {
        return this.gameStates;
    }

    private void startCountdownToStartGame() {
        this.countdownTask = new CountdownTask(this);
        this.countdownTask.runTaskTimer(plugin, 0, 20);
    }
}
