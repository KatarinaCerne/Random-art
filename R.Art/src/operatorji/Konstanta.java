package operatorji;

import java.util.Random;

public class Konstanta extends Operator {
	public Konstanta(){
		super();
	}
	Random random_generator = new Random();
	double a = 2*random_generator.nextDouble() - 1;
	double b = 2*random_generator.nextDouble() - 1;
	double c = 2*random_generator.nextDouble() - 1;

	@Override
	public double[] eval(double u, double v) {
		double[] konstanta = {a,b,c};
		return konstanta;
	}

}