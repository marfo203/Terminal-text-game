import java.util.ArrayList;

public class Location {

	private String name;
	private String description;
	private ArrayList<Location> neighbors = new ArrayList<Location>();

	public Location(String name, String longDesc, String shortDesc) {
	}

	public void setLocation(Location a, Location b, Location c, Location d) {
		neighbors.add(a);
		neighbors.add(b);
		neighbors.add(c);
		neighbors.add(d);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void describeYourself() {
		System.out.println();
	}

}
