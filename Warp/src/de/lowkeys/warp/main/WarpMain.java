package de.lowkeys.warp.main;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

import de.lowkeys.core.api.Common;
import de.lowkeys.warp.commands.CreateWarpCMD;
import de.lowkeys.warp.commands.DelWarpCMD;
import de.lowkeys.warp.commands.EditWarpCMD;
import de.lowkeys.warp.commands.WarpCMD;
import de.lowkeys.warp.commands.WarpsCMD;
import de.lowkeys.warp.events.InventoryClickListener;

public class WarpMain extends JavaPlugin {
	private static WarpMain INSTANCE;
	
	@Override
	public void onEnable() {
		INSTANCE = this;
		
		this.getCommand("warp").setExecutor(new WarpCMD());
		this.getCommand("createwarp").setExecutor(new CreateWarpCMD());
		this.getCommand("delwarp").setExecutor(new DelWarpCMD());
		this.getCommand("editwarp").setExecutor(new EditWarpCMD());
		this.getCommand("warps").setExecutor(new WarpsCMD());
		
		this.getConfig().addDefault("warplist", new ArrayList<>());
		
		this.getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();

		Common.log("?7Warp loaded!");
	}

	@Override
	public void onDisable() {
		Common.log("?7Warp unloaded!");
	}
	
	public static WarpMain getInstance() {
		return INSTANCE;
	}
}
