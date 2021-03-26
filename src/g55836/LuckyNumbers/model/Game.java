package g55836.LuckyNumbers.model;

import java.util.Random;

public class Game implements Model
{
    private final Random rng = new Random(); // rng for random number generator
    private State state;
    private Board[] boards;
    private Tile pickedTile;
    private int playerCount;
    private int currentPlayerNumber;
    public Game() {
        state = State.NOT_STARTED;
    }
    // Action on the game
    public void start(int playerCount) {
        if(state != State.NOT_STARTED && state != State.GAME_OVER) throw new IllegalStateException("Game already started!");
        if(playerCount > 4 || playerCount < 2) throw new IllegalArgumentException("playerCount must be between 2 and 4!");

        state = State.PICK_TILE;
        this.playerCount = playerCount;
        currentPlayerNumber = 0;

        boards = new Board[this.playerCount];
        for(int i=0; i<this.playerCount; ++i)
            boards[i] = new Board();
    }
    public Tile pickTile() {
        state = State.PLACE_TILE;
        pickedTile = new Tile(rng.nextInt(20) + 1);
        return pickedTile;
    }
    public void putTile(Position pos) {
        boards[currentPlayerNumber].put(pickedTile, pos);

        if(getWinner() != -1) state = State.GAME_OVER;
        else state = State.TURN_END;
    }
    public void nextPlayer() {
        if(++currentPlayerNumber > playerCount - 1) currentPlayerNumber = 0;
        state = State.PICK_TILE;
    }

    // Getting info on the game
    public int getBoardSize() {
        return boards[currentPlayerNumber].getSize();
    }
    public State getState() {
        return state;
    }
    public int getPlayerCount() {
        return playerCount;
    }
    public int getCurrentPlayerNumber() {
        return currentPlayerNumber;
    }
    public Tile getPickedTile() {
        return pickedTile;
    }
    public boolean isInside(Position pos) {
        return boards[currentPlayerNumber].isInside(pos);
    }
    public boolean canTileBePut(Position pos) {
        return boards[currentPlayerNumber].canBePut(pickedTile, pos);
    }
    public Tile getTile(int playerNumber, Position pos) {
        return boards[playerNumber].getTile(pos);
    }
    public int getWinner() {
        for(int i=0; i < playerCount; ++i) {
            if(boards[i].isFull()) return i;
        }

        return -1;
    }
}
