package com.skqins.islandchat.PlayerManager;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.skqins.islandchat.IslandChatPlugin;

public class PlayerManager implements Listener {

	private ArrayList<BPlayer> registeredPlayers = new ArrayList<BPlayer>();
	
	public PlayerManager(IslandChatPlugin pl) {
		pl.getServer().getPluginManager().registerEvents(this, pl);
		for(Player p : Bukkit.getOnlinePlayers()) {
			BPlayer bp = new BPlayer(p.getUniqueId());
			registeredPlayers.add(bp);
		}
	}
	
	public boolean isRegistered(UUID id) {
		for(BPlayer p : registeredPlayers) {
			if(p.getUUID().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public BPlayer getBPlayer(UUID id) {
		for(BPlayer p : registeredPlayers) {
			if(p.getUUID().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
	public boolean isIslandChatting(Player p) {
		return getBPlayer(p.getUniqueId()).getIsIslandChatting();
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		if(!isRegistered(e.getPlayer().getUniqueId())) {
			registeredPlayers.add(new BPlayer(e.getPlayer().getUniqueId()));
		}
	}
	@EventHandler
	public void leave(PlayerQuitEvent e) {
		BPlayer player = null;
		for(BPlayer p : registeredPlayers) {
			if(p.getUUID().equals(e.getPlayer().getUniqueId())) {
				player = p;
			}
		}
		registeredPlayers.remove(player);
	}

	public void setIslandChatting(Player pl, boolean b) {
		for(BPlayer p : registeredPlayers) {
			if(p.getUUID().equals(pl.getUniqueId())) {
				p.setIslandChatting(b);
			}
		}
		
	}

	public void setIsSpying(Player pl, boolean b) {
		for(BPlayer p : registeredPlayers) {
			if(p.getUUID().equals(pl.getUniqueId())) {
				p.setIsSpying(b);
			}
		}
		
	}

	public ArrayList<UUID> getSpies() {
		ArrayList<UUID> spies = new ArrayList<UUID>();
		
		for(BPlayer p : registeredPlayers) {
			if(p.isSpying()) {
				spies.add(p.getUUID());
			}
		}
		
		return spies;
	}

	public boolean isSpying(Player p) {
			return getBPlayer(p.getUniqueId()).isSpying();
		
	}
			
}
