package com.tqqn.hungergames.game.states.active;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.GameStates;
import com.tqqn.hungergames.game.events.PlayerGameDeathEvent;
import com.tqqn.hungergames.game.states.GameState;
import com.tqqn.hungergames.game.utils.GameUtils;
import com.tqqn.hungergames.messages.SMessages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class ActiveGameState extends GameState implements Listener {

    private final GameManager gameManager;

    public ActiveGameState(GameManager gameManager) {
        super("ActiveGameState");
        this.gameManager = gameManager;
        super.init();
    }

    @EventHandler
    public void onPlayerDamage(PlayerDeathEvent event) {
        if (!(gameManager.getGameStates() == GameStates.ACTIVE)) return;

        Player player = event.getEntity();
        gameManager.getArena().removePlayerFromArena(player.getUniqueId());
        if (player.getKiller() == null || player.getKiller() == player) {
            GameUtils.broadcastMessage(SMessages.PLAYER_DEATH.getMessage(player.getDisplayName()));
            return;
        }

        Player killer = player.getKiller();
        GameUtils.broadcastMessage(SMessages.PLAYER_DEATH_BY_PLAYER.getMessage(player.getDisplayName(), killer.getDisplayName()));
    }
    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        if (!(gameManager.getGameStates() == GameStates.ACTIVE)) return;
        PlayerGameDeathEvent gameDeathEvent = new PlayerGameDeathEvent(event.getPlayer(), event.getPlayer().getKiller(), gameManager);
        Bukkit.getPluginManager().callEvent(gameDeathEvent);
    }
}
