package me.DuckyProgrammer.EASimulator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Announce implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (!player.getUniqueId().toString().equals("9469e409-5a67-4af5-b4dd-e26624a66301")) {
                return false;
            }
            StringBuilder message = new StringBuilder();
            for (String arg : args) {
                message.append(arg).append(" ");
            }
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message.toString()));
            return true;
        }
        StringBuilder message = new StringBuilder();
        for (String arg : args) {
            message.append(arg).append(" ");
        }
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message.toString()));
        return true;
    }
}
