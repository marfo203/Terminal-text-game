import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	int command;
	private Scanner keyboard;
	private String name;
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
			System.out.println("");
		}
		if (cmd.equalsIgnoreCase("take")) {
			if (location.getItem() != null) {
				fillBriefcase();
				System.out.println("You took: " + this.item.getItemName());
				System.out.println(describeYourself());
			} else {
				System.out.println("There are no items to take\n");
			}
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
			if (wearables.size() != 0) {
				System.out.println("What do you want to wear?");
				for (int i = 0; i < wearables.size(); i++) {
					System.out.println(i + 1 + ": " + wearables.get(i).getItemName());
					keyboard = new Scanner(System.in);
				}
				try {
					command = keyboard.nextInt();
					System.out.println("You are now wearing " + wearables.get(command - 1).getItemName());
					wearables.remove(command - 1);
					addInfluence();
					System.out.println(describeYourself());
				} catch (Exception e) {
					System.out.println("Wrong input. Use an integer.");
				}
			} else {
				System.out.println("There is nothing in your briefcase to wear");
			}
		}

		if (cmd.equalsIgnoreCase("use")) {
			if (tools.size() != 0) {
				for (int i = 0; i < tools.size(); i++) {
					System.out.println(i + 1 + ": " + tools.get(i).getItemName());
					keyboard = new Scanner(System.in);
				}
				try {
					command = keyboard.nextInt();
					this.item = tools.get(command - 1);
					this.item.useOn(this.location, this);
				} catch (Exception e) {
					System.out.println("Wrong input. Use an integer.");
				}
			} else {
				System.out.println("There is nothing in your briefcase to use");
			}

		}
		if (cmd.equalsIgnoreCase("tweet")) {
			if (briefcase.contains(Game.getItems(2))) {
				Game.getItems(2).useOn(location, this);
		} else {
			System.out.println("You don't have a phone yet.");

		}
		}
	}

	public void fillBriefcase() {
		briefcase.add(location.getItem());
		this.item = location.getItem();
		if (location.getItem() instanceof Tool) {
			tools.add(location.getItem());
			addInfluence();
		}
		if (location.getItem() instanceof WearableItem) {
			wearables.add(location.getItem());
		}
		location.itemTaken();
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

	public void addStonks() {
		if (item.isUsed() == true) {
			stonks = stonks + item.addStonk();
		}
	}

	public String getLocation() {
		return location.describeYourself();
	}

	public String getName() {
		return name;
	}

	public String describeYourself() {
		return "Right now your Stonks are at " + (getStonks()) + "%. And your Influence is at " + getInfluence()
				+ ".\n";
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

	public ArrayList<Item> getBriefcase() {
		return briefcase;
	}

}
