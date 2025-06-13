import java.util.ArrayList;
import java.util.Arrays;
public class eleven{
    //? subsets ii 
    //? Given an integer array nums that may contain duplicates, return all 
    //? possible subsets (the power set).
    public static void main(String args[]){
        int[] arr = {1,2,2};
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> li = new ArrayList<>();
        subsets_ii(arr,0,ans,li);
        System.out.print(ans);
    }
    public static void subsets_ii(int[] arr,int idx,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> li){
        ans.add(new ArrayList<>(li));
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]) continue;
            li.add(arr[i]);
            subsets_ii(arr,i+1,ans,li);
            li.remove(li.size()-1);
        }
    }
}