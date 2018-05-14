package paillier.keys;

import java.math.BigInteger;

public class PrivKeyGeneration {
	
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
	// commonly used properties
	BigInteger n_sq = n.pow(2);
	
	// need public key parameters to generate private key
	PublicKeyGeneration publicKey = new PublicKeyGeneration(p, q, g, n);
	
	// TODO getters and setters
	
	

	

}
