
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

	public void doCommand(String cmd) {
		if (location.checkNeighbor(cmd) == true) {
			this.location = this.location.moveTo(cmd);
			getPaths(this.location);
			
		} else {
			System.out.println("Nothing to see here...");

		}
	}
//	public void setLocation() {
//		this.location = 
//	}
	

	public int getStonks() {
		return stonks;
	}

	public int getInfluence() {
		return influ;
	}

	

	public String getLocation() {
		return location.describeYourself();
	}

	public String getName() {
		return name;
	}

	public String describeYourself() {
		return "Right now your Stonks are at " + (getStonks()) + "%. And your Influence is at " + getInfluence() + ".";

	}

	public void getPaths(Location loc) {
		this.location.checkPaths();
		

	}

}
