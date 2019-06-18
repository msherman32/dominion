package sample.model.cards.victory_cards;

import javafx.scene.image.Image;

public class Province extends VictoryCard {

    private static final int PROVINCE_POINTS = 6;
    private static final int PROVINCE_COST = 8;
    private static final String IMAGE_LOCATION = "sample/view/icons/victory_card_icons/Province.jpg";
    private static final String id = "Province";


    public Province() {
        this.points = PROVINCE_POINTS;
        this.cost = PROVINCE_COST;
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
        return "Province Card";
    }
}
