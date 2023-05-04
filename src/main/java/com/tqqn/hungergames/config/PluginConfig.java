package com.tqqn.hungergames.config;

import com.tqqn.hungergames.HungerGames;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class PluginConfig {

    private final HungerGames plugin;

    public PluginConfig(HungerGames plugin) {
        this.plugin = plugin;
    }

    public String getPrefix() {
        return plugin.getConfig().getString("prefix");
    }

    public int getMaxPlayers() {
        return plugin.getConfig().getInt("max-players");
    }

    public int getMinPlayers() {
        return plugin.getConfig().getInt("min-players");
    }

    public List<Location> getSpawnLocations() {
        List<Location> spawnLocations = new ArrayList<>();
        for (String locationkey : plugin.getConfig().getConfigurationSection("arena.spawn-locations").getKeys(false)) {
            spawnLocations.add(getSpawnLocations(locationkey));
        }
        return spawnLocations;
    }

    private Location getSpawnLocations(String key) {
        return new Location(
                Bukkit.getWorld(plugin.getConfig().getString("arena.world")),
                plugin.getConfig().getDouble("arena.spawn-locations." + key + ".x"),
                plugin.getConfig().getDouble("arena.spawn-locations." + key + ".y"),
                plugin.getConfig().getDouble("arena.spawn-locations." + key + ".z"),
                (float) plugin.getConfig().getDouble("arena.spawn-locations." + key + ".pitch"),
                (float) plugin.getConfig().getDouble("arena.spawn-locations." + key + ".pitch"));
    }
}
