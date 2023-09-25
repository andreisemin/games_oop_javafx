package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertEquals;


public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C8, Cell.H4);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void testMoveFigureNotFound() {
        Logic logic = new Logic();
        Figure figure = new BishopBlack(Cell.C8);
        logic.add(figure);
        try {
            logic.move(Cell.A8, Cell.A7);
            fail("Should throw FigureNotFoundException");
        } catch (FigureNotFoundException e) {
            assertEquals("Figure not found on the board.", e.getMessage());
        } catch (Exception e) {
            fail("Should throw FigureNotFoundException");
        }
    }

    @Test
    public void testMoveImpossibleMove() {
        Logic logic = new Logic();
        Figure figure = new BishopBlack(Cell.C8);
        logic.add(figure);
        try {
            logic.move(Cell.C8, Cell.C7);
            fail("Should throw ImpossibleMoveException");
        } catch (ImpossibleMoveException e) {
            assertEquals("Could not move by diagonal from C8 to C7", e.getMessage());
        } catch (Exception e) {
            fail("Should throw ImpossibleMoveException");
        }
    }

    @Test
    public void testMoveOccupiedCell() {
        Logic logic = new Logic();
        Figure figure1 = new BishopBlack(Cell.C8);
        Figure figure2 = new BishopBlack(Cell.D7);
        logic.add(figure1);
        logic.add(figure2);
        try {
            logic.move(Cell.C8, Cell.E6);
            fail("Should throw OccupiedCellException");
        } catch (OccupiedCellException e) {
            assertEquals("The cell is occupied by another figure.", e.getMessage());
        } catch (Exception e) {
            fail("Should throw OccupiedCellException");
        }
    }
}