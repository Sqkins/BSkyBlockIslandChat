package com.skqins.islandchat.PlayerManager;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BPlayer {

	private UUID uuid;
	
	private Boolean isIslandChatting = false;
	private Boolean isSpying = false;

	public BPlayer(UUID uniqueId) {
		this.uuid = uniqueId;
	}
	
	public Player getPlayer() {
		return Bukkit.getPlayer(uuid);
	}
	
	public UUID getUUID() {
		return uuid;
	}

	public Boolean getIsIslandChatting() {
		return isIslandChatting;
	}

	public void setIslandChatting(Boolean isIslandChatting) {
		this.isIslandChatting = isIslandChatting;
	}

	public Boolean isSpying() {
		return isSpying;
	}

	public void setIsSpying(Boolean isSpying) {
		this.isSpying = isSpying;
	}

}
