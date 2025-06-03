public class Bs{
    //? Find square root of a number using binary search

    public static void main(String args[]){
        int x = 16; // Example input
        int result = findSqrt(x);
        System.out.println("Square root of " + x + " is: " + result);
    }
    public static int findSqrt(int x){
        int low = 1;
        int high = x;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(mid*mid<=x){
                ans = mid;
                low = mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}