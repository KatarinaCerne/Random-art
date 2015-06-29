package operatorji;

//import java.util.Random;

public class Sotor extends Operator {
	Operator podizraz;
	public Sotor(int globina) {
		super();
		this.podizraz = Operator.ustvari_operator(globina);
	}
	
	public static double sotor(double x){
		
		return 1-2*Math.abs(x);
		
	}
	
	@Override
	public double[] eval(double u, double v) {
		double[] vektor1 = podizraz.eval(u, v);
		double[] vektor_rgb = {sotor(vektor1[0]), sotor(vektor1[1]), sotor(vektor1[2])};
		
		return vektor_rgb;
	}

}
