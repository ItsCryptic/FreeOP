package me.kevind.listeners;

import me.kevind.FreeOP;
import me.kevind.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public final class BlockPlaceListener implements Listener {
    @EventHandler
    public void onBlockPlaceListener(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        Block block = e.getBlockPlaced();
        if (block.getType() == Material.BEDROCK) {
            block.setType(Material.AIR);
            player.sendMessage(ColorUtils.color(FreeOP.getPrefix() + "&cYou are not allowed to place BEDROCK"));
        }
        if (block.getType() == Material.FIRE) {
            block.setType(Material.AIR);
            player.sendMessage(ColorUtils.color(FreeOP.getPrefix() + "&cYou are not allowed to place FIRE"));
        }
        if (block.getType() == Material.TNT) {
            block.setType(Material.AIR);
            player.sendMessage(ColorUtils.color(FreeOP.getPrefix() + "&cYou are not allowed to place TNT"));
        }
    }
}
