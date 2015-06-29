package operatorji;

public class SpremenljivkaY extends Operator{
	public SpremenljivkaY(){
		super();
		
	}
	@Override
	public double[] eval(double u, double v) {
		double[] rgb_vektor = {v,v,v};
		return rgb_vektor;
	}

}

