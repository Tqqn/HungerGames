package com.tqqn.hungergames.playerdata;

import lombok.Getter;

import java.util.UUID;

@Getter
public class PluginPlayer {

    private final UUID uuid;
    private final String displayName;

    public PluginPlayer(UUID uuid, String displayName) {
        this.uuid = uuid;
        this.displayName = displayName;
    }

}
