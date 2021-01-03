package org.bnp.kata.tennis;


public enum TennisIndividualPlayerScore {
	
	WIN("WIN", null),
    ADVANTAGE("A", WIN),
    FORTY("40", WIN),
    THIRTY("30", FORTY),
    FIFTEEN("15", THIRTY),
    ZERO("0", FIFTEEN);

    private String scoreIndicator;
    private TennisIndividualPlayerScore nextScore;

    TennisIndividualPlayerScore(String scoreIndicator, TennisIndividualPlayerScore nextScore) {
        this.scoreIndicator = scoreIndicator;
        this.nextScore = nextScore;
    }

    public TennisIndividualPlayerScore getNextScore() {
        return nextScore;
    }

    @Override
    public String toString() {
        return scoreIndicator;
    }

}
