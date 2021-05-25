package de.lowkeys.warp.objects;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.lowkeys.warp.main.WarpMain;

public class Warp {
	private static ArrayList<Warp> allWarps;
	private static FileConfiguration fileConfiguration;
	
	private Location location;
	private String name;
	private String requiredPermission;
	private String itemName;

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
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String name) {
		this.itemName = name;
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
		fileConfiguration.set("warps." + name + ".itemName", "STONE");
		
		List<String> warpNameList = (List<String>) fileConfiguration.getList("warplist");
		
		if(!warpNameList.contains(name)) {
			warpNameList.add(name);
			fileConfiguration.set("warplist", warpNameList);
		}
		
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
			String itemName = fileConfiguration.getString("warps." + name + ".itemName");
			
			Location location = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
			Warp warp = new Warp(location, name, requiredPermission);
			
			warp.setItemName(itemName);
			
			return warp;
		} catch (Exception e) {
			return null;
		}
	}

	public static Warp[] getAllWarps() {
		fileConfiguration = WarpMain.getInstance().getConfig();
		List<String> allWarps = (List<String>) fileConfiguration.getList("warplist");
		ArrayList<Warp> finalWarps = new ArrayList<>();
		
		for(String warpName : allWarps) {
			finalWarps.add(Warp.getWarpByName(warpName));
		}
		
		return finalWarps.toArray(new Warp[0]);
	}
	
	public static Warp[] getAllWarps(Player player) {
		fileConfiguration = WarpMain.getInstance().getConfig();
		List<String> allWarps = (List<String>) fileConfiguration.getList("warplist");
		ArrayList<Warp> finalWarps = new ArrayList<>();
		
		for(String warpName : allWarps) {
			Warp warp = Warp.getWarpByName(warpName);
			
			if(player.hasPermission(warp.getRequiredPermission())) {
				finalWarps.add(warp);
			}
		}
		
		return finalWarps.toArray(new Warp[0]);
	}
}
