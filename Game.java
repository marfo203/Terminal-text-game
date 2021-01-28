import java.util.*;

public class Game {

	private String longDesc;
	private String shortDesc;
	private Scanner keyboard;
	private Player player;
	private ArrayList<Location> locations = new ArrayList<Location>();

	public void addLocation() { // Skapar våra Locations och lägger till dem i listan
		locations.add(new Location("Home", "Du är hemma och mår bra blalalala", "Sydafrika"));

		locations.add(new Location("Wall Street",
				"Wall Street. Home. At least it was before you moved out. Billions of dollars"
						+ " move through these buildings every day. All you need to do is to capture just a slice of it and you will be "
						+ "set for life. You will become the Puppy of Wall Street. Meet the right people. Buy the right stocks ant make your Stonks-meter increse.",
				"You are back on Wall Street. Go N/E/S/W"));
		
		locations.add(new Location("Billionare Boys Club",
				"Welcome to the BBC! The home of young and aspiaring trustfund kids like yourself! Come here to relax, party or get insider information. Everything from.. "
						+ "Wait is thet Mark \"Slobbins\" Cuban?",
				"Back at the BBC! Talk to one of the Billionare boys!"));
		
		locations.add(new Location("Silicon Valley",
				"Aaah.. Silicon Valley.. Or \" The V\" like the locals call it. The home of Start Ups that change the world as we know it! You can almost feel private information "
						+ "of millions of users travel through the wind! Amazing place and amazing people! Where do you want to go next?",
				"Back in The V! Wherre do you want to go?"));

	}

	public Game() {
		// Skapar vår player och introducerar världen
		String name;
		keyboard = new Scanner(System.in);

		System.out.println("Welcome to The Puppy of Wall Street \nWhat is your name?");
		name = keyboard.nextLine();
		System.out.println("Hello " + name
				+ ", welcome to the high pace world of the stock market! You can move around by typing north/south/west/east."
				+ "\nYou will have to learn more commands as you play the game! (Hint: there is a command \"help\").");
		System.out.println();
		
		System.out.println("Your goal is to gain Stonks and influence. You can get a higher or lower value depending on the choises you make."
				+ " You can see the value of your Stonks by typing \"Stonks\" at any time!");

		addLocation();
		player = new Player(name, locations.get(0), 100);

	}

	public void run() {

		while (true) {
			String command;

			player.getLocation();
			player.describeYourself();
			System.out.println("Right now your Stonks are at "+(player.getStonks())+"%");
			System.out.println(player.getLocation());
			System.out.println("What do you do? Go!");
			command = keyboard.nextLine();
			player.doCommand(command);
		}

	}
}
