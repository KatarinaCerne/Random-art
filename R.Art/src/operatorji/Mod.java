package operatorji;

import java.util.Random;


public class Mod extends Operator {
	Operator podizraz1, podizraz2;
	public Mod(int globina) {
		super();
		Random r = new Random();
		int i = r.nextInt(globina + 1);
		this.podizraz1 = Operator.ustvari_operator(globina-i);
		this.podizraz2 = Operator.ustvari_operator(i);

	}
	
	public double[] eval(double u, double v){
			double[] vektor1 = podizraz1.eval(u, v);
			double[] vektor2 = podizraz2.eval(u, v);
			double[] vektor_rgb = new double[3];
			for (int i = 0; i < vektor_rgb.length; i += 1){
				try {
					vektor_rgb[i] = vektor1[i] % vektor2[i];
				}
				catch (ArithmeticException e) {
					vektor_rgb[i] = 1;
				}
			}
			return vektor_rgb;
	}
}
