package typo;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;


public class Glyph extends Box {
  final private static FontRenderContext frc
     = new FontRenderContext(null, false, false);
  final private Font font;
  final private char[] chars;
  final private Rectangle2D bounds;

  Glyph(Font ft, char c){
	  this.font = ft;
	  this.chars = new char[1];
	  this.chars[0] = c;
	  TextLayout layout = new TextLayout("" + chars[0], font, frc);
	  this.bounds = layout.getBounds();
  }

  public String toString() {
    return super.toString(chars);
  }

  @Override
  public double getWidth() {
	// TODO Auto-generated method stub
	return bounds.getWidth();
  }

  @Override
  public double getAscent() {
	// TODO Auto-generated method stub
	return -bounds.getY();
  }

  @Override
  public double getDescent() {
	// TODO Auto-generated method stub
	return bounds.getHeight()+ bounds.getY();
  }

  @Override
  public double getStretchingCapacity() {
	// TODO Auto-generated method stub
	return 0;
  }

  @Override
  public boolean doDraw(Graphics graph, double x, double y, double w) {
      Graphics2D g2d = (Graphics2D) graph;
      g2d.setFont(font);
      Rectangle2D bounds = font.getStringBounds(String.valueOf(chars[0]), g2d.getFontRenderContext());
      g2d.drawChars(new char[]{chars[0]}, 0, 1,
          (int)(x - bounds.getX()),
          (int)(y - bounds.getY()));
      return bounds.getWidth() <= w;
  }
}