package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }
    @Test
    public void whenMoveThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> logic.move(Cell.C1,Cell.C3)
        );
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to C3");
    }
    @Test
    public void whenMoveThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure pawnBlack = new BishopBlack(Cell.D2);
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        OccupiedCellException exception = assertThrows(
                OccupiedCellException.class,
                () -> logic.move(Cell.C1,Cell.E3)
        );
    }
}