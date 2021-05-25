package de.lowkeys.warp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lowkeys.core.api.Common;

public class DelWarpCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		
		Player player = (Player) sender;
		
		if(!player.hasPermission("lowkeys.warp.createwarp")) {
			player.sendMessage(Common.getNoPerms());
			return false;
		}
		
		return false;
	}

}
