package me.kevind.commands;

import me.kevind.FreeOP;
import me.kevind.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class GmspCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0)  {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(ColorUtils.color(FreeOP.getPrefix() + "&eSet your gamemode to &cSpectator"));
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    target.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ColorUtils.color(FreeOP.getPrefix() + "&eSet &c" + target.getDisplayName() + "&e's gamemode to &cSpectator"));
                }else {
                    player.sendMessage(ColorUtils.color(FreeOP.getPrefix() + "&cThat player is not online!"));
                }
            }
        }
        return false;
    }
}
