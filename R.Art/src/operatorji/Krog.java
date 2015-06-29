package operatorji;

public class Krog extends Operator {
	
	Operator podizraz;

	public Krog(int globina) {
		super();
		
		this.podizraz = Operator.ustvari_operator(globina);
	}
	
	public static double krog (double x) {
		return Math.sqrt(1-x*x);
	}

	@Override
	public double[] eval(double u, double v) {
		double[] vektor1 = podizraz.eval(u, v);
		double[] vektor_rgb = {krog(vektor1[0]), krog(vektor1[1]), krog(vektor1[2])};
		return vektor_rgb;
	}

}
