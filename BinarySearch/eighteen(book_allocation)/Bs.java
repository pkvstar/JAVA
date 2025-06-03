public class Bs{
    //? Book Allocation
    //? find the least number of pages a student has to read such that all books are allocated
    public static void main(String[] args) {
        int[] arr = {12,34,67,90};
        int students = 2;
        System.out.println(bookAllocation(arr, students)); // Expected Output: 113
    }
    //! this code and striver code is not working on GFG
    public static int bookAllocation(int[] arr,int k){
        int sum = 0;
        int max = arr[0];
        for(int el : arr){
            sum += el;
            max = Math.max(max, el);
        }
        int ans = -1;
        int low = max; //? can be max also
        int high = sum;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(check(arr, k, mid)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static boolean check(int[] arr, int k, int mid){
        int count = 1;
        int sum = 0;
        for(int el : arr){
            sum += el;
            if(sum > mid){
                count++;
                sum = el; //? start new allocation
            }
        }
        return count <= k; //? if we can allocate to k students
    }
}