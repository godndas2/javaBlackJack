package domain;

/*
 * Card의 pattern은 무늬
 * denomination은 A,2~10,J,Q,K
 * */
public class Card {

	private String pattern;
	private String denomination;
	private int point;
	
	// 생성자를 수정하여 반복문의 index가 들어오면 denomination과 point를 계산하도록 수정
	public Card(String pattern,int index) {
		this.pattern = pattern;
		this.denomination = this.numberToDenomination(index);
		this.point = this.numberToPoint(index);
	}
	
	private String numberToDenomination(int number) {
		
		if ( number == 1 ) {
			return "A";
		} else if( number == 11 ) {
			return "J";
		} else if( number == 12 ) {
			return "Q";
		} else if( number == 13 ) {
			return "K";
		}
		return String.valueOf(number); // number가 null 이면 문자열 null을 만들어서 담는다.
	}
	
	private int numberToPoint(int number) { // Card의 point값을 계산하는 역할, CardDeck이 생성될 때 52개 카드의 point도 자동으로 할당
		if (number >= 11) {
			return 10;
		}
		return number;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "Card [pattern=" + pattern + ", denomination=" + denomination + "]";
	}
	
}
