import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class thirteen{
    //? Permutation 2nd Aprroach(Optimal approach as reduced 
    //? space of map or set used in previous aproach)
    //* Swapping approach means run loop from 0 -> n
    //* and swap with itself and i+1 to n and when
    //* index == arr.length-1 OR li.size == arr.length then add li in ans
    public static void main(String[] args){
        int[] arr = {1,2,3};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> li = new ArrayList<>();
        Permutation_ii(arr,ans,0);
        System.out.print(ans);  
    }
    public static void Permutation_ii(int[] arr,ArrayList<ArrayList<Integer>> ans,int idx){
        if(idx==arr.length){
            ArrayList<Integer> li = new ArrayList<>();
            for(int el : arr) li.add(el);
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            swap(idx,i,arr);
            Permutation_ii(arr,ans,idx+1);
            swap(idx,i,arr);
        }
    }
    public static void swap(int idx1,int idx2,int[] arr){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}