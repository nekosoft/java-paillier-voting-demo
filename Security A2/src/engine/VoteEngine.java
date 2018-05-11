package engine;

public class VoteEngine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is the Greek letter for lambda: \u03bb");
		System.out.println("This is the Greek letter for miu: \u03bc");
		
		int gcdTest;
		int lcmTest;
		int lambdaTest;
		
		gcdTest = PrivKeyGeneration.gcdCalc(58, 96);
		// lcmTest = PrivKeyGeneration.lcmCalc(58, 96, gcdTest);
//		lambdaTest = PrivKeyGeneration.lambdaCalc(59, 97);
		
		System.out.printf("gcd: %d", gcdTest);
		// System.out.printf("lcm: %d", lcmTest);
//		System.out.printf("\u03bb: %d", lambdaTest);
	}

}
