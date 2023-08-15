package com.watsonllc.pure.commands.player;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.watsonllc.pure.config.Config;

public class pSpawn implements CommandExecutor {

	private Player player;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player player = (Player) sender;
		this.player = player;
		
		if(!(sender instanceof Player))
			return true;
		
		if(cmd.getName().equalsIgnoreCase("spawn")) {
			if(!sender.hasPermission("pure.spawn"))
				noPermission();
			
			if(!hasSpawn()) {
				player.sendMessage("Spawn location hasnt been set yet!");
				return true;
			}
			
			goSpawn();
			player.sendMessage("Taking you to the spawn!");
			return true;
		}
			
		
		return false;
	}
	
	private void goSpawn() {
		if(!hasSpawn())
			return;
		
		World world = Bukkit.getWorld(Config.getString("spawn.WORLD"));
		double x = Config.getDouble("spawn.X");
		double y = Config.getDouble("spawn.Y");
		double z = Config.getDouble("spawn.Z");
		float yaw = Config.getFloat("spawn.YAW");
		float pitch = Config.getFloat("spawn.PITCH");
		Location spawnLoc = new Location(world, x, y, z, yaw, pitch);
		
		player.teleport(spawnLoc);
	}
	
	private boolean hasSpawn() {
		if(Config.getString("spawn") == null)
			return false;
		else
			return true;
	}
	
	private void noPermission() {
		player.sendMessage("You dont have permission to do that.");
		return;
	}
}
