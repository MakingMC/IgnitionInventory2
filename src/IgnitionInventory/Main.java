package IgnitionInventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    public static boolean EnderEnabled = true;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        switch (label.toLowerCase()) {
            case "toggleender": {
                Player player = (Player) sender;
                if(player.isOp()) {
                    if (EnderEnabled) {
                        EnderEnabled = false;
                        player.sendMessage(String.format("%s%sYou have toggled EnderChests on", ChatColor.GREEN, ChatColor.BOLD));
                    } else {
                        EnderEnabled = true;
                        player.sendMessage(String.format("%s%sYou have toggled EnderChests off", ChatColor.RED, ChatColor.BOLD));
                    }
                }
                else{
                    player.sendMessage(ChatColor.RED + "You are not op!");
                }
                break;
            }
            default: {
                break;
            }
        }
        return true;
    }
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) {
        if (!e.getPlayer().isOp()) {
            if (e.getInventory().getType().equals(InventoryType.CHEST) || e.getInventory().getType().equals(InventoryType.ENCHANTING)) {
                e.setCancelled(false);
            }
            else{
                e.setCancelled(true);
            }
        }
    }
}
