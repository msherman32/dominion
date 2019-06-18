package sample.view;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import sample.model.Game;
import sample.model.Player;
import sample.model.cards.Card;

public class TurnOptions extends VBox {

    private Button action;
    private Button buy;

    public TurnOptions() {
        super(10);
        action = new Button("Action");
        buy = new Button("Buy");
        this.getChildren().addAll(action, buy);
        this.setAlignment(Pos.CENTER);

        buy.setOnAction(event -> {
            CardView currentlyClicked = GameScreen.getCurrentlySelected();
            if (GameScreen.nothingSelected()) {
                showAlert("Nothing Selected");
            } else {
                Player player = Game.getCurrentPlayer();
                Card card = currentlyClicked.getCard();
                if (player.canBuyCard(card)) {
                    player.buyCard(card);
                    GameScreen.getPlayerStats().updateBuyingPower();
                    GameScreen.getHandView().update();
                    GameScreen.updateAvailability(card);
                } else {
                    showAlert("Not Enough Money");
                }
            }
        });
    }

    private void showAlert(String message) {
        Alert newAlert = new Alert(Alert.AlertType.ERROR);
        newAlert.setTitle("Try Again");
        newAlert.setHeaderText(message);
        newAlert.showAndWait();
    }

    public Button getAction() {
        return action;
    }

    public Button getBuy() {
        return buy;
    }

}
