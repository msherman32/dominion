package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.Game;
import sample.view.GameScreen;

public class Dominion extends Application {

    public static final int WIDTH = 700;
    private static final int HEIGHT = 500;

    private Stage myStage;
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        myStage = primaryStage;
        myStage.setTitle("Dominion");
        myStage.setScene(startGame());
        myStage.setMaximized(true);
        myStage.show();
        controller.playing();
    }

    /**
     * This method is responsible for setting the scene to the corresponding
     * layout.
     * and returning the scene.
     * @return Scene
     */
    public Scene startGame() {

        //        StartScreen startScreen = new StartScreen(); //startScreen is a layout
        //        Scene start = new Scene(startScreen);
        //
        //        Button startButton = startScreen.getStartButton();
        //        startButton.setOnAction(event -> {
        //
        //            Integer selection = startScreen.getNumPlayerOptions().getSelectionModel().getSelectedItem();
        //
        //            if (selection != null) {
        Game game = new Game(5); //selection
        GameScreen gameScreen = new GameScreen(game);
        //                myStage.setScene(new Scene(gameScreen));
        this.controller = new Controller(gameScreen, game);
        //                controller.playing();
        //            }
        //        });
        //
        //        return start;
        return new Scene(gameScreen);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
