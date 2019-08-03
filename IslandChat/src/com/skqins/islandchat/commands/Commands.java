package com.skqins.islandchat.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.skqins.islandchat.IslandChatPlugin;
public class Commands implements CommandExecutor {
	
	public String cmd = "islandchat";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				if(IslandChatPlugin.instance.getPlayerManager().isIslandChatting(p)) {
					IslandChatPlugin.instance.getPlayerManager().setIslandChatting(p,false);
					p.sendMessage(color(IslandChatPlugin.instance.getConfigManager().toggleMessage(false)));
				} else {
					IslandChatPlugin.instance.getPlayerManager().setIslandChatting(p,true);
					p.sendMessage(color(IslandChatPlugin.instance.getConfigManager().toggleMessage(true)));
				}
			} 
			if(args.length == 1) {
				if(sender.hasPermission("islandchat.spy")) {
					if(args[0].equalsIgnoreCase("spy")) {
						if(IslandChatPlugin.instance.getPlayerManager().isSpying(p)) {
							IslandChatPlugin.instance.getPlayerManager().setIsSpying(p,false);
							p.sendMessage(color(IslandChatPlugin.instance.getConfigManager().toggleSpyMessage(false)));
						} else {
							IslandChatPlugin.instance.getPlayerManager().setIsSpying(p,true);
							p.sendMessage(color(IslandChatPlugin.instance.getConfigManager().toggleSpyMessage(true)));
						}
						
					}
				}
			}
		}
		
		
		
		
		return false;
	}
	

	
	private String color(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
}
