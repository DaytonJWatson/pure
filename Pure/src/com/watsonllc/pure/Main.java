package com.watsonllc.pure;

import org.bukkit.plugin.java.JavaPlugin;

import com.watsonllc.pure.commands.Commands;
import com.watsonllc.pure.config.Config;

public class Main extends JavaPlugin {
	public static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		Config.setup();
		Commands.setup();
	}
	
	@Override
	public void onDisable() {
		
	}
}