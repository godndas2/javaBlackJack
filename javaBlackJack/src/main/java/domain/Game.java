package domain;

import java.util.Scanner;

public class Game {

	public void play() {
		System.out.println("========== BlackJack ==========");
		Scanner sc = new Scanner(System.in);
		Dealer dealer = new Dealer();
		Gamer gamer = new Gamer();
		Rule rule = new Rule();
		CardDeck cardDeck = new CardDeck();
		
		initPhase(cardDeck, gamer, dealer);
		playingPhase(sc, cardDeck, gamer, dealer);
	}
	
	// 카드 뽑기
	public void playingPhase(Scanner sc, CardDeck cardDeck, Gamer gamer, Dealer dealer) {
		String gamerInput, dealerInput;
		boolean isGamerTurn = false, isDealerTurn = false;
		
		while (true) {
			System.out.println("카드를 뽑으시겠습니까? 종료:0");
			gamerInput = sc.nextLine();
			
			if ("0".equals(gamerInput)) {
				isGamerTurn = true;
				System.out.println("종료되었습니다.");
			} else {
				Card card = cardDeck.draw(); // 뽑고
				gamer.receiveCard(card); // 받고 확인
			}
			
			System.out.println("카드를 뽑겠습니까? 종료:0");
			dealerInput = sc.nextLine();
			
			if ("0".equals(dealerInput)) {
				isDealerTurn = true;
				System.out.println("종료되었습니다.");
			} else {
				Card card = cardDeck.draw();
				dealer.receiveCard(card);
			}
			
			if ( isGamerTurn && isDealerTurn) {
				break;
			}
		}
	}
	
	// 처음 시작시 Dealer와 Gamer가 2장씩 카드를 받는 역할을 담당
	
	private static final int INIT_RECEIVE_CARD_COUNT = 2;
	
	private void initPhase(CardDeck cardDeck, Gamer gamer, Dealer dealer) {
		System.out.println("처음 2장의 카드를 각자 뽑겠습니다.");
		
		for (int i = 0; i < INIT_RECEIVE_CARD_COUNT; i++) {
			Card card = cardDeck.draw();
			gamer.receiveCard(card);
			
			Card card2 = cardDeck.draw();
			dealer.receiveCard(card2);
		}
	}
}
