package paillier.homomorphism;

import java.math.BigInteger;

import paillier.keys.PublicKeyGeneration;

public class PaillierCalculations {
	
	BigInteger p;
	BigInteger q;
	BigInteger g;
	BigInteger n;
	static BigInteger lcm;
	static BigInteger gcd;
	
	// private key properties
	BigInteger lambda;
	BigInteger k;
	BigInteger miu;
	static BigInteger u;
	
	// need public key parameters to generate private key
	PublicKeyGeneration publicKey = new PublicKeyGeneration(p, q, g, n);
	
	
	// calculates the Greatest Common Divisor using Euclid's Algorithm
	public static BigInteger calculateGCD(BigInteger p, BigInteger q)
	{
		// setting the min and max parameters in the right order otherwise while loops infinitely
		// a must be larger than b to calc difference for gcd in while loop
		BigInteger a = p.max(q);
		BigInteger b = p.min(q);
		
		while (a !=b) 
		{
			BigInteger c;
			c = a.subtract(b);
			a = b.max(c);
			b = b.min(c);
			gcd = a;
		}
		
		return gcd;
	}
	
	// calculates Lowest Common Multiple using gcd
	public static BigInteger lcmCalc(BigInteger p, BigInteger q, BigInteger gcd)
	{
		lcm = (p * q) / gcd;
		return lcm;
	}
	
	// calculates Lambda parameter (NOT a lambda function) which uses lcm
	public static BigInteger lambdaCalc(BigInteger p, BigInteger q)
	{
		p -= 1;
		q -= 1;
//		System.out.printf("p: %d q: %d", p, q);
		gcd = gcdCalc(p, q);
		lcm = lcmCalc(p, q, gcd);
		return lcm;
	}
	
	// L function used to compute k
	public static BigInteger LCalc(BigInteger n)
	{
		int L;
		L = (u - 1) / n;
		return L;
	}
	
	// compute k

}
