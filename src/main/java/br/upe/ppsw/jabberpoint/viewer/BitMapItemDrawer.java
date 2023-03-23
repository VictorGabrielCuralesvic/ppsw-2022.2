package br.upe.ppsw.jabberpoint.viewer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.model.BitmapItem;
import br.upe.ppsw.jabberpoint.model.SlideItem;
import br.upe.ppsw.jabberpoint.model.Style;

public class BitMapItemDrawer extends Drawer {

    // vai implementar a classe pai Drawer para desenhar itens do BitMap
    @Override
    public void draw(int x, int y, float scale, Graphics g, ImageObserver observer, SlideItem item) {
        Style myStyle = Style.getStyle(item.getLevel());

        int width = x + (int) (myStyle.getIndent() * scale);
        int height = y + (int) (myStyle.getLeading() * scale);

        BufferedImage bufferedImage = ((BitmapItem) item).getBufferedImage();
        if (bufferedImage != null) {
            g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale), (int) (bufferedImage.getHeight(observer) * scale), observer);
        }   

    }
    
}
