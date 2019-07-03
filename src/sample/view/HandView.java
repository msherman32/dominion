package sample.view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import sample.Controller;
import sample.model.Hand;
import sample.model.cards.Card;

import static sample.model.Game.getCurrentPlayer;

public class HandView extends HBox {

    private Hand hand;
    private ObservableList<CardView> cards;

    public HandView(Hand hand) {
        this.hand = hand;
        //        int numCards = hand.getCards().size();
        ArrayList<CardView> cardViews = new ArrayList<>();
        this.setSpacing(5);
        for (Card card : hand.getCards()) {
            cardViews.add(new CardView(card));
//            this.getChildren().add(new CardView((card)));
        }
        this.cards = FXCollections.observableArrayList();
        this.setAlignment(Pos.BOTTOM_CENTER);
        this.getChildren().addAll(cardViews);
    }

    public Hand getHand() {
        return hand;
    }

    public void update() {
        hand = getCurrentPlayer().getHand();
        this.getChildren().clear();
        ArrayList<Node> cards = new ArrayList<>();
        for (Card card : hand.getCards()) {
            cards.add(new CardView((card)));
        }
        this.getChildren().addAll(cards);
    }
}
