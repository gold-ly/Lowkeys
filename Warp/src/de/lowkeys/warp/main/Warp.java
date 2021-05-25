package de.lowkeys.warp.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.lowkeys.core.api.Common;
import de.lowkeys.warp.commands.CreateWarpCMD;
import de.lowkeys.warp.commands.WarpCMD;

public class Warp extends JavaPlugin {
	@Override
	public void onEnable() {
		this.getCommand("warp").setExecutor(new WarpCMD());
		this.getCommand("createwarp").setExecutor(new CreateWarpCMD());

		Common.log("§7Warp loaded!");
	}

	@Override
	public void onDisable() {
		Common.log("§7Warp unloaded!");
	}
}
