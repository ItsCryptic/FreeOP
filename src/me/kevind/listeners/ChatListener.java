package me.kevind.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public final class ChatListener implements Listener {
    @EventHandler
    public void onChatEvent(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        e.setFormat("&8(&cOP&8) &c" + player.getPlayer().getDisplayName() + "&8&l» &f" + e.getMessage());
    }
}
