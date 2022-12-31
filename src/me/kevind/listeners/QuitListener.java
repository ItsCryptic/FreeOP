package me.kevind.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import me.kevind.FreeOP;
import me.kevind.utils.ColorUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public final class QuitListener implements Listener {
    @EventHandler
    public void onQuitEvent(PlayerQuitEvent e) {
        String quitmessage = FreeOP.getInstance().getConfig().getString("messages.QuitMessage");
        quitmessage = PlaceholderAPI.setPlaceholders(e.getPlayer(), quitmessage);
        e.setQuitMessage(ColorUtils.color(quitmessage));
    }
}
