package com.test;

public class Player {
	
	private String playerName;
	private int playerId;
	
	public Player(String playerName, int playerId) {
		this.playerName = playerName;
		this.playerId = playerId;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public int getPlayerId() {
		return playerId;
	}
}
