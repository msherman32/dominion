package sample.model.cards.treasury_cards;

import java.util.Objects;

import sample.model.cards.Card;
import sample.model.visitor_pattern.Visitor;

public abstract class TreasuryCard extends Card {

    protected int value;

    public int getValue() {
        return value;
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
        if (!(o instanceof TreasuryCard)) {
            return false;
        }
        TreasuryCard that = (TreasuryCard) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
