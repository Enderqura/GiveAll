package com.oasisdevs.giveall.guis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Enderqura on 10/08/2017 at 18:56.
 */
public class GiveGui implements Listener {

    private static GiveGui instance = new GiveGui();

    public static GiveGui getInstance() {
        return instance;
    }

    private final String name = "§c§lGive GUI §c[Close Inventory To Give] ";

    private GiveGui(){}

    public void open(Player player, Player target){

        Inventory inventory = Bukkit.createInventory(null, 27, name + "-" +target.getName());
        player.openInventory(inventory);

    }

    @EventHandler
    public void invClose(InventoryCloseEvent e){

        if(e.getInventory().getName().startsWith(name)){

            Player target = Bukkit.getPlayer(e.getInventory().getName().split("-")[1]);

            if(e.getPlayer().hasPermission("giveall.givegui")){

                for(ItemStack item: e.getInventory().getContents()){

                    target.getInventory().addItem(item);
                    target.sendMessage("§a§l" + e.getPlayer().getName() + " gave you multiple items!");

                }

            }

        }

    }

}
