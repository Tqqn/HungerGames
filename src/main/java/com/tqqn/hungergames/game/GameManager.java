package com.tqqn.hungergames.game;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.arena.Arena;
import com.tqqn.hungergames.game.globallisteners.GlobalBlockPlaceBreakListener;
import com.tqqn.hungergames.game.globallisteners.GlobalPlayerChatListener;
import com.tqqn.hungergames.game.globallisteners.GlobalPlayerDamageListener;
import com.tqqn.hungergames.game.globallisteners.GlobalPlayerJoinListener;
import com.tqqn.hungergames.game.states.GameState;
import com.tqqn.hungergames.game.states.active.ActiveGameState;
import com.tqqn.hungergames.game.states.end.EndGameState;
import com.tqqn.hungergames.game.states.restarting.RestartingGameState;
import com.tqqn.hungergames.game.states.starting.StartingGameState;
import com.tqqn.hungergames.game.states.waiting.WaitingGameState;
import com.tqqn.hungergames.game.tasks.EndCountdownTask;
import com.tqqn.hungergames.game.tasks.StartCountdownTask;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class GameManager {

    private GameStates gameState = GameStates.WAITING;

    private final HungerGames plugin;
    @Getter
    private final Arena arena;
    private StartCountdownTask startCountdownTask;
    private EndCountdownTask endCountdownTask;
    //TODO: PlayerDataManager
    //TODO: ScoreboardManager

    public GameManager(HungerGames plugin) {
        this.plugin = plugin;
        this.arena = new Arena(plugin.getPluginConfig().getMinPlayers(), plugin.getPluginConfig().getMaxPlayers(), plugin.getPluginConfig().getSpawnLocations(), this);
        registerEvents();
    }

    public void setGameState(GameStates gameState) {
        //Checks if the new gameState is the same as the old gameState.
        if (this.gameState == gameState) return;
        //Checks if the current gameState is active and the new gameState is not lobby or starting.
        if (this.gameState == GameStates.ACTIVE && (gameState == GameStates.RESTARTING || gameState == GameStates.STARTING)) return;

        switch (gameState) {
            case WAITING:
                WaitingGameState waitingGameState = new WaitingGameState(plugin);
                waitingGameState.init();
                this.gameState = GameStates.WAITING;
                Bukkit.getPluginManager().registerEvents(waitingGameState, plugin);
                break;
            case STARTING:
                StartingGameState startingGameState = new StartingGameState(plugin);
                startingGameState.init();
                startCountdownToStartGame();
                this.gameState = GameStates.STARTING;
                break;
            case ACTIVE:
                ActiveGameState activeGameState = new ActiveGameState(this);
                activeGameState.init();
                this.gameState = GameStates.ACTIVE;
                Bukkit.getPluginManager().registerEvents(activeGameState, plugin);
                break;
            case END:
                EndGameState endGameState = new EndGameState(plugin);
                endGameState.init();
                startEndCountDownTask();
                this.gameState = GameStates.END;
                break;
            case RESTARTING:
                RestartingGameState restartingGameState = new RestartingGameState(plugin);
                restartingGameState.init();
                this.gameState = GameStates.RESTARTING;
                break;
        }
    }

    public GameStates getGameStates() {
        return this.gameState;
    }

    private void startCountdownToStartGame() {
        this.startCountdownTask = new StartCountdownTask(this);
        this.startCountdownTask.runTaskTimerAsynchronously(plugin, 0, 20L);
    }

    private void startEndCountDownTask() {
        this.endCountdownTask = new EndCountdownTask(this);
        this.endCountdownTask.runTaskTimerAsynchronously(plugin, 0, 20L);
    }

    private void registerEvents() {
        PluginManager pluginManager = plugin.getServer().getPluginManager();
        pluginManager.registerEvents(new GlobalPlayerChatListener(), plugin);
        pluginManager.registerEvents(new GlobalPlayerDamageListener(this), plugin);
        pluginManager.registerEvents(new GlobalPlayerJoinListener(this), plugin);
        pluginManager.registerEvents(new GlobalBlockPlaceBreakListener(this), plugin);
    }
}
