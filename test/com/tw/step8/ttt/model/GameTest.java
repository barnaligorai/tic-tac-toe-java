package com.tw.step8.ttt.model;

import com.tw.step8.ttt.symbol.Symbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
  @Test
  void currentPlayer() {
    Player bani = new Player("bani", Symbol.X);
    Player barnali = new Player("barnali", Symbol.X);

    Game game1 = new Game(new Player[]{bani, barnali});
    assertEquals(bani, game1.currentPlayer());

    Game game2 = new Game(new Player[]{barnali, bani});
    assertEquals(barnali, game2.currentPlayer());

  }
}