package agh.cs.lab2;

import java.util.ArrayList;

public class CarSystem {
    public static void main(String[] args){

        /*MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Car(map));
        map.place(new Car(map,new Position(3,4)));
        System.out.println(map.toString());
        map.run(directions);
        System.out.println(map.toString());*/

        ArrayList<HayStack> stacks = new ArrayList<>();
        stacks.add(new HayStack(new Position(-4,-4)));
        stacks.add(new HayStack(new Position(7,7)));
        stacks.add(new HayStack(new Position(3,6)));
        stacks.add(new HayStack(new Position(2,0)));
        UnboundedMap map = new UnboundedMap(stacks);
        map.place(new Car(map));
        map.place(new Car(map,new Position(3,4)));
        System.out.println(map.toString());
        try{
            MoveDirection[] directions = new OptionsParser().parse(args);
            map.run(directions);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        System.out.println(map.toString());

    }
}
