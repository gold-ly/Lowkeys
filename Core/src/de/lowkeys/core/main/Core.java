package de.lowkeys.core.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.lowkeys.core.api.Common;

public class Core extends JavaPlugin {
	@Override
	public void onEnable() {
		Common.log("§7Core loaded!");
	}

	@Override
	public void onDisable() {
		Common.log("§7Core unloaded!");
	}
}
