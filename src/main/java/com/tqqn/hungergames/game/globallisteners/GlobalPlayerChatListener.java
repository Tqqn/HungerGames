package com.tqqn.hungergames.game.globallisteners;

import com.tqqn.hungergames.game.utils.GameUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class GlobalPlayerChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        event.setCancelled(true);
        Player player = event.getPlayer();
        String playerMessage = event.getMessage();
        GameUtils.broadcastMessage(player.getDisplayName() + "&f: " + playerMessage);
    }
}
