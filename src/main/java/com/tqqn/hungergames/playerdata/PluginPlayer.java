package com.tqqn.hungergames.playerdata;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.GameStates;
import com.tqqn.hungergames.game.utils.GameUtils;
import com.tqqn.hungergames.messages.SMessages;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
public class PluginPlayer {

    private final UUID uuid;
    private final String displayName;
    private final Player player;
    private boolean isDeath;

    public PluginPlayer(UUID uuid, String displayName, Player player, boolean isDeath) {
        this.uuid = uuid;
        this.displayName = displayName;
        this.player = player;
        this.isDeath = isDeath;
    }

    public void handleSpectator() {
        HungerGames.getInstance().getGameManager().getArena().removeAlivePlayer(this);
        if (isDeath) return;
        player.setGameMode(GameMode.SPECTATOR);
        isDeath = true;
        Bukkit.getLogger().info("Set player to spectator.");

        Bukkit.getScheduler().scheduleSyncDelayedTask(HungerGames.getInstance(), () -> {
            player.spigot().respawn();
            if (player.getKiller() != null) {
                player.teleport(player.getKiller().getLocation());
            }
        },2L);
    }
}
