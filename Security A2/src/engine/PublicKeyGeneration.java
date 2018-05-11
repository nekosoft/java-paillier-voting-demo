package engine;

public class PublicKeyGeneration {
	
	// TODO create configurable properties
	int p;
	int q;
	int g;
	int n;
	
	public PublicKeyGeneration(int p, int q, int g, int n)
	{
		this.p = p;
		this.q = q;
		this.g = g;
		this.n = n;
	}

	
	public int getP()
	{
		return p;
	}
	
}
