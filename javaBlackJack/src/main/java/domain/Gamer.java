package domain;

import java.util.ArrayList;
import java.util.List;

/*
 * 1) 추가로 카드를 받는다.
 * 2) 뽑은 카드를 소유한다.
 * 3) 카드를 오픈한다.
 * Gamer는 현재 카드를 확인 할 수 있어야한다.
 * */
public class Gamer {

	private List<Card> cards;
	
	public Gamer() {
		cards = new ArrayList<>();
	}
	
	public void receiveCard(Card card) { 
		this.cards.add(card);
		this.showCards();// 카드를 받을 때마다 현재 소유한 카드를 확인해야함
	}
	
	public List<Card> openCards(){ // 현재 갖고 있는 모든 카드를 전달하는 역할
		return this.cards;
		}
	
	public void showCards() {
		StringBuilder sb = new StringBuilder(); // sysout은 성능저하
		sb.append("현재 카드 보유 목록 \n");
		
		for (Card card : cards) {
			sb.append(card.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
