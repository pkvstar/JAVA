import java.util.ArrayList;
public class eight{
    //? Combination Sum
    //* Approach : Tanke and not take but will not increase idx evrytime because
    //* there can chance of same element to form target and to prevent stackoverflow
    //* from that recursion call we apply one condition that if sum+arr[idx]<=target then
    //* only call that function that doesnt increade idx

    public static void main(String args[]){
        int[] arr = {2,3,5};
        int target = 8;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> li = new ArrayList<>();
        CombinationSum(arr,target,0,ans,li,0);
        System.out.print(ans);
    }
    public static void CombinationSum(int[] arr,int target,int idx,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> li,int sum){
        if(idx==arr.length){
            if(sum==target){
                ans.add(new ArrayList<>(li));
            }
            return;
        }
        if(arr[idx]+sum<=target){
            li.add(arr[idx]);
            CombinationSum(arr,target,idx,ans,li,sum+arr[idx]);
            li.remove(li.size()-1);
        }
        CombinationSum(arr,target,idx+1,ans,li,sum);
    }
}