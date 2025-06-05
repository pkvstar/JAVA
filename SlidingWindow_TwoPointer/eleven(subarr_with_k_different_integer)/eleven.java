import java.util.HashMap;
public class eleven{
    //? Subarray with k different integers
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;
        int result = subarraysWithKDiffInt(arr, k);
        int result1 = subarraysWithKDiffInt(arr, k - 1);
        System.out.println(result-result1); // Output: 7
    }
    //? BRUTE FORCE -> generate all subarrays and count the ones with k different integers
    //? code (reference image)

    //? OPTIMAL -> using sliding window (two pointer)
    //* Approach : same as previous(nine.java) one means consider question as count no. of
    //* subarrays <= k and count no. of subarrays <= k-1
    //* and then subtract the two results
    //* TC O(2n), SC O(N)

    public static int subarraysWithKDiffInt(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            while(map.size() > k){
                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left])==0){
                    map.remove(arr[left]);
                }
                left++;
            }
            count+=(i-left)+1;
        }   
        return count;
    }
}