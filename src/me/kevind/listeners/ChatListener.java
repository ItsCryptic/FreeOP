package me.kevind.listeners;

import me.kevind.utils.ColorUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public final class ChatListener implements Listener {
    @EventHandler
    public void onChatEvent(AsyncPlayerChatEvent e) {
        e.setFormat(ColorUtils.color("&8(&4&lOP&8) &c%s &8&l» &f%s"));
    }
}
