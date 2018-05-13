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
		
		// candidate assignments
		int candidateA = 8;
		int candidateB = 1;
		
		// voters random numbers
		BigInteger r1 = new BigInteger("91");
		BigInteger r2 = new BigInteger("92");
		BigInteger r3 = new BigInteger("93");
		BigInteger r4 = new BigInteger("94");
		BigInteger r5 = new BigInteger("95");
		BigInteger r6 = new BigInteger("96");
		BigInteger r7 = new BigInteger("97");
		
		
		gcdTest = PaillierCalculations.calculateGCD(p, q);
		lcmTest = PaillierCalculations.calculateLCM(p, q, gcdTest);
		lambdaTest = PaillierCalculations.calculateLambda(p, q);
		kTest = PaillierCalculations.calculateK(n, g, p, q);
		miuTest = PaillierCalculations.calculateMiu(kTest, n);
		
		// encrypted vote test, to be put in array
		voteTest1 = PaillierCalculations.encrypt(g, r1, n, 5723, candidateA);
		BigInteger voteTest2 = PaillierCalculations.encrypt(g, r2, n, 5723, candidateB);
		BigInteger voteTest3 = PaillierCalculations.encrypt(g, r3, n, 5723, candidateB);
		BigInteger voteTest4 = PaillierCalculations.encrypt(g, r4, n, 5723, candidateA);
		BigInteger voteTest5 = PaillierCalculations.encrypt(g, r5, n, 5723, candidateA);
		BigInteger voteTest6 = PaillierCalculations.encrypt(g, r6, n, 5723, candidateB);
		BigInteger voteTest7 = PaillierCalculations.encrypt(g, r7, n, 5723, candidateA);
		
		System.out.printf("gcd: %d\n", gcdTest);
		System.out.printf("lcm: %d\n", lcmTest);
		System.out.printf("\u03bb: %d k: %d\n\u03bc: %d\n", lambdaTest, kTest, miuTest);
		System.out.printf("Vote 1 Encryption: %d\n", voteTest1);
		System.out.printf("Vote 2 Encryption: %d\n", voteTest2);
		System.out.printf("Vote 3 Encryption: %d\n", voteTest3);
		System.out.printf("Vote 4 Encryption: %d\n", voteTest4);
		System.out.printf("Vote 5 Encryption: %d\n", voteTest5);
		System.out.printf("Vote 6 Encryption: %d\n", voteTest6);
		System.out.printf("Vote 7 Encryption: %d\n", voteTest7);
	}

}
