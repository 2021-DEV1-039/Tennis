package org.bnp.kata.tennis;

import java.util.ArrayList;
import java.util.List;

import org.bnp.kata.game.Player;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisPlayer extends Player {
	
	private TennisIndividualPlayerScore playerScore;
	private List<String> scores;

	public TennisPlayer() {
		super();
		playerScore = TennisIndividualPlayerScore.ZERO;
		scores = new ArrayList<String>();
	}

	public TennisIndividualPlayerScore getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(TennisIndividualPlayerScore playerScore) {
		this.playerScore = playerScore;
		scores.add(playerScore.toString());
	}
	
	public void setNextPlayerScore() {
		this.playerScore = this.playerScore.getNextScore();
		scores.add(playerScore.toString());
	}

	public List<String> getScores() {
		return scores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((playerScore == null) ? 0 : playerScore.hashCode());
		result = prime * result + ((scores == null) ? 0 : scores.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TennisPlayer other = (TennisPlayer) obj;
		if (playerScore != other.playerScore)
			return false;
		if (scores == null) {
			if (other.scores != null)
				return false;
		} else if (!scores.equals(other.scores))
			return false;
		return true;
	}

}
