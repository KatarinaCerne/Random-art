package operatorji;

//import java.util.Random;

public class Vodnjak extends Operator {

	Operator podizraz;

	public Vodnjak(int globina) {
		super();
		
		this.podizraz = Operator.ustvari_operator(globina);
		
	}
	
	public static double vodnjak (double x) {
		//double k = 1+x*x;
	    
		return 1-2/(Math.pow(1+x*x, 8));
	}

	@Override
	public double[] eval(double u, double v) {
		double[] vektor1 = podizraz.eval(u, v);
		double[] vektor_rgb = {vodnjak(vektor1[0]), vodnjak(vektor1[1]), vodnjak(vektor1[2])};
		return vektor_rgb;
	}

}
