package com.tqqn.hungergames.game.states.waitingstate;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;

public class WaitingGameState extends GameState {


    private final HungerGames plugin;
    public WaitingGameState(HungerGames plugin) {
        super("WaitingGameState");
        this.plugin = plugin;
        super.onEnable();
    }

    public void disable() {
        super.onDisable();
    }


    @Override
    public void registerEvents() {

    }

    @Override
    public void deRegisterEvents() {

    }
}
