import java.util.*;
public class one{
    public static void main(String[] args){
        // System.out.print(decToBinary(5));
        System.out.print(binToDecimal(111));
    }

    //? 1. convert Decimal to Binary
    //* Approach is simple as we divide with 2 and whatever be the remainder
    //* we get , we store it to any Data Structure and after that we reverse that ans.
    public static String decToBinary(int n){
        StringBuilder ans = new StringBuilder(""); //* you cannot store answer in any DS
        while(n!=0){
            if(n%2 == 1){
                ans.append("1");
            }
            else{
                ans.append("0");
            }
            n/=2;
        }
        ans.reverse();
        return ans.toString();
    } 

    //? 2. convert Binary to Decimal
    //* Approach : take count and every time we increase count that will become power 
    //* of 2 and multiplied by that binary bit . But we start from back of binary for
    //* easyness
    public static int binToDecimal(int n){
        String str = n+"";
        int ans = 0;
        int powerCalc = 1;
        for(int i=str.length()-1;i>=0;i--){
            int num = str.charAt(i)-'0'; //character to number
            ans+=(num*powerCalc);
            powerCalc*=2; //increase power 2 at every iteration
        }
        return ans;
    }
}