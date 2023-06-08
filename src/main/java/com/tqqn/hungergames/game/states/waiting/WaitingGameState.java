package com.tqqn.hungergames.game.states.waiting;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;

public class WaitingGameState extends GameState {


    private final HungerGames plugin;
    public WaitingGameState(HungerGames plugin) {
        super("WaitingGameState");
        this.plugin = plugin;
        super.init();
    }
}
