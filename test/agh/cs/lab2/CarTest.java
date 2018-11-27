package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void car1(){
        RectangularMap map = new RectangularMap(4,4);
        Car mercedes = new Car(map,new Position(2,2));
        String[] drive = {"b", "backward", "awkward", "right", "forward"};
        MoveDirection[] theWay = new OptionsParser().parse(drive);
        for (MoveDirection partOfWay : theWay){
            mercedes.move(partOfWay);
        }
        assertEquals("E", mercedes.toString());
    }

    @Test
    public void car2(){
        RectangularMap map = new RectangularMap(4,4);
        Car bmw = new Car(map);
        String[] drive = {"l", "backward", "r", "forward", "f", "whatever", "whenever", "right", "b", "THE END"};
        MoveDirection[] theWay = new OptionsParser().parse(drive);
        for (MoveDirection partOfWay : theWay){
            bmw.move(partOfWay);
        }
        assertEquals("E", bmw.toString());
    }

    @Test
    public void car3(){
        RectangularMap map = new RectangularMap(4,4);
        Car renault = new Car(map);
        String[] randomWords = {"1", "owebfowbf", "wieo", "wiofho", "forwardd", "lr", "saodno"};
        MoveDirection[] noWay = new OptionsParser().parse(randomWords);
        for (MoveDirection nothing : noWay){
            renault.move(nothing);
        }
        assertEquals("N", renault.toString());
    }

    @Test
    public void car4(){
        RectangularMap map = new RectangularMap(4,4);
        Car jaguar = new Car(map);
        String[] toTheNorth = {"forward", "f","forward", "f","forward", "f","forward", "f","forward", "f","forward", "f","forward", "f"};
        MoveDirection[] farFarAway = new OptionsParser().parse(toTheNorth);
        MoveDirection[] expected = {MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,};
        assertArrayEquals(expected,farFarAway);
        for (MoveDirection forward : farFarAway){
            jaguar.move(forward);
        }
        assertEquals("N", jaguar.toString());
    }

    @Test
    public void car5(){
        RectangularMap map = new RectangularMap(4,4);
        Car fiat = new Car(map);
        String[] totheWest = {"r", "b", "b", "b", "b", "nknweofwe", "b"};
        MoveDirection[] farAway = new OptionsParser().parse(totheWest);
        MoveDirection[] expected = {MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.BACKWARD,MoveDirection.BACKWARD,MoveDirection.BACKWARD,MoveDirection.BACKWARD,};
        assertArrayEquals(expected,farAway);
        for (MoveDirection RnB : farAway){
            fiat.move(RnB);
        }
        assertEquals("E", fiat.toString());
    }

    @Test
    public void world1(){
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Car(map));
        map.place(new Car(map,new Position(3,4)));
        map.run(directions);
        assertTrue(map.isOccupied(new Position(2,0)) && map.isOccupied(new Position(3,5)));
    }

    @Test
    public void world2(){
        String[] args = {"f", "f", "f", "r", "f", "f", "f", "f", "f", "f", "f", "f", "r", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(1, 1);
        map.place(new Car(map));
        map.place(new Car(map,new Position(0,0)));
        map.run(directions);
        assertTrue(map.isOccupied(new Position(1,0)));
    }

}