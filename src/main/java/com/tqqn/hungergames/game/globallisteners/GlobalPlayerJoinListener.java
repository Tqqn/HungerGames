package com.tqqn.hungergames.game.globallisteners;

import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.GameStates;
import com.tqqn.hungergames.game.utils.GameUtils;
import com.tqqn.hungergames.messages.SMessages;
import com.tqqn.hungergames.playerdata.PluginPlayer;
import com.tqqn.hungergames.sounds.Sounds;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class GlobalPlayerJoinListener implements Listener {

    private final GameManager gameManager;

    public GlobalPlayerJoinListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (gameManager.getGameStates() != GameStates.STARTING || gameManager.getGameStates() != GameStates.WAITING) {
            if (!player.hasPermission("hungergames.joinstaff")) {
                player.kickPlayer("Game has already started!");
            }
            gameManager.getArena().addPlayerToArena(new PluginPlayer(player.getUniqueId(), player.getDisplayName()));

        } else if (gameManager.getGameStates() == GameStates.STARTING || gameManager.getGameStates() == GameStates.WAITING) {
            if (gameManager.getArena().isArenaFull()) {
                if (!player.hasPermission("hungergames.joinstaff")) {
                    player.kickPlayer("Game is already full!");
                }
            } else {
                gameManager.getArena().addPlayerToArena(new PluginPlayer(player.getUniqueId(), player.getDisplayName()));
            }
        }
    }
}
