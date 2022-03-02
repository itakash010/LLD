package com.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Driver {
	
	public static void main(String args[]) {
		Dice dice = new Dice(1);
		
		Player player1 = new Player("Akash" ,1);
		Player player2 = new Player("Sonali" ,2);
		
		Queue<Player> players = new LinkedList<>();
		players.offer(player1);
		players.offer(player2);
		
		Map<Player, Integer> positions = new HashMap<>();
		positions.put(player1, 0);
		positions.put(player2, 0);
		
		Map<Integer, Integer> ladders = new HashMap<>();
		ladders.put(5, 20);
		ladders.put(15, 35);
		ladders.put(21, 91);
		ladders.put(24, 65);
		ladders.put(45, 85);
		
		Map<Integer, Integer> snakes = new HashMap<>();
		snakes.put(94, 14);
		snakes.put(85, 65);
		snakes.put(98, 2);
		snakes.put(38, 12);
		snakes.put(68, 23);
		
		
		Board board = new Board(dice,players,positions,ladders,snakes,100);
		board.startGame();
	}

}
