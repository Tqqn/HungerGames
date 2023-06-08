package com.tqqn.hungergames.game.states.starting;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;

public class StartingGameState extends GameState {

    private final HungerGames plugin;


    public StartingGameState(HungerGames plugin) {
        super("StartingGameState");
        this.plugin = plugin;
        super.init();
    }
}
