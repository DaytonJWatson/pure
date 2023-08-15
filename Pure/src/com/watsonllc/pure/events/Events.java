package com.watsonllc.pure.events;

import org.bukkit.plugin.PluginManager;

import com.watsonllc.pure.Main;
import com.watsonllc.pure.events.block.BlockPlace;
import com.watsonllc.pure.events.player.PlayerJoin;
import com.watsonllc.pure.events.player.PlayerQuit;

public class Events {

	public static void setup() {
		PluginManager pm = Main.instance.getServer().getPluginManager();
		
		pm.registerEvents(new BlockPlace(), Main.instance);
		pm.registerEvents(new PlayerJoin(), Main.instance);
		pm.registerEvents(new PlayerQuit(), Main.instance);
	}
}
