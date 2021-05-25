package de.lowkeys.warp.commands;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lowkeys.core.api.Common;
import de.lowkeys.warp.objects.Warp;

public class WarpCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {

		if (!(sender instanceof Player)) {
			return false;
		}

		Player player = (Player) sender;

		if (!player.hasPermission("lowkeys.warp.warp")) {
			player.sendMessage(Common.getNoPerms());

			return false;
		}
		
		if(args.length != 1) {
			player.sendMessage(Common.getPrefix() + "§cBitte benutze /warp <Name>");
			return false;
		}
		
		String warpName = args[0];
		Warp warp = Warp.getWarpByName(warpName);
		
		if(warp == null) {
			player.sendMessage(Common.getPrefix() + "§cDieser Warp existiert nicht!");
			return false;
		}
		if(!player.hasPermission(warp.getRequiredPermission())) {
			player.sendMessage(Common.getNoPerms());
			return false;
		}
		
		Location location = warp.getLocation();
		player.teleport(location);
		
		player.sendMessage(Common.getPrefix() + "§7Du wurdest zum Warp §6" + warpName + " §7teleportiert!");
		player.getWorld().playSound(warp.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);


		return false;
	}

}
