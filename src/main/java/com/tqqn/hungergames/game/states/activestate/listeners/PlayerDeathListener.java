package com.tqqn.hungergames.game.states.activestate.listeners;

import com.tqqn.hungergames.game.utils.GameUtils;
import com.tqqn.hungergames.messages.SMessages;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

@AllArgsConstructor
public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDamage(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (player.getKiller() == null || player.getKiller() == player) {
            GameUtils.broadcastMessage(SMessages.PLAYER_DEATH.getMessage(player.getDisplayName()));
            return;
        }

        Player killer = player.getKiller();
        GameUtils.broadcastMessage(SMessages.PLAYER_DEATH_BY_PLAYER.getMessage(player.getDisplayName(), killer.getDisplayName()));
    }
}
