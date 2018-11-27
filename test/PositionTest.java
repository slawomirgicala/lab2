import agh.cs.lab2.Position;
import javafx.geometry.Pos;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void toStringTest(){
        Position pos1 = new Position(1,2);
        String result = "(1,2)";
        assertEquals(result,pos1.toString());
    }

    @Test
    public void smallerTest() {
        Position smallPosition = new Position(-1,0);
        Position largePosition = new Position(100,1213);
        assertTrue(smallPosition.smaller(largePosition));
    }

    @Test
    public void largerTest() {
        Position smallPosition = new Position(-1,0);
        Position largePosition = new Position(100,1213);
        assertTrue(largePosition.larger(smallPosition));
    }

    @Test
    public void upperRightTest() {
        Position pos1 = new Position(4,6);
        Position pos2 = new Position(5,5);
        Position result = new Position(5,6);
        assertEquals(result, pos1.upperRight(pos2));
    }

    @Test
    public void lowerLeftTest() {
        Position pos1 = new Position(4,6);
        Position pos2 = new Position(5,5);
        Position result = new Position(4,5);
        assertEquals(result, pos2.lowerLeft(pos1));
    }

    @Test
    public void addTest() {
        Position pos1 = new Position(-10,27);
        Position pos2 = new Position(14,2);
        Position result = new Position(4,29);
        assertEquals(result, pos1.add(pos2));
    }

    @Test
    public void equalsTest1() {
        Position pos1 = new Position(2,3);
        Position pos2 = pos1;
        assertTrue(pos1.equals(pos2));
    }

    @Test
    public void equalsTest2() {
        Position pos1 = new Position(2,3);
        Position pos2 = new Position(2,3);
        assertTrue(pos1.equals(pos2));
    }

    @Test
    public void equalsTest3() {
        Position pos1 = new Position(2,3);
        Position pos2 = new Position(1,1);
        assertFalse(pos1.equals(pos2));
    }

    @Test
    public void equalsTest4() {
        Position pos1 = new Position(2,3);
        Object whatever = new Object();
        assertFalse(pos1.equals(whatever));
    }

}