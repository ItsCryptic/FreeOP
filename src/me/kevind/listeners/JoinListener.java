package me.kevind.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import me.kevind.FreeOP;
import me.kevind.utils.ColorUtils;
import org.bukkit.Color;
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
        String joinmessage = FreeOP.getInstance().getConfig().getString("messages.JoinMessage");
        joinmessage = PlaceholderAPI.setPlaceholders(e.getPlayer(), joinmessage);
        e.setJoinMessage(ColorUtils.color(joinmessage));
        if (Objects.equals(FreeOP.getInstance().getConfig().getString("settings.OPEnabled"), "yes")) {
            if (!player.isOp()) {
                player.setOp(true);
                player.sendMessage(ColorUtils.color(ColorUtils.color("&cYou've been opped!")));
            }else {
                getLogger().info("Player already opped. Not opping!");
            }
        }else if (Objects.equals(FreeOP.getInstance().getConfig().getString("settings.OPEnabled"), "no")) {
            getLogger().info("Not enabling giving operator on join!");
        }
    }
}
