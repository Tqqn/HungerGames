package com.tqqn.hungergames.sounds;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.injector.PacketConstructor;
import com.tqqn.hungergames.HungerGames;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public enum Sounds {

    COUNTDOWN_SOUND(Sound.BLOCK_DISPENSER_FAIL, 0.5, 1.5);

    private final Sound sound;
    private final double volume;
    private final double pitch;

    Sounds(Sound sound, double volume, double pitch) {
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
    }

    public void playSound(Player player) {
        player.playSound(player.getLocation(), this.sound, (float) this.volume, (float) this.pitch);
    }

    public void playPacketSound(Player player) {
        Location location = player.getLocation();
        ProtocolManager protocolManager = HungerGames.getProtocolManager();
        PacketContainer packetContainer = protocolManager.createPacket(PacketType.Play.Server.NAMED_SOUND_EFFECT);
        packetContainer.getModifier().writeDefaults();
        packetContainer.getSoundEffects().write(0, this.sound);
        packetContainer.getIntegers().write(0, location.getBlockX() * 8).write(1, location.getBlockY() * 8).write(2, location.getBlockZ() * 8);
        packetContainer.getFloat().write(0, (float) this.volume).write(1, (float) this.pitch);

        try {
            protocolManager.sendServerPacket(player, packetContainer);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
