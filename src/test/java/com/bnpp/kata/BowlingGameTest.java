package com.bnpp.kata;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void newBowlingGameInstanceShouldNotBeNull() {
		BowlingGame game = new BowlingGame();

		assertNotNull(game);
	}
}