package com.watsonllc.pure.events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.watsonllc.pure.Utils;

public class PlayerJoin implements Listener {
	
	private String name;
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		this.name = player.getName();
		
		if(player.hasPlayedBefore())
			event.setJoinMessage(join());
		else
			event.setJoinMessage(firstJoin());
		
	}
	
	private String firstJoin() {
		return Utils.color("&a"+name+" has joined for the first time!");
	}
	
	private String join() {
		return Utils.color("&a"+name+" has joined");
	}
}
