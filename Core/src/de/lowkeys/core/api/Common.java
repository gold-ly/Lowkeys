package de.lowkeys.core.api;

import org.bukkit.Bukkit;

public class Common {
	private static String prefix = "§7[§6Core§7] ";
	
	public static void log(String msg) {
		Bukkit.getConsoleSender().sendMessage(prefix + msg);
	}
}
