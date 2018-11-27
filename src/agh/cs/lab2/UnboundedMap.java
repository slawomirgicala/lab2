package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {
    private List<HayStack> stacks;

    public UnboundedMap(List<HayStack> stacks){

        this.stacks = stacks;
    }

    public boolean canMoveTo(Position position){

        return !isOccupied(position);
    }

    public boolean place(Car car) {
        if (isOccupied(car.getPosition())){
            return false;
        }
        cars.add(car);
        return true;
    }


    public boolean isOccupied(Position position){
        //super.isOccupied(position);
        for (Car carOnMap : cars){
            if (carOnMap.getPosition().equals(position)){
                return true;
            }
        }
        for (HayStack stackOnMap : stacks){
            if (stackOnMap.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }


    public Object objectAt(Position position) {
        for (HayStack stackOnMap : stacks){
            if (stackOnMap.getPosition().equals(position)){
                return stackOnMap;
            }
        }
        return super.objectAt(position);
    }

    public String toString(){

        Position upRight = new Position(0,0);
        Position lowLeft = new Position(0,0);

        for (Car carOnMap : cars){
            upRight = carOnMap.getPosition().upperRight(upRight);
            lowLeft = carOnMap.getPosition().lowerLeft(lowLeft);
        }
        for (HayStack stackOnMap : stacks){
            upRight = stackOnMap.getPosition().upperRight(upRight);
            lowLeft = stackOnMap.getPosition().lowerLeft(lowLeft);
        }

        return new MapVisualizer(this).draw(lowLeft,upRight);
    }

}
