//? Recursion -> when a function called itself until a specified condition is met
public class one{
    //* 1.Recursion , 2.base case , 3.stack overflow , 4.recursion tree  
    public static void main(String[] args) {
        int max = 5;
        func(max,0);
    }
    public static void func(int max, int current) {
        if (current == max) {
            System.out.println(current);
            return;
        }
        System.out.println(current);
        func(max, current + 1);
    }
}