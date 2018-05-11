package engine;

public class PrivKeyGeneration {
	
	int p;
	int q;
	int g;
	int n;
	static int lcm;
	static int gcd;
	
	// need public key parameters to generate private key
	PublicKeyGeneration publicKey = new PublicKeyGeneration(p, q, g, n);
	
	
	// calculates the Greatest Common Divisor using Euclid's Algorithm
	public static int gcd(int p, int q)
	{
		while (p !=q) 
		{
			int c;
			c = p - q;;
			p = Math.max(q, c);
			q = Math.min(q, c);
			gcd = p;
		}
		
		return gcd;
	}
	
	public static int lcm(int p, int q, int gcd)
	{
		lcm = 
		return lcm;
	}
	

	

}
