package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * return type이 void가 아닌 것들은 null을 리턴한다.
 * */
public class CardDeck {

	private List<Card> cards;
	
	private static final String[] PATTERNS = {"space", "heart", "diamond", "club"};
	private static final int CARD_COUNT = 13;
	
	/* CardDeck.draw 메소드는 실제로 카드를 뽑아줘야 하기 때문에 구체적된 코드를 작성해보겠습니다. 
	   draw는 남아 있는 카드 중 랜덤한 1개의 카드를 준다 라는 CardDeck의 유일한 역할을 하고 있습니다. 
	       즉, CardDeck은 본인의 역할을 수행하기 위해 52개의 서로 다른 카드가 존재 해야만 합니다. 
	       생성 되는 시점에는 이 조건을 만족해야만 하기 때문에 생성자 를 사용하겠습니다.
	       
	       각 메소드는 하나의 역할만 할 수 있도록 분리하였습니다.
	 * */
	private List<Card> generateCards() {
		
//		cards = new ArrayList<>();
		List<Card> cards = new LinkedList<>();
		
		for (String pattern : PATTERNS) {
			for (int i = 1; i <= CARD_COUNT; i++) { // 1 ~ 13
				String denomination = this.numberToDenomination(i);
				Card card = new Card(pattern, denomination);
//				card.setDenomination(denomination);
//				card.setPattern(pattern);
				cards.add(card);
		}
	}
		return cards;
}
	
	public CardDeck() {
		cards = this.generateCards();
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

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for (Card card : cards) {
			sb.append(card.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
}
