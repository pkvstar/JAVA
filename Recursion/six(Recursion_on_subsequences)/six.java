import java.util.ArrayList;
public class six{
    //* subsequence -> a contiguous or non-contiguous sequence of 
    //* characters in a string and follows the order.
    
    //? Print all subsequences of a string
    //* Approach: take / not take approach
    public static void main(String args[]){
        ArrayList<Integer> li = new ArrayList<>();
        int[] arr = {3,1,2};
        printAllSubsequences(arr,0,li);
    }
    public static void printAllSubsequences(int[] arr,int idx,ArrayList<Integer> ans){
        //* instead of list we can also use String ans and add it during calling
        //* like this -> printAllSubsequences(arr,idx+1,ans+arr[idx]);
        if(idx>=arr.length){
            System.out.println(ans);
            return;
        }
        ans.add(arr[idx]);
        printAllSubsequences(arr,idx+1,ans); //? TAKE
        ans.remove(ans.size()-1);
        printAllSubsequences(arr,idx+1,ans); //? NOT TAKE
    }
}