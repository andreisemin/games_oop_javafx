package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {

    @Test
    void whenPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.findBy(2, 0));
        assertThat(Cell.C8).isEqualTo(bishopBlack.position());
    }

    @Test
    void whenCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        BishopBlack copy = (BishopBlack) bishopBlack.copy(Cell.A6);
        assertThat(Cell.A6).isEqualTo(copy.position());
    }


    @Test
    public void whenWay() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        Cell[] expectedWay = {Cell.D7, Cell.E6, Cell.F5, Cell.G4};
        Cell[] actualWay = bishop.way(Cell.G4);
        assertThat(expectedWay).isEqualTo(actualWay);
    }
}