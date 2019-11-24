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

	@Test
	public void gameScoreShouldBe5When5PinsDownForSingleRoll() {
		game.roll(5);
		int gameScore = game.getGameScore();

		assertEquals(5, gameScore);
	}

	@Test
	public void gameScoreShouldBe60When3PinsDown20Times() {
		roll20Times3Pins();
		int gameScore = game.getGameScore();

		assertEquals(60, gameScore);
	}

	@Test
	public void gameScoreShouldGetAddedWith2ImmediateNextRollsForStrike() {
		game.roll(10);
		game.roll(2);
		game.roll(2);
		int gameScore = game.getGameScore();

		assertEquals(18, gameScore);
	}

	private void roll20Times3Pins() {
		for (int rollCount = 0; rollCount < 20; rollCount++) {
			game.roll(3);
		}
	}
}