import java.util.HashSet;
import java.util.ArrayList;    
public class twelve{
    //? Permutation
    //* Approach : save index of element which is being added in list
    //* so that in forward call, it will not be added again and this can be achieved
    //* either taking list,map or set
    public static void main(String args[]){
        int[] arr = {1,2,3};
        HashSet<Integer> mp = new HashSet<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> li = new ArrayList<>();
        Permutation_i(arr,ans,li,mp);
        System.out.print(ans);  
    }
    public static void Permutation_i(int[] arr,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> li,HashSet<Integer> mp){
        if(li.size()==arr.length){
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!mp.contains(i)){
                mp.add(i); //index added to avoid further add
                li.add(arr[i]);
                Permutation_i(arr,ans,li,mp);
                mp.remove(i); // backtrack
                li.remove(li.size()-1);
            }
        }
    }
}