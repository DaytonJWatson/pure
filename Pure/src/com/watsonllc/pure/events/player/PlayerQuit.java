package com.watsonllc.pure.events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.watsonllc.pure.Utils;

public class PlayerQuit implements Listener {
	
	private String name;
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		this.name = player.getName();
		
		event.setQuitMessage(quit());
	}
	
	private String quit() {
		return Utils.color("&c"+name+" has left");
	}	
}