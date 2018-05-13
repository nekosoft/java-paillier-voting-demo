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
	
	static BigInteger one = new BigInteger("1");
//	one = new BigInteger("1");
	
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
		}
		
		return a;
	}
	
	// calculates Lowest Common Multiple using gcd
	public static BigInteger calculateLCM(BigInteger p, BigInteger q, BigInteger gcd)
	{
		lcm = (p.multiply(q)).divide(gcd);
		return lcm;
	}
	
	// calculates Lambda parameter (NOT a lambda function) which uses lcm
	public static BigInteger calculateLambda(BigInteger p, BigInteger q)
	{
		p = p.subtract(one);
		q = q.subtract(one);
//		System.out.printf("p: %d q: %d", p, q);
		gcd = calculateGCD(p, q);
		lcm = calculateLCM(p, q, gcd);
		return lcm;
	}
	
	// L function used to compute k
	public static BigInteger functionL(BigInteger u, BigInteger n)
	{
		BigInteger L;
		L = (u.subtract(one)).divide(n);
//		L = (u - 1) / n;
		return L;
	}
	
	// compute k
	public static BigInteger calculateK(BigInteger n, BigInteger g, BigInteger p, BigInteger q)
	{
		BigInteger k;
		BigInteger n_sq = n.pow(2);
		k = g.modPow(calculateLambda(p, q), n_sq);
		System.out.printf("Calculate k: \nN Squared: %d K Mod Pow: %d\n", n_sq, k);
		k = functionL(k, n);
		System.out.printf("L of k: \n", k);
		return k;
	}
	
	// calculate miu
	public static BigInteger calculateMiu(BigInteger k, BigInteger n)
	{
		BigInteger miu;
		miu = k.modInverse(n);
		System.out.printf("\u03bc: \n", miu);
		return miu;
	}
	
	// here comes the actual Paillier encryption using Public Key
	// formula to encrypt each vote is: c = g^m * r^n mod n^2
	// where c is the ciphertext, m is the message (vote) and r is a random number chosen by the voter
	public static BigInteger encrypt(BigInteger g, BigInteger r, BigInteger n, int nExponent, int m)
	{
		BigInteger CT;
		BigInteger n_sq = n.pow(2);
		// as pow(a) requires an int, have passed in n twice until better fix
		CT = ((g.pow(m)).multiply(r.pow(nExponent))).mod(n_sq);
		System.out.printf("Encrypted Message: \n", CT);
		return CT;
	}
	

}
