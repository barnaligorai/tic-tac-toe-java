package com.tw.step8.ttt.model;

import com.tw.step8.ttt.exception.CellNotVacantException;
import com.tw.step8.ttt.symbol.Symbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
  @Test
  void currentPlayerShouldReturnTheCurrentPlayer() {
    Player bani = new Player("bani", Symbol.X);
    Player barnali = new Player("barnali", Symbol.O);

    Game game1 = new Game(new Player[]{bani, barnali});
    assertEquals(bani, game1.currentPlayer());

    Game game2 = new Game(new Player[]{barnali, bani});
    assertEquals(barnali, game2.currentPlayer());

  }

  @Test
  void isGameOverShouldReturnFalseForARunningGame() {
    Player bani = new Player("bani", Symbol.X);
    Player barnali = new Player("barnali", Symbol.O);

    Game game = new Game(new Player[]{bani, barnali});

    assertFalse(game.isGameOver());
  }
  @Test
  void isGameOverShouldReturnTrueWhenGameIsOver() throws CellNotVacantException {
    Player bani = new Player("bani", Symbol.X);
    Player barnali = new Player("barnali", Symbol.O);

    Game game = new Game(new Player[]{bani, barnali});

    int[] moves = new int[]{1,5,4,3,7};
    for (int move:moves) {
      game.play(move);
    }

    assertTrue(game.isGameOver());
  }

  @Test
  void isGameDrawn() throws CellNotVacantException {
    Player bani = new Player("bani", Symbol.X);
    Player barnali = new Player("barnali", Symbol.O);

    Game game = new Game(new Player[]{bani, barnali});

    int[] moves = new int[]{0,1,2,4,3,6,5,8,7};
    for (int move:moves) {
      game.play(move);
    }

    assertTrue(game.isGameDrawn());
  }
}
