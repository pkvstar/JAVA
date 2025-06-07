public class two{
    //? 1. Print name 5 times
    //? 2. Print Linearly from 1 to N
    //? 3. Print from N to 1
    //? 4. Print Linearly from 1 to N (but by backtracking)  
    //? 5. Print Linearly from N to 1 (but by backtracking)
    public static void main(String[] args) {
        // Ques1(1, 5);
        // Ques2(1, 5);
        // Ques3(5, 5);
        // Ques4(5,5);
        Ques5(1,5);
    }
    public static void Ques1(int i,int n) {
        if (i > n) return;
        System.out.println("Your Name");
        Ques1(i+1,n);
    }
    public static void Ques2(int i,int n) {
        if (i > n) return;
        System.out.println(i);
        Ques2(i+1,n);
    }
    public static void Ques3(int i,int n) {
        if (i < 1) return;
        System.out.println(i);
        Ques3(i-1,n);
    }
    public static void Ques4(int i,int n) {
        if (i<1) return;
        Ques4(i-1,n);
        System.out.println(i);
    }
    public static void Ques5(int i,int n) {
        if(i>n) return;
        Ques5(i+1,n);
        System.out.println(i);
    }
}