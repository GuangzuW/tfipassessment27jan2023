package assessment;

import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Console cons=System.console();
        System.out.println("Welcome. ");
        String $last="0";

        while (true){
            String input =cons.readLine("> ");
            String result;
                
            if (input.equalsIgnoreCase("exit")){
                System.out.println("Bye bye");
                break;
            }else{
                String []splitted = input.trim().split(" ");
                for (int i=0;i<splitted.length;i++){
                    if(splitted[i].equalsIgnoreCase("$last")){
                        splitted[i]=$last;
                    }
                }

                switch(splitted[1]){
                    case("+"):
                        result =Double.toString(Double.parseDouble(splitted[0])+Double.parseDouble(splitted[2]));
                        break;
                    case("-"):
                        result =Double.toString(Double.parseDouble(splitted[0])-Double.parseDouble(splitted[2]));
                        break;
                    case("*"):
                        result =Double.toString(Double.parseDouble(splitted[0])*Double.parseDouble(splitted[2]));
                        break;
                    case("/"):
                        result =Double.toString(Double.parseDouble(splitted[0])/Double.parseDouble(splitted[2]));
                        break;
                    default:
                        result="Invalid Entry";
                }
                $last=result;
                System.out.println(result);
            }
        }    
    }
    
}
