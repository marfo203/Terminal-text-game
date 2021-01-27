
public class WallSt extends Location {

	public WallSt(String name, String longDesc, String shortDesc) {
		super(name, longDesc, shortDesc);
	}
		@Override
		public String getDescription() {
			return System.out.println("Wall steet. The pinnacel of human intelect and  greed. Your second home. Billions of dollars pass through these buildings every day. Every second.\n Your goal " + getName() + " is to maximize your profits and become the yougest Puppy.");
		
	}

}
