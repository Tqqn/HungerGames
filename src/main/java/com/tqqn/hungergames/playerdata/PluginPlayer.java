package com.tqqn.hungergames.playerdata;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
public class PluginPlayer {

    private final UUID uuid;
    private final String displayName;

    private PlayerRoles playerRoles;
    private final Player player;

    public PluginPlayer(UUID uuid, String displayName, Player player) {
        this.uuid = uuid;
        this.displayName = displayName;
        this.playerRoles = PlayerRoles.SURVIVOR;
        this.player = player;
    }

    public void setPlayerRoles(PlayerRoles playerRoles) {
        if (playerRoles == this.playerRoles) return;
        this.playerRoles = playerRoles;
    }
}
