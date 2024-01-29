package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    void whenPositionC8ThenSuccessful() {
        Cell expected = Cell.C8;
        Figure bishopBlack = new BishopBlack(expected);
        Cell result = bishopBlack.position();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenCopyC8ThenSuccessful() {
        Cell expected = Cell.C8;
        Figure bishopBlack = new BishopBlack(expected);
        Figure newBishopBlack = bishopBlack.copy(expected);
        Cell result = newBishopBlack.position();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenWayC1ToG5ThenSuccessful() {
        Cell start = Cell.C1;
        Cell finish = Cell.G5;
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, finish};
        Figure bishopBlack = new BishopBlack(start);
        Cell[] result = bishopBlack.way(finish);
        assertThat(result).containsExactly(expected);
    }

    @Test
    void whenWayF8ToA3ThenSuccessful() {
        Cell start = Cell.F8;
        Cell finish = Cell.A3;
        Cell[] expected = new Cell[]{Cell.E7, Cell.D6, Cell.C5, Cell.B4, finish};
        Figure bishopBlack = new BishopBlack(start);
        Cell[] result = bishopBlack.way(finish);
        assertThat(result).containsExactly(expected);
    }

    @Test
    void whenWayNotDiagonalThenImpossibleMoveException() {
        Cell start = Cell.C1;
        Cell finish = Cell.C3;
        Figure bishopBlack = new BishopBlack(start);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bishopBlack.way(finish)
        );
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to C3");
    }
}