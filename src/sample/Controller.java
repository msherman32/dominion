package sample;

import sample.model.Game;
import sample.view.GameScreen;

import static sample.model.Game.getCurrentPlayer;

public class Controller {

    private static GameScreen gameScreen;
    private static Game game;

    public Controller(GameScreen gameScreen, Game currentGame) {//todo: get rid of these attributs and make controller static
        this.gameScreen = gameScreen;
        this.game = currentGame;
    }

    public void playing() {
        while (game.isInProgress()) {
            //todo: set up the players options FIRST
            GameScreen.updateForCurrentPlayer(getCurrentPlayer());

            getCurrentPlayer().takeTurn();

            //maybe more stuff


            game.goToNextPlayer();
        }
    }

    public static Game getGame() {
        return game;
    }

}
