package de.lowkeys.quest.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.lowkeys.core.api.Common;

public class QuestMain extends JavaPlugin {
	@Override
	public void onEnable() {
		Common.log("§7Quest loaded!");
	}
	
	@Override
	public void onDisable() {
		Common.log("§7Quest unloaded!");
	}

}
