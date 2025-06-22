public class two{
    public static void main(String[] args){
        // swap(3,5);
        // System.out.println(checkIthBit(13,1));
        // System.out.println(setIthBit(9,2));
        // System.out.println(clearIthBit(7,1));
        // System.out.println(toggleIthBit(13,2));
        // System.out.println(clearLastSetBit(40));
        // System.out.println(powerOfTwo(32));
        System.out.println(countSetBits(3));

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
        return (1<<i)^num; //* OR num & ~(1<<i)
    }

    //? 5. Toggle the ith Bit
    //* Approach : left shift 1 ith time and use '^'(XOR) operator with num
    public static int toggleIthBit(int num,int i){
        return num^(1<<i);
    }

    //? 6. Clear the Last Set Bit(rightmost)
    //* Approach : method 1(Brute Force) -> find position of rightmost set bit
    //* and clear that ith bit
    //* method 2(Optimal) -> n&(n-1)
    public static int clearLastSetBit(int num){
        return num&(num-1);
    } 

    //? 7. Check if the Number is a Power of 2
    //* Approach : method 1(Brute Force) -> count set bits and if count is 1 means
    //* it is the number is a power of 2 and if count is greater than that then means false
    //* method 2(Optimal) -> n&(n-1); if it returns 0 ; it means there was only one set bit
    //* which shows that it was the number power of two and if it return any number ; it means
    //* that number as having more than one set bit which is not power of two
    public static boolean powerOfTwo(int num){
        return (num&(num-1))==0 ? true : false;
    }

    //? 8. Count the no. of Set Bits
    //* Approach : method 1(Brute Force) -> right shift the number and use '&' with 1
    //* if it returns 1 then increase count and do this work till num!=0
    //* method 2(Optimal) -> n&(n-1) till n!=0 and count++ everytime loop runs because
    //* it remove right most bit every time and also pass new n for every iteration
    public static int countSetBits(int num) {
        int count = 0;
        while(num!=0){
            num = num&(num-1);
            count++;
        }
        return count;
    }
}