import java.util.ArrayList;
import java.util.HashMap;

public class Location extends Game {

	private String name;
	private String longDesc;
	private String shortDesc;
	private Location north, south, east, west; 
	private static HashMap<String, Location> paths = new HashMap<String, Location>(); //HashMap med paths så att "North" förknippas med wallstreet tex.
	private ArrayList<Location> neighbors = new ArrayList<Location>();         // Måste man kunna gå inom   rummen?
	

	
	public Location(String name, String longDesc, String shortDesc, Location north, Location south, Location east, Location west) {
		this.name = name;
		this.longDesc = longDesc;
		this.shortDesc = shortDesc;
		//grannarna tas in redan i location
		this.north = north; 
		this.south = south;
		this.east = east;
		this.west = west;
	
	
		
	}
	public void getNeighbor() {
		
	}
	
	public static void setNeighbor(Location a, Location b, Location c, Location d) {
		//Måste ha någon metod som vet vilka locations som gränsar till varandra
		//Home ska gränsa till wall street. Tänker att vi kan göra som när vi tilldelade en leksak till ett djur? Fast med en ny location bara
		
		paths.put("north", a);
		paths.put("south", b);
	    paths.put("east", c);
		paths.put("west", d);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return shortDesc;
	}

	public String describeYourself() {
		return longDesc;
	}
	public  Location moveTo(String cmd) {
		return paths.get(cmd);
		//flyttar till grannen som ligger på key cmd
		
		
	}

}
