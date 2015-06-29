package operatorji;

import java.util.Random;


public abstract class Operator {


public Operator() {	

}

public static double[] povprecje (double[] vektor1, double[] vektor2, double w) {
	
    double r = w * vektor1[0] + (1 - w) * vektor2[0];
    double g = w * vektor1[1] + (1 - w) * vektor2[1];
    double b = w * vektor1[2] + (1 - w) * vektor2[2];
    
    double[] rgb_vektor = {r,g,b};
    
	return rgb_vektor;
}

public abstract double[] eval(double u, double v);

public static Operator ustvari_operator(int globina){
	Random random = new Random();
	if (globina <=0){
		int stevilo = random.nextInt(3);
		if (stevilo == 0) return new Konstanta();
		if (stevilo == 1) return new SpremenljivkaX();
		if (stevilo == 2) return new SpremenljivkaY();
			
	}
	int stevilo = random.nextInt(11);
	if (stevilo == 0) return new Vsota(globina-1);
	if (stevilo == 1) return new Produkt(globina-1);
	if (stevilo == 2) return new Krog(globina-1);
	
	if (stevilo == 3) return new Sinus(globina-1);
	if (stevilo == 4) return new Sotor(globina-1);
    if (stevilo == 5) return new Vodnjak(globina-1);
    if (stevilo == 6) return new Level(globina-1);
    if (stevilo == 7) return new Sinus2(globina-1);
    if (stevilo == 8) return new ArcTan(globina-1);
    if (stevilo == 9) return new Tan(globina-1);
	return new Mix(globina-1);
}
}

