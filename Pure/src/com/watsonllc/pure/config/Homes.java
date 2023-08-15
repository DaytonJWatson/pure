package com.watsonllc.pure.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.watsonllc.pure.Main;

public class Homes {
	private static File homesFile = new File(Main.instance.getDataFolder(), "homes.yml");
	private static YamlConfiguration homes = YamlConfiguration.loadConfiguration(homesFile);
	
	public static void create() {
		if(homesFile.exists())
			return;
		
		try {
			homes.save(homesFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void save() {
		try {
			homes.save(homesFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void load() {
		try {
			homes.load(homesFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	private Player player;
	private String uniqueID;
	
	public Homes(Player player) {
		this.player = player;
		this.uniqueID = player.getUniqueId().toString();
	}
	
	public boolean hasHome() {
		if(homes.contains("homes."+uniqueID))
			return true;
		else
			return false;
	}
	
	public void goHome() {
		World world = Bukkit.getWorld(homes.getString("homes."+uniqueID+".WORLD"));
		double x = homes.getDouble("homes."+uniqueID+".X");
		double y = homes.getDouble("homes."+uniqueID+".Y");
		double z = homes.getDouble("homes."+uniqueID+".Z");
		float yaw = (float) homes.getDouble("homes."+uniqueID+".YAW");
		float pitch = (float) homes.getDouble("homes."+uniqueID+".PITCH");
		
		Location homeLoc = new Location(world, x, y, z, yaw, pitch);
		player.teleport(homeLoc);
	}
	
	public void setHome() {
		Location currentLoc = player.getLocation();
		String world = currentLoc.getWorld().getName();
		double x = currentLoc.getX();
		double y = currentLoc.getY();
		double z = currentLoc.getZ();
		float yaw = currentLoc.getYaw();
		float pitch = currentLoc.getPitch();
		
		homes.set("homes."+uniqueID+".WORLD" , world);
		homes.set("homes."+uniqueID+".X" , x);
		homes.set("homes."+uniqueID+".Y" , y);
		homes.set("homes."+uniqueID+".Z" , z);
		homes.set("homes."+uniqueID+".YAW" , yaw);
		homes.set("homes."+uniqueID+".PITCH" , pitch);
		save();
	}
	
	public void removeHome() {
		if(!hasHome())
			return;
			
		homes.set("homes."+uniqueID, null);
		save();
	}
}