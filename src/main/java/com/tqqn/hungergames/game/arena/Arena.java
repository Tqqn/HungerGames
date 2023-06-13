package com.tqqn.hungergames.game.arena;

import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.GameStates;
import com.tqqn.hungergames.game.utils.GameUtils;
import com.tqqn.hungergames.messages.SMessages;
import com.tqqn.hungergames.playerdata.PluginPlayer;
import com.tqqn.hungergames.sounds.Sounds;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.*;

public class Arena {

    @Getter
    private final int minimumPlayers;
    @Getter
    private final int maximumPlayers;

    private final List<Location> spawnLocations;
    private final GameManager gameManager;

    @Getter
    private static Map<UUID, PluginPlayer> playersInArena = new HashMap<>();

    @Getter
    private static List<PluginPlayer> alivePlayers = new ArrayList<>();

    private PluginPlayer winner = null;

    public Arena(int minimumPlayers, int maximumPlayers, List<Location> spawnLocations, GameManager gameManager) {
        this.minimumPlayers = minimumPlayers;
        this.maximumPlayers = maximumPlayers;
        this.spawnLocations = spawnLocations;
        this.gameManager = gameManager;
    }

    public void addPlayerToArena(PluginPlayer player) {
        if (playersInArena.containsKey(player.getUuid())) return;
        playersInArena.put(player.getUuid(), player);
        GameUtils.broadcastMessage(SMessages.PLAYER_JOIN.getMessage(player.getDisplayName(),String.valueOf(getPlayersInArena().size()), String.valueOf(getMaximumPlayers())));
        Bukkit.getOnlinePlayers().forEach(Sounds.COUNTDOWN_SOUND::playPacketSound);
        addAlivePlayer(player);
    }

    public void removeAlivePlayer(PluginPlayer player) {
        alivePlayers.remove(player);
    }

    public void addAlivePlayer(PluginPlayer player) {
        if (alivePlayers.contains(player)) return;
        alivePlayers.add(player);
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

    public void canEnd() {
        if (getAlivePlayers().size() <= 1) {
            gameManager.setGameState(GameStates.END);
            GameUtils.broadcastMessage(SMessages.PLAYER_WINNER.getMessage(getWinner().getDisplayName()));
        }
    }

    public PluginPlayer getWinner() {
        for (PluginPlayer alivePlayer : alivePlayers)
            if (winner == null) {
                winner = alivePlayer;
            }
        return winner;
    }
}
