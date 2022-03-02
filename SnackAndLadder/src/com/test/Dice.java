package com.test;

import java.util.Random;

public class Dice {

	private int noOfDice;
	private Random random;
	
	public Dice(int noOfDice)
	{
		this.noOfDice=noOfDice;
		random = new Random();
	}
	
	public int roll()
	{
		return random.nextInt(6)+1;
	}
}
