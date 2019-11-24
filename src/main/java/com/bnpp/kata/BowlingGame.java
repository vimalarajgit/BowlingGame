package com.bnpp.kata;

public class BowlingGame {

	private int gameScore;
	private int[] rollScore = new int[22];
	private int rollCount;

	int calculateGameScore() {
		gameScore = 0;
		int rollCountToCalculate = rollCount > 20 ? 20 : rollCount;
		for (int rollPosition = 0; rollPosition < rollCountToCalculate; rollPosition++) {
			gameScore += rollScore[rollPosition];
			calculateGameScoreWhenStrike(rollPosition);
			calculateGameScoreWhenSpare(rollPosition);
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

	private void calculateGameScoreWhenSpare(int rollPosition) {
		if (rollPosition % 2 == 1 && !isStrike(rollPosition - 1)) {
			if (rollScore[rollPosition] + rollScore[rollPosition - 1] == 10) {
				gameScore += rollScore[rollPosition + 1];
			}
		}
	}

	private void calculateGameScoreWhenStrike(int rollPosition) {
		if (isStrike(rollPosition)) {
			int nextRoll = rollScore[rollPosition + 2];
			gameScore += nextRoll;
			rollPosition = nextRoll == 10 && rollPosition < 18 ? rollPosition + 4 : rollPosition + 3;
			gameScore += rollScore[rollPosition];
		}
	}

	private boolean isStrike(int rollPosition) {
		return rollScore[rollPosition] == 10;
	}
}