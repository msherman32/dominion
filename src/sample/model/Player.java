package sample.model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import sample.model.cards.Card;
import sample.model.cards.action_cards.ActionCard;
import sample.model.cards.treasury_cards.Copper;
import sample.model.cards.treasury_cards.TreasuryCard;
import sample.model.cards.victory_cards.Estate;
import sample.model.cards.victory_cards.VictoryCard;
import sample.model.visitor_pattern.Visitable;
import sample.model.visitor_pattern.Visitor;

public class Player {
    private static final int HAND_SIZE = 5;
    private static final int INITIAL_NUM_COPPER = 7;
    private static final int INITIAL_NUM_ESTATE = 3;

    private int playerId;
    private Hand hand;
    private List<Card> deck;
    private List<Card> discardPile;
    private int score;
    private int treasuryPoints;

    public Player(int playerNo) {
        this.playerId = playerNo;
        //todo: why is all this here??
        deck = createStartDeck();
        drawNewHand();
        discardPile = new ArrayList();
        score = INITIAL_NUM_ESTATE;
        treasuryPoints = INITIAL_NUM_COPPER;
    }

    public void takeTurn() {
        drawNewHand();
        performActions();
        buyCards();
    }

    private void performActions() {
        while (hand.getNumActions() > 0) {
            performAction();
            hand.changeNumActionsBy(-1);
        }
    }

    private void buyCards() {
        while (hand.getNumBuys() > 0) {
//            buyCard(userInput);
            hand.changeNumBuysBy(-1);
        }
    }

    private void performAction() {
    }

    public boolean canBuyCard(Card card) {
        return card.getCost() <= hand.getMoneyAmount();
    }
    public void buyCard(Visitable card){
//        if (((Card) card).getCost() > hand.getBuyingPower()) {
//            throw new RuntimeException(String.format("Card costs %d, but your buying power is only %d",
//                    ((Card) card).getCost(), hand.getBuyingPower()));
//        }
        card.accept(new BuyVisitor());
    }

    private void drawNewHand() {
        if (deck.size() < HAND_SIZE) {
            shuffleDeck();
        }

        ArrayList<Card> cards = new ArrayList<>();
        int i = 0;
        while (i < HAND_SIZE) {
            cards.add(deck.remove(0));
            i++;
        }
        hand = new Hand(FXCollections.observableArrayList(cards));
    }

    public void trash(Card card) {

        //add the card back to the hashset of the game
    }

    public void discard(Card card) {
        if (card == null) {
            throw new RuntimeException("null card");
        }
        hand.removeCard(card);
        discardPile.add(card);
    }

    public Hand getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public int getPlayerId() {
        return playerId;
    }

    private void shuffleDeck() {
        for (Card card : discardPile) {
            deck.add(card); //todo: make this randomized
        }

    }

    private List<Card> createStartDeck() {
        List<Card> initialDeck = new ArrayList<>();
        for (int i = 0; i < INITIAL_NUM_ESTATE; i++) {
            initialDeck.add(new Estate());
        }
        for (int i = 0; i < INITIAL_NUM_COPPER; i++) {
            initialDeck.add(new Copper());
        }
        return initialDeck;
    }

    private class BuyVisitor implements Visitor {

        //todo: subtract these cards from the game's available cards

        @Override
        public void visit(TreasuryCard treasuryCard) {
            treasuryPoints += treasuryCard.getValue();
            hand.changeTreasuryPointsBy(-treasuryCard.getCost());
            hand.changeNumBuysBy(-1);
            hand.addCard(treasuryCard);
            discardPile.add(treasuryCard);
            Game.decrementTreasuryCards(treasuryCard);
        }

        @Override
        public void visit(VictoryCard victoryCard) {
            score += victoryCard.getPoints();
            hand.changeTreasuryPointsBy(-victoryCard.getCost());
            hand.changeNumBuysBy(-1);
            hand.addCard(victoryCard);
            discardPile.add(victoryCard);
            Game.decrementVictoryCards(victoryCard);
        }

        @Override
        public void visit(ActionCard actionCard) {
            hand.changeTreasuryPointsBy(-actionCard.getCost());
            hand.changeNumBuysBy(-1);
            hand.addCard(actionCard);
            discardPile.add(actionCard); //fixme: it is not always discarded but can go back to your hand
            Game.decrementActionCards(actionCard);
        }

        @Override
        public int getAvailability(TreasuryCard treasuryCard) {
            return 0;
        }

        @Override
        public int getAvailability(VictoryCard victoryCard) {
            return 0;
        }

        @Override
        public int getAvailability(ActionCard actionCard) {
            return 0;
        }
    }
}
