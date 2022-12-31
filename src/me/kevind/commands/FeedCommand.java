package me.kevind.commands;

import me.kevind.FreeOP;
import me.kevind.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("freeop.feed")) {
                if (args.length == 0) {
                    player.setFoodLevel(20);
                    player.setSaturation(20);
                    player.sendMessage(ColorUtils.color(FreeOP.getPrefix() + "Your appetite has been sated"));
                    return false;
                }
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        target.setFoodLevel(20);
                        target.setSaturation(20);
                        player.sendMessage(ColorUtils.color(FreeOP.getPrefix() + target.getDisplayName() + "&e's appetite has been sated"));
                        return false;
                    }
                }else {
                    player.sendMessage(ColorUtils.color(FreeOP.getPrefix() + "&cThat player isn't online!"));
                }
            }
        }else {
            sender.sendMessage("You must be a player to use that command!");
        }
        return false;
    }
}
