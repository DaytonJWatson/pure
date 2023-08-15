package com.watsonllc.pure.commands;

import com.watsonllc.pure.Main;
import com.watsonllc.pure.commands.admin.aSpawn;
import com.watsonllc.pure.commands.player.pBed;
import com.watsonllc.pure.commands.player.pHome;
import com.watsonllc.pure.commands.player.pSpawn;

public class Commands {
	public static void setup() {
		// admin
		Main.instance.getCommand("setspawn").setExecutor(new aSpawn());
		Main.instance.getCommand("removespawn").setExecutor(new aSpawn());
		
		// player
		Main.instance.getCommand("bed").setExecutor(new pBed());
		Main.instance.getCommand("spawn").setExecutor(new pSpawn());
		Main.instance.getCommand("home").setExecutor(new pHome());
		Main.instance.getCommand("sethome").setExecutor(new pHome());
		Main.instance.getCommand("removehome").setExecutor(new pHome());
	}
}