package org.bnp.kata.game;

import org.bnp.kata.tennis.exception.GameOverException;

public interface Game {
	String play(Scorer scorer) throws GameOverException;
}
