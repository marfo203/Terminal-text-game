import java.util.*;

public class Game {

	private Scanner keyboard;
	private Player player;
	private Location a, b, c, d;
	private ArrayList<Location> locations = new ArrayList<Location>();
	private ArrayList<Location> neighbors = new ArrayList<Location>();

	public Game() {
		// Skapar vår player, array för locations

 // Skapar våra Locations och lägger till dem i listan

		Location Home = new Indoors("Home", "Du är hemma och mår bra blalalala", "Sydafrika", a, b, c, d);
		locations.add(Home);
		Location WallStreet = new Outdoors("Wall Street",
				"Wall Street. Home. At least it was before you moved out. Billions of dollars"
						+ " move through these buildings every day.\nAll you need to do is to capture just a slice of it and you will be "
						+ "set for life. You will become the Puppy of Wall Street. Meet the right people.\nBuy the right stocks ant make your Stonks-meter increse.",
				"You are back on Wall Street. Go N/E/S/W", a, b, c, d);
		locations.add(WallStreet);

		Location BBC = (new Indoors("Billionare Boys Club",
				"Welcome to the BBC! The home of young and aspiaring trustfund kids like yourself! Come here to relax, party or get insider information. Everything from.. "
						+ "Wait is that Mark \"Slobbins\" Cuban?",
				"Back at the BBC! Talk to one of the Billionare boys!", a, b, c, d));
		locations.add(BBC);

		Location SilVal = (new Outdoors("Silicon Valley",
				"Aaah.. Silicon Valley.. Or \" The V\" like the locals call it. The home of Start Ups that change the world as we know it! You can almost feel private information "
						+ "of millions of users travel through the wind! Amazing place and amazing people! Where do you want to go next?",
				"Back in The V! Where do you want to go?", a, b, c, d));
		locations.add(SilVal);

	
		
		Home.setNeighbor(WallStreet, null, null, null);
	    WallStreet.setNeighbor(null, BBC, Home, null);
	    BBC.setNeighbor(null, WallStreet, null, null);
	}

	public void run() {
		// Första som händer i spelet
		String name;
		keyboard = new Scanner(System.in);

		System.out.println("Welcome to The Puppy of Wall Street \nWhat is your name?");
		name = keyboard.nextLine();
		player = new Player(name, locations.get(0), 100, 100);
		System.out.println("Hello " + name
				+ ", welcome to the high pace world of the stock market! You can move around by typing north/south/west/east."
				+ "\nYou will have to learn more commands as you play the game! (Hint: there is a command \"help\").");
		System.out.println();
		System.out.println(
				"Your goal is to gain Stonks and influence. You can get a higher or lower value depending on the choises you make. \n"
						+ "You can see the value of your Stonks and Influence by typing \"stats\" at any time!");

		while (true) {

			String command;

			player.getLocation();
			player.describeYourself();

			System.out.println(player.getLocation());
		
			player.getPaths(locations.get(0));			
			System.out.println("What do you do? Go!");
			
		
			
			command = keyboard.nextLine();
			player.doCommand(command);
		}

	}
}
