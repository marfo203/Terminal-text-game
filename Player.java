

public class Player {

	private String name;
	private Location location;
	private int stonks;
	private int influ;

	public Player(String name, Location location, int stonks, int influ) {
		this.name = name;
		this.location = location;
		this.stonks = stonks;
		this.influ = influ;
	}

	public void doCommand(String command) {
		
		}
	
	public int getStonks() {
		return stonks;
	}
	public int getInfluence() {
		return influ;
	}
	
	public void setLocation(int loc) {
		
		
	}

	public String getLocation() {
		return location.describeYourself(); 
	}

	public String getName() {
		return name;
	}
	public void describeYourself() {
		System.out.println("Right now your Stonks are at "+(getStonks())+"%");
		System.out.println("Your Influence is at "+ (getInfluence()));
	
		
	}

}
