package sample.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import sample.model.Game;
import sample.model.Player;
import sample.model.cards.Card;
import sample.model.cards.action_cards.ActionCard;
import sample.model.cards.treasury_cards.TreasuryCard;
import sample.model.cards.victory_cards.VictoryCard;
import sample.model.visitor_pattern.Visitor;

import static sample.model.Game.getCurrentPlayer;

public class GameScreen extends BorderPane {

    private static CardView lastClicked;

    private static Image background = new Image("sample/view/icons/Background.jpg");
    private static Label title = new Label("Dominion!");
    private static TurnOptions options;
    private static HandView handView;
    private static PlayerStats playerStats;
    private static AvailableVictoryCards availableVictoryCards;
    private static AvailableTreasuryCards availableTreasuryCards;
    private static AvailableActionCards availableActionCards;

    public GameScreen(Game game) {

        this.options = new TurnOptions(); //fixme: should turn options be based on player?
        this.handView = new HandView(getCurrentPlayer().getHand());
        this.playerStats = new PlayerStats(getCurrentPlayer());
        this.availableVictoryCards = new AvailableVictoryCards(game);
        this.availableTreasuryCards = new AvailableTreasuryCards(game);
        this.availableActionCards = new AvailableActionCards(game);

        VBox idk = new VBox(25);
        idk.getChildren().addAll(playerStats, availableVictoryCards, availableTreasuryCards);

        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setAlignment(idk, Pos.CENTER);

        this.setTop(title);
        this.setRight(idk);
        this.setBottom(handView);
        this.setCenter(availableActionCards);
        this.setLeft(options);

        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO,
                BackgroundSize.AUTO,
                false,
                false,
                true,
                true);

        this.setBackground(new Background(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, bSize)));
    }

    public static HandView getHandView() {
        return handView;
    }

    public static void setLastClicked(CardView cardView) {
        lastClicked = cardView;
    }

    //todo: make a method to get the currently selected Card View

    public static CardView getLastClicked() {
        return lastClicked;
    }

    public static void unSelectLastClicked() {
        if (lastClicked != null) {
            lastClicked.unSelect();
        }
    }

    public static TurnOptions getOptions() {
        return options;
    }

    public static PlayerStats getPlayerStats() {
        return playerStats;
    }

    public static AvailableVictoryCards getAvailableVictoryCards() {
        return availableVictoryCards;
    }

    public static AvailableActionCards getAvailableActionCards() {
        return availableActionCards;
    }

    public static AvailableTreasuryCards getAvailableTreasuryCards() {
        return availableTreasuryCards;
    }

    public static CardView getCurrentlySelected() { //todo: lastClicked can be null here (NullPointerException)
        return lastClicked.isSelected() ? lastClicked : null;
    }

    public static boolean nothingSelected() {
        return lastClicked == null || !lastClicked.isSelected();
    }

    public static void updateForCurrentPlayer(Player currentPlayer) {
        handView = new HandView(currentPlayer.getHand());
        playerStats = new PlayerStats(currentPlayer);
    }

    public static void updateAvailability(Card card) {
        card.accept(new AvailabilityVisitor());
    }

    private static class AvailabilityVisitor implements Visitor {
        @Override
        public void visit(TreasuryCard treasuryCard) {
            GameScreen.getAvailableTreasuryCards().updateAvailability(treasuryCard);
        }

        @Override
        public void visit(VictoryCard victoryCard) {
            GameScreen.getAvailableVictoryCards().updateAvailability(victoryCard);
        }

        @Override
        public void visit(ActionCard actionCard) {
            GameScreen.getAvailableActionCards().updateAvailability(actionCard);
        }

        @Override
        public int getAvailability(TreasuryCard treasuryCard) {
            return 0;
        }

        @Override
        public int getAvailability(VictoryCard victoryCard) {
            return 0;
        }

        @Override
        public int getAvailability(ActionCard actionCard) {
            return 0;
        }
    }
}
