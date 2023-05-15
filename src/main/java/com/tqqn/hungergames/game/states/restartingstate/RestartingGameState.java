package com.tqqn.hungergames.game.states.restartingstate;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;

public class RestartingGameState extends GameState {

    private final HungerGames plugin;

    public RestartingGameState(HungerGames plugin) {
        super("RestartingGameState", plugin.getGameManager());
        this.plugin = plugin;
        super.init();
    }

    @Override
    public void registerEvents() {

    }

    @Override
    public void deRegisterEvents() {

    }
}
