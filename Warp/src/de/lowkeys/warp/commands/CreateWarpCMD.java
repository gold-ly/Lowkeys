package de.lowkeys.warp.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lowkeys.core.api.Common;
import de.lowkeys.warp.objects.Warp;

public class CreateWarpCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}		
		
		Player player = (Player) sender;
		
		if(!player.hasPermission("lowkeys.warp.createwarp")) {
			player.sendMessage(Common.getNoPerms());
			return false;
		}
		
		if(args.length == 1) {
			String warpName = args[0];
			String requiredPermission = "lowkeys.warp.warp";
			Location location = player.getLocation();
			
			Warp.createWarp(location, warpName, requiredPermission);
			player.sendMessage(Common.getPrefix() + "§7You created the Warp §6" + warpName);
			
			return false;
		}
		if(args.length == 2) {
			String warpName = args[0];
			String requiredPermission = args[1];
			Location location = player.getLocation();
			
			Warp.createWarp(location, warpName, requiredPermission);
			player.sendMessage(Common.getPrefix() + "§7You created the Warp §6" + warpName + "§7 with the permission §6" + requiredPermission + "!");
			return false;
		}
		
		

		return false;
	}

}
