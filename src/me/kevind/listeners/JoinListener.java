package me.kevind.listeners;

import me.kevind.FreeOP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

import static org.bukkit.Bukkit.getLogger;

public final class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage(FreeOP.getPrefix() + FreeOP.getInstance().getConfig().getString( "messages.JoinMessage"));
        if (Objects.requireNonNull(FreeOP.getInstance().getConfig().getString("settings.FreeOPEnabled?")).equalsIgnoreCase("true")) {
            player.setOp(true);
        }else if (Objects.requireNonNull(FreeOP.getInstance().getConfig().getString("settings.FreeOPEnabled?")).equalsIgnoreCase("false")) {
            getLogger().info("Not enabling giving operator on join!");
        }
    }
}
