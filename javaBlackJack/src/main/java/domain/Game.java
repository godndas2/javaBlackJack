package domain;

public class Game {

	public void play() {
		System.out.println("========== BlackJack ==========");
		Dealer dealer = new Dealer();
		Gamer gamer = new Gamer();
		Rule rule = new Rule();
		CardDeck cardDeck = new CardDeck();
		
		System.out.println(cardDeck.toString());
	}
}