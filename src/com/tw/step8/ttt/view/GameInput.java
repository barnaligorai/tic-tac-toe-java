package com.tw.step8.ttt;

import com.tw.step8.ttt.exception.InvalidCellException;

import java.util.Scanner;

public class GameInput {
  private final Scanner scanner;

  public GameInput(Scanner scanner) {
    this.scanner = scanner;
  }

  public int getPos() throws InvalidCellException {
    String pos = this.scanner.next();

    try {
      this.validatePosition(pos);

    } catch (InvalidCellException e) {
      throw e;
    }

    return Integer.parseInt(pos);
  }

  private void validatePosition(String pos) throws InvalidCellException {
    if (!pos.matches("[1-9]")) {
      throw new InvalidCellException(pos);
    }
  }
}
