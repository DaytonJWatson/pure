package com.watsonllc.pure.config;

import java.util.List;

import com.watsonllc.pure.Main;

public class Config {
	
	public static void setup() {
		create();
		Homes.create();
	}
	
	public static void create() {
		Main.instance.getConfig().options().copyDefaults();
		Main.instance.saveDefaultConfig();
	}
	
	public static void save() {
		Main.instance.saveConfig();
	}
	
	public static void reload() {
		Main.instance.reloadConfig();
	}
	
	public static void set(String string, Object obj) {
		Main.instance.getConfig().set(string, obj);
	}
	
	public static String getString(String string) {
		return Main.instance.getConfig().getString(string);
	}
	
	public static List<String> getStringList(String string) {
		return Main.instance.getConfig().getStringList(string);
	}
	
	public static Double getDouble(String string) {
		return Main.instance.getConfig().getDouble(string);
	}
	
	public static Float getFloat(String string) {
		return (float) Main.instance.getConfig().getDouble(string);
	}
}