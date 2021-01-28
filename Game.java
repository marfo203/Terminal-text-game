import java.util.*;

public class Game {

	private String longDesc;
	private String shortDesc;
	private Scanner keyboard;
	private ArrayList<Location> locations;
	private Player player;

	public Game() {
		String name;
        keyboard = new Scanner(System.in);
		System.out.println("Welcome to The Puppy of Wall Street \nWhat is your name?");
		name = keyboard.nextLine();

		locations = new ArrayList<Location>();
		locations.add(new Location("Home", "Du är hemma och mår bra blalalala", "Sydafrika"));
		locations.add(new Location("WallSt",
				"Wall steet. The pinnacle of human intellect and  greed. The cradle of innovation. Your second home. Billions of dollars pass through these buildings every day. Every second.\n Your goal "
						+ name + " is to maximize your profits and become the youngest Puppy.",
				"Wallnrkoat"));
		
		
		player = new Player(name, locations.get(0));
	}

	public void run() {

	

		System.out.println("Hello " + player.getName()
				+ ", welcome to the high pace world of the stock market! You can move around by typing north/south/west/east. You will have to learn more commands as you play the game! (Hint: there is a command \"help\").");

		while (true) {
			String command;

			player.getLocation().describeYourself();
			System.out.println("What do you do? Go!");
			command = keyboard.nextLine();
			player.doCommand(command);
		}

	}
}
