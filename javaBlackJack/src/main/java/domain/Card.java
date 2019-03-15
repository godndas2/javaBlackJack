package domain;


/*
 * Card의 pattern은 무늬
 * denomination은 A,2~10,J,Q,K
 * */
public class Card {

	private Pattern pattern;
	private Denomination denomination;
	
	// 생성자를 수정하여 반복문의 index가 들어오면 denomination과 point를 계산하도록 수정
	public Card(Pattern pattern,Denomination denomination) {
		this.pattern = pattern;
		this.denomination = denomination;
	}
	
	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public Denomination getDenomination() {
		return denomination;
	}
	public void setDenomination(Denomination denomination) {
		this.denomination = denomination;
	}
	
	@Override
	public String toString() {
		return "Card [pattern=" + pattern + ", denomination=" + denomination + "]";
	}
	
	public enum Pattern { /* 문자열이 아닌 Pattern이란 enum으로 대체
	 						 Card외에는 사용되는 곳이 없기 때문에
							 innerType, Card 내부에 선언
	 					  */
		SPACE("SPACE"),
		HEART("heart"),
		DIAMOND("diamond"),
		CLUB("club");
		
		private String value;
		
		Pattern(){}
		
		Pattern(String value) {
			this.value = value;
		}
	}
	
	public enum Denomination {
		
		ACE("A", 1),
        TWO("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JACK("J", 10),
        QUEEN("Q", 10),
        KING("K", 10);
	
	private String mark;
	private int point;
	
	Denomination(){}
	
    Denomination(String mark, int point) {
        this.mark = mark;
        this.point = point;
    }
        
    public int getPoint() {
        return this.point;
    }  
  }
}
