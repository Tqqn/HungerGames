package com.tqqn.hungergames.game.states.activestate;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;

public class ActiveGameState extends GameState {

    private final HungerGames plugin;

    public ActiveGameState(HungerGames plugin) {
        super("ActiveGameState", plugin.getGameManager());
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
