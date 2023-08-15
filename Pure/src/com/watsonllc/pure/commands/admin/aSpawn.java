package com.watsonllc.pure.commands.admin;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.watsonllc.pure.config.Config;

public class aSpawn implements CommandExecutor {

	private Player player;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player player = (Player) sender;
		this.player = player;
		
		if(!(sender instanceof Player))
			return true;
		
		// set spawn command
		if(cmd.getName().equalsIgnoreCase("setspawn")) {
			if(!sender.hasPermission("pure.spawn.admin"))
				noPermission();
			
			setSpawn();
			player.sendMessage("[ADMIN] You set the spawn location.");
			return true;
		}
		
		// remove spawn command
		if(cmd.getName().equalsIgnoreCase("removespawn")) {
			if(!sender.hasPermission("pure.spawn.admin"))
				noPermission();
			
			if(!hasSpawn()) {
				player.sendMessage("[ADMIN] Spawn null");
				return true;
			}
			
			removeSpawn();
			player.sendMessage("[ADMIN] You removed the spawn location.");
			return true;
		}
		return false;
	}
	
	private void noPermission() {
		player.sendMessage("You dont have permission to do that.");
		return;
	}
	
	private boolean hasSpawn() {
		if(Config.getString("spawn.WORLD").equals(null))
			return false;
		else
			return true;
	}
	
	private void setSpawn() {
		Location loc = player.getLocation();
		Config.set("spawn.WORLD", loc.getWorld().getName());
		Config.set("spawn.X", loc.getX());
		Config.set("spawn.Y", loc.getY());
		Config.set("spawn.Z", loc.getZ());
		Config.set("spawn.YAW", loc.getYaw());
		Config.set("spawn.PITCH", loc.getPitch());
		Config.save();
	}
	
	private void removeSpawn() {
		Config.set("spawn", null);
		Config.save();
	}
}