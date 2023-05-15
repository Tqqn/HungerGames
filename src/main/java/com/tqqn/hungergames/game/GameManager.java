package com.tqqn.hungergames.game;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.arena.Arena;
import com.tqqn.hungergames.game.globallisteners.GlobalPlayerChatListener;
import com.tqqn.hungergames.game.globallisteners.GlobalPlayerDamageListener;
import com.tqqn.hungergames.game.globallisteners.GlobalPlayerJoinListener;
import com.tqqn.hungergames.game.states.GameState;
import com.tqqn.hungergames.game.states.activestate.ActiveGameState;
import com.tqqn.hungergames.game.states.endstate.EndGameState;
import com.tqqn.hungergames.game.states.restartingstate.RestartingGameState;
import com.tqqn.hungergames.game.states.startingstate.StartingGameState;
import com.tqqn.hungergames.game.states.waitingstate.WaitingGameState;
import com.tqqn.hungergames.game.tasks.StartCountdownTask;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;

import java.util.*;

public class GameManager {

    private GameStates gameStates = GameStates.RESTARTING;

    public List<? extends GameState> activeGameStates = new ArrayList<>();

    private final HungerGames plugin;
    @Getter
    private final Arena arena;
    private StartCountdownTask startCountdownTask;
    //TODO: PlayerManager
    //TODO: ScoreboardManager

    public GameManager(HungerGames plugin) {
        this.plugin = plugin;
        this.arena = new Arena(plugin.getPluginConfig().getMinPlayers(), plugin.getPluginConfig().getMaxPlayers(), plugin.getPluginConfig().getSpawnLocations());
        registerGlobalEvents();
    }

    public void setGameState(GameStates gameState) {
        //Checks if the new gameState is the same as the old gameState.
        if (this.gameStates == gameState) return;
        //Checks if the current gameState is active and the new gameState is not lobby or starting.
        if (this.gameStates == GameStates.ACTIVE && (gameState == GameStates.RESTARTING || gameState == GameStates.STARTING)) return;

        switch (gameState) {
            case WAITING:
                WaitingGameState waitingGameState = new WaitingGameState(plugin);
                activeGameStates.add(waitingGameState);
                waitingGameState.init();
            case STARTING:
                StartingGameState startingGameState = new StartingGameState(plugin);
                activeGameStates.add(startingGameState);
                startingGameState.init();
                startCountdownToStartGame();
            case ACTIVE:
                ActiveGameState activeGameState = new ActiveGameState(plugin);
                activeGameState.init();
            case END:
                EndGameState endGameState = new EndGameState(plugin);
                endGameState.init();
            case RESTARTING:
                RestartingGameState restartingGameState = new RestartingGameState(plugin);
                restartingGameState.init();
        }
    }

    public GameStates getGameStates() {
        return this.gameStates;
    }

    private void startCountdownToStartGame() {
        this.startCountdownTask = new StartCountdownTask(this);
        this.startCountdownTask.runTaskTimer(plugin, 0, 20);
    }

    private void registerGlobalEvents() {
        PluginManager pluginManager = plugin.getServer().getPluginManager();
        pluginManager.registerEvents(new GlobalPlayerChatListener(), plugin);
        pluginManager.registerEvents(new GlobalPlayerDamageListener(this), plugin);
        pluginManager.registerEvents(new GlobalPlayerJoinListener(this), plugin);
    }

    public void unRegisterPreviousGameState() {
        if (activeGameStates.isEmpty()) return;
        activeGameStates.get(0).onDisable();
        activeGameStates.clear();
    }
}
