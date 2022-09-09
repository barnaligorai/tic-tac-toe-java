package com.tw.step8.ttt.model;

import com.tw.step8.ttt.exception.CellNotVacantException;
import com.tw.step8.ttt.symbol.Symbol;
import com.tw.step8.ttt.view.Visitor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitorTest {

  @Test
  void isGameDrawnShouldReturnFalseWhenGameIsNotDrawn() throws CellNotVacantException {
    Visitor visitor = new Visitor();
    Player bani = new Player("bani", Symbol.X);
    Player barnali = new Player("barnali", Symbol.O);

    Game game = new Game(new Player[]{bani, barnali});

    visitor.visitGame(game);
    assertFalse(visitor.isGameDrawn());
  }

  @Test
  void isGameDrawnShouldReturnTrueWhenGameIsDrawn() throws CellNotVacantException {
    Visitor visitor = new Visitor();
    Player bani = new Player("bani", Symbol.X);
    Player barnali = new Player("barnali", Symbol.O);
    Game game = new Game(new Player[]{bani, barnali});

    int[] moves = new int[]{0,1,2,4,3,6,5,8,7};
    for (int move:moves) {
      game.play(move);
    }

    visitor.visitGame(game);
    assertTrue(visitor.isGameDrawn());
  }

  @Test
  void getCurrentPlayerName() throws CellNotVacantException {
    Visitor visitor = new Visitor();
    Player bani = new Player("bani", Symbol.X);
    Player barnali = new Player("barnali", Symbol.O);
    Game game = new Game(new Player[]{bani, barnali});

    game.accept(visitor);
    assertEquals("bani", visitor.getCurrentPlayerName());

    game.play(1);
    visitor.visitGame(game);
    assertEquals("barnali", visitor.getCurrentPlayerName());
  }

  @Test
  void getCells() {
    Visitor visitor = new Visitor();
    Player bani = new Player("bani", Symbol.X);
    Player barnali = new Player("barnali", Symbol.O);
    Game game = new Game(new Player[]{bani, barnali});

    visitor.visitGame(game);

    String[] expectedCells = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    assertArrayEquals(expectedCells, visitor.getCells());
  }

}
