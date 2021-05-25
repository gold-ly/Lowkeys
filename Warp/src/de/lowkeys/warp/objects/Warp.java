package de.lowkeys.warp.objects;

import org.bukkit.Location;

public class Warp {
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
}
