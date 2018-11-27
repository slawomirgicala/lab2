package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap{
    protected List<Car> cars = new ArrayList<>();


    public abstract boolean canMoveTo(Position position);

    public abstract boolean place(Car car);

    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++){
            cars.get(i%cars.size()).move(directions[i]);
        }
    }

    public abstract boolean isOccupied(Position position);

    public Object objectAt(Position position) {
        for (Car carOnMap : cars){
            if (carOnMap.getPosition().equals(position)){
                return carOnMap;
            }
        }
        return null;
    }

}
