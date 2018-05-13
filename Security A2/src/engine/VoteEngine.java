package engine;

import paillier.homomorphism.PaillierCalculations;
import java.math.BigInteger;

public class VoteEngine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is the Greek letter for lambda: \u03bb");
		System.out.println("This is the Greek letter for miu: \u03bc");
		
		BigInteger gcdTest;
		BigInteger lcmTest;
		BigInteger lambdaTest, kTest, miuTest;
		BigInteger voteTest1;
		
		BigInteger n = new BigInteger("5723");
		BigInteger g = new BigInteger("5724");
		BigInteger p = new BigInteger("59");
		BigInteger q = new BigInteger("97");
		BigInteger r1 = new BigInteger("91");
		
		
		gcdTest = PaillierCalculations.calculateGCD(p, q);
		lcmTest = PaillierCalculations.calculateLCM(p, q, gcdTest);
		lambdaTest = PaillierCalculations.calculateLambda(p, q);
		kTest = PaillierCalculations.calculateK(n, g, p, q);
		miuTest = PaillierCalculations.calculateMiu(kTest, n);
		
		// encrypted vote test
		voteTest1 = PaillierCalculations.encrypt(g, r1, n, 5723, 8);
		
		System.out.printf("gcd: %d\n", gcdTest);
		System.out.printf("lcm: %d\n", lcmTest);
		System.out.printf("\u03bb: %d k: %d\n\u03bc: %d\n", lambdaTest, kTest, miuTest);
		System.out.printf("Vote 1 Encryption: %d\n", voteTest1);
	}

}
