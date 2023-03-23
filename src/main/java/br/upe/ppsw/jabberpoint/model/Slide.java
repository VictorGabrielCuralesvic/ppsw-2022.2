package br.upe.ppsw.jabberpoint.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

public class Slide {

  //constante
  public final static int WIDTH = 1200;
  public final static int HEIGHT = 800;

  //atributos
  protected TextItem title;
  protected Vector<SlideItem> items;

  // construtor
  public Slide() {
    items = new Vector<SlideItem>();
  }

  // métodos
  public void append(SlideItem anItem) {
    items.addElement(anItem);
  }

  public TextItem getTitle() {
    return title;
  }

  public void setTitle(String newTitle) {
    title = new TextItem(0, newTitle);
  }

  public void append(int level, String message) {
    append(new TextItem(level, message));
  }

  public SlideItem getSlideItem(int number) {
    return (SlideItem) items.elementAt(number);
  }

  public Vector<SlideItem> getSlideItems() {
    return items;
  }

  public int getSize() {
    return items.size();
  }
// refatorar 
  public void draw(Graphics g, Rectangle area, ImageObserver view) {
  
    float scale = getScale(area);

    int y = area.y;

    SlideItem slideItem = this.title;

    slideItem.draw(area.x, y, scale, g, view);

    y += slideItem.getBoundingBox(g, view, scale).height;

    for (int number = 0; number < getSize(); number++) {
      slideItem = (SlideItem) getSlideItems().elementAt(number);

      slideItem.draw(area.x, y, scale, g, view);

      y += slideItem.getBoundingBox(g, view, scale).height;
    }
  }

  private float getScale(Rectangle area) {
    return Math.min(((float) area.width) / ((float) WIDTH),
        ((float) area.height) / ((float) HEIGHT));
  }
}
