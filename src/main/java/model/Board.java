package model;

public class Board {

    public Cell[][] getCells() {
        return cells;
    }

    private final Cell[][] cells;

    public Board(int lengthX, int lengthY, boolean alive) {
        this.cells = new Cell[lengthX][lengthY];
        for (int x = 0; x< lengthX; x++ ) {
            for (int y = 0; y< lengthX; y++) {
                cells[x][y] = new Cell(alive);

            }

        }
    }

    public int getSize() {
        return cells.length * cells[0].length;
    }


}
