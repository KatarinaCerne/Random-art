package operatorji;

import java.util.Random;

public class Sinus2 extends Operator {

	Operator podizraz;
	Random random_generator = new Random();
	double faza = Math.PI * random_generator.nextDouble();
	double frekvenca = 1 + 5 * random_generator.nextDouble();
	int potenca = random_generator.nextInt(5)+1;

	public Sinus2(int globina) {
		super();
		this.podizraz = Operator.ustvari_operator(globina);

	}
	

	@Override
	public double[] eval(double u, double v) {
		double[] vektor1 = podizraz.eval(u, v);
		double r2 = Math.pow(Math.sin(faza+frekvenca*vektor1[0]),potenca);
		double g2 = Math.pow(Math.sin(faza+frekvenca*vektor1[1]),potenca);
		double b2 = Math.pow(Math.sin(faza+frekvenca*vektor1[2]),potenca);
		double[] vektor_rgb = {r2,g2,b2};
		return vektor_rgb;
	}

}
