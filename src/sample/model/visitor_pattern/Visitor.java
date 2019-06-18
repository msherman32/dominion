package sample.model.visitor_pattern;

import sample.model.cards.action_cards.ActionCard;
import sample.model.cards.treasury_cards.TreasuryCard;
import sample.model.cards.victory_cards.VictoryCard;

public interface Visitor {

    void visit(TreasuryCard treasuryCard);

    void visit(VictoryCard victoryCard);

    void visit(ActionCard actionCard);

    int getAvailability(TreasuryCard treasuryCard);

    int getAvailability(VictoryCard victoryCard);

    int getAvailability(ActionCard actionCard);
}
