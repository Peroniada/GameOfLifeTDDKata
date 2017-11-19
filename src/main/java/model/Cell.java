package model;

import java.util.ArrayList;
import java.util.List;

public class Cell {


    private boolean alive;
    private final List<Cell> neighbours;




    public Cell(boolean alive) {
        this.alive = alive;
        this.neighbours = new ArrayList<>();
    }

    public void setNeighbours(List<Cell> neighbours) {
        this.neighbours.addAll(neighbours);
    }
    public boolean willBeAlive(){
        return meetsAllLivingConditions();
    }

    private int countLivingNeighbours() {
        int livingNeighboursCounter= 0;
        for(Cell neighbour : neighbours) {
            if(neighbour.alive) {
                livingNeighboursCounter++;
            }
        }
        return livingNeighboursCounter;
    }

    private boolean meetsAllLivingConditions() {
        int livingNeighboursCounter = countLivingNeighbours();
        if (alive) {
            return livingNeighboursCounter >= 2 && livingNeighboursCounter < 4 ;
        }
        else{
            return  livingNeighboursCounter == 3;
        }
    }

}
