package br.upe.ppsw.jabberpoint.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import br.upe.ppsw.jabberpoint.viewer.BitMapItemDrawer;

// atributos
public class BitmapItem extends SlideItem {

  private BufferedImage bufferedImage;
  private String imageName;

  protected static final String FILE = "Arquivo ";
  protected static final String NOTFOUND = " não encontrado";

  // construtor
  public BitmapItem(int level, String name) {
    super(level);

    imageName = name;

    try {
      bufferedImage = ImageIO.read(new File(imageName));
      /* bufferedImage = ImageIO.read(ResourceUtils.getFile(imageName).getAbsoluteFile()); */
    } catch (IOException e) {
      System.err.println(FILE + imageName + NOTFOUND);
    }

    drawer = new BitMapItemDrawer();

  }

  // construtor
  public BitmapItem() {
    this(0, null);
  }

  // métodos
  public String getName() {
    return imageName;
  }

  public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale) {

    Style myStyle = Style.getStyle(getLevel());

    return new Rectangle((int) (myStyle.indent * scale), 0,
        (int) (bufferedImage.getWidth(observer) * scale),
        ((int) (myStyle.leading * scale)) + (int) (bufferedImage.getHeight(observer) * scale));
  }

  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }

  public String toString() {
    return "BitmapItem[" + getLevel() + "," + imageName + "]";
  }
}