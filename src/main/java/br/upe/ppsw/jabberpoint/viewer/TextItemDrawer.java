package br.upe.ppsw.jabberpoint.viewer;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.List;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.TextLayout;
import java.util.Iterator;

import br.upe.ppsw.jabberpoint.model.SlideItem;
import br.upe.ppsw.jabberpoint.model.Style;
import br.upe.ppsw.jabberpoint.model.TextItem;

public class TextItemDrawer extends Drawer {

	// vai implementar a superclasse Drawer para desenhar o que for passado na classe TextItem
    @Override
    public void draw(int x, int y, float scale, Graphics g, ImageObserver observer, SlideItem item) {
        TextItem itemToDraw = (TextItem) item;

		Style myStyle = Style.getStyle(itemToDraw.getLevel());

		if (itemToDraw == null || itemToDraw.getText().length() == 0) {
			return;
		}

		List<TextLayout> layouts = itemToDraw.getLayouts(g, myStyle, scale);

		Point pen = new Point(x + (int) (myStyle.getIndent() * scale), y + (int) (myStyle.getLeading() * scale));

		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(myStyle.getColor());

		Iterator<TextLayout> it = layouts.iterator();

		while (it.hasNext()) {
			TextLayout layout = it.next();
			pen.y += layout.getAscent();
			layout.draw(g2d, pen.x, pen.y);
			pen.y += layout.getDescent();
		}
    }
    
}
