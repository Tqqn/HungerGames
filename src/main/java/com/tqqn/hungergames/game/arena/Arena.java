package com.tqqn.hungergames.game.arena;

import com.tqqn.hungergames.playerdata.PluginPlayer;
import lombok.Getter;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Arena {

    @Getter
    private final int minimumPlayers;
    @Getter
    private final int maximumPlayers;
    @Getter
    private PluginPlayer winner = null;

    private final List<Location> spawnLocations;

    @Getter
    private Map<UUID, PluginPlayer> playersInArena = new HashMap<>();

    public Arena(int minimumPlayers, int maximumPlayers, List<Location> spawnLocations) {
        this.minimumPlayers = minimumPlayers;
        this.maximumPlayers = maximumPlayers;
        this.spawnLocations = spawnLocations;
    }

    public void addPlayerToArena(PluginPlayer player) {
        if (playersInArena.containsKey(player.getUuid())) return;
        playersInArena.put(player.getUuid(), player);
    }

    public boolean isArenaFull() {
        return playersInArena.size() >= this.maximumPlayers;
    }

    public boolean canStart() {
        return playersInArena.size() >= this.minimumPlayers;
    }

    public PluginPlayer getPlayerInArena(UUID uuid) {
        return playersInArena.get(uuid);
    }

}
