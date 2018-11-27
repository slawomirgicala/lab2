import agh.cs.lab2.MapDirection;
import org.junit.Test;

import static org.junit.Assert.*;


public class MapDirectionTest {

    @Test
    public void toStringTest() {
        MapDirection direction = MapDirection.NORTH;
        assertEquals("Północ",direction.toString());
    }

    @Test
    public void next1() {
        MapDirection direction1 = MapDirection.NORTH;
        assertEquals(MapDirection.EAST, direction1.next());
    }

    @Test
    public void next2(){
        MapDirection direction2 = MapDirection.SOUTH;
        assertEquals(MapDirection.WEST,direction2.next());
    }

    @Test
    public void next3(){
        MapDirection direction3 = MapDirection.EAST;
        assertEquals(MapDirection.SOUTH,direction3.next());
    }

    @Test
    public void next4(){
        MapDirection direction4 = MapDirection.WEST;
        assertEquals(MapDirection.NORTH,direction4.next());
    }

    @Test
    public void previous1() {
        MapDirection direction1 = MapDirection.NORTH;
        assertEquals(MapDirection.WEST,direction1.previous());
    }

    @Test
    public void previous2() {
        MapDirection direction2 = MapDirection.WEST;
        assertEquals(MapDirection.SOUTH,direction2.previous());
    }

    @Test
    public void previous3() {
        MapDirection direction3 = MapDirection.SOUTH;
        assertEquals(MapDirection.EAST,direction3.previous());
    }

    @Test
    public void previous4() {
        MapDirection direction4 = MapDirection.EAST;
        assertEquals(MapDirection.NORTH,direction4.previous());
    }
}