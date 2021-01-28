import java.util.ArrayList;
import java.util.HashMap;

public class Location {

	private String name;
	//private String description;
	private String longDesc;
	private String shortDesc;
	private HashMap<String, Location> paths = new HashMap<String, Location>();
	private ArrayList<Location> neighbors = new ArrayList<Location>();
	

	
	public Location(String name, String longDesc, String shortDesc) {
		this.name = name;
		this.longDesc = longDesc;
		this.shortDesc = shortDesc;
	}
	
	
	

	public void setNeighbor(Location a, Location b, Location c, Location d) {
		//Måste ha någon metod som vet vilka locations som gränsar till varandra
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
