package sample.model.cards.action_cards;

import javafx.scene.image.Image;

public class Village extends ActionCard {

    private static final String id = "Village";
    private static final String IMAGE_LOCATION = "sample/view/icons/action_card_icons/Village.jpg";
    private static final int VILLAGE_COST = 3;

    public Village() {
//        Builder builder = new Builder().;
        this.cost = VILLAGE_COST;
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
        return "Village Card";
    }
}
