package domain;

import java.util.List;

public interface Player {

	// Gamer와 Dealer의 공통인 메소드
	void receiveCard(Card card);
	void showCards();
	List<Card> openCards();
	// -
	void turnOff();
	void turnOn();
	boolean isTurn();
	String getName();
	
}
