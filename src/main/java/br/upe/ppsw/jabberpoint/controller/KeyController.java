package br.upe.ppsw.jabberpoint.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {

  // atributos
  private Presentation presentation;

  // construtor
  public KeyController(Presentation p) {
    presentation = p;
  }

  // métodos
  public void keyPressed(KeyEvent keyEvent) {
    switch (keyEvent.getKeyCode()) {
      case KeyEvent.VK_PAGE_DOWN:
      case KeyEvent.VK_DOWN:
      case KeyEvent.VK_ENTER:
      case '+':
        presentation.nextSlide();
        break;
      case KeyEvent.VK_PAGE_UP:
      case KeyEvent.VK_UP:
      case '-':
        presentation.prevSlide();
        break;
      case 'q':
      case 'Q':
        System.exit(0);
        break; // fix?
      default:
        break;
    }
  }

}
