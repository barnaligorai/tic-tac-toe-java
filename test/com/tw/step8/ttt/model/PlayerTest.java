package com.tw.step8.ttt.model;

import com.tw.step8.ttt.symbol.Symbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

  @Test
  void getName() {
    Player barnali = new Player("Barnali", Symbol.X);
    assertEquals("Barnali", barnali.getName());

    Player bani = new Player("Bani", Symbol.X);
    assertEquals("Bani", bani.getName());
  }

  @Test
  void getSymbol() {
    Player barnali = new Player("Barnali", Symbol.X);
    assertEquals(Symbol.X, barnali.getSymbol());

    Player bani = new Player("Bani", Symbol.O);
    assertEquals(Symbol.O, bani.getSymbol());
  }
}