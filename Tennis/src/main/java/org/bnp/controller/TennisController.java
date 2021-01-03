package org.bnp.kata.controller;

import org.bnp.kata.game.Game;
import org.bnp.kata.game.Scorer;
import org.bnp.kata.tennis.exception.GameOverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tennis")
public class TennisController {
	
	@Autowired
	private Game tennisGame;
	
	@GetMapping
	public String playTennisGame(@RequestParam Integer scorer) throws GameOverException {
		return tennisGame.play(Scorer.fromValue(scorer));
	}
}
