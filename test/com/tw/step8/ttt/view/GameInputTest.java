package com.tw.step8.ttt.view;

import com.tw.step8.ttt.exception.InvalidCellException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class GameInputTest {

  @Test
  void getPosReturnsNextPosAsAnInteger() throws InvalidCellException {

    byte[] b = "9 1 5 2 6 3".getBytes();
    ByteArrayInputStream inputStream = new ByteArrayInputStream(b);
    GameInput gameInput = new GameInput(inputStream);

    assertEquals(9, gameInput.getPos());
    assertEquals(1, gameInput.getPos());
    assertEquals(5, gameInput.getPos());
  }

  @Test
  void getPosThrowsExceptionForNonIntegerInput() throws Exception {

    byte[] b = "a".getBytes();
    ByteArrayInputStream inputStream = new ByteArrayInputStream(b);
    GameInput gameInput = new GameInput(inputStream);

    try {
      gameInput.getPos();
      throw new Exception("test failed");
    } catch (InvalidCellException e) {
      assertEquals("Invalid cell a", e.getMessage());
    }
  }

  @Test
  void getPosThrowsExceptionForNonValidCellPos() throws Exception {

    byte[] b = "10".getBytes();
    ByteArrayInputStream inputStream = new ByteArrayInputStream(b);
    GameInput gameInput = new GameInput(inputStream);

    try {
      gameInput.getPos();
      throw new Exception("test failed");
    } catch (InvalidCellException e) {
      assertEquals("Invalid cell 10", e.getMessage());
    }
  }
}