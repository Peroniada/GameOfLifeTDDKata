package model;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CellTest {

    @Test
    public void shouldDieWhenHasLessThan2Neighbours() {
        //given
        Cell cell = new Cell(true);

        //when
        cell.setNeighbours(Arrays.asList(
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(true)
                )
        );

        //then
        assertThat(cell.willBeAlive()).isFalse();
    }


    @Test
    public void shouldBeRebornWhenHaveThreeLivingNeighbours(){

        //given
        Cell cell = new Cell(false);

        //when
        cell.setNeighbours(Arrays.asList(
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(true),
                new Cell(true),
                new Cell(true)
                )
        );

        //then

        assertThat(cell.willBeAlive()).isTrue();
    }

    @Test
    public void shouldDieWhenHaveMoreThan3LivingNeighbours() {
        // given
        Cell cell = new Cell(true);

        //when
        cell.setNeighbours(Arrays.asList(
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(true),
                new Cell(true),
                new Cell(true),
                new Cell(true)
        ));

        //then
        assertThat(cell.willBeAlive()).isFalse();

    }

    @Test
    public void shouldNotBeRebornWhenLessThan3Neighbors(){

        // given
        Cell cell = new Cell(false);

        //when
        cell.setNeighbours(Arrays.asList(
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(true),
                new Cell(true)
        ));

        //then

        assertThat(cell.willBeAlive()).isFalse();
    }

    @Test
    public void shouldSurviveWhenHas2Or3LivingNeigbours() {
        //given
        Cell cell1 = new Cell(true);
        Cell cell2 = new Cell(true);

        //when
        cell1.setNeighbours(Arrays.asList(
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(true),
                new Cell(true)
        ));
        cell2.setNeighbours(Arrays.asList(
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(false),
                new Cell(true),
                new Cell(true),
                new Cell(true)
        ));

        //then
        assertThat(cell1.willBeAlive()).isTrue();
    }
}