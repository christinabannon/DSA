package midterm;

public class Stock 
{
	private int ghost, fire, ice;
	private int transactions = 0;
	
	public Stock (int ghost, int fire, int ice)
	{
		this.ghost = ghost;
		this.fire = fire;
		this.ice = ice;
	}
	
	
	public void give(int g, int f, int i) throws OOSException
	{
		if (ghost >=g && fire >= f && ice >= i)
		{
			ghost -= g;
			fire -=f;
			ice -= i;
			
			transactions++;
		}
	}
	
	public void accept(int g, int f, int i)
	{
		ghost += g;
		fire +=f;
		ice += i;
		
		transactions++;
		
	}
	
	public int getTransactions()
	{
		return transactions;
	}
	
	public void setGhost(int ghost) {
		this.ghost = ghost;
	}

	public void setFire(int fire) {
		this.fire = fire;
	}

	public void setIce(int ice) {
		this.ice = ice;
	}

	public int getGhost() {
		return ghost;
	}

	public int getFire() {
		return fire;
	}

	public int getIce() {
		return ice;
	}
}
