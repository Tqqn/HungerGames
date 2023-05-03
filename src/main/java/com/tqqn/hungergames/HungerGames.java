package com.tqqn.hungergames;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.tqqn.hungergames.config.PluginConfig;
import com.tqqn.hungergames.game.GameManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class HungerGames extends JavaPlugin {

    @Getter
    private GameManager gameManager;
    @Getter
    private PluginConfig pluginConfig;
    @Getter
    private static ProtocolManager protocolManager;

    @Override
    public void onEnable() {
        protocolManager = ProtocolLibrary.getProtocolManager();
        this.gameManager = new GameManager(this);
        this.pluginConfig = new PluginConfig(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
