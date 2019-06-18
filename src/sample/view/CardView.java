package sample.view;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import sample.model.cards.Card;

public class CardView extends StackPane {

    private static final int CARD_WIDTH = 89;
    private static final int CARD_HEIGHT = 144;
    private static final Paint HIGHLIGHTED = Color.YELLOW;
    private static final Paint INVISIBLE = Color.TRANSPARENT;

    private ImageView background;
    private Rectangle border;
    private Card card;
    private boolean selected;

    public CardView(Card card) {
        this.card = card;
        assignBackground(card);
        this.getChildren().addAll(border, background);
        this.setOnMouseClicked(event -> {
            if (GameScreen.getLastClicked() != this) {
                GameScreen.unSelectLastClicked();
                GameScreen.setLastClicked(this);
                select();
            } else {
                unSelect();
            }
        });
        if (selected == false) {
            this.setOnMouseEntered(event -> border.setStroke(HIGHLIGHTED));
            this.setOnMouseExited(event -> border.setStroke(INVISIBLE));
        }
    }

    private void assignBackground(Card card) {
        ImageView imgView = new ImageView(card.getImage());
        imgView.setFitWidth(CARD_WIDTH);
        imgView.setFitHeight(CARD_HEIGHT);
        this.border = new Rectangle(CARD_WIDTH + 5, CARD_HEIGHT + 5);
        this.border.setStroke(INVISIBLE);
        this.background = imgView;
    }

    public void unSelect() {
        border.setStroke(INVISIBLE);
        selected = false;
    }

    public void select() {
        border.setStroke(HIGHLIGHTED);
        selected = true;
    }

    public boolean isSelected() {
        return selected = true;
    }

    public Card getCard() {
        return card;
    }
}
