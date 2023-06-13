package com.tqqn.hungergames.game.states.end;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;
import org.bukkit.Bukkit;

public class EndGameState extends GameState {

    private HungerGames plugin;

    public EndGameState(HungerGames plugin) {
        super("EndGameState");
        this.plugin = plugin;
        super.init();
    }
}
