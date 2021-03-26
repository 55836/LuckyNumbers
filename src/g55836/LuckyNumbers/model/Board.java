package g55836.LuckyNumbers.model;

public class Board
{
    private final Tile[][] tiles;

    public Board() {
        tiles = new Tile[4][4]; // size of the board
    }

    public int getSize() { return tiles.length; }
    public boolean isInside(Position pos) {
        return !(pos.getRow() < 0 || pos.getRow() >= getSize() || // I used "!" to check if a point is not inside the board
                pos.getColumn() < 0 || pos.getColumn() >= getSize());
    }
    public Tile getTile(Position pos) { return tiles[pos.getRow()][pos.getColumn()]; }
    // Put a tile and return the state of the board
    public boolean canBePut(Tile tile, Position pos) {
        boolean res = true;

        // Row
        for(int i=0; i < getSize(); ++i) {
            if(tiles[pos.getRow()][i] != null && (
                    (i < pos.getColumn() && tile.getValue() <= tiles[pos.getRow()][i].getValue()) ||
                            (i > pos.getColumn() && tile.getValue() >= tiles[pos.getRow()][i].getValue())
            ))
            { res = false; }
        }

        // Col
        for(int i=0; i < getSize(); ++i) { // ++i return the value after adding
            if(tiles[i][pos.getColumn()] != null && (
                    (i < pos.getRow() && tile.getValue() <= tiles[i][pos.getColumn()].getValue()) ||
                            (i > pos.getRow() && tile.getValue() >= tiles[i][pos.getColumn()].getValue())
            ))
            { res = false; }
        }

        return res;
    }

    public void put(Tile tile, Position pos) {
        tiles[pos.getRow()][pos.getColumn()] = tile;
    }

    public boolean isFull() {
        for(int row=0; row < getSize(); ++row){
            for(int col=0; col < getSize(); ++col) {
                if(tiles[row][col] == null) { return false; }
            }
        }

        return true;
    }
}
