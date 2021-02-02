import java.util.HashMap;

abstract class Location {

	private String name;
	private String longDesc;
	private String shortDesc;
	protected Location north, south, east, west;
	private Item item;
	private int counter;
	@SuppressWarnings("unused")
	private boolean taken = false;
	private HashMap<String, Location> paths = new HashMap<String, Location>();

	public Location(String name, String longDesc, String shortDesc, Item item) {
		this.name = name;
		this.longDesc = longDesc;
		this.shortDesc = shortDesc;
		this.item = item;
	}

	public void setNeighbor(Location north, Location south, Location east, Location west) {
		this.north = north;
		this.paths.put("north", north);
		this.south = south;
		this.paths.put("south", south);
		this.east = east;
		this.paths.put("east", east);
		this.west = west;
		this.paths.put("west", west);

	}

	public boolean checkNeighbor(String cmd) {
		if (this.paths.get(cmd) == null) {
			return false;
		} else {
			return true;
		}
	}

	public Location moveTo(String cmd) {
		return this.paths.get(cmd);
		// flyttar till grannen som ligger på key cmd
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void locationCounter() {
		this.counter = this.counter + 1;
	}

	public String describeYourself() {
		if (this.counter < 1) {
			return longDesc;
		} else {
			return shortDesc;
		}
	}

	public void checkPaths() {
	}

	public void setWeather() {
	}

	public Item getItem() {

		if (this.taken = false) {
			this.taken = true;
			return this.item;
		} else {
			return this.item;
		}

	}

	public void itemTaken() {
		if (this.taken = true) {
			this.item = null;
		}
	}

	public void locItems() {
	}
}
