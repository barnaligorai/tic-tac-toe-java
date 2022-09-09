package com.tw.step8.ttt.view;

import com.tw.step8.ttt.exception.InvalidCellException;

import java.io.InputStream;
import java.util.Scanner;

public class GameInput {
  private final Scanner scanner;

  public GameInput(InputStream inputStream) {
    this.scanner = new Scanner(inputStream);
  }

  public int getPos() throws InvalidCellException {
    String pos = this.scanner.next();
    this.validatePosition(pos);
    return Integer.parseInt(pos);
  }

  private void validatePosition(String pos) throws InvalidCellException {
    if (!pos.matches("[1-9]")) {
      throw new InvalidCellException(pos);
    }
  }

  public void stop() {
    this.scanner.close();
  }
}
