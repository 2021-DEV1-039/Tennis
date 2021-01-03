package org.bnp.kata.tennis;

import org.bnp.kata.game.Scorer;

@FunctionalInterface
public interface DeuceResolver {
	public Boolean resolve(TennisPlayer player1, TennisPlayer player2, Scorer scorer);
}