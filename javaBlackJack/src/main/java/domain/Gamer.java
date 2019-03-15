package domain;

import java.util.ArrayList;
import java.util.List;

/*
 * 1) 추가로 카드를 받는다.
 * 2) 뽑은 카드를 소유한다.
 * 3) 카드를 오픈한다.
 * Gamer는 현재 카드를 확인 할 수 있어야한다.
 * */
public class Gamer implements Player{

	private List<Card> cards;
	private boolean turn;
	private String name;
	
	public Gamer(String name) {
//		cards = new ArrayList<>();
		this.cards = new ArrayList<>();
		this.name = name;
	}
	
	@Override
    public void turnOff() {
        this.setTurn(false);
    }

    @Override
    public void turnOn() {
        this.setTurn(true);
    }

    @Override
    public boolean isTurn() {
        return this.turn;
    }

    private void setTurn(boolean turn) {
        this.turn = turn;
    }
	
	@Override
	public void receiveCard(Card card) { 
		this.cards.add(card);
		this.showCards();// 카드를 받을 때마다 현재 소유한 카드를 확인해야함
	}
	
	@Override
	public List<Card> openCards(){ // 현재 갖고 있는 모든 카드를 전달하는 역할
		return this.cards;
		}
	
	@Override
	public void showCards() {
		StringBuilder sb = new StringBuilder(); // sysout은 성능저하
		sb.append("현재 카드 보유 목록 \n");
		
		for (Card card : cards) {
			sb.append(card.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	@Override
	public String getName() {
		return this.name;
	}
	
}
