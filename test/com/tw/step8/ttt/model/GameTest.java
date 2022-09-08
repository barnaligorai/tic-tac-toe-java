package com.tw.step8.ttt.model;

import com.tw.step8.ttt.symbol.Symbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
  @Test
  void currentPlayerShouldReturnTheCurrentPlayer() {
    Player bani = new Player("bani", Symbol.X);
    Player barnali = new Player("barnali", Symbol.X);

    Game game1 = new Game(new Player[]{bani, barnali});
    assertEquals(bani, game1.currentPlayer());

    Game game2 = new Game(new Player[]{barnali, bani});
    assertEquals(barnali, game2.currentPlayer());

  }

  @Test
  void isGameOverShouldReturnFalseForARunningGame() {
    Player bani = new Player("bani", Symbol.X);
    Player barnali = new Player("barnali", Symbol.X);

    Game game = new Game(new Player[]{bani, barnali});

    assertFalse(game.isGameOver());
  }
  @Test
  void isGameOverShouldReturnTrueWhenGameIsOver() {
    Player bani = new Player("bani", Symbol.X);
    Player barnali = new Player("barnali", Symbol.X);

    Game game = new Game(new Player[]{bani, barnali});
    game.play(1);
    game.play(4);
    game.play(2);
    game.play(5);
    game.play(3);

    assertTrue(game.isGameOver());
  }


}