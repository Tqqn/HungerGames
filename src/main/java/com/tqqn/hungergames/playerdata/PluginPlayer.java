package com.tqqn.hungergames.playerdata;

import lombok.Getter;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
public class PluginPlayer {

    private final UUID uuid;
    private final String displayName;
    private final Player player;

    private boolean isDeath;

    public PluginPlayer(UUID uuid, String displayName, Player player, boolean isDeath) {
        this.uuid = uuid;
        this.displayName = displayName;
        this.player = player;
        this.isDeath = isDeath;
    }

    public void setDeath() {
        isDeath = true;
    }
}
