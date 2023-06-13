package com.tqqn.hungergames.game.globallisteners;

import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.GameStates;
import lombok.AllArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

@AllArgsConstructor
public class GlobalPlayerDamageListener implements Listener {

    private final GameManager gameManager;

    @EventHandler
    public void generalPlayerDamage(EntityDamageEvent event) {
        if (gameManager.getGameStates() == GameStates.ACTIVE) return;
        event.setCancelled(true);
    }
}
