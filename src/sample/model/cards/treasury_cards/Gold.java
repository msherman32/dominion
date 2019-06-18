package sample.model.cards.treasury_cards;

import javafx.scene.image.Image;

public class Gold extends TreasuryCard {

    public static final int GOLD_COST = 6;
    public static final int GOLD_VALUE = 3;
    private static final String IMAGE_LOCATION = "sample/view/icons/treasury_card_icons/Gold.jpg";
    private static final String id = "Gold";

    public Gold() {
        this.value = GOLD_VALUE;
        this.cost = GOLD_COST;
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
        return "Gold Card";
    }
}
