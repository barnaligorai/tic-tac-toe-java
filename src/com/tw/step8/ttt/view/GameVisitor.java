package com.tw.step8.ttt.view;

import com.tw.step8.ttt.model.Game;

public interface GameVisitor {
  public void visitGame(Game game);
}
