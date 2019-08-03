package com.skqins.islandchat;

public class ConfigManager {

	
	private String island_chat_format = "";
	private String island_spy_format = "";
	private String toggle_island_chat_on = "";
	private String toggle_island_chat_off = "";
	private String toggle_island_spy_on = "";
	private String toggle_island_spy_off = "";
	
	public ConfigManager(IslandChatPlugin p) {
		this.island_chat_format = p.getConfig().getString("island-chat-format");
		this.island_spy_format = p.getConfig().getString("island-spy-format");
		this.toggle_island_chat_on  = p.getConfig().getString("toggle-island-chat-on");
		this.toggle_island_chat_off  = p.getConfig().getString("toggle-island-chat-off");
		this.toggle_island_spy_on  = p.getConfig().getString("toggle-island-spy-on");
		this.toggle_island_spy_off  = p.getConfig().getString("toggle-island-spy-off");
		System.out.print(toggle_island_chat_on);
	}
	
	public String chatFormat(String message, String name) {
		String toreturn = island_chat_format;
		toreturn = toreturn.replaceAll("\\%player\\%", name);
		toreturn = toreturn.replaceAll("\\%message\\%", message);
		return toreturn;
	}
	
	public String spyFormat(String message, String name) {
		String toreturn = island_spy_format;
		toreturn = toreturn.replaceAll("\\%player\\%", name);
		toreturn = toreturn.replaceAll("\\%message\\%", message);
		return toreturn;
	}
	
	public String toggleMessage(boolean isOn) {
		if(isOn) {
			return this.toggle_island_chat_on;
		} else {
			return this.toggle_island_chat_off;
		}
	}
	
	public String toggleSpyMessage(boolean isOn) {
		if(isOn) {
			return this.toggle_island_spy_on;
		} else {
			return this.toggle_island_spy_off;
		}
	}
	
}
