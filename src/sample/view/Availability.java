package sample.view;

import java.util.Objects;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import sample.model.Game;
import sample.model.cards.Card;
import sample.model.cards.action_cards.ActionCard;
import sample.model.cards.treasury_cards.TreasuryCard;
import sample.model.cards.victory_cards.VictoryCard;
import sample.model.visitor_pattern.Visitor;

public class Availability extends VBox {

    private static CardView cardView;
    private static Label label;

    public Availability(Card card) {
        super(10);
        this.cardView = new CardView(card);
        Integer available = card.getAvailability(new AvailabilityVisitor());
        Text text = new Text(String.format("%d Left", available));
        text.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        this.label = new Label(text.getText());
        this.label.setFont(Font.font("Verdana", 15));
        this.getChildren().addAll(cardView, label);
    }

    public void update(Integer availability) {
        this.label.setText(String.format("%d left", availability));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Availability)) {
            return false;
        }
        Availability that = (Availability) o;
        return Objects.equals(cardView, that.cardView) &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardView, label);
    }

    private static class AvailabilityVisitor implements Visitor {

        @Override
        public void visit(TreasuryCard treasuryCard) {

        }

        @Override
        public void visit(VictoryCard victoryCard) {

        }

        @Override
        public void visit(ActionCard actionCard) {

        }

        @Override
        public int getAvailability(TreasuryCard treasuryCard) {
            return Game.getTreasuryCards().get(treasuryCard);
        }

        @Override
        public int getAvailability(VictoryCard victoryCard) {
            return Game.getVictoryCards().get(victoryCard);
        }

        @Override
        public int getAvailability(ActionCard actionCard) {
            return Game.getActionCards().get(actionCard);
        }
    }
}
