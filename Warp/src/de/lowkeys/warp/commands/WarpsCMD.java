package de.lowkeys.warp.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.lowkeys.core.api.Common;
import de.lowkeys.warp.objects.Warp;

public class WarpsCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {
		
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		
		if(!player.hasPermission("lowkeys.warp.warpmenu")) {
			player.sendMessage(Common.getNoPerms());
			return false;
		}
		
		Warp[] allowedWarps = Warp.getAllWarps(player);
		
		Inventory inventory = Bukkit.createInventory(null, 1*9, "§6Warps");
		
		for(Warp warp : allowedWarps) {
			String itemName = warp.getItemName();
			
			
			ItemStack itemStack = new ItemStack(Material.valueOf(itemName));
			ItemMeta itemMeta = itemStack.getItemMeta();
			itemMeta.setDisplayName("§6" + warp.getName());
			itemStack.setItemMeta(itemMeta);
			
			inventory.addItem(itemStack);
		}
		
		player.openInventory(inventory);
		
		return false;
	}

}
