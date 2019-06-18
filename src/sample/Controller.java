package sample;

import sample.model.Game;
import sample.view.GameScreen;

public class Controller {

    private static GameScreen gameScreen;
    private static Game game;

    public Controller(GameScreen gameScreen, Game currentGame) {//todo: get rid of these attributs and make controller static
        this.gameScreen = gameScreen;
        this.game = currentGame;
    }

    public void playing() {
//        while (game.isInProgress()) {
//
//        }

        //        while (currentGame.isPlaying()) {
        //            gameScreen.getRemoveCard().setOnAction(event -> gameScreen.getRidOfCard());
        //        }
    }

    public static Game getGame() {
        return game;
    }

    public static GameScreen getGameScreen() {
        return gameScreen;
    }
}
