package com.tqqn.hungergames.game.arena;

import com.tqqn.hungergames.game.utils.GameUtils;
import com.tqqn.hungergames.messages.SMessages;
import com.tqqn.hungergames.playerdata.PluginPlayer;
import com.tqqn.hungergames.sounds.Sounds;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

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
    @Getter
    private Map<UUID, PluginPlayer> spectatorsInArena = new HashMap<>();

    public Arena(int minimumPlayers, int maximumPlayers, List<Location> spawnLocations) {
        this.minimumPlayers = minimumPlayers;
        this.maximumPlayers = maximumPlayers;
        this.spawnLocations = spawnLocations;
    }

    public void addPlayerToArena(PluginPlayer player) {
        if (playersInArena.containsKey(player.getUuid())) return;
        playersInArena.put(player.getUuid(), player);
        GameUtils.broadcastMessage(SMessages.PLAYER_JOIN.getMessage(player.getDisplayName(),String.valueOf(getPlayersInArena().size()), String.valueOf(getMaximumPlayers())));
        Bukkit.getOnlinePlayers().forEach(Sounds.COUNTDOWN_SOUND::playPacketSound);
    }

    public void addSpectatorToArena(PluginPlayer player) {
        if (spectatorsInArena.containsKey(player.getUuid())) return;
        spectatorsInArena.put(player.getUuid(), player);

        if (player.getPlayer() == null) return;

        player.getPlayer().setGameMode(GameMode.SPECTATOR);
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
