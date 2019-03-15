import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import domain.Card;
import domain.CardDeck;

public class ApplicationTest {
	
	private CardDeck cardDeck;
	private List<Card> cards;
	
	
   @Before
    public void setup() {
        cardDeck = new CardDeck();
        cards = cardDeck.getCards();
    }
	/*
	 * 0~13번째 카드를 뽑아서 그게 SPACE인지 HEART인지 검증
	 * 
	 * */
	@Test
	public void test_CardPattern() {
		assertThat(cards.get(0).getPattern(), is(Card.Pattern.SPACE));
		assertThat(cards.get(13).getPattern(), is(Card.Pattern.HEART));
	}
	
	@Test@Ignore
    public void test_카드끗수비교 () {
        assertThat(cards.get(0).getDenomination(), is(Card.Denomination.ACE));
        assertThat(cards.get(0).getDenomination().getPoint(), is(1));
    }
	 
	@Test@Ignore
    public void test_List를Stack으로변환() {
        assertThat(cardDeck.getCards().size(), is(52));
        cardDeck.draw();
        assertThat(cardDeck.getCards().size(), is(51));
        cardDeck.draw();
        assertThat(cardDeck.getCards().size(), is(50));
        cardDeck.draw();
        assertThat(cardDeck.getCards().size(), is(49));
    }
}
