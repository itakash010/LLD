package com.test;

import java.util.Map;
import java.util.Queue;

public class Board {
	Dice dice;
	Queue<Player> players;
	Map<Player, Integer> positions;
	Map<Integer, Integer> ladders;
	Map<Integer, Integer> snakes;
	int sizeOfBoard;

	public Board(Dice dice, Queue<Player> players, Map<Player, Integer> positions, Map<Integer, Integer> ladders,
			Map<Integer, Integer> snakes, int sizeOfBoard) {
			this.dice=dice;
			this.players=players;
			this.positions=positions;
			this.ladders=ladders;
			this.snakes=snakes;
			this.sizeOfBoard=sizeOfBoard;
	}
	
	public void startGame()
	{
		while(players.size()>1)
		{
			Player currentPlayer = players.poll();
			int currentPlayerPosition = positions.get(currentPlayer) ;
			
			
			
			
			int rollValue = dice.roll();
			System.out.println(currentPlayer.getPlayerName()+ " has rolled "+rollValue);
			int newPosition = currentPlayerPosition+rollValue;
			if(newPosition>sizeOfBoard) 
			{
				System.out.println(currentPlayer.getPlayerName() + " is waiting");
				players.offer(currentPlayer);
			}
			else if(newPosition==sizeOfBoard)
			{
				System.out.println("Congrats !! " + currentPlayer.getPlayerName() + " has won the game");
			}
			else
			{
				if(ladders.containsKey(newPosition))
				{
					System.out.println(currentPlayer.getPlayerName() + " has moved from " + currentPlayerPosition + " to "+newPosition);
					System.out.println(currentPlayer.getPlayerName() + " has got ladder and moved from " + newPosition + " to "+ladders.get(newPosition));
					positions.put(currentPlayer, ladders.get(newPosition));
					players.offer(currentPlayer);
				}
				else if(snakes.containsKey(newPosition))
				{
					System.out.println(currentPlayer.getPlayerName() + "has bit by snake and moved from " + newPosition + " to "+snakes.get(newPosition));
					positions.put(currentPlayer, snakes.get(newPosition));
					players.offer(currentPlayer);
				}
				else
				{
					System.out.println(currentPlayer.getPlayerName() + " has moved from " + currentPlayerPosition + " to "+newPosition);
					positions.put(currentPlayer, newPosition);
					players.offer(currentPlayer);
				}
			}
			
		}
	}
}
