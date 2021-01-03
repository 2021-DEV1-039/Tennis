package org.bnp.kata.tennis;

import org.bnp.kata.game.OutdoorGame;
import org.bnp.kata.game.Scorer;
import org.bnp.kata.tennis.exception.GameOverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TennisGame extends OutdoorGame  {	

	@Autowired
	private TennisPlayer player1;
	
	@Autowired
	private TennisPlayer player2;
	
	public TennisGame(TennisPlayer player1, TennisPlayer player2) {
		super(true);
		this.player1 = player1;
		this.player2 = player2;
	}

	public TennisPlayer getPlayer1() {
		return player1;
	}

	public TennisPlayer getPlayer2() {
		return player2;
	}

	@Override
	public String play(Scorer scorer) throws GameOverException {
		StringBuilder displayScore = new StringBuilder();
		if(this.isRunning()) {
			return displayScore.toString();			
		}
	}
}
