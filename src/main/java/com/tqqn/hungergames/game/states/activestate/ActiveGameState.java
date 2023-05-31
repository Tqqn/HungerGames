package com.tqqn.hungergames.game.states.activestate;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.states.GameState;
import com.tqqn.hungergames.game.states.activestate.listeners.PlayerDeathListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public class ActiveGameState extends GameState {

    private final HungerGames plugin;
    private final Listener playerDeathListener = new PlayerDeathListener();

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
        PluginManager pluginManager = plugin.getServer().getPluginManager();

        pluginManager.registerEvents(playerDeathListener, plugin);
        super.listeners.add(playerDeathListener);
    }
}
