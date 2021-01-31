import java.util.ArrayList;
import java.util.HashMap;

abstract class Location {

	private String name;
	private String longDesc;
	private String shortDesc;
	private Location north;
	private Location south;
	private Location east;
	private Location west;
	private HashMap<String, Location> paths = new HashMap<String, Location>();
	// HashMap med paths så att
	// "North" förknippas med
	// wallstreet tex.

	public Location(String name, String longDesc, String shortDesc, Location north, Location south, Location east,
			Location west) {
		this.name = name;
		this.longDesc = longDesc;
		this.shortDesc = shortDesc;
		// grannarna tas in redan i location

	}

	public void setNeighbor(Location north, Location south, Location east, Location west) {
		// Måste ha någon metod som vet vilka locations som gränsar till varandra
		// Home ska gränsa till wall street. Tänker att vi kan göra som när vi
		// tilldelade en leksak till ett djur? Fast med en ny location bara

		this.north = north;
		this.paths.put("north", north);
		this.south = south;
		this.paths.put("south", south);
		this.east = east;
		this.paths.put("east", east);
		this.west = west;
		this.paths.put("west", west);

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

	public Location moveTo(String cmd) {
		return this.paths.get(cmd);
		// flyttar till grannen som ligger på key cmd

	}

	public boolean checkNeighbor(String cmd) {
		if (this.paths.get(cmd) == null) {
			return false;
		} else {
			return true;
		}
	}

	public void checkPaths() {
		if (this.north != null) {
			System.out.println("There is a path leading north.");
		}
		if (this.south != null) {
			System.out.println("There is a path leading south.");
		}
		if (this.east != null) {
			System.out.println("There is a path leading east.");
		}
		if (this.west != null) {
			System.out.println("There is a path leading west.");
		}
	}
}
