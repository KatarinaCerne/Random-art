package operatorji;

import java.util.Random;


public class Produkt extends Operator{
	Operator podizraz1, podizraz2;
	public Produkt(int globina) {
		super();
		Random r = new Random();
		int i = r.nextInt(globina + 1);
		this.podizraz1 = Operator.ustvari_operator(globina-i);
		this.podizraz2 = Operator.ustvari_operator(i);
	}
	
	public double[] eval(double u, double v){
		double[] vektor1 = podizraz1.eval(u, v);
		double[] vektor2 = podizraz2.eval(u, v);
		
		double r = vektor1[0] * vektor2[0];
		double g = vektor1[1] * vektor2[1];
		double b = vektor1[2] * vektor2[2];
		
		double[] rgb_vektor = {r,g,b};
		return rgb_vektor;
	}
}
