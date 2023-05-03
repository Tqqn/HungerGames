package com.tqqn.hungergames.game.states.startingstate;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;
import org.bukkit.Bukkit;

public class StartingGameState extends GameState {


    public StartingGameState(HungerGames plugin) {
        super(plugin);
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("");
    }
}
