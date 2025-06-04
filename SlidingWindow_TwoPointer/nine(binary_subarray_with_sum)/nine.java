import java.util.HashMap;    
public class nine{
    //? Binary Subarray with Sum
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        int result1 = binarySubarraysWithSum(nums, goal);
        int result2 = binarySubarraysWithSum(nums, goal-1);
        System.out.println("count: " + (result1-result2)); // Output : 4
        System.out.println("count: " + method1(nums, goal)); // Output : 4
    }
    //? BRUTE FORCE -> generate all subarrays and count the ones with sum equal to k
    //* TC O(n^2), SC O(1)

    //? OPTIMAL -> two methods : 
    //? a) using hashmap (already done in Arrays playlist of quest count subarray eqaul to k)
    //? b) using sliding window (two pointer)
    //* Approach : using slinding window
    //* we write program for sum<=goal and we call that function twice
    //* once with goal and once with goal-1 and then we subtract the two results
    //* func(nums,goal) - func(nums,goal-1)
    //* TC O(2 * 2n), SC O(1)

    public static int binarySubarraysWithSum(int[] arr,int k){
        if(k<0) return 0;
        int count = 0, sum = 0, left = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum > k) {
                sum -= arr[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
    public static int method1(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}