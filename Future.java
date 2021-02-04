
public class Future extends Tool {

	public Future(String name, int influ, int stonks) {
		super(name, influ, stonks);
	}

	@Override
	public void useOn(Location location, Player player) {
		if (location == Game.getLocation(5) && location.getDarkness()) {
			System.out.println(
					"You used your bright future to light up the room! You can now enter down in the Apple HQ Cryo chambers.\n");
			location.setDarkness();
		} else {
			System.out.println("No use for your bright future here...");
		}
	}
}
