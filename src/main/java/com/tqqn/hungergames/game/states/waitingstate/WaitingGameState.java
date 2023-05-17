package com.tqqn.hungergames.game.states.waitingstate;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;

public class WaitingGameState extends GameState {


    private final HungerGames plugin;
    public WaitingGameState(HungerGames plugin) {
        super("WaitingGameState", plugin.getGameManager());
        this.plugin = plugin;
        super.init();
    }


    @Override
    public void registerGameState() {
        plugin.getGameManager().registerGameState(this);
    }

    @Override
    public void registerEvents() {

    }

    @Override
    public void deRegisterEvents() {

    }
}
