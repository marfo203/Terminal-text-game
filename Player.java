import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	int command;
	private Scanner keyboard;
	private static String name;
	private Location location;
	private int stonks;
	private int influ;
	private Item item;
	private ArrayList<Item> wearables = new ArrayList<Item>();
	private ArrayList<Item> tools = new ArrayList<Item>();
	private ArrayList<Item> briefcase = new ArrayList<Item>();
	// briefcase contains blablabla

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
			System.out.println(describeYourself());
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
					System.out.println(i + 1 + ": " + briefcase.get(i).getItemName());
					keyboard = new Scanner(System.in);
				}
			}
			try {
				command = keyboard.nextInt();
				wearables.add(briefcase.get(command - 1));
				System.out.println("You are now wearing " + briefcase.get(command - 1).getItemName());
				briefcase.remove(command - 1);
				this.influ = this.influ + this.item.addInflu();
				System.out.println(describeYourself());
			} catch (Exception e) {
				System.out.println("Wrong input");
			}
		}
		if (cmd.equalsIgnoreCase("use")) {
			for (int i = 0; i < tools.size(); i++) {
				System.out.println(i + 1 + ": " + tools.get(i).getItemName());
				keyboard = new Scanner(System.in);
			}
			try {
				command = keyboard.nextInt();
				this.item.useOn(this.location);
				this.item.isUsed();
			} catch (Exception e) {
				System.out.println("Wrong input");
			}
		}
	}

	private void fillBriefcase() {
		if (location.getItem() != null) {
			briefcase.add(location.getItem());
			if (location.getItem() instanceof Tool) {
				tools.add(location.getItem());
			}
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
		if (this.item instanceof Tool) {
			this.influ = this.influ + this.item.addInflu();
		}
	}

	public void addStonks() {
		if (item.isUsed() == true) {
			stonks = stonks + item.addStonk();
		}
	}

	public String getLocation() {
		return location.describeYourself();
	}

	public static String getName() {
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
		this.wearables.add(item);
	}

}
