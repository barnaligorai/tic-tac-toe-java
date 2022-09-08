package com.tw.step8.ttt.view;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class View {
  private final Scanner scanner;
  private final OutputStream out;

  public View(Scanner scanner, OutputStream out) {
    this.scanner = scanner;
    this.out = out;
  }

  public String read (){
    return scanner.next();
  }

  public void write (String text) throws IOException {
    out.write(text.getBytes());
  }
}
