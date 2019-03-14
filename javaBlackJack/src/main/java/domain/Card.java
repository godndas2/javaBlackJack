package domain;

/*
 * Card의 pattern은 무늬
 * denomination은 A,2~10,J,Q,K
 * */
public class Card {

	private String pattern;
	private String denomination;
	
	public Card(String pattern, String denomination) {
		super();
		this.pattern = pattern;
		this.denomination = denomination;
	}
	
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	@Override
	public String toString() {
		return "Card [pattern=" + pattern + ", denomination=" + denomination + "]";
	}
	
}
