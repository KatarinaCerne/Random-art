package operatorji;

import java.util.Random;

public class Tan extends Operator {
	Operator podizraz1, podizraz2, podizraz3;
	Random r = new Random();
	double konstanta = r.nextDouble();
	public Tan(int globina) {
		super();
		Random r = new Random();
		int i = r.nextInt(globina + 1);
		this.podizraz1 = Operator.ustvari_operator(globina-i);
		this.podizraz2 = Operator.ustvari_operator(i);
	}

	@Override
	public double[] eval(double u, double v) {
		double[] vektor1 = podizraz1.eval(u, v);
		double[] vektor2 = podizraz2.eval(u, v);
		double[] vektor_rgb = new double[3];
		for(int j=0; j<3; j+=1){
			vektor_rgb[j] = Math.atan(vektor1[j]+vektor2[j]*konstanta);
			if(Math.abs(vektor_rgb[j])>1){vektor_rgb[j]=0;}
		}
		return vektor_rgb ;
	}

}