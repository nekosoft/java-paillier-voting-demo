package engine;

import paillier.homomorphism.PaillierCalculations;
import java.math.BigInteger;

public class VoteEngine {

	public static void main(String[] args) {
		// TODO Add log output
		// TODO user input for parameters
//		System.out.println("This is the Greek letter for lambda: \u03bb");
//		System.out.println("This is the Greek letter for miu: \u03bc");
		
		BigInteger gcdTest;
		BigInteger lambdaTest, kTest, miuTest;
		BigInteger voteTest1;
		
		BigInteger n = new BigInteger("5723");
		BigInteger g = new BigInteger("5724");
		BigInteger p = new BigInteger("59");
		BigInteger q = new BigInteger("97");
		BigInteger n_sq = n.pow(2);
		
		System.out.printf("The following Public Key has been provided:\n"
				+ "p = %d  q = %d  g = %d  n = p * q = %d\n"
				+ "(n, g) = (%d, %d)\n", p, q, g, n, n, g);
		
		// vote assignments
		int yes = 8;
		int no = 1;
		
		// voters random numbers
		BigInteger r1 = new BigInteger("90");
		BigInteger r2 = new BigInteger("91");
		BigInteger r3 = new BigInteger("92");
		BigInteger r4 = new BigInteger("93");
		BigInteger r5 = new BigInteger("94");
		BigInteger r6 = new BigInteger("95");
		BigInteger r7 = new BigInteger("96");
		
		
		gcdTest = PaillierCalculations.calculateGCD(p, q);
		lambdaTest = PaillierCalculations.calculateLambda(p, q);
		kTest = PaillierCalculations.calculateK(n, g, p, q);
		miuTest = PaillierCalculations.calculateMiu(kTest, n);
		
		System.out.printf("The following Private Key has been calculated:\n"
				+ "\u03bb = %d  k = %d  \u03bc = %d\n"
				+ "(\u03bb, \u03bc) = (%d, %d)\n", lambdaTest, kTest, miuTest,lambdaTest, miuTest);
		
		// TODO encrypted vote test, to be put in array
		voteTest1 = PaillierCalculations.encrypt(g, r1, n, 5723, yes);
		BigInteger voteTest2 = PaillierCalculations.encrypt(g, r2, n, 5723, no);
		BigInteger voteTest3 = PaillierCalculations.encrypt(g, r3, n, 5723, no);
		BigInteger voteTest4 = PaillierCalculations.encrypt(g, r4, n, 5723, yes);
		BigInteger voteTest5 = PaillierCalculations.encrypt(g, r5, n, 5723, yes);
		BigInteger voteTest6 = PaillierCalculations.encrypt(g, r6, n, 5723, no);
		BigInteger voteTest7 = PaillierCalculations.encrypt(g, r7, n, 5723, yes);
		

		System.out.printf("Vote 1 Encryption: %d\n", voteTest1);
		System.out.printf("Vote 2 Encryption: %d\n", voteTest2);
		System.out.printf("Vote 3 Encryption: %d\n", voteTest3);
		System.out.printf("Vote 4 Encryption: %d\n", voteTest4);
		System.out.printf("Vote 5 Encryption: %d\n", voteTest5);
		System.out.printf("Vote 6 Encryption: %d\n", voteTest6);
		System.out.printf("Vote 7 Encryption: %d\n", voteTest7);
		
		// multiply set of encrypted votes
		BigInteger multiplyResult;
		// TODO loop to multiply
		multiplyResult = (((((voteTest1.multiply(voteTest2)).multiply(voteTest3)).multiply(voteTest4)).multiply(voteTest5)).multiply(voteTest6)).multiply(voteTest7);
		multiplyResult = multiplyResult.mod(n_sq);

		System.out.printf("Homomorphic Addition - Encrypted result: %d\n", multiplyResult);
		
		// decrypt result
		BigInteger decrypted = PaillierCalculations.decrypt(n, g, p, q, multiplyResult);
		System.out.printf("Decrypted votes: %d\n", decrypted);
		
		// TODO binary conversions to represent votes and comments explaining system
		System.out.printf("Binary Result: %s\n", decrypted.toString(2));
	  
		
	}

}
