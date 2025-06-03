public class Bs{
    //? Search element in rotated sorted array - ii (duplicates allowed)
    //? Answer should be boolean means exist or not exist
    //* important : in this question previous code will not work because
    //* if the array is like this [3 1 2 3 3 3 3] then it will not be able 
    //* to decide which side is sorted. So we have to use a different approach
    //* Approach : whenever we get the condition arr[low] == arr[mid] == arr[high] 
    //* we will trim by high-1 and low+1 . This will help us to skip the duplicates 
    public static void main(String[] args) {
        int[] arr = {7,8,9,1,5,6,6,7,7};
        int target = 5;
        boolean result = searchInRotated_ii(arr, target);
        System.out.print(result);
    }
    public static boolean searchInRotated_ii(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target){
                return true;
            }
            if(arr[mid] == arr[low] && arr[mid] == arr[high]){
                low++;
                high--;
                continue; // skip duplicates
            }
            // left sorted
            if(arr[low]<=arr[mid]){
                if(target>=arr[low] && target<=arr[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            // right sorted
            else{
                if(target>=arr[mid] && target<=arr[high]){
                    low= mid+1;
                }
                else{
                    high = mid-1;
                }
            }

        }
        return false;
    }
}   