package com.skqins.islandchat;

import org.bukkit.plugin.java.JavaPlugin;

import com.skqins.islandchat.ChatHandler.ChatEvents;
import com.skqins.islandchat.PlayerManager.PlayerManager;
import com.skqins.islandchat.commands.Commands;

public class IslandChatPlugin extends JavaPlugin{

	public static IslandChatPlugin instance;
	private PlayerManager playerManager;
	private ConfigManager configManager;
	
	public void onEnable() {
		instance = this;
		@SuppressWarnings("unused")
		Metrics metrics = new Metrics(this);
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		
		setPlayerManager(new PlayerManager(this));
		configManager = new ConfigManager(this);
		getServer().getPluginManager().registerEvents(new ChatEvents(), this);
		Commands commands = new Commands();
		getCommand(commands.cmd).setExecutor(commands);
	}

	public PlayerManager getPlayerManager() {
		return playerManager;
	}

	public void setPlayerManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public ConfigManager getConfigManager() {
		return configManager;
	}
	
}
