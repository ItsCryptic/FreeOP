package me.kevind;

import me.kevind.commands.*;
import me.kevind.listeners.BlockPlaceListener;
import me.kevind.listeners.ChatListener;
import me.kevind.listeners.JoinListener;
import me.kevind.listeners.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class FreeOP extends JavaPlugin {
    private static FreeOP instance;
    public static FreeOP getInstance() {
        return instance;
    }
    public static String getPrefix() {
        return instance.getConfig().getString("messages.Prefix");
    }
    public void onEnable() {

        instance = this;

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            getLogger().info("Using PlaceholderAPI");
        }else {
            getLogger().warning("Please install PlaceholderAPI!");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        getLogger().info("Setting gamerules...");
        for (World world : Bukkit.getWorlds()) {
            world.setGameRule(GameRule.SEND_COMMAND_FEEDBACK, false);
            world.setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, false);
        }

        getLogger().info("Registering commands...");
        getCommand("gmc").setExecutor(new GmcCommand());
        getCommand("gms").setExecutor(new GmsCommand());
        getCommand("gm").setExecutor(new GmCommand());
        getCommand("gma").setExecutor(new GmaCommand());
        getCommand("gmsp").setExecutor(new GmspCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("nick").setExecutor(new NickCommand());

        getLogger().info("Registering events...");
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new QuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(), this);
        saveDefaultConfig();

        getLogger().info("Done!");
    }
    public void onDisable() {

    }
}
