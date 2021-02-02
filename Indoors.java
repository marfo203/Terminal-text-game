
public class Indoors extends Location {

	public Indoors(String name, String longDesc, String shortDesc, Item item) {
		super(name, longDesc, shortDesc, item);
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

	@Override
	public void locItems() {
		if (getItem() != null) {
			System.out.println("There is an item in this room: " + getItem().getItemName());
		} else {
			System.out.println("There are no items here.");
		}
	}

}
