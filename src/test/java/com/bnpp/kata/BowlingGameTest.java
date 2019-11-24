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
		rollMany(20, 3);
		int gameScore = game.getGameScore();

		assertEquals(60, gameScore);
	}

	@Test
	public void gameScoreShouldGetAddedWith2ImmediateNextRollsForStrike() {
		game.roll(10);
		rollMany(2, 2);
		int gameScore = game.getGameScore();

		assertEquals(18, gameScore);
	}

	@Test
	public void allStrikeRollsIncludeExtra2AtLastFrame() {
		rollMany(12, 10);
		int gameScore = game.getGameScore();

		assertEquals(300, gameScore);
	}

	private void rollMany(final int numberOfRolls, final int numberOfPinsKnocked) {
		for (int rollCount = 0; rollCount < numberOfRolls; rollCount++) {
			game.roll(numberOfPinsKnocked);
		}
	}
}