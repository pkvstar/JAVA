public class two{
    public static void main(String[] args){
        // swap(3,5);
        // System.out.println(checkIthBit(13,1));
        // System.out.println(setIthBit(9,2));
        System.out.println(clearIthBit(7,1));
    }
    //? 1. swap two numbers
    //* Approach : we know that num ^ num = 0 
    //* So, a = a^b; 
    //* b = a^b ((a^b)^b ==> a)
    //* a = a^b ((a^b)^a ==> b)
    public static void swap(int a,int b){
        System.out.println("a = "+a+" "+"b = "+b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.print("a = "+a+" "+"b = "+b);
    }

    //? 2. check if the ith bit is set or not
    //* Approach : there are two approaches 
    //* method 1 : using left shift operator -> in this left shift the 1 ith
    //* times and perform '&' with number and if it return any number (but not 0) then t
    //* true , if zero then return false

    //* method 2 : using right shift operator -> in this right shift the given number
    //* ith times and perform '&' with 1 and if it return 1 then true otherwise 
    //* false if zero comes.
    //* Here we use method 1
    public static boolean checkIthBit(int num,int i){
        return ((1<<i)&num)!=0 ? true : false;
    }

    //? 3. Set the ith Bit
    //* Approach : left shift 1 ith time and use '|' (OR) operator with num
    public static int setIthBit(int num,int i){
        return (1<<i)|num;
    }

    //? 4. Clear the ith Bit
    //* Approach : left shift 1 ith time and use '^' (XOR) operator with num
    public static int clearIthBit(int num,int i){
        return (1<<i)^num;
    }
}