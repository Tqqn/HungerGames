package com.tqqn.hungergames.game.commands;

import com.tqqn.hungergames.HungerGames;
import com.tqqn.hungergames.game.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GameStartCommand implements CommandExecutor {

    private final HungerGames plugin;
    private final GameManager gameManager;

    public GameStartCommand(HungerGames plugin) {
        this.plugin = plugin;
        this.gameManager = plugin.getGameManager();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return true;
    }
}
