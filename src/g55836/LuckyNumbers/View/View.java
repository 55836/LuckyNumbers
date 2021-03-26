package g55836.LuckyNumbers.View;

import g55836.LuckyNumbers.model.Position;

public interface View {
    void displayWelcome();
    void displayGame();
    void displayWinner();
    int askPlayerCount();
    Position askPosition();
    void displayError(String message);
}
