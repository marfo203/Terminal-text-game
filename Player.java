
public class Player {

	private String name;
	private Location location;

	public Player(String name, Location location) {
		this.name = name;
	}

	public void doCommand(String command) {

	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location; // Här måste returneras något.
	}

	public String getName() {
		return name;
	}

}
