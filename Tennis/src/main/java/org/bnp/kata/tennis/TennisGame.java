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
	
	private static final AdvantageResolver advantageResolver = (player1,player2,scorer) -> {
    	Boolean result=false;
    	if(player1.getPlayerScore() == TennisIndividualPlayerScore.ADVANTAGE && scorer == Scorer.SECOND) {
				player1.setPlayerScore(TennisIndividualPlayerScore.FORTY);
				result = true;
		}else if(player2.getPlayerScore() == TennisIndividualPlayerScore.ADVANTAGE && scorer == Scorer.FIRST) {
				player2.setPlayerScore(TennisIndividualPlayerScore.FORTY);
				result=true;
		}
    	return result;
    };
	
    private static final DeuceResolver deuceResolver = (player1,player2,scorer) -> {
    	if(player1.getPlayerScore() == TennisIndividualPlayerScore.FORTY && player2.getPlayerScore() == TennisIndividualPlayerScore.FORTY) {
			if(scorer == Scorer.FIRST) 
				player1.setPlayerScore(TennisIndividualPlayerScore.ADVANTAGE);
			else
				player2.setPlayerScore(TennisIndividualPlayerScore.ADVANTAGE);	
			return true;
		}
    	return advantageResolver.resolve(player1,player2,scorer);
    }; 
    
    private static final ScoreResolver scoreResolver = (player1,player2,scorer) -> {
    	switch(scorer) {
			case FIRST:
				player1.setNextPlayerScore();
			break;
			case SECOND:
				player2.setNextPlayerScore();
			break;					
    	}
    };
	
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
			if(!deuceResolver.resolve(player1, player2, scorer)) {
				scoreResolver.resolve(player1, player2, scorer);
			}
			if(player1.getPlayerScore() == TennisIndividualPlayerScore.WIN || player2.getPlayerScore() == TennisIndividualPlayerScore.WIN) {
				this.setRunning(false);
				displayScore.setLength(0);
				displayScore.append(getWinner(player1,player2,scorer)).append(" has won the game").append(" || ");
			}
			return displayScore.append(getScores()).toString();			
		}
		throw new GameOverException("Game Already Over");	
	}

	private String getWinner(TennisPlayer player1, TennisPlayer player2, Scorer scorer) {
		return player1.getPlayerScore() == TennisIndividualPlayerScore.WIN ? "Player 1":"Player 2" ;
	}

	public String getScores() {
		StringBuilder sb = new StringBuilder();
		sb.append("Player 1").append(":").append(player1.getScores()).append(" || ").append("Player 2").append(":").append(player2.getScores());		
		return sb.toString();
	}

}
