package midterm;

//CB this class should have been named employee
public class Line<T> 
{
	Queue<Customer> getterQ;
	Queue<Customer> giverQ;
	Stock stock;
	StackRA<Customer> pending;
	
	int numGivers;
	int numGetters;
	int numServed;

	public Line(Stock stock)
	{
		this.stock = stock;
		getterQ = new Queue<Customer>();
		numGetters = 0;
		giverQ = new Queue<Customer>();
		pending = new StackRA<Customer>();
		numServed = 0;
	}
	
	public void add(Customer c)
	{/*
		if (c.isGiver())
		{
			giverQ.enqueue(c);
			numGivers ++;
		}
		else 
		{
			getterQ.enqueue(c);
			numGetters ++;
		}
*/
	}
	
	public String lastPending()
	{
		StringBuilder s = new StringBuilder("Customers gotten through:");
		
		Customer c = pending.peek();
		while(c.getFire() >= stock.getFire() && 
				c.getIce() >= stock.getIce() &&
				c.getGhost() >= stock.getGhost())
		{
			c = pending.pop();
			stock.give(c.getGhost(), c.getFire(), c.getIce());
			s.append(c.getName() + " ");
			numServed++;
			c = pending.peek();
		}
		
		return s.toString();
	}
	
	public String pendingStack()
	{
		return pending.toString();
	}
	
	public String getGivers()
	{
		return giverQ.toString();
	}
	
	public Customer serveGivers()
	{
		Customer customer = giverQ.dequeue();
		
		stock.accept(customer.getGhost(), customer.getFire(), customer.getIce());
		numServed++;
		return customer;
	}
	
	public boolean isGiverEmpty()
	{
		return giverQ.isEmpty();
	}
	
	public String getGetters()
	{
		return getterQ.toString();
	}
	
	public Customer serveGetters()
	{
		Customer customer = getterQ.dequeue();
		
		try {
		stock.give(customer.getGhost(), customer.getFire(), customer.getIce());
		numServed++;
		}
		catch (OOSException e)
		{
		pending.push(customer);
		throw new OOSException("not enough!");
		}
		return customer;
	}
	
	public boolean isGetterEmpty()
	{
		return getterQ.isEmpty();
	}
	
	public String getStock()
	{ 
		
		String s = ("Stock: " + stock.getFire() + " fire " + 
							+ stock.getGhost() + " ghost " + 
							+ stock.getIce() + " ice");
		return s;
	}
	
	public String inventory()
	{
		String s = ("Number of givers served: " + numServed);
		return s;
	}

}
