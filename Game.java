import java.util.*;

public class Game {

	private Scanner keyboard;
	private Player player;
	private static ArrayList<Location> locations = new ArrayList<Location>();
	private ArrayList<String> commands = new ArrayList<String>();
	private static ArrayList<Item> items = new ArrayList<Item>();

	public Game() {
		// Skapar vår player, array för locations
		// Skapar våra Locations och lägger till dem i listan
		// Skapar våra items

		Item scrubDaddy = new ScrubDaddy("Scrub Daddy", 20, 50);
		Item vest = new WearableItem("Patagonia Vest", 50, 0);
		Item turtleneck = new WearableItem("Steve Jobs Turtleneck", 200, 0);
		Item passWord = new Tool("Elon Musk's Twitter Password", 500, 400);

		Item phone = new phone("The Iphone", 100, 50);
		Item future = new Tool("Your bright future", 130, 0);
		
		

		Item phone = new Tool("The Iphone", 100, 0);
		Item future = new Future("Your bright future", 130, 0);


		Location home = new Indoors("Home", "You are at home and feeling great...Longdescription...",
				"Your are back at home", scrubDaddy, false);
		Location wallStreet = new Outdoors("Wall Street",
				"Wall Street. Home. At least it was before you moved out. Billions of dollars"
						+ " move through these buildings every day.\nAll you need to do is to capture just a slice of it and you will be "
						+ "set for life. You will become the Puppy of Wall Street. Meet the right people.\nBuy the right stocks ant make your Stonks-meter increse.",
				"You are back on Wall Street.", future);
		Location bbc = new Indoors("Billionare Boys Club",
				"Welcome to the BBC! The home of young and aspiring trustfund kids like yourself!\nCome here to relax, party or get insider information.\nEverything from... "
						+ "Wait is that Mark \"Slobbins\" Cuban?\n"
						+ "Slobbins: 'I am really looking for my next big investment. I heard the spongemarket is on fire right now!!'",
				"Back at the BBC! Talk to one of the Billionare boys!", vest, false);
		Location silVal = new Outdoors("Silicon Valley",
				"Aaah.. Silicon Valley.. Or \" The V\" like the locals call it.\nThe home of Start Ups that change the world as we know it!\nYou can almost feel private information "
						+ "of millions of users travel through the wind!\nAmazing place and amazing people! Where do you want to go next?",
				"Back in The V!", passWord);
		Location appleHQ = new Indoors("Apple Head Quarters", "AppleHQ...Longdescription...",
				"Back at AppleHQ! Talk to Tim Cook.", phone, false);
		Location appleCryo = new Indoors("Apple Cryo Chambers", "Tim takes you down to the Cryo Chambers...",
				"Down at the Cryo Chambers", turtleneck, true);

		locations.add(home);
		locations.add(wallStreet);
		locations.add(bbc);
		locations.add(silVal);
		locations.add(appleHQ);
		locations.add(appleCryo);
		
		items.add(scrubDaddy);
		items.add(future);
		items.add(phone);
		items.add(turtleneck);
		items.add(vest);
		items.add(passWord);
		
		

		home.setNeighbor(wallStreet, null, null, null);
		wallStreet.setNeighbor(silVal, home, null, bbc);
		bbc.setNeighbor(null, null, wallStreet, null);
		silVal.setNeighbor(null, wallStreet, null, appleHQ);
		appleHQ.setNeighbor(appleCryo, null, silVal, null);
		appleCryo.setNeighbor(null, appleHQ, null, null);

		commands.add("north/south/east/west - move around");
		commands.add("stats - See the value of your Stonks and Influence");
		commands.add("look - See items in current room or area");
		commands.add("items - See the current items in your briefcase");
		commands.add("take - Take item in current room or area");
//		commands.add("tweet - Use your phone and Twitter Password to tweet");
		commands.add("use - Use the tools in your briefcase");
		commands.add("wear - Wear the wearable items in your briefcase");
	}
	
	public static Location getLocation(int i) {
		return locations.get(i);
	}
	public static Item getItems (int i) {
		return items.get(i);
	}

	public void getHelp(String cmd) {
		System.out.println("These are the commands:");
		for (int i = 0; i < commands.size(); i++) {
			System.out.println(commands.get(i));
		}
	}

	public void run() {

		String name;
		keyboard = new Scanner(System.in);

		System.out.println("Welcome to The Puppy of Wall Street \nWhat is your name?");
		name = keyboard.nextLine();
		player = new Player(name, locations.get(0), 100, 0);
		System.out.println("\nHello " + name
				+ ", welcome to the high pace world of the stock market! You can move around by typing north/south/west/east."
				+ "\nYou will have to learn more commands as you play the game! (Hint: there is a command \"help\").\n");
		System.out.println(
				"Your goal is to gain Stonks and influence. You can get a higher or lower value depending on the choises you make. \n"
						+ "You can see the value of your Stonks and Influence by typing \"stats\" at any time!\n");

		while (true) {

			String command;

			player.describeYourself();
			System.out.println(player.getLocation() +"\n");
			player.getPosition().setWeather();
			player.getPosition().getDarkness();
			player.getPaths(player.getPosition());
			player.counterLocation();
			player.locItems();
			System.out.println("\nWhat do you do? Go!");
			command = keyboard.nextLine();
			if (command.equalsIgnoreCase("help")) {
				getHelp(command);
			} else {
				if (command.equalsIgnoreCase("stats")) {
					System.out.println(player.describeYourself());
				} else {
					player.doCommand(command);
				}
			}
		}
	}
}