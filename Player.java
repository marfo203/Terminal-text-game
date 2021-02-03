import java.util.ArrayList;

public class Player {

	private String name;
	private Location location;
	private int stonks;
	private int influ;
	private Item item;
	private ArrayList<Item> wearable = new ArrayList<Item>();
	private ArrayList<Item> briefcase = new ArrayList<Item>();

	public Player(String name, Location location, int stonks, int influ) {
		this.name = name;
		this.location = location;
		this.stonks = stonks;
		this.influ = influ;

	}

	public void doCommand(String cmd) {
		if (cmd.equalsIgnoreCase("items")) {
			System.out.println("The items in your breifcase are: ");
			for (int i = 0; i < briefcase.size(); i++) {
				System.out.println(briefcase.get(i).getItemName());
			}
		}
		if (cmd.equalsIgnoreCase("take")) {
			fillBriefcase();
			System.out.println("You took: " + this.item.getItemName());
		}
		if (cmd.equalsIgnoreCase("look")) {
			this.location.locItems();
		}
		if (cmd.equalsIgnoreCase("north") || cmd.equalsIgnoreCase("south") || cmd.equalsIgnoreCase("east")
				|| cmd.equalsIgnoreCase("west")) {
			if (location.checkNeighbor(cmd) == true) {
				this.location = this.location.moveTo(cmd);
			} else {
				System.out.println("Nothing to see here...");
			}
		}
		if (cmd.equalsIgnoreCase("wear")) {
			System.out.println("What do you want to wear?");
			for (int i = 0; i < briefcase.size(); i++) {
				if (briefcase.get(i) instanceof WearableItem) {
				System.out.println(i+1+": "+briefcase.get(i).getItemName());}
			
			}
		}
	}

	private void fillBriefcase() {
		if (location.getItem() != null) {
			briefcase.add(location.getItem());
			this.item = location.getItem();
			addInfluence();
			location.itemTaken();

		} else {
			System.out.println("No item to take");
		}

	}
	
	public void getitemName() {
		this.item.getItemName();
	}

	public Location getPosition() {
		return this.location;
	}

	public void locItems() {
		this.location.locItems();
	}

	public int getStonks() {
		return stonks;
	}

	public int getInfluence() {
		return influ;
	}

	public void addInfluence() {
		this.influ = this.influ + this.item.addInflu();
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
	public void wearItem(WearableItem wear) {
		this.wearable.add(item);
	}

}
