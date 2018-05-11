package engine;

public class VoteEngine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is the Greek letter for lambda: \u03bb");
		System.out.println("This is the Greek letter for miu: \u03bc");
		
		int gcdTest;
		int lcmTest;
		
		gcdTest = PrivKeyGeneration.gcd(132, 84);
		lcmTest = PrivKeyGeneration.lcm(132, 84, gcdTest);
		
		System.out.printf("%d %d", gcdTest, lcmTest);

	}

}
