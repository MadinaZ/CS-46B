package airlines;

import java.util.HashSet;

public class FlightNet extends HashSet<Airport> {
	//Returns true if the FlightNet doesn't contain an airport with the specified name
	public boolean nameIsAvailable(String name){
		for (Airport airport : this){
			if (airport.getName().equals(name)){
				return false;
			}
		}
		return true;
	}
	
	//Connects a1 and a2
	public void connect(Airport a1, Airport a2){
		a1.connectTo(a2);
		a2.connectTo(a1);
	}

	//Disconnects a1 and a2
	public void disconnect(Airport a1, Airport a2){
		a1.disconnectFrom(a2);
		a2.disconnectFrom(a1);
	}
	
	//Removes removeMe from the FlightNet, and disconnects it from any airports that are
	//still in the flight net
	public void removeAndDisconnect(Airport removeMe){
		this.remove(removeMe);
		for (Airport airport : this){
			if (removeMe.isConnectedTo(airport))
				airport.disconnectFrom(removeMe);
		}
	}
	
	//Checks all airports in the FlightNet. Returns the first airport whose (x,y)
	//location is within maximumDistance of the x,y args of the method. Returns null
	//if no airport is within MaximumDistance.
	public Airport getAirportNearXY(int x, int y, int maximumDistance){
		double distance;
		for (Airport airport : this){
			distance = Math.hypot(Math.abs(x - airport.getX()), Math.abs(y - airport.getY()));
			if (distance < maximumDistance){
				return airport;
			}
		}
		return null;
	}
	public static FlightNet makeTestInstance()
	{
		Airport sfo = new Airport("SFO", 31, 207);
		Airport lax = new Airport("LAX", 81, 291);
		Airport jfk = new Airport("JFK", 724, 169);
		Airport mia = new Airport("MIA", 667, 455);
		Airport sea = new Airport("SEA", 92, 31);
		FlightNet net = new FlightNet();
		net.connect(sfo, sea);
		net.connect(sfo, jfk);
		net.connect(sfo, lax);
		net.connect(jfk, mia);
		net.connect(jfk, sea);
		return net;
	}
}
