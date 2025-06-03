import java.util.Arrays;
public class Bs{
    //? Smallest Divisor Given a Threshold
    //? find an integer divisor such that the sum of the division of each element by 
    //? the divisor is less than or equal to the threshold

    //* trick for ceil : (numerator + denominator - 1) / denominator ensures that any  
    //* remainder will cause the result to round up.
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold)); // Output: 5
    }
    public static int smallestDivisor(int[] arr, int threshold) {
        Arrays.sort(arr); //? not required but i have sorted it for clarity and max num
        int low = 1;
        int ans = -1;
        int high = arr[arr.length-1];
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(arr,threshold,mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static boolean check(int[] arr,int threshold,int num){
        int sum = 0;
        for(int el : arr){
            sum+=(el+num-1)/num;
            if(sum>threshold){
                return false;
            }
        }
        return true;
    }
}