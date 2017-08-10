package com.oasisdevs.giveall.commands;

import com.oasisdevs.giveall.guis.GiveallGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Enderqura on 10/08/2017 at 18:27.
 */
public class GiveallguiCmd implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("giveallgui")){

            if(sender instanceof Player){

                Player player = (Player) sender;

                if(player.hasPermission("giveall.giveallgui")){

                    GiveallGui.getInstance().open(player);


                    return true;
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
