import java.util.ArrayList;
import java.util.Arrays;
public class nine{
    //? Combination sum 2 
    //? solution set must not contain duplicate and also in every set duplicates
    //? are not allowed
    public static void main(String args[]){
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> li = new ArrayList<>();
        Arrays.sort(arr);
        CombinationSum2(arr,target,0,ans,li,0);
        System.out.print(ans);
    }
    public static void CombinationSum2(int[] arr,int target,int idx,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> li,int sum){
        if(sum==target){
            ans.add(new ArrayList<>(li));
            return;
        }
        if(idx==arr.length){
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]) continue;
            if(target<arr[i]+sum) break;
            li.add(arr[i]);
            CombinationSum2(arr,target,i+1,ans,li,sum+arr[i]);
            li.remove(li.size()-1);
        }
    }
}