package sample.model.cards.victory_cards;

import javafx.scene.image.Image;

public class Estate extends VictoryCard {

    private static final int ESTATE_POINTS = 1;
    private static final int ESTATE_COST = 2;
    private static final String IMAGE_LOCATION = "sample/view/icons/victory_card_icons/Estate.jpg";
    private static final String id = "Estate";

    public Estate() {
       this.points = ESTATE_POINTS;
       this.cost = ESTATE_COST;
       this.image = getImage();
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public Image getImage() {
        return new Image(IMAGE_LOCATION);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Estate Card";
    }
}
