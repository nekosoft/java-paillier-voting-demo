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
	
	// accessors
	public int getP()
	{
		return p;
	}
	
	public int getQ()
	{
		return q;
	}
	
	public int getG()
	{
		return g;
	}
	
	public int getN()
	{
		return n;
	}
	
	// modifiers
	public void setP(int p)
	{
		this.p = p;
	}
	
	public void setQ(int q)
	{
		this.q = q;
	}
	
	public void setG(int g)
	{
		this.g = g;
	}
	
	public void setN(int n)
	{
		this.n = n;
	}
	
}
