

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
		if (cmd == "stats" || cmd == "Stats") {
			System.out.println(describeYourself());
		}
		this.location = this.location.moveTo(cmd);
		
		if (this.location == null) {
			System.out.println("Nothing to see here..");
		}

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
		if (this.location != null) {
			return location.describeYourself();
		} else {
			return "Try another path!";
		}
	}

	public String getName() {
		return name;
	}

	public String describeYourself() {
		return "Right now your Stonks are at " + (getStonks()) + "%. And your Influence is at " + getInfluence()+"." ;
		
		

	}

//	public void getPaths() {
//	
//		System.out.println("There is a path leading");
//		
//	}

}
