package paillier.keys;

import java.math.BigInteger;

public class PublicKeyGeneration {
	
	// TODO create configurable properties
	private BigInteger p;
	private BigInteger q;
	private BigInteger g;
	private BigInteger n;
	
	public PublicKeyGeneration(BigInteger p, BigInteger q, BigInteger g, BigInteger n)
	{
		this.p = p;
		this.q = q;
		this.g = g;
		this.n = n;
	}
	
	// accessors
	public BigInteger getP()
	{
		return p;
	}
	
	public BigInteger getQ()
	{
		return q;
	}
	
	public BigInteger getG()
	{
		return g;
	}
	
	public BigInteger getN()
	{
		return n;
	}
	
	// modifiers
	public void setP(BigInteger p)
	{
		this.p = p;
	}
	
	public void setQ(BigInteger q)
	{
		this.q = q;
	}
	
	public void setG(BigInteger g)
	{
		this.g = g;
	}
	
	public void setN(BigInteger n)
	{
		this.n = n;
	}
	
}
