package com.tqqn.hungergames.game.globallisteners;

import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.GameStates;
import com.tqqn.hungergames.playerdata.PluginPlayer;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
@AllArgsConstructor
public class GlobalPlayerJoinListener implements Listener {

    private final GameManager gameManager;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (gameManager.getGameStates() != GameStates.STARTING || gameManager.getGameStates() != GameStates.WAITING) {
            if (!player.hasPermission("hungergames.joinstaff")) {
                player.kickPlayer("Game has already started!");
                return;
            }
            if (gameManager.getGameStates() != GameStates.ACTIVE) return;
            gameManager.getArena().addSpectatorToArena(new PluginPlayer(player.getUniqueId(), player.getDisplayName(), player));

        } else if (gameManager.getGameStates() == GameStates.STARTING || gameManager.getGameStates() == GameStates.WAITING) {
            if (gameManager.getArena().isArenaFull()) {
                if (!player.hasPermission("hungergames.joinstaff")) {
                    player.kickPlayer("Game is already full!");
                }

            } else {
                gameManager.getArena().addPlayerToArena(new PluginPlayer(player.getUniqueId(), player.getDisplayName(), player));
                if (gameManager.getArena().isArenaFull()) {
                    gameManager.setGameState(GameStates.STARTING);
                }
            }
        }
    }
}
