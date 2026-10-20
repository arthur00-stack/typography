package typo;

import java.awt.Graphics;

public class Space extends Box{
	
	protected double width, strechingCapacity;
	
	Space(double dimMin, double Streching){
		width = dimMin;
		strechingCapacity = Streching;
	}
	
	public boolean doDraw() {
		return true;
	}
	
	public String toString() {
	    return super.toString();
	  }

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	@Override
	public double getAscent() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDescent() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getStretchingCapacity() {
		// TODO Auto-generated method stub
		return this.strechingCapacity;
	}

	@Override
	public boolean doDraw(Graphics graph, double x, double y, double w) {
		// TODO Auto-generated method stub
		return false;
	}

}
