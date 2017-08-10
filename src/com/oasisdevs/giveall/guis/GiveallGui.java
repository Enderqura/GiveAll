package com.oasisdevs.giveall.guis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Enderqura on 10/08/2017 at 18:30.
 */
public class GiveallGui implements Listener {

    private static GiveallGui instance = new GiveallGui();

    public static GiveallGui getInstance() {
        return instance;
    }

    private final String name = "§c§lGiveAll GUI §c[Close Inventory To Give]";

    private GiveallGui(){}

    public void open(Player player){

        Inventory inventory = Bukkit.createInventory(null, 27, name);
        player.openInventory(inventory);

    }

    @EventHandler
    public void invClose(InventoryCloseEvent e){

        if(e.getInventory().getName().equalsIgnoreCase(name)){

            if(e.getPlayer().hasPermission("giveall.giveallgui")){

                for(ItemStack item: e.getInventory().getContents()){

                    for(Player player : Bukkit.getOnlinePlayers()){

                        player.getInventory().addItem(item);
                        player.sendMessage("§a§l" + e.getPlayer().getName() + " gave everyone multiple items!");

                    }

                }

            }

        }

    }

}
