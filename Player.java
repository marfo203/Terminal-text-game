import java.util.ArrayList;

public class Player {

	private String name;
	private Location location;
	private int stonks;
	private int influ;
	public Item item;
	private ArrayList<Item> briefcase = new ArrayList<Item>();

	public Player(String name, Location location, int stonks, int influ) {
		this.name = name;
		this.location = location;
		this.stonks = stonks;
		this.influ = influ;

	}

	public void doCommand(String cmd) {
		if (cmd.equalsIgnoreCase("take")) {
			fillBriefcase();
			System.out.println(this.item.getItemName());
		}
		if (cmd.equalsIgnoreCase("look")) {
			this.location.locItems();
		}
		if (location.checkNeighbor(cmd) == true) {
			this.location = this.location.moveTo(cmd);

		} else {
			System.out.println("Nothing to see here...");
		}
	}

	private void fillBriefcase() {
		if(location.getItem() != null) {
				briefcase.add(location.getItem());
				this.item = location.getItem();
				location.itemTaken();
				
		} else {
			System.out.println("No item to take");
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

}
