package com.tqqn.hungergames.game.events;

import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.GameStates;
import com.tqqn.hungergames.game.utils.GameUtils;
import com.tqqn.hungergames.messages.SMessages;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerGameDeathEvent extends Event {

    private final Player player;
    private final Player killer;
    private final GameManager gameManager;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public PlayerGameDeathEvent(Player player, Player killer, GameManager gameManager) {
        this.player = player;
        this.killer = killer;
        this.gameManager = gameManager;
        setSpectator();
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    private void setSpectator() {
        if (gameManager.getArena().getPlayersInArena().size() >= 1) {
            gameManager.setGameState(GameStates.END);
            GameUtils.broadcastMessage(SMessages.PLAYER_WINNER.getMessage(gameManager.getArena().getWinner().getDisplayName()));
        }
        this.player.setGameMode(GameMode.SPECTATOR);
        Bukkit.getLogger().info("Set player to spectator.");
        if (killer != null) {
            player.teleport(killer);
            Bukkit.getLogger().info("Teleport spectator to killer.");
        }
    }

    public Player getKilledPlayer() {
        return this.player;
    }

    public Player getKiller() {
        return this.killer;
    }
}
