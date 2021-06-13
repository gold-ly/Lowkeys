package de.lowkeys.clan.main;

import de.lowkeys.clan.commands.ClanCMD;
import de.lowkeys.core.api.Common;
import org.bukkit.plugin.java.JavaPlugin;

public class ClanMain extends JavaPlugin {
    @Override
    public void onEnable() {
        Common.log("§7Clan loaded!");

        this.getCommand("clan").setExecutor(new ClanCMD());
    }

    @Override
    public void onDisable() {
        Common.log("§7Clan unloaded!");
    }
}
