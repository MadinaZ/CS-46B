package airlines;

import java.util.*;


public class Airport implements Comparable<Airport>
{
	private String					name;
	private int						x;
	private int						y;
	private Set<Airport>			connections;	// all airports with a direct route to/from this airport
	
	
	public Airport(String name, int x, int y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		connections = new TreeSet<>();
	}
	
	
	public String getName()
	{
		return name;
	}
	
	
	public int getX()
	{
		return x;
	}
	
	
	public int getY()
	{
		return y;
	}
	
	
	public List<Airport> getConnections()
	{
		return new ArrayList<>(connections);
	}
	
	
	// Adds that airport to the list of connections.
	public void connectTo(Airport that)
	{
		connections.add(that);
	}
	
	
	//
	// Does nothing if this airport is not connected to that.
	//
	public void disconnectFrom(Airport that)
	{
		Set<Airport> removeUs = new HashSet<Airport>();
		for (Airport airport : connections){
			if (airport.equals(that)){
				removeUs.add(airport);
			}
		}
		connections.removeAll(removeUs);
	}
	
	
	// Use best practice.
	public boolean equals(Object x)
	{
		Airport that = (Airport)x;
		return this.compareTo(that) == 0;
	}
	
	
	// Just compare by airport name.
	public int compareTo(Airport that)
	{
		int cmpName = this.getName().compareTo(that.getName());
		return cmpName;
	}
	
	
	public boolean isConnectedTo(Airport that)
	{
		for (Airport airport : connections){
			if (airport.equals(that)){
				return true;
			}
		}
		return false;
	}
	
	
	public String toString()
	{
		return "Airport " + name + " @(" + x + "," + y + ")";
	}
}
