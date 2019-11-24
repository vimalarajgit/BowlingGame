package com.bnpp.kata;

public class BowlingGame {

	private int gameScore;
	private int[] rollScore = new int[22];
	private int rollCount;

	int calculateGameScore() {
		int rollCountToCalculate = rollCount > 20 ? 20 : rollCount; 
		for (int rollPosition = 0; rollPosition < rollCountToCalculate; rollPosition++) {
			gameScore += rollScore[rollPosition];
			calculateGameScoreWhenStrike(rollPosition);
		}
		return gameScore;
	}

	void roll(final int numberOfpinsKnocked) {
		rollScore[rollCount++] = numberOfpinsKnocked;
		moveToNextFrameWhenStrikeAchieved(numberOfpinsKnocked);
	}

	private void moveToNextFrameWhenStrikeAchieved(final int numberOfpinsKnocked) {
		if (numberOfpinsKnocked == 10 && rollCount < 20) {
			rollCount++;
		}
	}

	private void calculateGameScoreWhenStrike(int rollPosition) {
		if (rollScore[rollPosition] == 10) {
			int nextRoll = rollScore[rollPosition + 2];
			gameScore += nextRoll;
			rollPosition = nextRoll == 10 && rollPosition < 18 ? rollPosition + 4 : rollPosition + 3;
			gameScore += rollScore[rollPosition];
		}
	}
}