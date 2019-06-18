package sample.model.cards.victory_cards;

import javafx.scene.image.Image;

public class Duchy extends VictoryCard {

    private static final int DUCHY_POINTS = 3;
    private static final int DUCHY_COST = 5;
    private static final String IMAGE_LOCATION = "sample/view/icons/victory_card_icons/Duchy.jpg";
    private static final String id = "Duchy";


    public Duchy() {
        this.points = DUCHY_POINTS;
        this.cost = DUCHY_COST;
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
        return "Duchy Card";
    }


}
