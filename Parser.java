import java.util.*;
//(Stack, StringTokenizer, Scanner)
import java.io.*;
//(File, IOException)


public class Parser {
    private static StringTokenizer st;
    private static String leftExpression;
    //To store the current input string
    private static String currentString;
    //To store the items on the stack
    private static Stack<String> stackSymbol = new Stack<String>();
    //To store the current state on the stack
    private static Stack<Integer> stackState = new Stack<Integer>();

    //set the current string to the next token
    public static void next() {
        currentString = st.nextToken().intern();
        if (currentString == "v"){}
        else if(currentString == "l"){}
        else if(currentString == "yo"){}
        else if(currentString == "ba"){}
        else if(currentString == "o"){}
        else if(currentString == "se"){}
        else if(currentString == "le"){}
        else if(currentString == "n"){}
        else if(currentString == "c"){}
        else if(currentString == "a"){}
        else if(currentString == "t"){}
        else if(currentString == "b"){}
        else if(currentString == "$"){}
    }

    public static String input() {
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
    public static void shift(int nextState) {
        //push the first string of the input onto the stack
        stackSymbol.push("" + leftExpression.charAt(0));       

        //push the shifted state onto the stack as well
        stackState.push(nextState);

        // returns a new string that is a substring of leftExpression
        // excluding the first character
        leftExpression = leftExpression.substring(1);

    }

    //Method to indicate that the grammer is invalid
    public static void InvalidString() {
        System.out.println("THE GRAMMER IS INVALID");
        System.exit(0);
    }

    public static void reduce(int rule) {
        switch (rule)
        {

            case 1:
                //S -> C1C2 V X L
                stackSymbol.pop();
                stackSymbol.pop();
                stackSymbol.pop();
                stackSymbol.pop();
                stackState.pop();
                stackState.pop();
                stackState.pop();
                stackState.pop();
                if (stackState.peek() == 0)
                {
                    stackSymbol.push("S");
                    stackState.push(1);
                }
                break;
            case 2:
            {
                //reduce C1C2 -> yo o
                // pop 4 items (2 symbols and 2 states) 
                // from the top of the stack
                stackSymbol.pop();
                stackSymbol.pop();
                stackState.pop();
                stackState.pop();
                if (stackState.peek() == 0) {
                    stackSymbol.push("C1C2");
                    stackState.push(2);
                }
                break;
            }

            case 3:
            
                //reduce C1C2 -> ba ba

                stackSymbol.pop();
                stackSymbol.pop();
                stackState.pop();
                stackState.pop();
                if (stackState.peek() == 0)
                {
                    stackSymbol.push("C1C2");
                    stackState.push(2);
                }
                break;

            case 4:	
            
                //reduce C1C2 -> se se

                stackSymbol.pop();
                stackSymbol.pop();
                stackState.pop();
                stackState.pop();
                if (stackState.peek() == 0)
                {
                    stackSymbol.push("C1C2");
                    stackState.push(2);
                }
                break;

            case 5:
            
                //reduce C1C2 -> le le
                
                stackSymbol.pop();
                stackSymbol.pop();
                stackState.pop();
                stackState.pop();
                if (stackState.peek() == 0)
                {
                    stackSymbol.push("C1C2");
                    stackState.push(2);
                }
                break;
        
            case 6:
            
                //reduce C1C2 -> a a
                
                stackSymbol.pop();
                stackSymbol.pop();
                stackState.pop();
                stackState.pop();
                if (stackState.peek() == 0)
                {
                    stackSymbol.push("C1C2");
                    stackState.push(2);
                }
                break;

            case 7:
            
                //reduce C1C2 -> o o
                
                stackSymbol.pop();
                stackSymbol.pop();
                stackState.pop();
                stackState.pop();
                if (stackState.peek() == 0)
                {
                    stackSymbol.push("C1C2");
                    stackState.push(2);
                }
                break;

            case 8:
            
                //reduce C1C2 -> e e
                
                stackSymbol.pop();
                stackSymbol.pop();
                stackState.pop();
                stackState.pop();
                if (stackState.peek() == 0)
                {
                    stackSymbol.push("C1C2");
                    stackState.push(2);
                }
                break;

            case 9:
            
                //reduce V -> V L

                stackSymbol.pop();
                stackSymbol.pop();
                stackState.pop();
                stackState.pop();
                if (stackState.peek() == 2) {
                    stackSymbol.push("V");
                    stackState.push(10);
                }
                break;

            case 10:
            
                //reduce V -> v
                
                stackSymbol.pop();
                stackState.pop();
                if (stackState.peek() == 2) {
                    stackSymbol.push("V");
                    stackState.push(10);
                }
                break;

            case 11:
            
                //reduce L -> la
                
                stackSymbol.pop();
                stackSymbol.pop();
                stackState.pop();
                stackState.pop();
                if (stackState.peek() == 10) {
                    stackSymbol.push("L");
                    stackState.push(20);
                } else if (stackState.peek() == 19) {
                    stackSymbol.push("L");
                    stackState.push(25);
                }
                break;

            case 12:
            
                //reduce L -> c
                
                stackSymbol.pop();
                stackState.pop();
                if (stackState.peek() == 10) {
                    stackSymbol.push("L");
                    stackState.push(20);
                } else if (stackState.peek() == 19) {
                    stackSymbol.push("L");
                    stackState.push(25);
                }
                break;

            case 13:
                break;

            case 14:
            
                //reduce X -> N T
                
                stackSymbol.pop();
                stackSymbol.pop();
                stackState.pop();
                stackState.pop();
                if (stackState.peek() == 10) {
                    stackSymbol.push("X");
                    stackState.push(19);
                }
                break;

            case 15:
            
                //reduce N -> n
                
                stackSymbol.pop();
                stackState.pop();
                if (stackState.peek() == 10) {
                    stackSymbol.push("N");
                    stackState.push(21);
                }
                break;

            case 16:
                break;

            case 17:
            
                //reduce T -> t b
                
                stackSymbol.pop();
                stackSymbol.pop();
                stackState.pop();
                stackState.pop();
                if (stackState.peek() == 21) {
                    stackSymbol.push("T");
                    stackState.push(28);
                }
                break;
   
            case 18:
                break;


        }
    }

    public static void LR1() {
        //push S and state 0 unto the stack
        stackSymbol.push("S");
        stackState.push(0);
        int iterator = 1;
        while (iterator == 1) {
            //fetch the element(state) on top of the stack
            // and store it in currentStackState
            int currentStackState = stackState.peek();
            //fetch the character(string) at the left of the input
            // and store it in frontOfExrpession as a string
            String frontOfExpression = Character.toString(leftExpression.charAt(0));
            

            if (leftExpression.charAt(0) == 'y') {
                frontOfExpression = "yo";
            } else if (leftExpression.charAt(0) == 's') {
                frontOfExpression = "se";
            } else if (leftExpression.charAt(0) == 'l' && leftExpression.charAt(1) == 'e') {
                frontOfExpression = "le";
            } else if (leftExpression.charAt(0) == 'b' && leftExpression.charAt(1) == 'a') {
                frontOfExpression = "ba";
            }
            //use a switch to iterate over all assumption 
            // [yo, o, ba, se, le, v,l,n,c,a,t,b]
            switch(frontOfExpression) 
            {
                case "yo":
                
                    //if the state at the top of the stack is
                    //0 then push the first input string and
                    //the next state onto the stack (shift method)
                    //else the string the string is invalid


                    if (currentStackState == 0) shift(3);
                    else if (currentStackState == 8) shift(17);
                    else InvalidString();
                    break;
                    

                case "o":
                    
                    if (currentStackState == 0) shift(8);
                    else if (currentStackState == 3) shift(12);
                    else InvalidString();
                    break;

                case "ba":

                    if (currentStackState == 0) shift(4);
                    else if (currentStackState == 4) shift(13);
                    else InvalidString();
                    break;

                case "se":

                    if (currentStackState == 0) shift(5);
                    else if (currentStackState == 5) shift(14);
                    else InvalidString();
                    break;


                case "le":

                    if (currentStackState == 0) shift(6);
                    else if (currentStackState == 6) shift(15);
                    else InvalidString();
                    break;

                case "a":

                    if (currentStackState == 0) shift(7);
                    else if (currentStackState == 7) shift(16);
                    else if (currentStackState == 22) shift(30);
                    else if (currentStackState == 26) shift(31);
                    else InvalidString();
                    break;

                case "e":

                    if (currentStackState == 0) shift(9);
                    else if (currentStackState == 9) shift(18);
                    else InvalidString();
                    break;

                case "l":

                    if (currentStackState == 10) shift(22);
                    else if (currentStackState == 11) reduce(10);
                    else if (currentStackState == 19) shift(26);
                    else if (currentStackState == 20) reduce(9);
                    else if (currentStackState == 23) reduce(12);
                    else if (currentStackState == 24) reduce(15);
                    else if (currentStackState == 28) reduce(14);
                    else if (currentStackState == 30) reduce(11);
                    else if (currentStackState == 32) reduce(17);
                    else InvalidString();
                    break;

                case "v": 

                    if (currentStackState == 2) shift(11);
                    else if (currentStackState == 12) reduce(2);
                    else if (currentStackState == 13) reduce(3);
                    else if (currentStackState == 14) reduce(4);
                    else if (currentStackState == 15) reduce(5);
                    else if (currentStackState == 16) reduce(6);
                    else if (currentStackState == 17) reduce(7);
                    else if (currentStackState == 18) reduce(8);
                    else InvalidString();
                    break;

                case "c":

                    if (currentStackState == 10) shift(23);
                    else if (currentStackState == 11) reduce(10);
                    else if (currentStackState == 19) shift(27);
                    else if (currentStackState == 20) reduce(9);
                    else if (currentStackState == 23) reduce(12);
                    else if (currentStackState == 24) reduce(15);
                    else if (currentStackState == 28) reduce(14);
                    else if (currentStackState == 30) reduce(11);
                    else if (currentStackState == 32) reduce(17);
                    else InvalidString();
                    break;

                case "n":

                    if (currentStackState == 10) shift(24);
                    else if (currentStackState == 11) reduce(10);
                    else if (currentStackState == 20) reduce(9);
                    else if (currentStackState == 23) reduce(12);
                    else if (currentStackState == 30) reduce(11);
                    else InvalidString();
                    break;

                case "t":

                    if (currentStackState == 11) reduce(10);
                    else if (currentStackState == 20) reduce(9);
                    else if (currentStackState == 21) shift(29);
                    else if (currentStackState == 23) reduce(12);
                    else if (currentStackState == 24) reduce(15);
                    else if (currentStackState == 30) reduce(11);
                    else InvalidString();
                    break;

                case "b":

                    if (currentStackState == 29) shift(32);
                    else InvalidString();
                    break;

                case "$":

                    if (currentStackState == 1) {
                        System.out.println("ACCEPT!");
                        iterator = 0;
                        //Remove everything in the stack
                        //stackSymbol.clear();
                        //stackState.clear();
                    }
                    else if (currentStackState == 11) reduce(10);
                    else if (currentStackState == 20) reduce(9);
                    else if (currentStackState == 23) reduce(12);
                    else if (currentStackState == 24) reduce(15);
                    else if (currentStackState == 25) reduce(1);
                    else if (currentStackState == 27) reduce(12);
                    else if (currentStackState == 28) reduce(14);
                    else InvalidString();
                    break;
                
                //default:
                  //  throw new IllegalArgumentException("Something went wrong... :(");
            }

            if (iterator != 0) 
            {
                System.out.print("["+stackSymbol.elementAt(0)+" "+stackState.elementAt(0)+"]");
                //iterate over every element in the stack
                for (int i = 1; i < stackSymbol.size(); i++) 
                {
                    System.out.print("["+stackSymbol.elementAt(i)+" "+stackState.elementAt(i)+"]");
                }
                System.out.print("  " + leftExpression + "\n");
                
            }
        }
    }   
    //}

    public static void main(String[] args)throws IOException
    {

        //Parser parse = new Parser();
        //Read the input from a file
        File file = new File("Grammar.txt");
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()) {
            String string = "";
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            System.out.println(line);

            String[] arr1 = new String[]{"thulang", "segang", "ratang", "belang", "dirang", "bofang", "lwalang"};
            String[] arr2 = new String[]{"ka"};
            String[] arr3 = new String[]{"monna", "banna", "selepe", "lesaka", "masaka", "koloi"};
            String[] arr4 = new String[]{"thata", "phakela", "bosigo", "motshegare"};
            String[] arr5 = new String[]{"kopi", "borotho", "kobo"};
            String[] arr6 = new String[]{"ya"};
            String[] arr7 = new String[]{"gago", "me", "sone", "bone", "tsone"};

            // Convert String Array to List
            List<String> v = Arrays.asList(arr1);
            List<String> l = Arrays.asList(arr2);
            List<String> n = Arrays.asList(arr3);
            List<String> c = Arrays.asList(arr4);
            List<String> a = Arrays.asList(arr5);
            List<String> t = Arrays.asList(arr6);
            List<String> b = Arrays.asList(arr7);


            for (String s : arr) {
                if (v.contains(s)) string += "v";
                else if(s.equals("yo")) string += "yo";
                else if(s.equals("o")) string += "o";
                else if(s.equals("ba")) string += "ba";
                else if(s.equals("se")) string += "se";
                else if (l.contains(s)) string += "l";
                else if (n.contains(s)) string += "n";
                else if (c.contains(s)) string += "c";
                else if (a.contains(s)) string += "a";
                else if (t.contains(s)) string += "t";
                else if (b.contains(s)) string += "b";
            }

            System.out.println(string);
            st = new StringTokenizer(string+" $");
            next();
            input();
            LR1();
        }
    }
}