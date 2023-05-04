package com.tqqn.hungergames.game.states.activestate;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;

public class ActiveGameState extends GameState {

    private final HungerGames plugin;

    public ActiveGameState(HungerGames plugin) {
        super("ActiveGameState");
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
