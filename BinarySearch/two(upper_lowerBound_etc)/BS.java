public class BS {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 8, 9, 10};
        int target = 7;
        int result = upperBound(arr, target);

        System.out.print(result);
    }
    //? lowerBound = smallest index i such that arr[i] >= target
    public static int lowerBound(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(target<=arr[mid]){
                ans = mid;
                high=mid-1; // Search in the low half
            }
            else{
                low = mid+1; // Search in the high half
            }
        }
        return ans;
    }
    //? upperBound = smallest index i such that arr[i] > target
    public static int upperBound(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(target<arr[mid]){
                ans = mid;
                high=mid-1; // Search in the low half
            }
            else{
                low = mid+1; // Search in the high half
            }
        }
        return ans;
    }
    //? Search insert position = index where target can be inserted to keep the array sorted
    public static int searchInsertPosition(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(arr[mid]<=target){
                if(arr[mid]==target){
                    ans = mid;
                    break;
                }
                ans = mid+1; // Potential insert position
                low = mid+1;
            }
            else{
                high = mid - 1;
            }
        }
        if(ans==-1){
            ans = (target<arr[0]) ? 0 : arr.length;
        }
        return ans;
    }
    //? floor/ ceil 
}