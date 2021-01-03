package org.bnp.tenniskata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bnp.kata.tennis.TennisGame;
import org.bnp.kata.tennis.TennisPlayer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TennisKataApplicationTests {

	static TennisPlayer player1;
	
	static TennisPlayer player2;
	
	static TennisGame tennisGame;
	
	@BeforeAll
	public static void setup() {
		player1 = new TennisPlayer();
		player2 = new TennisPlayer();
		tennisGame = new TennisGame(player1,player2);
	}
	
	@Test
	public void testStartGame_returnsTrue () {				
		Boolean gameOn = tennisGame.isRunning();
		assertEquals(true,gameOn);
	}
}
