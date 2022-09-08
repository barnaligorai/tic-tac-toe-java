package com.tw.step8.ttt.model;

import com.tw.step8.ttt.symbol.Symbol;

public class Player {
  private final String name;
  private final Symbol symbol;

  public Player(String name, Symbol symbol) {
    this.name = name;
    this.symbol = symbol;
  }

  public String getName() {
    return name;
  }

  public Symbol getSymbol() {
    return symbol;
  }

  @Override
  public String toString() {
    return "Player{" +
            "name='" + name + '\'' +
            ", symbol='" + symbol + '\'' +
            '}';
  }
}
