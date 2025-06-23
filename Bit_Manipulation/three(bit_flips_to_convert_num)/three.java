public class three{
    //? Minimum bit flips to convert a number
    public static void main(String args[]){
        System.out.print(bitToFlip(7,5));
    }
    //* Approach : 
    //* method 1 -> check bits of both number at every iteration and if the
    //* bits are not equal then increase count and return count at the end

    //* method 2 -> use Xor(^) operator and perform start^goal and the the result
    //* we get , we count set bits of result nad return that as a answer 
    //* (method 2 code in image) 
    public static int bitToFlip(int start,int goal){
        int count = 0;
        while(start!=0 || goal!=0){
            int s = start%2;
            int g = goal%2;
            if(s!=g) count++;
            start/=2;
            goal/=2;
        }
        return count;
    }
}