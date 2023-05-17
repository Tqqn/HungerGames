package com.tqqn.hungergames.game.globallisteners;

import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.GameStates;
import lombok.AllArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

@AllArgsConstructor
public class GlobalBlockPlaceBreakListener implements Listener {

    private final GameManager gameManager;
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (gameManager.getGameStates() != GameStates.ACTIVE) event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (gameManager.getGameStates() != GameStates.ACTIVE) event.setCancelled(true);
    }
}
