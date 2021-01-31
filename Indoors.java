
public class Indoors extends Location {

	public Indoors(String name, String longDesc, String shortDesc, Location north, Location south, Location east,
			Location west, int counter) {
		super(name, longDesc, shortDesc, north, south, east, west, counter);
	}

	@Override
	public void checkPaths() {
		if (this.north != null) {
			System.out.println("There is a door leading north.");
		}
		if (this.south != null) {
			System.out.println("There is a door leading south.");
		}
		if (this.east != null) {
			System.out.println("There is a door leading east.");
		}
		if (this.west != null) {
			System.out.println("There is a door leading west.");
		}
	}
}
