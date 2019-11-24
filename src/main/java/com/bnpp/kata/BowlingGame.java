package com.bnpp.kata;

public class BowlingGame {
	
	private int gameScore;
	private int[] rollScore = new int[22];
	private int rollCount;

	int getGameScore() {
		for(int rollPosition = 0; rollPosition < rollCount; rollPosition++) {
			gameScore += rollScore[rollPosition];
			if(rollScore[rollPosition] == 10) {
				int nextRoll = rollScore[rollPosition+2];
				gameScore += nextRoll;
				if(nextRoll == 10) {
					gameScore += rollScore[rollPosition+4];
				} else {
					gameScore += rollScore[rollPosition+3];
				}
			}
		}
		return gameScore;
	}

	void roll(int numberOfpinsKnocked) {
		rollScore[rollCount++] = numberOfpinsKnocked;
		if(numberOfpinsKnocked == 10) {
			rollCount++;
		}
	}
}