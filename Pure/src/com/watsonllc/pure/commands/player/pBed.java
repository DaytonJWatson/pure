package com.watsonllc.pure.commands.player;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class pBed implements CommandExecutor {

	private Player player;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player player = (Player) sender;
		this.player = player;
		
		if(!(sender instanceof Player))
			return true;
		
		if(cmd.getName().equalsIgnoreCase("bed")) {
			if(!sender.hasPermission("pure.bed"))
				noPermission();
			
			if(bedNull()) {
				player.sendMessage("Your bed is missing or obstructed!");
				return true;
			}
			
			player.teleport(player.getBedSpawnLocation());
			player.sendMessage("Taking you to your bed!");
			return true;
		}
		
		return false;
	}
	
	private boolean bedNull() {
		if(player.getBedSpawnLocation() == null)
			return true;
		else
			return false;
	}
	
	private void noPermission() {
		player.sendMessage("You dont have permission to do that.");
		return;
	}
}