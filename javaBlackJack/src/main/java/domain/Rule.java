package domain;

import java.util.List;

/*
 * 승패 판단하는 역할
 * */
public class Rule {

	public int getScore(List<Card> cards) {
		return 0;
	}
	
	public Player getWinner(List<Player> players) {
		
		Player highestPlayer = null;
		int highestPoint = 0;
		
		for (Player player : players) {
			int playerPointSUm = getPointSum(player.openCards());
			if (playerPointSUm > highestPoint) {
				highestPlayer = player;
				highestPoint = playerPointSUm;
			}
		}
		return highestPlayer;
	}
	
	private int getPointSum(List<Card> cards) {
		int sum = 0;
		for (Card card : cards) {
			sum += card.getPoint();
		}
		return sum;
	}
}
