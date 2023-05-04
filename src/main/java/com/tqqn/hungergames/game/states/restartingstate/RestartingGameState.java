package com.tqqn.hungergames.game.states.restartingstate;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;

public class RestartingGameState extends GameState {

    private final HungerGames plugin;

    public RestartingGameState(HungerGames plugin) {
        super("RestartingGameState");
        this.plugin = plugin;
        super.onEnable();
    }

    @Override
    public void registerEvents() {

    }

    @Override
    public void deRegisterEvents() {

    }
}
