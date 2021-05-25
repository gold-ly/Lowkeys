package de.lowkeys.warp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lowkeys.core.api.Common;
import de.lowkeys.warp.objects.Warp;

public class DelWarpCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		
		Player player = (Player) sender;
		
		if(!player.hasPermission("lowkeys.warp.delwarp")) {
			player.sendMessage(Common.getNoPerms());
			return false;
		}
		
		if(args.length != 1) {
			player.sendMessage(Common.getPrefix() + "§cBitte benutze /delwarp <Name>");
		}
		
		String warpName = args[0];
		
		Warp.removeWarp(warpName);
		
		player.sendMessage(Common.getPrefix() + "§7Der Warp §6" + warpName + "§7 wurde entfernt!");
		return false;
	}

}
