package sample.model;

import java.util.ArrayList;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import sample.model.cards.Card;
import sample.model.cards.action_cards.ActionCard;
import sample.model.cards.treasury_cards.TreasuryCard;
import sample.model.cards.victory_cards.VictoryCard;
import sample.model.visitor_pattern.Visitor;

public class Hand {
    private static final int START_ACTIONS = 1;
    private static final int START_BUYS = 1;

    private ObservableList<Card> cards;
    private ArrayList<ActionCard> actionCards;
    private int treasuryPoints;
    private int numActions = START_ACTIONS;
    private int numBuys = START_BUYS;

    public Hand(ObservableList<Card> cards) {
        this.cards = cards;
        this.cards.addListener((ListChangeListener<Card>) c -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    System.out.printf("added");
                } else {
                    System.out.println("something else happened");
                }
            }
        });
        this.actionCards = new ArrayList<>();
        for (Card card : cards) {
            card.accept(new IDKVIsitor());
        }
    }

    public ObservableList<Card> getCards() {
        return cards;
    }

    public ArrayList<ActionCard> getActionCards() {
        return actionCards;
    }

    public int getMoneyAmount() {
        return treasuryPoints;
    }

    public int getNumActions() {
        return numActions;
    }

    public int getNumBuys() {
        return numBuys;
    }

    public void changeTreasuryPointsBy(int shift) {
        this.treasuryPoints += shift;
    }

    public void changeNumActionsBy(int shift) {
        this.numActions += shift;
    }

    public void changeNumBuysBy(int shift) {
        this.numBuys += shift;
    }

    public void addCard(Card card) {
        cards.add(card);
        //        actionCards.add(card); //todo: depends on description of action card...
    }

    public void removeCard(Card card) {
        cards.remove(card);
        //        actionCards.remove(card);
    }

    private class IDKVIsitor implements Visitor {
        @Override
        public void visit(TreasuryCard treasuryCard) {
            treasuryPoints += treasuryCard.getValue();
        }

        @Override
        public void visit(VictoryCard victoryCard) {

        }

        @Override
        public void visit(ActionCard actionCard) {
            actionCards.add(actionCard);
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
