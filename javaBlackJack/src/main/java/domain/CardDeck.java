package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * return type이 void가 아닌 것들은 null을 리턴한다.
 * */
public class CardDeck {

	private Stack<Card> cards;
	
	/* CardDeck.draw 메소드는 실제로 카드를 뽑아줘야 하기 때문에 구체적된 코드를 작성해보겠습니다. 
	   draw는 남아 있는 카드 중 랜덤한 1개의 카드를 준다 라는 CardDeck의 유일한 역할을 하고 있습니다. 
	       즉, CardDeck은 본인의 역할을 수행하기 위해 52개의 서로 다른 카드가 존재 해야만 합니다. 
	       생성 되는 시점에는 이 조건을 만족해야만 하기 때문에 생성자 를 사용하겠습니다.
	       
	       각 메소드는 하나의 역할만 할 수 있도록 분리하였습니다.
	 */
	
	public CardDeck() {
		this.cards = this.generateCards();
		Collections.shuffle(this.cards);
	}
	
	private Stack<Card> generateCards() {
		
		Stack<Card> cards = new Stack<>();
		
		for (Card.Pattern pattern : Card.Pattern.values()) {
			for (Card.Denomination denomination : Card.Denomination.values()) {
				Card card = new Card(pattern, denomination);
				cards.add(card);
			}
		}
		
		/*
		 * 그전에 있던 문자열 배열인 patterns를 제거하고, Card내부의 Pattern enum으로 Card 인스턴스 생성 코드를 수정
		 * enum.values()를 사용할 경우 그 결과는 해당 enum이 갖고 있는 모든 타입의 Java에서 enum의 타입들을 전부 순회하기 위해서는 해당 타입.values() 메소드를 사용하면 됩니다.
		 * 이 경우 values 메소드의 결과는 해당 enum이 갖고 있는 모든 타입들이기 때문에 변경에 따라 코드 수정이 필요없게 됩니다.  
		*/
		
		return cards;
}
	
	public Stack<Card> getCards(){
		return cards;
	}
	
	// draw() : 1) 남아 있는 카드 중 1개를 뽑는다. 2) 뽑은 카드는 카드덱에서 제거한다. -> 기능 분리
	public Card draw() {
		return this.cards.pop();
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
