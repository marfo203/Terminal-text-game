
public class Item {
	private int stonks;
	private String name;
	private int influ;
	private boolean used = false;

	public Item(String name, int influ, int stonks) {
		this.name = name;
		this.influ = influ;
		this.stonks = stonks;
	}

	public void printYourself() {
	}
	
	public void putOn(Player player) {		
	}
	
	public void useOn(Location location, Player player) {	
	}

	public void doCommand(String cmd) {
	}

	public String getItemName() {
		return this.name;

	}

	public int addInflu() {
		return this.influ;
	}

	public int addStonk() {
		return this.stonks;
	}

	public boolean isUsed() {	
		used = true;
		return used;
	}

}
