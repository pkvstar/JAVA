import java.util.*;
public class Bs{
    //? Koko Eating Bananas
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h)); // Output: 4
    }
    //? my code (striver code is similar to this)
    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        int low = 1;
        int high = piles[n-1];
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(mid,piles,h)){
                ans = mid;
                high=mid-1;  
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean check(int k,int[] arr,int h){
        for(int i=0;i<arr.length;i++){
            int banana = arr[i];
            // if(banana%k == 0){
            //     h-=(banana/k);
            // }
            // else{
            //     h-=((banana/k)+1);
            // }
            //* OR
            h -= (banana + k - 1) / k;
            if(h<0){
                return false;
            }
        }
        if(h<0){
            return false;
        }
        return true;
    }
}