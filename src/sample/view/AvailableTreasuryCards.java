package sample.view;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import sample.model.Game;
import sample.model.cards.treasury_cards.TreasuryCard;

public class AvailableTreasuryCards extends HBox {

    private static Map<TreasuryCard, Availability> availabilityHashMap;

    public AvailableTreasuryCards(Game game) {
        super(10);
        availabilityHashMap = new HashMap<>();
        for (TreasuryCard card : game.getTreasuryCards().keySet()) {
            Availability availability = new Availability(card);
            availabilityHashMap.put(card, availability);
            this.getChildren().add(availability);
        }
        this.setAlignment(Pos.CENTER);
    }

    public void updateAvailability(TreasuryCard treasuryCard) {
        Integer available = Game.getActionCards().get(treasuryCard);
        Availability availability = availabilityHashMap.get(treasuryCard);
        availability.update(available--);
    }
}
