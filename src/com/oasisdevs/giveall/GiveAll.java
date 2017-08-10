package com.oasisdevs.giveall;

import com.oasisdevs.giveall.commands.GiveCmd;
import com.oasisdevs.giveall.commands.GiveallCmd;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Enderqura on 03/07/2017 at 19:31.
 */
public class GiveAll extends JavaPlugin {

    public void onEnable() {
        getLogger().info("Enabled");
        getCommand("giveall").setExecutor(new GiveallCmd());
        getCommand("give").setExecutor(new GiveCmd());
    }


    public void onDisable() {
        getLogger().info("Disabled");
    }
}
