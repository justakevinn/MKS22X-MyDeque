import java.util.*;

public class Calculator{




  public static double eval(String s){
    String[] tokens = s.split(" ");
  //  System.out.println(Arrays.toString(tokens));
    MyDeque<Double> tokenD = new MyDeque<Double>(tokens.length);
    for (int x = 0; x < tokens.length; x++){
      try{
        tokenD.addFirst(Double.parseDouble(tokens[x]));
      }catch(NumberFormatException E){
        String t = tokens[x];
        Double v2 = tokenD.removeFirst();
        Double v1 = tokenD.removeFirst();
    //    System.out.println(v1 + " " + v2);
        if(t.equals("+")){
          tokenD.addFirst(v1 + v2);
        }
        if(t.equals("-")){
          tokenD.addFirst(v1 - v2);
        }
        if(t.equals("*")){
          tokenD.addFirst(v1 * v2);
        }
        if(t.equals("/")){
          tokenD.addFirst(v1 / v2);
        }
        if(t.equals("%")){
          tokenD.addFirst(v1 % v2);
        }
      }
    }
  //  System.out.println(tokenD.toString());
    return tokenD.getFirst();
  }

  public static void main(String args[]){
    System.out.println(eval("1 42 - 3 4.1 51 + * +"));
    System.out.println(eval("10 2.0 +"));
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println(eval("1 2 3 4 5 + * - -"));
  }
}
