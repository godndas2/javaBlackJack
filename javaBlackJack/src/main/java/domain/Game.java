package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

	private static final int INIT_RECEIVE_CARD_COUNT = 2;
	private static final String STOP_RECEIVE_CARD = "0";
	
	public void play() {
		System.out.println("========== BlackJack ==========");
		Scanner sc = new Scanner(System.in);
		Rule rule = new Rule();
		CardDeck cardDeck = new CardDeck();
		
		List<Player> players = Arrays.asList(new Gamer("사용자A"), new Dealer());
		List<Player> initAfterPlayers = initPhase(cardDeck, players);
		List<Player> playingAfterPlayer = playingPhase(sc, cardDeck, initAfterPlayers);
		
		Player winner = rule.getWinner(playingAfterPlayer);
		System.out.println("Winner : " + winner.getName());
			
	}
	
	
	private List<Player> receiveCardAllPlayers(Scanner sc, CardDeck cardDeck, List<Player> players) {
		
		for (Player player : players) {
			System.out.println(player.getName() + "님 차례입니다.");
			
			if (isReceiveCard(sc)) {
				Card card = cardDeck.draw();
				player.receiveCard(card);
				player.turnOn();
			} else {
				player.turnOff();
			}
		}
		return players;
	}
	
	private boolean isAllPlayerTurnOff(List<Player> players) { // 카드뽑기 종료상태인지 확인하는 역할
		for (Player player : players) {
			if (player.isTurn()) {
				return false;
			}
		}
		return true;
	}
	
	// 카드 뽑기
	private List<Player> playingPhase(Scanner sc, CardDeck cardDeck, List<Player> players) {
		/*
		 *  receiveCardAllPlayers : 모든 Player가 Card를 뽑도록 하는 역할
			playingPhase : receiveCardAllPlayers 결과에 따라 receiveCardAllPlayers를 반복시키는 역할
			isReceiveCard : Player 개개인에게 카드를 뽑을건지 의사를 묻는 역할
		 * */
		List<Player> cardReceivedPlayers;
		while (true) {
			cardReceivedPlayers = receiveCardAllPlayers(sc, cardDeck, players);
			if (isAllPlayerTurnOff(cardReceivedPlayers)) {
				break;
			}
				
		}
		return cardReceivedPlayers;
	}
	
	private boolean isReceiveCard(Scanner sc) {
		System.out.println("카드를 뽑겠습니까? 종료:0");
		return !STOP_RECEIVE_CARD.equals(sc.nextLine());
	}
	
	// 처음 시작시 Dealer와 Gamer가 2장씩 카드를 받는 역할을 담당
	private List<Player> initPhase(CardDeck cardDeck, List<Player> players) {
		System.out.println("처음 2장의 카드를 각자 뽑겠습니다.");
		for (int i = 0; i < INIT_RECEIVE_CARD_COUNT; i++) {
			for (Player player : players) {
				System.out.println(player.getName()+"님 차례입니다.");
				Card card = cardDeck.draw();
				player.receiveCard(card);
			}
		}
		return players;
	}
}
