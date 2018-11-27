package agh.cs.lab2;

public class Car {
    private Position carPosition = new Position(2,2);
    private MapDirection carDirection = MapDirection.NORTH;
    private IWorldMap map;

    public Car(IWorldMap map){

        this.map = map;
    }

    public Car(IWorldMap map, Position initialPosition){
        this.map = map;
        this.carPosition = initialPosition;
    }

    public Position getPosition(){

        return this.carPosition;
    }


    public String toString(){
        switch (this.carDirection){
            case NORTH:
                return "N";
            case SOUTH:
                return "S";
            case WEST:
                return "W";
            case EAST:
                return "E";
        }
        return "";
    }

    public void move(MoveDirection direction){
        if (direction == MoveDirection.RIGHT){
            this.carDirection = this.carDirection.next();
            return;
        }
        if (direction == MoveDirection.LEFT){
            this.carDirection = this.carDirection.previous();
            return;
        }

        Position unitVec = this.carDirection.toUnitVector();
        Position newPosition;
        if (direction == MoveDirection.FORWARD){
            newPosition = this.carPosition.add(unitVec);
        }else{
            newPosition = this.carPosition.subtract(unitVec);
        }
        if (this.map.canMoveTo(newPosition)){
            this.carPosition = newPosition;
        }
    }

}
