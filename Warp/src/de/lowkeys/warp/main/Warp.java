package de.lowkeys.warp.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.lowkeys.core.api.Common;

public class Warp extends JavaPlugin {
	@Override
	public void onEnable() {
		Common.log("§7Warp loaded!");
	}
	
	@Override
	public void onDisable() {
		Common.log("§7Warp unloaded!");
	}
}
