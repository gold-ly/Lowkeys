package de.lowkeys.core.api;

import org.bukkit.Bukkit;

public class Common {
	private static String prefix = "§7[§6Core§7] ";
	private static String noPerms = prefix + "§cDazu hast du keine Berechtigung!";

	public static void log(String msg) {
		Bukkit.getConsoleSender().sendMessage(prefix + msg);
	}

	public static String getPrefix() {
		return prefix;
	}

	public static String getNoPerms() {
		return noPerms;
	}
}
