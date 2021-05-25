package de.lowkeys.warp.objects;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import de.lowkeys.warp.main.WarpMain;

public class Warp {
	private static FileConfiguration fileConfiguration;
	
	private Location location;
	private String name;
	private String requiredPermission;

	public Warp(Location location, String name, String requiredPermission) {
		this.location = location;
		this.name = name;
		this.requiredPermission = requiredPermission;
	}

	public Location getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}
	
	public String getRequiredPermission() {
		return requiredPermission;
	}
	
	public static void createWarp(Location location, String name, String requiredPermission) {
		fileConfiguration = WarpMain.getInstance().getConfig();
		
		fileConfiguration.set("warps." + name + ".x", location.getX());
		fileConfiguration.set("warps." + name + ".y", location.getY());
		fileConfiguration.set("warps." + name + ".z", location.getZ());
		fileConfiguration.set("warps." + name + ".yaw", location.getYaw());
		fileConfiguration.set("warps." + name + ".pitch", location.getPitch());
		fileConfiguration.set("warps." + name + ".world", location.getWorld().getName());
		fileConfiguration.set("warps." + name + ".perms", requiredPermission);
		
		WarpMain.getInstance().saveConfig();
	}
	
	public static void removeWarp(String name) {
		fileConfiguration = WarpMain.getInstance().getConfig();
		
		fileConfiguration.set("warps." + name, null);
		WarpMain.getInstance().saveConfig();
	}
	
	public static Warp getWarpByName(String name) {
		fileConfiguration = WarpMain.getInstance().getConfig();
		
		try {
			double x = fileConfiguration.getDouble("warps." + name + ".x");
			double y = fileConfiguration.getDouble("warps." + name + ".y");
			double z = fileConfiguration.getDouble("warps." + name + ".z");
			float yaw = (float) fileConfiguration.getDouble("warps." + name + ".yaw");
			float pitch =(float) fileConfiguration.getDouble("warps." + name + ".pitch");
			String world = fileConfiguration.getString("warps." + name + ".world");
			String requiredPermission = fileConfiguration.getString("warps." + name + ".perms");

			
			Location location = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
			Warp warp = new Warp(location, name, requiredPermission);
			
			return warp;
		} catch (Exception e) {
			return null;
		}
	}
}
