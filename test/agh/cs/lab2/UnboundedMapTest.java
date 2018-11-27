package agh.cs.lab2;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UnboundedMapTest {

    @Test
    public void UnboundedMap1(){
        ArrayList<HayStack> stacks = new ArrayList<>();
        stacks.add(new HayStack(new Position(-1,-2)));
        stacks.add(new HayStack(new Position(0,0)));
        stacks.add(new HayStack(new Position(1,-1)));
        stacks.add(new HayStack(new Position(2,-2)));
        UnboundedMap map = new UnboundedMap(stacks);
        assertTrue(map.isOccupied(new Position(0,0)));
        assertTrue(map.canMoveTo(new Position(100,100)));
        assertFalse(map.canMoveTo(new Position(2,-2)));
        map.place(new Car(map,new Position(1,-2)));
        map.place(new Car(map,new Position(0,-1)));
        map.place(new Car(map,new Position(2,1)));
        String[] moves = {"f","f","f","l","r","f","f","r","f","f","f","f"};
        MoveDirection[] moveDirection = new OptionsParser().parse(moves);
        map.run(moveDirection);
        assertNull(map.objectAt(new Position(-1,-1)));
        assertNotNull(map.objectAt(new Position(1,-1)));
        assertTrue(map.isOccupied(new Position(0,-2)));
        assertTrue(map.isOccupied(new Position(0,-1)));
        assertTrue(map.isOccupied(new Position(2,5)));
    }

}