package de.lowkeys.core.main;

import de.lowkeys.core.api.User;
import de.lowkeys.core.events.JoinListener;
import de.lowkeys.core.events.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.lowkeys.core.api.Common;

public class Core extends JavaPlugin {
	@Override
	public void onEnable() {
		Common.log("§7Core loaded!");

		for(Player player : Bukkit.getOnlinePlayers()) {
			User user = new User(player);
		}

		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new JoinListener(), this);
		pluginManager.registerEvents(new QuitListener(), this);
	}

	@Override
	public void onDisable() {
		Common.log("§7Core unloaded!");
	}
}
