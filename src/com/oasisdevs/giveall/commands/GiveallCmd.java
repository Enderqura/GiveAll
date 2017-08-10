package com.oasisdevs.giveall.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enderqura on 03/07/2017 at 19:33.
 */
public class GiveallCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("giveall")){

            if(sender instanceof Player){

                Player player = (Player) sender;

                if(player.hasPermission("giveall.giveall")){

                    if(args.length == 0) {

                        ItemStack item = player.getItemInHand();
                        String amount = String.valueOf(item.getAmount());
                        String itemName = item.getItemMeta().getDisplayName();
                        String itemType = item.getType().name();

                        for (Player online : Bukkit.getOnlinePlayers()) {

                            online.getInventory().addItem(item);


                        }

                        Bukkit.broadcastMessage(ChatColor.BLUE + player.getName() + ChatColor.AQUA + " gave everyone " + ChatColor.BLUE + amount + " " + itemName + ChatColor.BLUE + " (" + itemType + ")" + ChatColor.AQUA + "!");

                        return true;

                    }

                    if(args.length == 1){

                        int radius;

                        try{

                            radius = Integer.parseInt(args[0]);

                        }catch(NumberFormatException e){

                            player.sendMessage("§4Error: §cYou need to enter a number!");
                            return true;

                        }

                        for(Entity entity : player.getNearbyEntities(radius, radius, radius)){

                            if(entity instanceof Player){

                                ((Player) entity).getInventory().addItem()

                            }

                        }



                    }


                }else{

                    player.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "Not enough permissions!");
                    return true;

                }

            }else{

                sender.sendMessage("You must be a player to use this command.");
                return true;

            }

        }

        return false;
    }
}
