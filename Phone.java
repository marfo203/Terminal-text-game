
public class Phone extends Tool {

	public Phone(String name, int influ, int stonks) {
		super(name, influ, stonks);
	}
		@Override
		public void useOn(Location location, Player player) {
			if (location == Game.getLocation(1) && player.getBriefcase().contains(Game.getItems(5))) {
				player.addStonks();
				System.out.println("You tweeted market manipulating information from Elons account and crashed the Euro, which you had shorted! Nice one!");
				System.out.println(player.describeYourself());
			} else { 
				System.out.println("Your tweet earned you nothing!");


		}
	}
}
