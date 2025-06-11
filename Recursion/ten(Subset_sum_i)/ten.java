import java.util.ArrayList;
import java.util.Collections;
public class ten{
    //? Subset sum 1
    //? return the sums of all subsets in the list in increaing order

    //* Method 1 -> Power Set (using Bit Manipulation)
    public static void main(String args[]){
        int[] arr = {2,3};
        ArrayList<Integer> ans = new ArrayList<>();
        subset_sum_i(arr,ans,0,0);
        Collections.sort(ans);
        System.out.print(ans); // Output : 0, 2, 3, 5
    }
    //* Method 2 -> using Recursion
    //* Pick and not pick approach and add that sum in list when idx==arr.length 
    //* after that we will sort the list

    public static void subset_sum_i(int[] arr,ArrayList<Integer> ans,int idx,int sum){
        if(idx==arr.length){
            ans.add(sum);
            return;
        }
        subset_sum_i(arr,ans,idx+1,sum+arr[idx]);
        subset_sum_i(arr,ans,idx+1,sum);
    }
}