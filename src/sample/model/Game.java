package sample.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import sample.model.cards.action_cards.ActionCard;
import sample.model.cards.action_cards.Village;
import sample.model.cards.treasury_cards.Copper;
import sample.model.cards.treasury_cards.Gold;
import sample.model.cards.treasury_cards.Silver;
import sample.model.cards.treasury_cards.TreasuryCard;
import sample.model.cards.victory_cards.Duchy;
import sample.model.cards.victory_cards.Estate;
import sample.model.cards.victory_cards.Province;
import sample.model.cards.victory_cards.VictoryCard;

public class Game {

    private static final int TWO_PLAYER_VICTORY_CARDS = 8;
    private static final int MULTIPLE_PLAYER_VICTORY_CARDS = 12;
    private static final int UNIVERSAL_TREASURY_CARDS = 50;
    private static final int UNIVERSAL_ACTIONS_CARDS = 10;

    private static Map<VictoryCard, Integer> victoryCards;
    private static Map<TreasuryCard, Integer> treasuryCards;
    private static Map<ActionCard, Integer> actionCards;

    private int numPlayers;
    private static Players players;

    public Game(int numPlayers) {
        this.numPlayers = numPlayers; //todo: check bounds on the number of players for the actual game

        victoryCards = new HashMap<>();
        if (numPlayers > 2) {
            victoryCards.put(new Estate(), MULTIPLE_PLAYER_VICTORY_CARDS);
            victoryCards.put(new Duchy(), MULTIPLE_PLAYER_VICTORY_CARDS);
            victoryCards.put(new Province(), MULTIPLE_PLAYER_VICTORY_CARDS);
        } else {
            victoryCards.put(new Estate(),TWO_PLAYER_VICTORY_CARDS);
            victoryCards.put(new Duchy(), TWO_PLAYER_VICTORY_CARDS);
            victoryCards.put(new Province(), TWO_PLAYER_VICTORY_CARDS);
        }
        treasuryCards = new HashMap<>();
        treasuryCards.put(new Copper(), UNIVERSAL_TREASURY_CARDS);
        treasuryCards.put(new Silver(), UNIVERSAL_TREASURY_CARDS);
        treasuryCards.put(new Gold(), UNIVERSAL_TREASURY_CARDS);

        actionCards = new HashMap<>();
        for (int i = 0; i < UNIVERSAL_ACTIONS_CARDS; i++) {
            actionCards.put(new Village(), UNIVERSAL_ACTIONS_CARDS);
        }

        this.players = new Players(this.numPlayers);
    }

    public static Player getCurrentPlayer() {
        return players.getCurrentPlayer(); //todo: fix this to actually get the current player or just use the GameScreen current player?
    }

    public void goToNextPlayer() {
        players.getNextPlayer();
    }

    public boolean isInProgress() {
        //! (3 action cards are depleted) && ! (1 esate is depeleted)
        return true;
    }

    public Players getPlayers() {
        //todo: make this immutable
        return players;
    }

    public static Map<VictoryCard, Integer> getVictoryCards() {
        return victoryCards;
    }

    public static Map<TreasuryCard, Integer> getTreasuryCards() {
        return treasuryCards;
    }

    public static Map<ActionCard, Integer> getActionCards() {
        return actionCards;
    }

    public static void decrementVictoryCards(VictoryCard victoryCard) {
        Integer available = victoryCards.get(victoryCard);
        victoryCards.put(victoryCard, available--);
    }

    public static void decrementTreasuryCards(TreasuryCard treasuryCard) {
        Integer available = treasuryCards.get(treasuryCard);
        treasuryCards.put(treasuryCard, available--);
    }

    public static void decrementActionCards(ActionCard actionCard) {
        Integer available = actionCards.get(actionCard);
        actionCards.put(actionCard, available--);
    }
}
