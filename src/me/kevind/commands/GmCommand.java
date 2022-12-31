package me.kevind.commands;

import me.kevind.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof Player) {
            if (args.length == 0) {
                player.sendMessage(ColorUtils.color("&cPlease specify arguments!: c, sp, s, a"));
                return false;
            }
            if (args[0].equalsIgnoreCase("c")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ColorUtils.color("&eSet your gamemode to &cCreative"));
            }
            if (args[0].equalsIgnoreCase("s")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ColorUtils.color("&eSet your gamemode to &cSurvival"));
            }
            if (args[0].equalsIgnoreCase("sp")) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(ColorUtils.color("&eSet your gamemode to &cSpectator"));
            }
            if (args[0].equalsIgnoreCase("a")) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(ColorUtils.color("&eSet your gamemode to &cAdventure"));
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (args[0].equalsIgnoreCase("c")) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(ColorUtils.color("&eSet" + target.getDisplayName() + "gamemode to &cCreative"));
                    }
                    if (args[0].equalsIgnoreCase("s")) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(ColorUtils.color("&eSet" + target.getDisplayName() + "gamemode to &cSurvival"));
                    }
                    if (args[0].equalsIgnoreCase("sp")) {
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(ColorUtils.color("&eSet" + target.getDisplayName() + "gamemode to &cSpectator"));
                    }
                    if (args[0].equalsIgnoreCase("a")) {
                        target.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(ColorUtils.color("&eSet" + target.getDisplayName() + "gamemode to &cAdventure"));
                    }
                }
            }
        }else {
            sender.sendMessage("You must be a player to use this command.");
        }
        return false;
    }
}
