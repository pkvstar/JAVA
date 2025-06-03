public class Bs{
    //? k-th missing positive integer
    //* bruteforce (reference image)
    //* Optimal (binary search): we find missing at every index (reference image2)
    //* we apply binary search on that missing number (reference image3)
    //* in image3 every time we cannot say high + more will give the answer but
    //* it will not work as for this arr[4 7 9] k=3 then high will point to -1 and 
    //* answer will be wrong.so we have to find formula for that.
    //? formula : after breakdown arr[high] + more
    //* we get this : 1) high+1+k  OR   2) low+k  
    public static void main(String[] args) {
        int[] nums = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(nums,k)); // Expected Output: 9
    }
    public static int findKthPositive(int[] arr,int k){
        int low = 0, high = arr.length - 1;
        while(low<=high){
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1); // Calculate the number of missing numbers up to arr[mid]
            if(missing < k){
                low = mid + 1; // Move to the right half
            } else {
                high = mid - 1; // Move to the left half
            }
        }
        return low+k;
    }
}