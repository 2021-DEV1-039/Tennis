package org.bnp.kata.game;


public enum Scorer {
	FIRST(1),
	SECOND(2);
	
	private Scorer(final Integer value) {
		this.value=value;
	}
	
	private Integer value;
	
	public Integer getValue() {
		return value;
	}
	
	public static Scorer fromValue(Integer value) {
		switch(value) {
		case 1:
			return Scorer.FIRST;
		case 2:
			return Scorer.SECOND;
		default:
			throw new IllegalArgumentException("Value [" +value+" ] not supported.");
		}
	}

}
