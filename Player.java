import java.util.ArrayList;

public class Player {

	private String name;
	private Location location;
	private int stonks;
	private int influ;
	private ArrayList<String> commands = new ArrayList<String>();

	public Player(String name, Location location, int stonks, int influ) {
		this.name = name;
		this.location = location;
		this.stonks = stonks;
		this.influ = influ;

		commands.add("north/south/east/west - move around");
		commands.add("stats - See the value of your Stonks and Influence");
	}

	public void doCommand(String cmd) {
		if (location.checkNeighbor(cmd) == true) {
			this.location = this.location.moveTo(cmd);

		} else {
			System.out.println("Nothing to see here...");
		}
	}

	public Location getPosition() {
		return this.location;
	}

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

	public void counterLocation() {
		location.locationCounter();
	}

	public void getWeather() {
		location.setWeather();
	}

	public void getHelp(String cmd) {
		System.out.println("These are the commands:");
		for (int i = 0; i < commands.size(); i++) {
			System.out.println(commands.get(i));
		}

	}
}
