import java.util.ArrayList;
public class eighteen{
    //? Kth permutation of a string
    //? Input: n = 3, k = 3
    //? Output: "213"
    public static void main(String args[]){
        ArrayList<Integer> arr =  new ArrayList<>(); 
        int n = 3;
        int k = 3;
        System.out.print(getPermutation(n, k));
    }
    //* Brute Force -> using recursion to generate all permutations and then sorting them
    
    //* Optimal (using Maths) -> O(n^2) (reference images)
    public static String getPermutation(int n, int k) {
        ArrayList<Integer> arr =  new ArrayList<>(); 
        int fact = 1;    
        for(int i=1;i<n;i++){
            fact *= i;
            arr.add(i);
        }
        arr.add(n);
        String ans = "";
        k=k-1;
        while(true){
            ans+=arr.get(k/fact);
            arr.remove(k/fact);
            if(arr.size()==0) break;
            k=k%fact;
            fact/=arr.size();
        }
        return ans;
    }
}