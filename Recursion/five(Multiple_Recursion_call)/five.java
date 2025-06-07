public class five{
    public static void main(String[] args){
        int n = 5;
        System.out.println(fibonacci(n));
    }
    public static int fibonacci(int n){
        if(n<=1){
            return 1;
        }
        int f = fibonacci(n-1); //? first recursive call
        int s = fibonacci(n-2); //? second recursive call
        return f + s;
    }
}