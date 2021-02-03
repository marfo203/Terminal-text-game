
public class ScrubDaddy extends Tool {
	private Location location;
	private Game game;

	public ScrubDaddy(String name, int influ, int stonks) {
		super(name, influ, stonks);
	}

	public void useOn(Location location) {
		if (location == Game.getLocation(2)) {
			System.out.println("You pitch the Scrub Daddy to Slobbins\n");
			System.out.println(
					"The Smiling Scrubbers are our most recognizable cleaning tools."
					+ "Yes the face is cute but there’s more to our iconic shape than you may think.\n"
					+ "Measuring over 1 ½ inches thick, Scrub Daddy’s unique size cleans the\n"
					+ "sides and depths of your containers simultaneously. The round shape is ergonomically\n"
					+ "designed for comfortable grip and the most thorough cleaning on everything from measuring\n"
					+ "cups to salad bowls. The eyes hold onto your fingers offering protection and a 360 degreed\n"
					+ "scrubbing surface; an especially helpful feature when dexterity is limited. And how could\n"
					+ "we forget that contagious grin? Effortlessly clean your kitchen utensils with a quick swipe.\n");
			System.out.println("Slobbins: Nice pitch, " + Player.getName() +"!");
		} else {
			System.out.println("No use for a Scrub Daddy here...");
		}
	}
}
