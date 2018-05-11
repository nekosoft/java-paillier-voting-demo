package engine;

public class PrivKeyGeneration {
	
	int p;
	int q;
	int g;
	int n;
	static int lcm;
	static int gcd;
	
	// private key properties
	int lambda;
	int k;
	int miu;
	
	// need public key parameters to generate private key
	PublicKeyGeneration publicKey = new PublicKeyGeneration(p, q, g, n);
	
	
	// calculates the Greatest Common Divisor using Euclid's Algorithm
	public static int gcdCalc(int p, int q)
	{
		// setting the min and max parameters in the right order otherwise while will loop infinitely
		// a must be larger than b to calc difference for gcd in while loop
		int a = Math.max(p, q);
		int b = Math.min(p, q);
		
		while (a !=b) 
		{
			int c;
			c = a - b;
			a = Math.max(b, c);
			b = Math.min(b, c);
			gcd = a;
			System.out.println(gcd);
		}
		
		return gcd;
	}
	
	// calculates Lowest Common Multiple using gcd
	public static int lcmCalc(int p, int q, int gcd)
	{
		lcm = (p * q) / gcd;
		return lcm;
	}
	
	// calculates Lambda parameter (NOT a lambda function) which uses lcm
	public static int lambdaCalc(int p, int q)
	{
		p -= 1;
		q -= 1;
//		System.out.printf("p: %d q: %d", p, q);
		gcd = gcdCalc(p, q);
		lcm = lcmCalc(p, q, gcd);
		return lcm;
	}
	

	

}
