package cecs277DemoMementoPattern;

public enum Time {
	EIGHT, EIGHT_THIRTY, NINE, NINE_THIRTY, TEN, TEN_THIRTY, ELEVEN, ELEVEN_THIRTY, NOON, TWELVE_THIRTY,
	ONE, ONE_THIRTY, TWO, TWO_THIRTY, THREE, THREE_THIRTY, FOUR, FOUR_THIRTY, FIVE, FIVE_THIRTY, SIX;
	
	public String to_string () {
		return this.name().toLowerCase().replace("_", " ");
	}
}