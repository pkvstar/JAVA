import java.util.Arrays;    
public class Bs{
    //? Aggressive Cows
    //? find the largest minimum distance between cows placed in stalls
    public static void main(String[] args) {
        int[] arr = {1,2,8,4,9};
        int cows = 3;
        System.out.println(aggressiveCows(arr, cows)); // Expected Output: 3
    }
    public static int aggressiveCows(int[] arr,int k){
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        int low = 1;
        int high = max; //? can be max-min also
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(arr,k,mid)){
                low=mid+1;
                ans = mid;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static boolean check(int[] arr,int k,int min){
        int cow = 1;
        int prev = arr[0];
        for(int i=1;i<arr.length;i++){
            int diff = arr[i]-prev;
            if(diff>=min){
                cow++;
                prev=arr[i];
            }
        }
        if(cow>=k){
            return true;
        }
        return false;
    }
}