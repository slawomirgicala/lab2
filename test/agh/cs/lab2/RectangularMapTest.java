package agh.cs.lab2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangularMapTest {


    @Test
    public void place(){
        RectangularMap map = new RectangularMap(2,2);
        assertTrue(map.place(new Car(map,new Position(2,0))));
        assertFalse(map.place(new Car(map, new Position(0,3))));
        assertFalse(map.place(new Car(map, new Position(2,0))));
    }


    @Test
    public void canMoveTo(){
        RectangularMap map = new RectangularMap(6,6);
        map.place(new Car(map, new Position(3,3)));
        map.place(new Car(map, new Position(4,0)));
        assertFalse(map.canMoveTo(new Position(7,0)));
        assertFalse(map.canMoveTo(new Position(3,3)));
        assertFalse(map.canMoveTo(new Position(4,0)));
        assertTrue(map.canMoveTo(new Position(4,1)));
        assertTrue(map.canMoveTo(new Position(6,6)));
    }

    @Test
    public void RectangularMap1(){
        RectangularMap map = new RectangularMap(10,10);
        map.place(new Car(map, new Position(3,3)));
        map.place(new Car(map, new Position(4,4)));
        map.place(new Car(map, new Position(5,5)));
        map.place(new Car(map, new Position(6,6)));
        assertNull(map.objectAt(new Position(1,2)));
        assertNotNull(map.objectAt(new Position(6,6)));
        String[] moves = {"f", "l", "l", "f", "r", "f", "f" ,"f", "f"};
        MoveDirection[] moveDirections = new OptionsParser().parse(moves);
        map.run(moveDirections);
        assertTrue(map.isOccupied(new Position(3,4)));
        assertTrue(map.isOccupied(new Position(4,4)));
        assertTrue(map.isOccupied(new Position(4,5)));
        assertTrue(map.isOccupied(new Position(6,8)));
        assertFalse(map.isOccupied(new Position(5,5)));
    }


}