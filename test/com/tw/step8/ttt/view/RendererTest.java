package com.tw.step8.ttt.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RendererTest {

  @Test
  void write() throws IOException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Renderer renderer = new Renderer(outputStream);
    renderer.write("hello");
    assertEquals("hello", outputStream.toString());
  }

  @Test
  void showPrompt() throws IOException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Renderer renderer = new Renderer(outputStream);
    renderer.showPrompt("bani");

    String expectedPrompt = "bani's turn. Please Enter the cell number > ";
    assertEquals(expectedPrompt, outputStream.toString());
  }

  @Test
  void displayBoard() throws IOException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Renderer renderer = new Renderer(outputStream);

    String[] cells = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    renderer.displayBoard(cells);

    String expectedBoard = " 1 2 3\n 4 5 6\n 7 8 9\n";
    assertEquals(expectedBoard, outputStream.toString());
  }

  @Test
  void showError() throws IOException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Renderer renderer = new Renderer(outputStream);

    renderer.showError(new Exception("testing error"));
    assertEquals("*ERROR* testing error, Please provide a vacant cell between 1-9\n", outputStream.toString());
  }
}