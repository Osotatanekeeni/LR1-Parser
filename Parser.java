import java.util.*;
//(Stack, StringTokenizer, Scanner)
import java.io.*;
//(File, IOException)


public class Parser {
    private StringTokenizer st;
    private String leftExpression;
    //To store the current input string
    private String currentString;
    //To store the items on the stack
    private Stack<String> stackSymbol = new Stack<String>();
    //To store the current state on the stack
    private Stack<Integer> stackState = new Stack<Integer>();

    //set the current string to the next token
    public void next() {
        currentString = st.nextToken().intern();
        if (currentString == "v"){}
        else if(currentString == "l"){}
        else if(currentString == "n"){}
        else if(currentString == "c"){}
        else if(currentString == "a"){}
        else if(currentString == "t"){}
        else if(currentString == "b"){}
        else if(currentString == "$"){}
    }

    public String input() {
        leftExpression = "";
        //check that the current string is not $
        //then add the current string to the left expression
        while(currentString != "$") {
            leftExpression += currentString;
            next();
        }

        //if the current string is $ then add $ to
        //the left and return it
        leftExpression += "$";
        return leftExpression;
    }

    //method to shift the current state and handle the
    public void shift(int nextState) {
        //push the first string of the input onto the stack
        stackSymbol.push("" + leftExpression.charAt(0));       

        //push the shifted state onto the stack as well
        stackState.push(nextState);

        //returns a new string that is a substring of leftExpression
        leftExpression = leftExpression.substring(1);

    }

    public void LR1() {
        //push S unto the stack
        stackSymbol.push("S");
        stackState.push(0);
        int count = 1;
        while (count == 1) {
            //fetch the element(state) on top of the stack
            int currentState = StackState.peek();
            

        }
    }

}