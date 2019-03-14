package domain;

import java.util.ArrayList;
import java.util.List;

/*
 * 1) 추가로 카드를 받는다
 * 2) 단, 2카드의 합계 점수가 16점 이하일 때 1장을 뽑고, 17점 이상이면 받을 수 없다.
 * 3) 뽑은 카드를 소유한다
 * 4) 카드를 오픈
 * 
 * 게임의 승패 판단 : Rule, 카드뽑기 : CardDeck
 * */
public class Dealer {

	private List<Card> cards;
	private static final int CAN_RECEIVE_POINT = 16;
	
	public Dealer() {
		cards = new ArrayList<>();
	}
	
	public void receiveCard(Card card) {
		if (this.isReceiveCard()) { // 총 포인트 합이 16이하인 경우
			this.cards.add(card);
			this.showCards();
		} else {
			System.out.println("카드의 총 합이 17이상입니다. 카드를 받을 수 없습니다.");
		}
	}
	
	private boolean isReceiveCard() {
		return getPointSum() <= CAN_RECEIVE_POINT;
	}
	
	private int getPointSum() {
		int sum = 0;
		for (Card card : cards) {
			sum += card.getPoint();
		}
		return sum;
	}
	
	public void showCards() {
		StringBuilder sb = new StringBuilder();
		sb.append("현재 카드 보유 목록 \n");
		
		for (Card card : cards) {
			sb.append(card.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public List<Card> openCards() {
		return this.cards;
	}
}
