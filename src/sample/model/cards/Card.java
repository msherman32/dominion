package sample.model.cards;

import javafx.scene.image.Image;
import sample.model.visitor_pattern.Visitable;

public abstract class Card implements Visitable {

    protected int cost;
    protected Image image;

    public abstract int getCost();

    public abstract Image getImage();

    public abstract String getId();

}
