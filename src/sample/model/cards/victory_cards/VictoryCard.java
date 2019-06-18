package sample.model.cards.victory_cards;

import java.util.Objects;

import sample.model.cards.Card;
import sample.model.visitor_pattern.Visitor;

public abstract class VictoryCard extends Card {

    protected int points;

    public int getPoints() {
        return points;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Integer getAvailability(Visitor visitor) {
        return visitor.getAvailability(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VictoryCard)) {
            return false;
        }
        VictoryCard card = (VictoryCard) o;
        return points == card.points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
