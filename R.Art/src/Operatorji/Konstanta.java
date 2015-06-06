package Operatorji;

//import java.awt.Color;
import java.util.Random;

public class Konstanta extends Operatorji {

	@Override
	public double[] eval(double u, double v) {
		Random random_generator = new Random();
		double a = random_generator.nextDouble();
		double b = random_generator.nextDouble();
		double c = random_generator.nextDouble();
		
		double[] rgb_vektor = {a,b,c};
		return rgb_vektor;
	}

}
