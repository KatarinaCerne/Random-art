package operatorji;

import java.util.Random;

public class Mix extends Operator {
	Operator podizraz1, podizraz2, posebni;
	Random random_generator = new Random();
	public Mix(int globina) {
		super();
		Random r = new Random();
		int i = r.nextInt(globina + 1);
		int j = r.nextInt(globina + 1);
		
		this.posebni = Operator.ustvari_operator(globina-i);
		this.podizraz1 = Operator.ustvari_operator(i);
		this.podizraz2 = Operator.ustvari_operator(Math.abs(i-j));
	}

	@Override
	public double[] eval(double u, double v) {
		double w = 0.5 * (posebni.eval(u, v)[0] +1.0);
		double[] vektor1 = podizraz1.eval(u, v);
		double[] vektor2 = podizraz2.eval(u, v);
		
		return povprecje(vektor1, vektor2, w);
	}

}