/**
 * Main
 */
import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(Reverse_string("Hello World"));


        System.out.println(NumDigit(1));


        ArrayList<Double> hello=new ArrayList<Double>();
        hello.add(2.0);
        hello.add(11.9);
        hello.add(10.0);
        System.out.println(SqrList(hello));
        System.out.println(Mean_and_deviation(hello));

        ArrayList<Integer> result=new ArrayList<Integer>();
        result.add(4);
        result.add(8);
        result.add(5);
        result.add(9);
        result.add(12);
        result.add(1);
        System.out.println(EvenCount(result));
        System.out.println(Index(1, result));

        System.out.println(HCF(10, 25));
        System.out.println(LCM(10, 25));

        System.out.println(Febonacci(8));
        System.out.println(Febonacci(3));


        System.out.println(nthMem(8));


        System.out.println(CrtHash(result, result));
        HashMap<?,?> request=CrtHash(result, result);

        String out="Hello";
        System.out.println(isKeyPresent(request,out));

        String textTocount="This corrected version should now correctly count the number of vowels in the input string x.";
        System.out.println(countVowel(textTocount)); 
        
       playTICTOC();
        
    }

// Loop Method to solve some interesting questions


// 1: Give a positive integer, return its factorial
static int Fact(int x){
        if(x<0){
            System.out.print("Invalid input to calculate factorial");
            return 405;
        }
        else{
            if(x>1){
                int result=x*Fact(x-1);
                return result;
            }
            else{
                return 1;
            }
        }
} // End of method Fact()


//2: Give a positive integer figure if it is prime or not
static boolean Prime(int x){
    if (x<=1){
        return false;
    }
    else{
        int root =(int) Math.sqrt(x);
        for (int i=2;i<=root;i++){
            if (x%i==0){
                return false;
            }
        }
    return true;
    }
}// End of method Prime()



//Given a positive integer, return the sum of all integers from 1 up to this number.
static int Sum(int x){
    if (x<1){
        System.out.print("Invalid input");
        return 405;
    }
    else{
        if (x==1){
            return 1;
        }
        else{
            int result=x+Sum(x-1);
            return result;
        }
    }
}//End of method Sum()



//Given a positive integer, return its binary representation (output using integer datatype).
static int binary_cal(int x){
    int Que =x;
    int result =0;
    int power=0;
    while (Que!=0){
        int rem=Que%2;
        Que=(int) Que/2;
        result=result+rem*(int)Math.pow(10, power);
        power++;
    }
    return result;
} // End of method binary_cal()


//Given a positive integer, return the sum of all prime numbers from 1 up to this number.

static int Sum_prime(int x){
    if (x<2){
        return 0;
    }
    else{
        int sum=0;
        for (int i=2;i<=x;i++){
            boolean output=Prime(i);
            if(output){
                sum+=i;
            }
        }
        return sum;

    }
}// End of method Sum_prime()





//Given a string as input, return the string in reverse order (without using string splicing).
static String Reverse_string(String x){
    String text="";
    for (int i=0;i<x.length();i++){
        char c= x.charAt(i);
        text=c+text;
    }
    return text;
} // End of Reverse_string()


//Given a positive integer, return the number of digits in it.
static int NumDigit(int x){
    if (x<1){
        System.out.println("Invalid input Enter a positive integer");
        return 405;
    }
    else{
        int digit=0;
        while (x!=0){
            digit++;
            x=(int) x/10;
        }
        return digit;
    }
    
}// End of method NumDigit()



//Given a list of numbers, return a list of the squares of all the numbers.
static ArrayList<Double> SqrList(ArrayList<Double> x){
    ArrayList<Double> Sqrd=new ArrayList<Double>();
    for (double i:x){
        Sqrd.add((double) Math.pow(i, 2));
    }
    return Sqrd;
}// End of the method


//Given a list of numbers, return their mean and standard deviation.

