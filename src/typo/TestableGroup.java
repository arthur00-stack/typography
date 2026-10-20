package typo;

import java.awt.Font;
import java.awt.Graphics;

public class TestableGroup extends Group {
	
	public static void main(String[] args) {
		
	}

	@Override
	public boolean doDraw(Graphics graph, double x, double y, double w) {
		
		return false;
	}

	public double getWidth() {
		return super.width;
	}


}
