package typo;

import java.util.LinkedList;


public abstract class Group extends Box {
	protected final LinkedList<Box> list = new LinkedList<Box>();
	private static int count = 0;
	
	public void add(Box box){
		list.addLast(box);
	}
	public double getWidth(){
		return super.width;
	}
	public double getAscent() {
		return super.ascent;
	}
	public double getDescent() {
		return super.descent;
	}
	public double getStretchingCapacity() {
		return super.strechingCapacity;
	}
	public String toString() {
		String resultat = new String();
		resultat = resultat + String.format("[w=%g, a=%g, d=%g, sC=%g]{\n",
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
