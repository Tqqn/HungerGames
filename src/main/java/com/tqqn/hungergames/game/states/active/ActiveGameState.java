package com.tqqn.hungergames.game.states.active;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;
import com.tqqn.hungergames.game.states.active.handlers.PlayerDeathHandler;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ActiveGameState extends GameState implements Listener {

    private final HungerGames plugin;

    public ActiveGameState(HungerGames plugin) {
        super("ActiveGameState");
        this.plugin = plugin;
        super.init();
    }

    @EventHandler
    public void onPlayerDeath() {

    }
}
