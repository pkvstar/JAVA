public class three{
    //? Parameterized recursion -> a function that takes additional parameters to 
    //?  control the recursion.

    //? Functional recursion -> a function that calls itself with a different
    //?  set of parameters, often used to solve problems in a more functional style.
    public static void main(String[] args){
        ParameterizedRecursion(5, 0);
        System.out.println(FunctionalRecursion(5));
    }
    //* Example: Calculate the sum of the first n natural numbers using parameterized 
    //* recursion and functional recursion.

    public static void ParameterizedRecursion(int n, int sum) {
        if (n == 0) {
            System.out.println(sum);
            return;
        }
        ParameterizedRecursion(n - 1, sum + n);
    }
    public static int FunctionalRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        return n + FunctionalRecursion(n - 1);
    }
}