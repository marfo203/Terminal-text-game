
public class Home extends Location{

	public Home(String name, String longDesc, String shortDesc) {
		super(name, longDesc, shortDesc);
	}
		@Override
		public void describeYourself() {
			System.out.println("Majs");
		}
}
