package com.tqqn.hungergames.game.tasks;

import com.tqqn.hungergames.game.GameManager;
import com.tqqn.hungergames.game.GameStates;
import com.tqqn.hungergames.game.utils.GameUtils;
import com.tqqn.hungergames.messages.SMessages;
import org.bukkit.scheduler.BukkitRunnable;

public class EndCountdownTask extends BukkitRunnable {

    private int endGameTime = 10;

    private final GameManager gameManager;

    public EndCountdownTask(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public void run() {
        if (endGameTime == 0) {
            cancel();
            gameManager.setGameState(GameStates.END);
            return;
        }

        GameUtils.broadcastMessage(SMessages.GAME_END_COUNTDOWN.getMessage(String.valueOf(endGameTime)));
        endGameTime--;
    }
}
