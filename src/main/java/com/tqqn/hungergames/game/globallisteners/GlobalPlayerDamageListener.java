package com.tqqn.hungergames.game.globallisteners;

import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.GameStates;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class GlobalPlayerDamageListener implements Listener {

    private final GameManager gameManager;

    public GlobalPlayerDamageListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        if (gameManager.getGameStates() == GameStates.ACTIVE) return;
        if (!(event.getDamager() instanceof Player || event.getEntity() instanceof Player)) return;

        event.setCancelled(true);
    }
}
