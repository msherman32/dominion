package sample.view;

import java.util.HashMap;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import sample.model.Game;
import sample.model.cards.victory_cards.VictoryCard;

public class AvailableVictoryCards extends HBox {

    private HashMap<VictoryCard, Availability> availabilityHashMap;

    public AvailableVictoryCards(Game game) {
        super(10);
        availabilityHashMap = new HashMap<>();
        for (VictoryCard card : game.getVictoryCards().keySet()) {
            Availability availability = new Availability(card);
            availabilityHashMap.put(card, availability);
            this.getChildren().add(availability);
        }
        this.setAlignment(Pos.CENTER);
    }

    public void updateAvailability(VictoryCard victoryCard) {
        Integer available = Game.getActionCards().get(victoryCard);
        Availability availability = availabilityHashMap.get(victoryCard);
        availability.update(available--);
    }
}
