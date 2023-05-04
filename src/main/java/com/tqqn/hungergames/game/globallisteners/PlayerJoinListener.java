package com.tqqn.hungergames.game.globallisteners;

import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.GameStates;
import com.tqqn.hungergames.game.utils.GameUtils;
import com.tqqn.hungergames.messages.SMessages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final GameManager gameManager;

    public PlayerJoinListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (gameManager.getGameStates() != GameStates.WAITING) {
            kickPlayer(player);
        } else {
            GameUtils.broadcastMessage(SMessages.PLAYER_JOIN.getMessage(player.getDisplayName(), String.valueOf(gameManager.getArena().getPlayersInArena().size()),String.valueOf(gameManager.getArena().getMaximumPlayers())));
        }
    }

    private void kickPlayer(Player player) {
        if (player.hasPermission("hg.join.fullgame")) return;
        player.kickPlayer("Game is full.");
    }
}
