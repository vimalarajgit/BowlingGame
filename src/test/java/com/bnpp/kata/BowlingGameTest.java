package com.bnpp.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	BowlingGame game;

	@Before
	public void init() {
		game = new BowlingGame();
	}

	@Test
	public void newBowlingGameInstanceShouldNotBeNull() {
		assertNotNull(game);
	}

	@Test
	public void gameScoreShouldBeZeroBeforeGameStarts() {
		int gameScore = game.getGameScore();

		assertEquals(0, gameScore);
	}

	@Test
	public void gameScoreShouldBe0WhenNoPinDownForSingleRoll() {
		game.roll(0);
		int gameScore = game.getGameScore();

		assertEquals(0, gameScore);
	}
}