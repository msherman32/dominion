package sample.model.cards.treasury_cards;

import javafx.scene.image.Image;

public class Copper extends TreasuryCard {

    private static final int COPPER_COST = 0;
    private static final int COPPER_VALUE = 1;
    private static final String IMAGE_LOCATION = "sample/view/icons/treasury_card_icons/Copper.jpg";
    private static final String id = "Copper";

    public Copper() {
        cost = COPPER_COST;
        value = COPPER_VALUE;
        this.image = getImage();
    }

    @Override
    public int getCost() {
        return cost;
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
        return "Copper Card";
    }
}
