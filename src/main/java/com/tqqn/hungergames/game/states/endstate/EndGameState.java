package com.tqqn.hungergames.game.states.endstate;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;

public class EndGameState extends GameState {

    private HungerGames plugin;

    public EndGameState(HungerGames plugin) {
        super("EndGameState");
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
