package de.lowkeys.warp.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.lowkeys.core.api.Common;
import de.lowkeys.warp.commands.CreateWarpCMD;
import de.lowkeys.warp.commands.WarpCMD;

public class WarpMain extends JavaPlugin {
	private static WarpMain INSTANCE;
	
	@Override
	public void onEnable() {
		INSTANCE = this;
		
		this.getCommand("warp").setExecutor(new WarpCMD());
		this.getCommand("createwarp").setExecutor(new CreateWarpCMD());

		Common.log("§7Warp loaded!");
	}

	@Override
	public void onDisable() {
		Common.log("§7Warp unloaded!");
	}
	
	public static WarpMain getInstance() {
		return INSTANCE;
	}
}
