package com.watsonllc.pure.commands.player;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class pHelp implements CommandExecutor {
	private Player player;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player player = (Player) sender;
		this.player = player;
		
		if(!(sender instanceof Player))
			return true;
		
		if(cmd.getName().equalsIgnoreCase("help")) {
			if(sender.hasPermission("pure.help"))
				noPermission();
			
			player.sendMessage("todo - help menu");
		}
		
		return false;
	}
	
	private void noPermission() {
		player.sendMessage("You dont have permission to do that.");
		return;
	}
}