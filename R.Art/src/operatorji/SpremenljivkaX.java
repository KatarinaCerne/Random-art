package operatorji;


public class SpremenljivkaX extends Operator{
	
	public SpremenljivkaX() {
		super();	
	}
	
	@Override
	public double[] eval(double u, double v) {
		double[] rgb_vektor = {u,u,u};
		return rgb_vektor;
	}

  }

