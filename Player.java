

public class Player {

	private String name;
	private Location location;

	public Player(String name, Location location) {
		this.name = name;
		this.location = location;
	}

	public void doCommand(String command) {
		

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
