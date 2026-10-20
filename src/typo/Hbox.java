package typo;

import java.awt.Graphics;

public class Hbox extends Group{
	public static int count = 0;
	
	public void add(Box box) {
	    this.ascent = Math.max(this.getAscent(), box.getAscent());
	    this.descent = Math.max(this.getDescent(), box.getDescent());
	    this.strechingCapacity += box.getStretchingCapacity();
	    this.width += box.getWidth();
	    super.add(box);
	}

	@Override
	public boolean doDraw(Graphics graph, double x, double y, double w) {
	    double mw = getWidth();
	    boolean success = mw <= w;
	    double actualWidth = success ? w : mw;
	    double totalStretch = getStretchingCapacity();
	    double extra = actualWidth - mw;

	    double currentX = x;
	    for (Box box : list) {
	        double boxW = box.getWidth();
	        if (totalStretch > 0) {
	            boxW += extra * (box.getStretchingCapacity() / totalStretch);
	        }
	        box.doDraw(graph, currentX, y, boxW);
	        currentX += boxW;
	    }
	    return success;
	}
	
	
	public String toString() {
		String resultat = new String();
		resultat = resultat + String.format("Hbox[w=%g, a=%g, d=%g, sC=%g]{\n",
		         this.getWidth(), this.getAscent(),
			        this.getDescent(), this.getStretchingCapacity());
		count++;
		for(Box b:list) {
			for (int i=0;i<count;i++) resultat = resultat +" ";
			resultat = resultat + b.toString() + ",\n";
		}
		count--;
		for (int i=0;i<count;i++) resultat = resultat +" ";
	    return resultat+"}";
	  }


}
