package com.tqqn.hungergames.game.states.active;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.GameStates;
import com.tqqn.hungergames.game.arena.Arena;
import com.tqqn.hungergames.game.states.GameState;
import com.tqqn.hungergames.game.utils.GameUtils;
import com.tqqn.hungergames.messages.SMessages;
import com.tqqn.hungergames.playerdata.PluginPlayer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
        if (gameManager.getGameStates() != GameStates.ACTIVE && gameManager.getGameStates() != GameStates.END) return;

        Player player = event.getEntity();
        gameManager.getArena().getPlayerInArena(player.getUniqueId()).handleSpectator();

        gameManager.getArena().canEnd();

        if (player.getKiller() == null || player.getKiller() == player) {
            GameUtils.broadcastMessage(SMessages.PLAYER_DEATH.getMessage(player.getDisplayName()));
            gameManager.getArena().getPlayerInArena(player.getUniqueId()).handleSpectator();
            return;
        }

        Player killer = player.getKiller();
        GameUtils.broadcastMessage(SMessages.PLAYER_DEATH_BY_PLAYER.getMessage(player.getDisplayName(), killer.getDisplayName()));
    }
}
