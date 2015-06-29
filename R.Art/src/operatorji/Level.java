package operatorji;

import java.util.Random;


public class Level extends Operator {
	Operator podizraz1, podizraz2, level;
	Random random_generator = new Random();
	double prag = -1 + 2* random_generator.nextDouble();
	
	public Level(int globina) {
		super();
		Random r = new Random();
		int i = r.nextInt(globina + 1);
		int j = r.nextInt(globina + 1);
		this.podizraz1 = Operator.ustvari_operator(globina-i);
		this.podizraz2 = Operator.ustvari_operator(i);
		this.level = Operator.ustvari_operator(Math.abs(i-j));
	}

	@Override
	public double[] eval(double u, double v) {
		double[] vektor1 = level.eval(u, v);
		double[] vektor2 = podizraz1.eval(u, v);
		double[] vektor3 = podizraz2.eval(u, v);
		
		double[] vektor_rgb = new double[3];
		
		for (int i = 0; i < 3; i += 1){
			if (vektor1[1] < prag){vektor_rgb[i] = vektor2[i];}
			else {vektor_rgb[i] = vektor3[i];}
		}		
		return vektor_rgb;
	}

}
