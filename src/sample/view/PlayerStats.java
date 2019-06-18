package sample.view;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import sample.model.Game;
import sample.model.Player;

public class PlayerStats extends StackPane {

    private Rectangle border;
    private Label playerNumber;
    private Label score;
    private Label actionPower;
    private Label buyingPower;

//    private int playerNum;
//    private int numActions;
//    private int numBuys;
//    private int numPoints; todo: refactor this into the string.formats?

    public PlayerStats(Player player) {
        playerNumber = new Label(String.format("Player Number: %d", player.getPlayerId()));
        actionPower = new Label(String.format("Action Power: %d", player.getHand().getNumActions()));
        buyingPower = new Label(String.format("Buying Power: %d", player.getHand().getNumBuys()));
        score = new Label(String.format("Score: %d", player.getScore()));

        VBox labels = new VBox(5);
        labels.getChildren().addAll(playerNumber, score, actionPower, buyingPower);

        for (Node child : labels.getChildren()) {
            ((Label) child).setFont(Font.font("Verdana", 20));
        }

        this.getChildren().add(labels);

        border = new Rectangle(this.getWidth(), this.getHeight());
        border.setStroke(Color.BLACK); //todo: fill the outside of the rectangle
        this.getChildren().add(0, border);
    }

    public void updateBuyingPower() {
        buyingPower.setText(String.format("Buying Power: %d",
                Game.getCurrentPlayer().getHand().getNumBuys()));
    }
}
