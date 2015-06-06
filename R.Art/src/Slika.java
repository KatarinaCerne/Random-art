import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class Slika extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage slika;
	
	public Slika(int dolzina, int sirina){
		super();
		this.slika = new BufferedImage(dolzina, sirina, BufferedImage.TYPE_INT_RGB);
	}
	
	
	public void izracunajSliko(){
		for (int x=0; x < slika.getWidth(); x++) {
			// Naslednji sleep je tu samo zato, da se vidi, da se slika racuna
			// vzporedno s preostankom programa.
			try { Thread.sleep(30); } catch (InterruptedException e) { }
			// Vsakih 100 stolpcev se narisemo (odsvetujemo)
			if (x % 100 == 0) { repaint(); }
			for (int y=0; y < slika.getHeight(); y++) {
				int red = (x % 256) ;
				int green = (y % 3) * 100 ;
				int blue = 100 ;
				int rgb = (red << 16) | (green << 8) | blue ; 
				slika.setRGB(x, y, rgb);
			}
		}
	}
	public void narisi() {
		Runnable slikar = new Runnable() {
			public void run() {
				izracunajSliko();
				repaint();
			}
		};
		new Thread(slikar).start();			
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(slika.getWidth(), slika.getHeight());
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = slika.getWidth();
		int h = slika.getHeight();
		int x = (this.getWidth() - w)/2;
		int y = (this.getHeight() - h)/2;
		g.drawImage(slika, x, y, w, h, Color.BLACK, null);
	}
}


