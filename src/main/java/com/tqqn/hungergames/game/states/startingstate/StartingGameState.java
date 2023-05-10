package com.tqqn.hungergames.game.states.startingstate;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;
import org.bukkit.Bukkit;

public class StartingGameState extends GameState {

    private HungerGames plugin;


    public StartingGameState(HungerGames plugin) {
        super("StartingGameState");
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
