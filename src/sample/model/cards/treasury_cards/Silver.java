package sample.model.cards.treasury_cards;

import javafx.scene.image.Image;

public class Silver extends TreasuryCard {

    public static final int SILVER_VALUE = 2;
    public static final int SILVER_COST = 3;
    private static final String IMAGE_LOCATION = "sample/view/icons/treasury_card_icons/Silver.jpg";
    private static final String id = "Silver";

    public Silver() {
        this.value = SILVER_VALUE;
        this.cost = SILVER_COST;
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
        return "Silver Card";
    }
}
