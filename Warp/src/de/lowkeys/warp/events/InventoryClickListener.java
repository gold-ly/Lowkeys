package de.lowkeys.warp.events;

import org.bukkit.EntityEffect;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.lowkeys.core.api.Common;
import de.lowkeys.warp.objects.Warp;

public class InventoryClickListener implements Listener{
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Inventory inventory = event.getClickedInventory();
		
		if(event.getView().getTitle().equalsIgnoreCase("§6Warps")) {
			event.setCancelled(true);
			
			if(event.getCurrentItem() != null) {
				ItemStack itemStack = event.getCurrentItem();
				
				String unfilteredWarpName = itemStack.getItemMeta().getDisplayName();
				String warpName = unfilteredWarpName.split("§6")[1];
				
				System.out.println(warpName);
				
				Warp warp = Warp.getWarpByName(warpName);
				
				event.getWhoClicked().teleport(warp.getLocation());
				event.getWhoClicked().sendMessage(Common.getPrefix() + "§7Du wurdest zum Warp §6" + warpName + " §7teleportiert!");
				event.getWhoClicked().getWorld().playSound(warp.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);
			}
		}
	}

}
