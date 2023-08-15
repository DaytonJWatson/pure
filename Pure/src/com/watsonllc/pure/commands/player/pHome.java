package com.watsonllc.pure.commands.player;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.watsonllc.pure.config.Homes;

public class pHome implements CommandExecutor {
	private Player player;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player player = (Player) sender;
		this.player = player;
		Homes homes = new Homes(player);
		
		if(!(sender instanceof Player))
			return true;
		
		if(cmd.getName().equalsIgnoreCase("home")) {
			if(!sender.hasPermission("pure.home"))
				noPermission();
			
			if(!homes.hasHome()) {
				player.sendMessage("You dont have a home!");
				return true;
			} else {
				homes.goHome();
				player.sendMessage("Taking you to your home!");
				return true;
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("sethome")) {
			if(!sender.hasPermission("pure.home.set"))
				noPermission();
			
			homes.setHome();
			player.sendMessage("You set your home at this location!");
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("removehome")) {
			if(!sender.hasPermission("pure.home.remove"))
				noPermission();
			
			homes.removeHome();
			player.sendMessage("You removed your home location!");
			return true;
		}
		
		return false;
	}
	
	private void noPermission() {
		player.sendMessage("You dont have permission to do that.");
		return;
	}
}