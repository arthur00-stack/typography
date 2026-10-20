package typo;

import java.awt.Graphics;

public class Vbox extends Group{
	double lineSkip;
	public static int count = 0;
	
	Vbox(double lineSkip){
		this.lineSkip = lineSkip;
	}
	
	@Override
	public void add(Box box) {
	    if (list.isEmpty()) {
	        this.ascent = box.getAscent();
	        this.descent = box.getDescent();
	    } else {
	        this.ascent += this.descent + lineSkip + box.getAscent();
	        this.descent = box.getDescent();
	    }
	    this.width = Math.max(this.width, box.getWidth());
	    this.strechingCapacity = Math.max(this.strechingCapacity, box.getStretchingCapacity());
	    super.add(box);
	}

	@Override
	public boolean doDraw(Graphics graph, double x, double y, double w) {
	    double currentY = y;
	    boolean success = true;
	    for (Box box : list) {
	        currentY += box.getAscent();
	        if (!box.doDraw(graph, x, currentY, w)) {
	            success = false;
	        }
	        currentY += box.getDescent() + lineSkip;
	    }
	    return success;
	}

    @Override
    public String toString() {
        String resultat = String.format("Vbox[w=%g, a=%g, d=%g, sC=%g]{\n",
                this.getWidth(), this.getAscent(),
                this.getDescent(), this.getStretchingCapacity());
        count++;
        for (Box b : list) {
            for (int i = 0; i < count; i++) resultat += " ";
            resultat += b.toString() + ",\n";
        }
        count--;
        for (int i = 0; i < count; i++) resultat += " ";
        return resultat + "}";
    }

}
