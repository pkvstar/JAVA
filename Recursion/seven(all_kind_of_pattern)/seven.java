import java.util.*;    
public class seven{
    //? 1.Printing subsequences whose sum is equal to K
    //* Approach : take and not take but only difference is in base consdition 
    //* and parameter as we create one parameter for sum and when base condition 
    //* hit of idx >= arr.length then we inside that we check sum == k and if 
    //* satisfy we print answer otherwise return ;

    //? 2.Print any 1 subsequence whose sum is equal to k
    //* Approach : we make boolean function and when base case satisfy with sum==k
    //* then we return true and if one time we get true we print that return true   

    //? 3.Count the subsequences with sum == k
    //* Approach : we make int function and if condition satisfy(sum == k) then 
    //* return 1 (means count 1) and if condition is not satisfy return 0;
    //* and here we not require list as we dont have to print , we just require
    //* sum parameter to check for condition sum == k

    public static void main(String[] args){
        int[] arr = {1,2,1};
        int k = 2;
        ArrayList<Integer> li = new ArrayList<>();
        // subsequenceSum(arr,0,0,li,k);
        // subsequenceSumOnce(arr,0,0,li,k);
        System.out.print(subsequenceSumCount(arr,0,0,k));
    }
    public static void subsequenceSum(int[] arr,int idx,int sum,ArrayList<Integer> ans,int k){
        if(idx>=arr.length){
            if(sum==k){
                System.out.println(ans);
            }
            return;
        }
        ans.add(arr[idx]);
        subsequenceSum(arr,idx+1,sum+arr[idx],ans,k); //* Take
        ans.remove(ans.size()-1);
        subsequenceSum(arr,idx+1,sum,ans,k); //* Not Take
    } 
    public static boolean subsequenceSumOnce(int[] arr,int idx,int sum,ArrayList<Integer> ans,int k){
        if(idx>=arr.length){
            if(sum==k){ //* condition satisfy then return true 
                System.out.println(ans);
                return true;
            }
            return false; //* if condition not satisfy then return false
        }
        ans.add(arr[idx]);
        if(subsequenceSumOnce(arr,idx+1,sum+arr[idx],ans,k)) return true;
        ans.remove(ans.size()-1);
        if(subsequenceSumOnce(arr,idx+1,sum,ans,k)) return true;
        return false;
    }
    public static int subsequenceSumCount(int[] arr,int idx,int sum,int k){
        if(sum > k) return 0;
        if(idx>=arr.length){
            if(sum == k){
                return 1;
            }
            return 0;
        }
        int take = subsequenceSumCount(arr,idx+1,sum+arr[idx],k);
        int notTake = subsequenceSumCount(arr,idx+1,sum,k);
        return take + notTake; //* return total count subsequence that satisfy condition
    }
}