package sample.model.cards.action_cards;

import sample.model.cards.Card;
import sample.model.visitor_pattern.Visitor;

public abstract class ActionCard extends Card {//create a builder to create specific cards with only some of the attributes
    private String description;

    //optional:
    private int plusBuys;
    private int plusActions;
    private int plusTreasury;
    private boolean gainCard;
    private boolean discardCard;

    public ActionCard(Builder builder) {
        this.description = builder.description;
        this.plusBuys = builder.plusBuys;
        this.plusActions = builder.plusActions;
        this.plusTreasury = builder.plusTreasury;
        //etc..
    }

    public ActionCard() {
    }

    //todo: create act method?

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Integer getAvailability(Visitor visitor) {
        return visitor.getAvailability(this);
    }

    class Builder {
        private String description;

        //optional:
        private int plusBuys;
        private int plusActions;
        private int plusTreasury;
        private boolean gainCard;
        private boolean discardCard;

        public Builder(String description) {
            this.description = description;
        }

        public Builder withPlusBuys(int buys) {
            this.plusBuys = buys;
            return this;
        }

        public Builder withPlusActions(int actions) {
            this.plusActions = actions;
            return this;
        }

        public Builder withPlusTreasury(int treasury) {
            this.plusTreasury = treasury;
            return this;
        }

//        public ActionCard build() {
//            return new ActionCard(this);
//        }
    }

}
