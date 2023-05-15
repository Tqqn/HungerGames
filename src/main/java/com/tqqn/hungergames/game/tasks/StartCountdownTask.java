package com.tqqn.hungergames.game.tasks;

import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.GameStates;
import com.tqqn.hungergames.game.utils.GameUtils;
import com.tqqn.hungergames.messages.NMessages;
import com.tqqn.hungergames.messages.SMessages;
import com.tqqn.hungergames.sounds.Sounds;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class StartCountdownTask extends BukkitRunnable {

    private int startGameTime = 10;

    private final GameManager gameManager;

    public StartCountdownTask(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public void run() {
        if (startGameTime == 0) {
            cancel();
            gameManager.setGameState(GameStates.ACTIVE);
            return;
        }
        if (gameManager.getArena().getPlayersInArena().size() < gameManager.getArena().getMinimumPlayers()) {
            cancel();
            gameManager.setGameState(GameStates.WAITING);
            GameUtils.broadcastMessage(NMessages.CANCEL_RESTART_NOT_ENOUGH_PLAYERS.getMessage());
        }

        Bukkit.getOnlinePlayers().forEach(Sounds.COUNTDOWN_SOUND::playPacketSound);
        GameUtils.broadcastMessage(SMessages.GAME_START_COUNTDOWN.getMessage(String.valueOf(startGameTime)));
        startGameTime--;
    }
}
