package agh.cs.lab2;

public enum MapDirection{
    NORTH,
    SOUTH,
    WEST,
    EAST;
    public String toString() {
        switch (this) {
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case EAST:
                return "Wschód";
            case WEST:
                return "Zachód";
        }
        return "";
    }
    public MapDirection next(){
        switch (this){
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
        }
        return null;
    }
    public MapDirection previous(){
        switch (this){
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
        }
        return null;
    }

    public Position toUnitVector(){
        switch (this){
            case NORTH:
                return new Position(0,1);
            case SOUTH:
                return new Position(0,-1);
            case WEST:
                return new Position(-1,0);
            case EAST:
                return new Position(1,0);
        }
        return new Position(0,0);
    }
}