package IgnitionInventory;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

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
