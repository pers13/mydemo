import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int number(String symbol) {
        return switch (symbol) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };
    }
    public static String numberReverse(int number) {
        return switch (number) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            case 10 -> "X";
            case 20 -> "XX";
            case 30 -> "XXX";
            case 40 -> "XL";
            case 50 -> "L";
            case 60 -> "LX";
            case 70 -> "LXX";
            case 80 -> "LXXX";
            case 90 -> "XC";
            case 100 -> "C";
            default -> null;
        };
    }
    public static int operation(int a, int b, String oper) throws Exception {
        return switch (oper) {
            case "+" -> a+b;
            case "-" -> a-b;
            case "/" -> a/b;
            case "*" -> a*b;
            default-> {
                try {
                    throw new Exception("Invalid operation");
                } catch (Exception e) {
                    throw new Exception(e);
                }
            }
        };
    }
    public static String calc(String input) throws Exception {
        String [] strings = input.split(" ");
        if (strings.length>3) {
            try {
                throw new Exception("More than 2 numbers");
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
        int a=-1,b=-1;
        boolean b1 = !(((number(strings[0])>0)&&(number(strings[2])>0))||((number(strings[0])==0)&&(number(strings[2])==0)));
        if (b1) {
            try {
                throw new Exception("Different type of numbers");
            } catch (Exception e) {
                throw new Exception(e);
            }
        } else {
            if ((number(strings[0])>0)&&(number(strings[2])>0)) {
                a = number(strings[0]);
                b = number(strings[2]);
                int c = operation(a,b,strings[1]);
                if (c>0) {
                    if ((c<10)||(c%10==0)) {
                        return numberReverse(c);
                    } else {
                        return numberReverse((c/10)*10)+numberReverse(c%10);
                    }
                } else {
                    try {
                        throw new Exception("Result is lower than 1");
                    } catch (Exception e) {
                        throw new Exception(e);
                    }
                }
            } else if ((number(strings[0])==0)&&(number(strings[2])==0)) {
                a = Integer.parseInt(strings[0]);
                b = Integer.parseInt(strings[2]);
                boolean b2 = !((a > 10) || (a < 1) || (b > 10) || (b < 1));
                if (b2) {
                    return Integer.toString(operation(a, b, strings[1]));
                }else{
                        try {
                            throw new Exception("Invalid numbers, they must be in [1;10]");
                        } catch (Exception e) {
                            throw new Exception(e);
                        }
                    }
            }
        }
        return null;
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String test = in.nextLine();
        if(test.isEmpty()) {
            throw new Exception("String is empty");
        } else {
            try {
                if (calc(test)!=null) {
                    System.out.println(calc(test));
                }
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
    }
}
