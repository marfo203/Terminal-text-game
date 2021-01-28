

public class Player {

	private String name;
	private Location location;
	private int stonks;

	public Player(String name, Location location, int stonks) {
		this.name = name;
		this.location = location;
		this.stonks = stonks;
	}

	public void doCommand(String command) {
		

	}
	public int getStonks() {
		return stonks;
	}

	public String getLocation() {
		return location.describeYourself(); 
	}

	public String getName() {
		return name;
	}
	public void describeYourself() {
	
		
	}

}
