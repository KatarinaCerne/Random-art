package operatorji;

import java.util.Random;


public class Vsota extends Operator{
	private Operator podizraz1;
	private Operator podizraz2;
	
	public Vsota(int globina) {
		super();
		Random r = new Random();
		int i = r.nextInt(globina + 1);
		this.podizraz1 = Operator.ustvari_operator(globina-i);
		this.podizraz2 = Operator.ustvari_operator(i);

	}

	public double[] eval(double u, double v){
		return povprecje(podizraz1.eval(u, v), podizraz2.eval(u, v),0.5);
	}
}
