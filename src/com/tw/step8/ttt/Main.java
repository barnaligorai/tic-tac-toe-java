package com.tw.step8.ttt;

import com.tw.step8.ttt.model.Player;
import com.tw.step8.ttt.symbol.Symbol;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Player player1 = new Player("Ramesh", Symbol.X);
    Player player2 = new Player("Suresh", Symbol.O);

    Player[] players = new Player[]{player1, player2};

    System.out.println(Arrays.toString(players));
  }
}
