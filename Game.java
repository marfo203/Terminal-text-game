import java.util.*;

public class Game {

	private String longDesc;
	private String shortDesc;
	private Scanner keyboard;
	private ArrayList<Location> locations;
	private Player player;

	public Game() {
		keyboard = new Scanner(System.in);
		locations = new ArrayList<>();
		locations.add(new Location("Home", longDesc, shortDesc));
		locations.add(new Location("WallSt", "Wall steet. The pinnacel of human intelect and  greed. Your second home. Billions of dollars pass through these buildings every day. Every second.\n Your goal "
				+ getName() + " is to maximize your profits and become the yougest Puppy."));
	}

	public void run() {
		String name;

		System.out.println("Welcome to 'The Puppy of Wall St'\nwhat is your name?");
		name = keyboard.nextLine();
		player = new Player(name, locations.get(0));
		System.out.println("Hello " + name
				+ ", welcome to the high pace world of the stock market! You can move around by typing north/south/west/east. You will have to learn more commands as you play the game! (Hint: there is a command \"help\").");

		while (true) {
			String command;

			player.getLocation().describeYourself();
			System.out.println("What do you want to do?");
			command = keyboard.nextLine();
			player.doCommand(command);
		}

	}
}
