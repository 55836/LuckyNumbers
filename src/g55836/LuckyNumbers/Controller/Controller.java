package g55836.LuckyNumbers.Controller;

import g55836.LuckyNumbers.model.Model;
import g55836.LuckyNumbers.View.View;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    public void play() {
        view.displayWelcome();
        while (true) {
            switch (model.getState()) {
                case NOT_STARTED, GAME_OVER -> {
                    view.displayWinner();
                    model.start(view.askPlayerCount());
                }
                case PICK_TILE -> {
                    model.pickTile();
                    view.displayGame();
                }
                case PLACE_TILE -> model.putTile(view.askPosition());
                case TURN_END -> model.nextPlayer();
            }
        }
    }
}
