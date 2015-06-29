package operatorji;

import java.util.Random;


public class Sinus extends Operator {
	Operator podizraz;
	Random random_generator = new Random();
	double faza = Math.PI * random_generator.nextDouble();
	double frekvenca = 1 + 5 * random_generator.nextDouble();
	
	public Sinus(int globina) {
		super();
		this.podizraz = Operator.ustvari_operator(globina);
	}
	@Override
	public double[] eval(double u, double v) {
		double[] vektor1 = podizraz.eval(u, v);
		double r2 = Math.sin(faza+frekvenca*vektor1[0]);
		double g2 = Math.sin(faza+frekvenca*vektor1[1]);
		double b2 = Math.sin(faza+frekvenca*vektor1[2]);
		double[] vektor_rgb = {r2,g2,b2};
		
		return vektor_rgb;
	}

}
