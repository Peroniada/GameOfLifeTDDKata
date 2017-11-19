package model;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;


public class BoardTest {

    @Test
    public void shouldHave100Cells() {
        //given
        Board board = new Board(10, 10);
        //when
        //then
        assertThat(board.getSize()).isEqualTo(100);
    }

//    @Test
//    public void eachCellShouldHaveReferenceToItsNeighbour() {
//        //given
//        Board board
//    }

    @Test
    public void shouldHaveAllFieldsNotEqualNull() {
        //given
        Board board = new Board(5, 5);

        //when

        //then
        boolean actual = noFieldIsNull(board);
        assertThat(actual).isTrue();
    }

    private boolean noFieldIsNull(Board board) {
        for (Cell[] row : board.getCells()) {
            for (Cell cell : row) {
                if (cell == null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void shouldBorderNeighborsBeAlwaysDead(){
        //given

        Board board = new Board(5, 5, true );
        //when
        Cell cellAtCorner = board.getCells()[0][0];
        Cell cellAtLeftWall = board.getCells()[0][1];
        Cell cellAtTopWall = board.getCells()[1][0];


        //then
        assertThat(cellAtCorner.getLivingNeighbours()).isEqualTo(3);
        assertThat(cellAtLeftWall.getLivingNeighbours()).isEqualTo(5);
        assertThat(cellAtTopWall.getLivingNeighbours()).isEqualTo(5);

    }

}