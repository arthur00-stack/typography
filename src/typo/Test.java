package typo;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;

public class Test {
	
	static void test5() {
		Font f = new Font("SansSerif", Font.PLAIN, 70);
		  Space g = new Space(2.0, 3.0);
		  Space gg = new Space(5.0, 0.0);
		  Space ggg = new Space(35.0, 1.0);
		  System.out.println(g);
		  System.out.println(gg);
		  System.out.println(ggg);
	}
	
	static void test7a() {
		  Hbox h = new Hbox();
		  System.out.println(h);
		  Font f = new Font("SansSerif", Font.PLAIN, 40);
		  h.add(new Glyph(f, 'a'));
		  System.out.println(h);
		  h.add(new Space(2., 3.));
		  System.out.println(h);
		}
	static Hbox lineFromString(Font f, String s) {
		  Hbox line = new Hbox();
		  for (int i = 0; i < s.length(); i++) {
		    char c = s.charAt(i);
		    if (c == ' ')
		      line.add(new RelativeSpace(0.5, f));
		    else {
		      line.add(new Glyph(f, c));
		      if (i < s.length() - 1 && s.charAt(i+1)!=' ')
		        line.add(new FixedSpace(2));
		    }
		  }
		  return line;
		}

		static void test7b() {
		  Font f = new Font("SansSerif", Font.PLAIN, 40);
		  Box t = lineFromString(f, "Typographie sans peine");
		  System.out.println(t);
		  new Page(t, 450, 150);
		}

	static void test6() {
		Font f = new Font("SansSerif", Font.PLAIN, 70);
		TestableGroup groupe1 = new TestableGroup();
		Space g = new Space(2.0, 3.0);
		TestableGroup groupe2 = new TestableGroup();
		Space gt = new Space(2.0, 3.0);
		Glyph gs = new Glyph(f, 'g');
		Space gg = new Space(5.0, 0.0);
		Space ggg = new Space(35.0, 1.0);
		groupe1.add(g);
		groupe1.add(gg);
		groupe2.add(groupe1);
		groupe2.add(ggg);
		System.out.println(groupe2);
	}
	
	final static Box hfill = new Space(0, Double.POSITIVE_INFINITY);

	static Vbox fromString(Font f, String s) {
	  Vbox     text  = new Vbox(5);
	  String[] lines = s.split("\n");

	  for (int i = 0; i < lines.length; ++i) {
	    Hbox line = lineFromString(f, lines[i]);

	    if (i+1 == lines.length)
	      line.add(hfill);
	    text.add(line);
	  }
	  return text;
	}

	static void test8a() {
	  Font f = new Font("SansSerif", Font.PLAIN, 40);
	  Box  t = fromString(f,
	    "L'homme n'est qu'un\n" +
	    "roseau, le plus faible\n" +
	    "de la nature ; mais\n" +
	    "c'est un roseau pensant.");
	  new Page(t, 450);
	}
	
	
	static void test7c() {
		  Font f = new Font("SansSerif", Font.PLAIN, 40);
		  Box t = lineFromString(f, "Test");
		  System.out.println(t);
		  new Page(t, 450, 150);
		}
	
	public static void main(String[] args) {
		test8a();
	}

}
