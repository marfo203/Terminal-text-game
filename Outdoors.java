import java.util.Random;

public class Outdoors extends Location {

	private String weather;
	private String[] Rand = { "Sunny", "Rainy", "Cloudy" };

	public Outdoors(String name, String longDesc, String shortDesc, Item item) {
		super(name, longDesc, shortDesc, item);
	}

	public String getPassage() {
		return "path";
	}

	@Override
	public void checkPaths() {
		if (this.north != null) {
			System.out.println("There is a path leading north.");
		}
		if (this.south != null) {
			System.out.println("There is a path leading south.");
		}
		if (this.east != null) {
			System.out.println("There is a path leading east.");
		}
		if (this.west != null) {
			System.out.println("There is a path leading west.");
		}
	}

	public void setWeather() {
		Random r = new Random();
		int randomWeather = r.nextInt(Rand.length);
		this.weather = Rand[randomWeather];
		System.out.println("The weather is " + this.weather + "\n");

	}

	@Override
	public void locItems() {
		if (getItem() != null) {
			System.out.println("There is an item in this area: " + getItem().getItemName());
		} else {
			System.out.println("There are no items here.");
		}
	}
}
