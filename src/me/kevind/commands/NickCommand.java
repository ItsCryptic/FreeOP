package me.kevind.commands;

import me.kevind.FreeOP;
import me.kevind.utils.ColorUtils;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(ColorUtils.color(FreeOP.getPrefix() + "&cYou must specify arguments!"));
            }

            if (args.length == 1) {
                player.setDisplayName(ColorUtils.color(args[0]));
                player.sendMessage(ColorUtils.color(FreeOP.getPrefix() + "&eSet your display name to " + args[0] + " &euntil next login!"));
            }
        }
        return false;
    }
}
