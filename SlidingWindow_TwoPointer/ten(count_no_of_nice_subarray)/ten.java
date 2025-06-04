public class ten{
    //? Count Number of Nice Subarrays
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        int result = numberOfSubarrays(nums, k);
        int result1 = numberOfSubarrays(nums, k-1);
        System.out.println("Count: " + (result-result1)); // Output : 2
    }
    //? BRUTE FORCE -> generate all subarrays and count the k odd numbers
    //* TC O(n^2), SC O(1)

    //? OPTIMAL -> using sliding window (two pointer)
    //* Approach : use the same approach same as nine.java (binary subarray with sum)
    //* we write program for odd count<=k and we call that function twice
    //* once with k and once with k-1 and then we subtract the two results
    //* func(nums,k) - func(nums,k-1)
    //* TC O(2 * 2n), SC O(1)
    public static int numberOfSubarrays(int[] nums,int k){
        int arr[] = new int[2];
        int left = 0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            arr[nums[i]%2]++;
            while(arr[1]>k){
                arr[nums[left]%2]--;
                left++;
            }
            count+=i-left+1;
        }
        return count;
    }
}