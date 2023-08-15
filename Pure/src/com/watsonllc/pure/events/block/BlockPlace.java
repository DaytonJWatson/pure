package com.watsonllc.pure.events.block;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.watsonllc.pure.Utils;

public class BlockPlace implements Listener {
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		Material block = event.getBlock().getType();
		
		if(blacklisted(block)) {
			event.setCancelled(true);
			player.sendMessage(cantPlace());
		}
	}
	
	private String cantPlace() {
		return Utils.color("&cYou can't place that!");
	}
	
	private boolean blacklisted(Material mat) {
		switch(mat) {
		case LAVA:
			return true;
		case LAVA_BUCKET:
			return true;
		case TNT_MINECART:
			return true;
		case TNT:
			return true;
		default:
			return false;
		}	
	}
}
