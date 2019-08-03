package com.skqins.islandchat.ChatHandler;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.skqins.islandchat.IslandChatPlugin;

import world.bentobox.bentobox.BentoBox;

public class ChatEvents implements Listener{

	private String color(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	@EventHandler
	public void islandChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String message = e.getMessage();
		
		if(IslandChatPlugin.instance.getPlayerManager().isIslandChatting(p)) {
			e.setCancelled(true);
			
			String messagetoplayer = IslandChatPlugin.instance.getConfigManager().chatFormat(message, p.getName());
			String messagetospy = IslandChatPlugin.instance.getConfigManager().spyFormat(message, p.getName());
			
			for(UUID user : BentoBox.getInstance().getIslands().getIsland(Bukkit.getWorld("bskyblock_world"), p.getUniqueId()).getMembers().keySet()) {
				
			
				
				if(Bukkit.getOfflinePlayer(user).isOnline()) {
					Player target = Bukkit.getPlayer(user);
					target.sendMessage(color(messagetoplayer));
				}
			}
			for(UUID spy : IslandChatPlugin.instance.getPlayerManager().getSpies()) {
				if(!spy.equals(p.getUniqueId())) {
					if(Bukkit.getOfflinePlayer(spy).isOnline()) {
						Player target = Bukkit.getPlayer(spy);
						target.sendMessage(color(messagetospy));
					}
				}
			}
			
		}
	}
	
}
