package com.oasisdevs.giveall.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Enderqura on 03/07/2017 at 19:59.
 */
public class GiveCmd implements CommandExecutor {

    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("give")){

            if(sender instanceof Player){

                Player player = (Player) sender;

                if(player.hasPermission("giveall.give")){

                    if(args.length == 1) {

                        Player target = Bukkit.getPlayer(args[0]);

                        if(target == null){

                            player.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + args[0] + " is offline!");
                            return true;
                        }

                        ItemStack item = player.getItemInHand();

                        String amount = String.valueOf(item.getAmount());
                        String itemName = item.getItemMeta().getDisplayName();
                        String itemType = item.getType().name();

                        target.getInventory().addItem(item);

                        target.sendMessage(ChatColor.BLUE + player.getName() + ChatColor.AQUA + " gave you " + ChatColor.BLUE + amount + " " + itemName + " (" + itemType + ")" + ChatColor.AQUA + "!");

                        return true;
                    }else{

                        player.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "Usage: /give [player]!");
                        return true;

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
