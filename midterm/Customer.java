package midterm;

public class Customer 
{
	private boolean giver;
	private int ghost, fire, ice;
	String name;
	
	public Customer (String name, int ghost, int fire, int ice)
	{
		this.name = name;
		this.ghost = ghost;
		this.fire = fire;
		this.ice = ice;
	}
	public String getName()
	{
		return name;
	}
	
	public int getGhost() {
		return ghost;
	}

	public void setGhost(int ghost) {
		this.ghost = ghost;
	}

	public int getFire() {
		return fire;
	}

	public void setFire(int fire) {
		this.fire = fire;
	}

	public int getIce() {
		return ice;
	}

	public void setIce(int ice) {
		this.ice = ice;
	}
}
