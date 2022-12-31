package me.kevind.commands;

import me.kevind.utils.ColorUtils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class GmcCommand implements CommandExecutor {
    @Override
    public final boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof Player) {
            if (player.hasPermission("freeop.gmc")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage();
            }else {
                sender.sendMessage(ColorUtils.color("&cYou do not have permission to run this command!"));
            }

        }
        return false;
    }
}
