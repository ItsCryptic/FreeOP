package me.kevind.listeners;

import me.kevind.FreeOP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public final class QuitListener implements Listener {
    @EventHandler
    public void onQuitEvent(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(FreeOP.getInstance().getConfig().getString("messages.Prefix") + FreeOP.getInstance().getConfig().getString("messages.QuitMessage"));
    }
}
