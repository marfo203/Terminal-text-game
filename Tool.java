
public class Tool extends Item {

	public Tool(String name, int influ, int stonks) {
		super(name, influ, stonks);
	}

	@Override
	public void useOn(Location location) {
		System.out.println("No use for this tool here...");
	}

	public void doCommand(String cmd) {
	}

}
