package com.tqqn.hungergames.game.globallisteners;

import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.GameStates;
import com.tqqn.hungergames.playerdata.PluginPlayer;
import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;
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

        event.setJoinMessage("");

        if (gameManager.getGameStates() != GameStates.STARTING && gameManager.getGameStates() != GameStates.WAITING) {
            System.out.println("1");
            if (!player.hasPermission("hungergames.joinstaff")) {
                System.out.println("2");
                player.kickPlayer("Game has already started!");
                return;
            }

        } else if (gameManager.getGameStates() == GameStates.STARTING || gameManager.getGameStates() == GameStates.WAITING) {
            System.out.println("4");
            if (gameManager.getArena().isArenaFull()) {
                System.out.println("5");
                if (!player.hasPermission("hungergames.joinstaff")) {
                    System.out.println("6");
                    player.kickPlayer("Game is already full!");
                    return;
                }

            } else {
                System.out.println("7");
                gameManager.getArena().addPlayerToArena(new PluginPlayer(player.getUniqueId(), player.getDisplayName(), player, false));
                Bukkit.getLogger().info("registered player.");
                if (gameManager.getArena().canStart()) {
                    System.out.println("8");
                    gameManager.setGameState(GameStates.STARTING);
                    return;
                }
            }
        }

        if (gameManager.getGameStates() != GameStates.ACTIVE && gameManager.getGameStates() != GameStates.END && gameManager.getGameStates() != GameStates.RESTARTING) return;
        System.out.println("3");
        gameManager.getArena().getPlayerInArena(player.getUniqueId()).handleSpectator();
    }
}
