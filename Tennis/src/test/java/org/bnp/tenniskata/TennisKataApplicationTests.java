package org.bnp.tenniskata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.bnp.kata.game.Scorer;
import org.bnp.kata.tennis.TennisGame;
import org.bnp.kata.tennis.TennisPlayer;
import org.bnp.kata.tennis.exception.GameOverException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
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
	@Order(1)
	public void testStartGame_returnsTrue () {				
		Boolean gameOn = tennisGame.isRunning();
		assertEquals(true,gameOn);
	}
	
	@Test
	@Order(2)
	public void testPlayer1Scores1_returnsScoreBoard() throws GameOverException {
		String display = tennisGame.play(Scorer.FIRST);
		assertEquals("Player 1:[15] || Player 2:[]",display);
	}
	
	@Test
	@Order(3)
	public void testPlayer2Scores1_returnsScoreBoard() throws GameOverException {
		String display = tennisGame.play(Scorer.SECOND);
		assertEquals("Player 1:[15] || Player 2:[15]",display);
	}
	
	@Test
	@Order(4)
	public void testPlayer1Scores2_returnsScoreBoard() throws GameOverException {
		String display = tennisGame.play(Scorer.FIRST);
		assertEquals("Player 1:[15, 30] || Player 2:[15]",display);
	}
	
	@Test
	@Order(5)
	public void testPlayer2Scores2_returnsScoreBoard() throws GameOverException {
		String display = tennisGame.play(Scorer.SECOND);
		assertEquals("Player 1:[15, 30] || Player 2:[15, 30]",display);
	}
	
	@Test
	@Order(6)
	public void testPlayer1Scores3_returnsScoreBoard() throws GameOverException {
		String display = tennisGame.play(Scorer.FIRST);
		assertEquals("Player 1:[15, 30, 40] || Player 2:[15, 30]",display);
	}
	
	@Test
	@Order(7)
	public void testPlayer2Scores3_DeuceScenario_returnsScoreBoard() throws GameOverException {
		String display = tennisGame.play(Scorer.SECOND);
		assertEquals("Player 1:[15, 30, 40] || Player 2:[15, 30, 40]",display);
	}
	
	@Test
	@Order(8)
	public void testPlayer1ScoresAdvantage_returnsScoreBoard() throws GameOverException {
		String display = tennisGame.play(Scorer.FIRST);
		assertEquals("Player 1:[15, 30, 40, A] || Player 2:[15, 30, 40]",display);
	}
	
	@Test
	@Order(9)
	public void testPlayer2ScoresDeuce_returnsScoreBoard() throws GameOverException {
		String display = tennisGame.play(Scorer.SECOND);
		assertEquals("Player 1:[15, 30, 40, A, 40] || Player 2:[15, 30, 40]",display);
	}
	
	@Test
	@Order(10)
	public void testPlayer2ScoresAdvantage_returnsScoreBoard() throws GameOverException {
		String display = tennisGame.play(Scorer.SECOND);
		assertEquals("Player 1:[15, 30, 40, A, 40] || Player 2:[15, 30, 40, A]",display);
	}
	
	@Test
	@Order(11)
	public void testPlayer2WinsGame_returnsScoreBoard() throws GameOverException {
		String display = tennisGame.play(Scorer.SECOND);
		assertEquals("Player 2 has won the game || Player 1:[15, 30, 40, A, 40] || Player 2:[15, 30, 40, A, WIN]",display);
	}
	
	@Test
	@Order(12)
	public void testGameOverException_returnsScoreBoard() throws GameOverException {
		assertThrows(GameOverException.class,() -> tennisGame.play(Scorer.FIRST));
	}
}
