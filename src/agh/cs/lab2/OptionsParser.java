package agh.cs.lab2;

public class OptionsParser {

    public MoveDirection[] parse(String[] options) throws  IllegalArgumentException{
        int counter = 0;
        for (String option : options){
            if (option.equals("f") || option.equals("forward") || option.equals("b") || option.equals("backward") || option.equals("r") || option.equals("right") || option.equals("l") || option.equals("left")){
                counter++;
            }else{
                throw new IllegalArgumentException(option + " is not legal move specification");
            }
        }
        MoveDirection[] result = new MoveDirection[counter];
        counter = 0;
        for (String option : options){
            if (option.equals("f") || option.equals("forward")){
                result[counter] = MoveDirection.FORWARD;
                counter++;
            } else if (option.equals("b") || option.equals("backward")){
                result[counter] = MoveDirection.BACKWARD;
                counter++;
            } else if (option.equals("r") || option.equals("right")){
                result[counter] = MoveDirection.RIGHT;
                counter++;
            } else if (option.equals("l") || option.equals("left")){
                result[counter] = MoveDirection.LEFT;
                counter++;
            }
        }
        return result;
    }
}
