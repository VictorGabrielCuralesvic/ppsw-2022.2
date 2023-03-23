package br.upe.ppsw.jabberpoint.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.viewer.Drawer;

public abstract class SlideItem {

  private int level = 0;
  protected Drawer drawer;

  public SlideItem(int lev) {
    level = lev;
  }

  public SlideItem() {
    this(0);
  }

  public int getLevel() {
    return level;
  }

  public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale);

  public void draw(int x, int y, float scale, Graphics g, ImageObserver observer) {
    drawer.draw(x, y, scale, g, observer, this);
  }

}