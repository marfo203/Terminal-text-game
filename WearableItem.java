
public class WearableItem extends Item {
	private String name;

	public WearableItem(String name, int influ, int stonks) {
		super(name, influ, stonks);
		this.name = name;
	}

	@overrides
	public void putOn(Player player) {
		player.wearItem(this);

	}

	public String getWearName() {
		return this.name;
	}

	public void doCommand(String cmd) {
	}

}
