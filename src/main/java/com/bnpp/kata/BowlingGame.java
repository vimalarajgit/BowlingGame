package com.bnpp.kata;

public class BowlingGame {
	
	private int gameScore;

	int getGameScore() {
		return gameScore;
	}

	void roll(int numberOfpinsKnocked) {
		gameScore += numberOfpinsKnocked;
	}
}