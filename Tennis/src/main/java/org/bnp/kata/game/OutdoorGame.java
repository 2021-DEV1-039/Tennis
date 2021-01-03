package org.bnp.kata.game;

public abstract class OutdoorGame implements Game {

	private Boolean running;

	protected OutdoorGame(Boolean running) {
		super();
		this.running = running;
	}

	public Boolean isRunning() {
		return running;
	}

	public void setRunning(Boolean running) {
		this.running = running;
	}

}
