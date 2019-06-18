package sample.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StartScreen extends StackPane {

    private static final int ROW_HEIGHT = 24;
    private static final ObservableList<Integer> playerOptions = FXCollections.observableArrayList(2, 3, 4, 5, 6);

    private Image background = new Image("sample/view/icons/Background.jpg");
    private ListView<Integer> numPlayerOptions;
    private Button startButton;

    public StartScreen() {
        //todo:add a "Dominion" text to the top
        numPlayerOptions = new ListView<>(playerOptions);
        numPlayerOptions.setMaxWidth(200);
        numPlayerOptions.setPrefHeight(ROW_HEIGHT * playerOptions.size());

        Label select = new Label("Select number of players:");
        select.setFont(Font.font("Verdana", 15));
        select.setMaxWidth(numPlayerOptions.getMaxWidth());

        startButton = new Button("Begin");

        VBox content = new VBox(10);
        content.setAlignment(Pos.CENTER);
        content.getChildren().addAll(select, numPlayerOptions, startButton);

        ImageView backgroundView = new ImageView(background);
        //        backgroundView.setFitWidth(this.getScene().getWidth());
        //        backgroundView.setFitHeight(this.getScene().getHeight());

        this.setAlignment(content, Pos.CENTER);
        this.getChildren().addAll(backgroundView, content);
    }

    public ListView<Integer> getNumPlayerOptions() {
        return numPlayerOptions;
    }

    public Button getStartButton() {
        return startButton;
    }
}
