package sample.view;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import sample.model.Game;
import sample.model.cards.action_cards.ActionCard;

public class AvailableActionCards extends GridPane {

    private static final int ROWS = 2;
    private static final int COLUMNS = 5;

    private static Map<ActionCard, Availability> actionCardAvailabilityMap;

    public AvailableActionCards(Game game) {
        this.actionCardAvailabilityMap = new HashMap<>();
        int i = 0;
        for (ActionCard card : game.getActionCards().keySet()) {
            Availability availability = new Availability(card);
            actionCardAvailabilityMap.put(card, availability);
            if (i >= COLUMNS) {
                this.add(availability, i % COLUMNS, 1);
            } else {
                this.add(availability, i, 0);
            }
            i++;
        }
        this.setHgap(20);
        this.setAlignment(Pos.CENTER);
    }

    public void updateAvailability(ActionCard actionCard) {
        Integer available = Game.getActionCards().get(actionCard); //todo: this value is null!m
        Availability availability = actionCardAvailabilityMap.get(actionCard);
        availability.update(available--);
    }
}
