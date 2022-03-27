package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        Figure bishopBlack = new BishopBlack(Cell.C3);
        assertEquals(Cell.C3, bishopBlack.position());
    }

    @Test
    public void copy() {
        Figure bishopBlack = new BishopBlack(Cell.H6);
        Figure bishopBlack2 = bishopBlack.copy(Cell.H3);
        assertThat(bishopBlack2.position(), is(Cell.H3));
    }

    @Test
    public void way() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.G5), is(expected));
    }

    @Test
    public void isDiagonal() {
        Figure bishopBlack = new BishopBlack(Cell.D6);
        bishopBlack.way(Cell.A3);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void isNotDiagonal() {
        Figure bishopBlack = new BishopBlack(Cell.D6);
        bishopBlack.way(Cell.A5);
    }
}