static HashMap<String, Double> Mean_and_deviation(ArrayList<Double> x){
    HashMap<String, Double> result = new HashMap<String,Double>();


    double mean=0.0;
    for (double i:x){
        mean+=i;
    }
    double Mean=mean/x.size();
    result.put("Mean", Mean);


    double sumSqrdiff=0.0;
    for (double i:x){
        sumSqrdiff+=Math.pow(i-Mean, 2);
    }
    double stDev=Math.sqrt(sumSqrdiff/x.size());

    result.put("STD", stDev);
    return result;
}// End of the method



//Given a list of integers, return the count of even numbers in it.
static int EvenCount(ArrayList<Integer> x){
    int count=0;
    for (int i: x){
        if(i%2==0){
            count++;
        }
    }
    return count;
}// End of method



//Given a list of numbers, return the maximum number in it.
static double MaxList(ArrayList<Double> x){
    double Max=x.get(0);
    for (double i:x){
        if (i>Max){
            Max=i;
        }
    }
    return Max;
}// End of method


// Given a list of integers and another integer, return the index of this given integer.
static int Index(int y,ArrayList<Integer> x){
    for (int i=0;i<x.size();i++){
        if (y==x.get(i)){
            return i;
        }
    }
    System.out.print("Given integer is not available in the list ");
    return 405;
}// End of the method

// Given a list of integers, return their Greatest Common Divisor (Divisor)
static int HCF(int x,int y){
    int min=Math.min(x, y);
    int hcf=1;
    for (int i=2;i<=min;i++){
        if(x%i==0 && y%i==0){
            hcf=i;
        }
    }
    return hcf;
}// End of the method



//Given a list of integers, return their Least Common Multiple (LCM).
static int LCM(int x,int y){
    int hcf=HCF(x, y);
    return x*y/hcf;
}// End of the method


//Given a positive integer (n), return a list containing the first n integers in the Fibonacci series

static ArrayList<Integer> Febonacci(int x){
    if (x<1){
        System.out.println("Invalid Input");
        throw new IllegalArgumentException("Invalid input to create the list");
    }
    else{
        ArrayList<Integer> result=new ArrayList<Integer>();
        result.add(1);
        result.add(1);
        if (x==1){
            result.remove(1);
            return result;
        }
        else if(x==2){
            return result;
        }
        else{
            for (int i=2;i<x;i++){
                int val=result.get(i-1)+result.get(i-2);
                result.add(val);
            }
        }
        return result;
    }
}// End



// Find nth member of Fibonacci series
static int nthMem(int x){
    if (x<0){
        throw new IllegalArgumentException("Invalid Input");

    }
    else if(x==1 || x==2){
        return 1;
    }
    else{
        return nthMem(x-1)+nthMem(x-2);
    }
}// End



//Given two lists of the same length as input, return a Hashmap with keys taken from the first list and values from the second list. If the list sizes are different, consider the length of the shorter one for creating the Hashmap.
static <T> HashMap<T,T> CrtHash(ArrayList<T> x,ArrayList<T> y){
    HashMap<T, T> result=new HashMap<>();
    int min=Math.min(x.size(), y.size());
    for (int i=0;i<min;i++){
        result.put(x.get(i),y.get(i));    
    }
    return result;
}// End



//Given a Hashmap and a key, return True if the key is present in the Hashmap, else return False.
static <K,V,T> boolean isKeyPresent(HashMap<K,V> map,T keys){
    for (Map.Entry<K,V> entry:map.entrySet()){
        if(entry.getKey()==keys){
            return true;
        }
        
    }
    return false;
}//End



//Given a string as input, return the number of vowels in it.
static int countVowel(String x) {
    String[] vowels = {"A", "a", "E", "e", "I", "i", "O", "o", "U", "u"};
    int lengthX = x.length();
    int vowelsCount = 0;
    
    for (int i = 0; i < lengthX; i++) {
        String currentChar = String.valueOf(x.charAt(i)); 
        for (int j = 0; j < vowels.length; j++) {
            if (currentChar.equals(vowels[j])) { // 
                vowelsCount++;
                break; 
            }
        }
    }
    
    return vowelsCount;
}


