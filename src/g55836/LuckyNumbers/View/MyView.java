package g55836.LuckyNumbers.View;

import g55836.LuckyNumbers.model.Model;
import g55836.LuckyNumbers.model.Position;
import g55836.LuckyNumbers.model.Tile;

import java.util.Scanner;

public class MyView implements View {
    private final Model model;
    private final Scanner input;

    private void printLine(int line) {
        System.out.print(line+1+"|");
        for(int i=0; i<model.getBoardSize(); ++i) {
            Tile tile = model.getTile(model.getCurrentPlayerNumber(), new Position(line, i));
            if(tile == null) System.out.print("  .");
            else System.out.print("  " + tile.getValue());
        }
        System.out.println();
    }

    public MyView(Model model) {
        this.model = model;
        input = new Scanner(System.in);
    }

    public void displayWelcome() {
        System.out.println("Lucky Number,Kerdoudi Zakaria, v0.1\n");
    }
    public void displayGame() {
        System.out.println("Joueur " + model.getCurrentPlayerNumber() + 1 + '\n');
        System.out.println("    1  2  3  4");
        System.out.println(" -------------");
        for(int i=0; i<model.getBoardSize(); ++i) printLine(i);
        System.out.println(" -------------");

        System.out.println(model.getPickedTile().getValue());
    }
    public void displayWinner() {
        System.out.println("Winner: "+model.getWinner());
    }
    public int askPlayerCount() {
        System.out.print("Number of players: ");
        return input.nextInt();
    }
    public Position askPosition() {
        int posXBuffer, posYBuffer;
        Position pos;
        do {
            System.out.print("Row: ");
            posYBuffer = input.nextInt() - 1;
            System.out.print("Column: ");
            posXBuffer = input.nextInt() - 1;
            pos = new Position(posYBuffer, posXBuffer);
        } while (!model.isInside(pos) || !model.canTileBePut(pos)); // do while loop so the program run the condition at least once
        // and ask again a position if she is not a valid position

        return pos;
    }
    public void displayError(String message) {
        System.err.println(message);
    }
}
