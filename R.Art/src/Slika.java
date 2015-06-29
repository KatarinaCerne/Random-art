import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.util.Random;

import javax.swing.JPanel;

import operatorji.Operator;

public class Slika extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage slika; //slika, ki se bo narisala
	BufferedImage original; //pomo�na slika, ki jo uporabljamo pri sliderjih
	private BufferedImage zacetna; //pomo�na slika, ki se ne spreminja, uporabimo pri razveljavi
	boolean sivina; //ali je slika siva
	boolean crno_belo; //ali je slika �rno-bela
	
	int w = 0; //�irina
	int h = 0; //vi�ina
	int svetl; //sprememba svetlosti
	int rdeca; //spremembna rde�e
	int zelena; //sprememba zelene
	int modra; //sprememba modre
	
	public Slika(int dolzina, int sirina){
		super();
		this.slika = new BufferedImage(dolzina, sirina, BufferedImage.TYPE_INT_RGB);
		this.original = new BufferedImage(dolzina, sirina, BufferedImage.TYPE_INT_RGB);
		this.zacetna = new BufferedImage(dolzina, sirina, BufferedImage.TYPE_INT_RGB);
		w = dolzina;
		h = sirina;
		sivina = false;
		crno_belo = false;
		svetl = 0;
		rdeca = 100;
		zelena = 100;
		modra = 100;
	}
	
    public void sivina(BufferedImage s){
    	//sliko pretvori v grayscale (sivo)
        ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        op.filter(s, slika);
        op.filter(s, original);
        sivina = true;
        repaint();
    }
	
	public void crnoBela(BufferedImage s){
		//sliko pretvori v �rno-belo
		slika = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_BINARY);
		Graphics g = slika.getGraphics();
		g.drawImage(s, 0, 0, null); 
		g.dispose();
		crno_belo = true;
		repaint();
	}
	
	public void razveljavi(BufferedImage s){
		//razveljavi vsako oblikovanje (svetloba, barve,...)
		BufferedImage novaSlika = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		for (int y=0; y < s.getHeight(); y += 1) {
			for (int x=0; x < s.getWidth(); x += 1) {
				Color barva = new Color(zacetna.getRGB(x, y));
				novaSlika.setRGB(x, y, barva.getRGB());
				}
			}
		slika = novaSlika;
		original = novaSlika;
		repaint();
	}
	
	   public void svetlostINbarva(BufferedImage s) {
		   //spremeni svetlost in vsebnost posamezne barve
			BufferedImage novaSlika = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			for (int y=0; y < s.getHeight(); y += 1) {
				for (int x=0; x < s.getWidth(); x += 1) {
					Color barva = new Color(s.getRGB(x, y));
			
					int r = Math.min(Math.max(0, barva.getRed()*rdeca/100+svetl), 255);
					int g = Math.min(Math.max(0, barva.getGreen()*zelena/100+svetl), 255);
					int b = Math.min(Math.max(0, barva.getBlue()*modra/100+svetl), 255);
					Color novaBarva = new Color(r,g,b);
					novaSlika.setRGB(x, y, novaBarva.getRGB());
					}
				}
			slika = novaSlika;
			repaint();	
		}
	
	public int rgb(double[] rgb_vektor) {
		//pretvori rgb vrednosti iz [-1,1] na [0,255]
		int r = Math.max(0, Math.min(255,(int)(128*(rgb_vektor[0]+1))));
		int g = Math.max(0, Math.min(255, (int)(128*(rgb_vektor[1]+1))));
		int b = Math.max(0, Math.min(255, (int)(128*(rgb_vektor[2]+1))));

		Color barva = new Color(r, g, b);
		return barva.getRGB();
	}
	

	
	public void izracunajSliko(){
		Random random_generator = new Random();
		int n = random_generator.nextInt(150)+20;
		Operator operator = Operator.ustvari_operator(n);
		for (int y=0; y < slika.getHeight(); y+=1) {
			repaint();
			for (int x=0; x < slika.getWidth(); x+=1){
				double u = x * 2.0/slika.getWidth() - 1.0;
				double v = y * 2.0/slika.getHeight() - 1.0;
				int rgb = rgb(operator.eval(u, v));
				slika.setRGB(x, y, rgb);
				original.setRGB(x, y, rgb);
				zacetna.setRGB(x, y, rgb);
			}
		}
	}
	
	public void narisi() {
		slika = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		
		sivina = false;
		crno_belo = false;
		svetl = 0;
		rdeca = 100;
		zelena = 100;
		modra = 100;

		
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
	
	public void clearRect(int x,
            int y,
            int width,
            int height) {
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