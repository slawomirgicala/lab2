package agh.cs.lab2;

public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean smaller(Position another){
        return this.x <= another.x && this.y <= another.y;
    }

    public boolean larger(Position another){
        return this.x >= another.x && this.y >= another.y;
    }

    public Position upperRight(Position other){
        int x;
        int y;
        if (this.x >= other.x){
            x = this.x;
        }else{
            x = other.x;
        }
        if (this.y >= other.y){
            y = this.y;
        }else{
            y = other.y;
        }
        return new Position(x,y);
    }

    public Position lowerLeft(Position other){
        int x;
        int y;
        if (this.x <= other.x){
            x = this.x;
        }else{
            x = other.x;
        }
        if (this.y <= other.y){
            y = this.y;
        }else{
            y = other.y;
        }
        return new Position(x,y);
    }


    public Position add(Position other){
        int x = this.x + other.x;
        int y = this.y + other.y;
        return new Position(x,y);
    }

    public Position subtract(Position other){
        int x = this.x - other.x;
        int y = this.y - other.y;
        return new Position(x,y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Position))
            return false;
        Position that = (Position) other;
        return this.x == that.x && this.y == that.y;
    }
}
