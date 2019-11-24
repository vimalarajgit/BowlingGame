package com.bnpp.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void newBowlingGameInstanceShouldNotBeNull() {
		BowlingGame game = new BowlingGame();

		assertNotNull(game);
	}

	@Test
	public void gameScoreShouldBeZeroBeforeGameStarts() {
		BowlingGame game = new BowlingGame();
		int gameScore = game.getGameScore();

		assertEquals(0, gameScore);
	}
}