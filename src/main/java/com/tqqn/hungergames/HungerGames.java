package com.tqqn.hungergames;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.tqqn.hungergames.config.PluginConfig;
import com.tqqn.hungergames.game.GameManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class HungerGames extends JavaPlugin {


    @Getter
    private PluginConfig pluginConfig;
    @Getter
    private GameManager gameManager;
    @Getter
    private static ProtocolManager protocolManager;

    private static HungerGames instance;

    @Override
    public void onEnable() {
        protocolManager = ProtocolLibrary.getProtocolManager();
        this.pluginConfig = new PluginConfig(this);
        this.gameManager = new GameManager(this);
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static HungerGames getInstance() {
        return instance;
    }
}
