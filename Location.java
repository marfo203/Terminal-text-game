import java.util.ArrayList;
import java.util.HashMap;

public class Location {

	private String name;
	//private String description;
	private String longDesc;
	private String shortDesc;
	private HashMap<String, Location> paths = new HashMap<String, Location>(); //HashMap med paths så att "North" förknippas med wallstreet tex.
	private ArrayList<Location> neighbors = new ArrayList<Location>();         // Måste man kunna gå inom   rummen?
	

	
	public Location(String name, String longDesc, String shortDesc) {
		this.name = name;
		this.longDesc = longDesc;
		this.shortDesc = shortDesc;
	}
	
	
	

	public void setNeighbor(Location a, Location b, Location c, Location d) {
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

}
