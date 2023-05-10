package com.tqqn.hungergames.game.globallisteners;

import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.GameStates;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class GlobalPlayerJoinListener implements Listener {

    private final GameManager gameManager;

    public GlobalPlayerJoinListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (gameManager.getGameStates() != GameStates.STARTING || gameManager.getGameStates() != GameStates.WAITING) {
            if (!player.hasPermission("hungergames.joinstaff")) {
                player.kickPlayer("Game has already started!");

            }
        }
    }

}