//Implement the Tic-Tac-Toe game. The program should allow two players to play against each other and display the board after each move.

static void playTICTOC(){
    ArrayList<ArrayList<String>> Game = new ArrayList<ArrayList<String>>();
    int count=0;
    boolean turn=true;
    String marker="o";
    for (int i = 0; i < 3; i++) {
        ArrayList<String> inner = new ArrayList<>(); // Create a new ArrayList for each row
        for (int j = 0; j < 3; j++) {
            inner.add("_"); // Add "_" to each column of the current row
        }
        Game.add(inner); // Add the current row to the Game board
    }
    print_game(Game);
    ArrayList<Integer> container=new ArrayList<Integer>();
    while (count<10){
        System.out.println("Hello player please enter the position to play");
        Scanner pos=new Scanner(System.in);
        int choice = pos.nextInt();

        if (turn){
            marker="o";
        }
        else{
            marker="x";
        }
        switch (choice) {
            case 11:
            if (container.contains(11)){
                System.out.println("Already entered the value");
                print_game(Game);
                break;
            }
            Game.get(0).set(0, marker);
            count++;
            container.add(11);
            turn=!turn;
            print_game(Game);
            System.out.println(count);
            break;
            
            case 12:
            if (container.contains(12)){
                System.out.println("Already entered the value");
                print_game(Game);
                break;
            }
            Game.get(0).set(1, marker);
            count++;
            container.add(12);
            turn=!turn;
            print_game(Game);
            System.out.println(count);
               break;

            case 13:
            if (container.contains(13)){
                System.out.println("Already entered the value");
                print_game(Game);
                break;
            }
            Game.get(0).set(2, marker);
            count++;
            container.add(11);
            turn=!turn;
            print_game(Game);
            System.out.println(count);
              break;

            case 21:

            if (container.contains(21)){
                System.out.println("Already entered the value");
                print_game(Game);
                break;
            }
            Game.get(1).set(0, marker);
            count++;
            container.add(21);
            turn=!turn;
            print_game(Game);
            System.out.println(count);
            break;

            case 22:
            if (container.contains(22)){
                System.out.println("Already entered the value");
                print_game(Game);
                break;
            }
            Game.get(1).set(1, marker);
            count++;
            container.add(22);
            turn=!turn;
            print_game(Game);
            System.out.println(count);
            break;

            case 23:
            if (container.contains(23)){
                System.out.println("Already entered the value");
                print_game(Game);
                break;
            }
            Game.get(1).set(2, marker);
            count++;
            container.add(23);
            turn=!turn;
            print_game(Game);
            System.out.println(count);
            break;


            case 31:
            if (container.contains(31)){
                System.out.println("Already entered the value");
                print_game(Game);
                break;
            }
            Game.get(2).set(0, marker);
            count++;
            container.add(31);
            turn=!turn;
            print_game(Game);
            System.out.println(count);
            break;

            case 32:
            if (container.contains(32)){
                System.out.println("Already entered the value");
                print_game(Game);
                break;
            }
            Game.get(2).set(1, marker);
            count++;
            container.add(32);
            turn=!turn;
            print_game(Game);
            System.out.println(count);
            break;

            case 33:
            if (container.contains(33)){
                System.out.println("Already entered the value");
                print_game(Game);
                break;
            }
            Game.get(2).set(2, marker);
            count++;
            container.add(33);
            turn=!turn;
            print_game(Game);
            System.out.println(count);
            break;


            default:
              System.out.println("Invalid input, valid inputs are 11,12,13  21,22,23, 31,32,33");  
            break;
        }


    }
    

    
}

static void print_game(ArrayList<ArrayList<String>> Game){
    System.out.println("Hello players! Enjoy the game");
    for(ArrayList<String> i:Game){
        System.out.println(i);
    }
}

 
// End of main class
}





