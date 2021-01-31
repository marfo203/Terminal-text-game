import java.util.Random;

public class Outdoors extends Location {

	private String weather;
	private String[] Rand = { "Sunny", "Rainy", "Cloudy" };

	public Outdoors(String name, String longDesc, String shortDesc, Location north, Location south, Location east,
			Location west, int counter, String weather) {
		super(name, longDesc, shortDesc, north, south, east, west, counter);
		this.weather = weather;
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
}
