package com.tqqn.hungergames.game.states.active.handlers;

import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.events.PlayerGameDeathEvent;
import com.tqqn.hungergames.game.utils.GameUtils;
import com.tqqn.hungergames.messages.SMessages;
import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

@AllArgsConstructor
public class PlayerDeathHandler implements Listener {

    private GameManager gameManager;

    @EventHandler
    public void onPlayerDamage(PlayerDeathEvent event) {
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
        PlayerGameDeathEvent gameDeathEvent = new PlayerGameDeathEvent(event.getPlayer(), event.getPlayer().getKiller(), gameManager);
        Bukkit.getPluginManager().callEvent(gameDeathEvent);
    }
}
