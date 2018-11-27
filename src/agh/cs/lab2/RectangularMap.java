package agh.cs.lab2;
import java.util.*;

class RectangularMap extends AbstractWorldMap{
    private int width;
    private int height;


    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public boolean canMoveTo(Position position){
        Position upLimit = new Position(this.width,this.height);
        Position downLimit = new Position(0,0);
        if (!(position.smaller(upLimit) && position.larger(downLimit))){
            return false;
        }
        return !isOccupied(position);
    }

    public boolean place(Car car) {
        Position upLimit = new Position(this.width,this.height);
        Position downLimit = new Position(0,0);
        if (!(car.getPosition().smaller(upLimit) && car.getPosition().larger(downLimit))){
            return false;
        }
        if (isOccupied(car.getPosition())){
            return false;
        }
        cars.add(car);
        return true;
    }

    public boolean isOccupied(Position position){
        for (Car carOnMap : cars){
            if (carOnMap.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }


    public String toString() {
        return new MapVisualizer(this).draw(new Position(0,0),new Position(this.width,this.height));
    }
}
