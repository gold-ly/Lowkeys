package de.lowkeys.warp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lowkeys.core.api.Common;
import de.lowkeys.warp.objects.Warp;

public class EditWarpCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {
		if(!(sender instanceof Player)) return false;
		
		Player player = (Player) sender;
		
		if(!player.hasPermission("lowkeys.warp.editwarp")) {
			player.sendMessage(Common.getNoPerms());
		}
		
		if(args.length != 1) {
			player.sendMessage(Common.getPrefix() + "§cBitte benutze /editwarp <Name>");
			return false;
		}
		
		Warp warp = Warp.getWarpByName(args[0]);
		if(warp == null) {
			player.sendMessage(Common.getPrefix() + "§cDieser Warp existiert nicht!");
		}
		
		Warp.createWarp(player.getLocation(), args[0], warp.getRequiredPermission());
		
		player.sendMessage(Common.getPrefix() + "§7Der Warp §6" + warp.getName() + " §7wurde geändert!");
		
		return false;
	}

}
