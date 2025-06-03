public class Bs {
    //? Search element in rotated sorted array
    //* intuition -> identify the sorted half of the array
    //* if target lies in that half, search in that half
    //* if target does not lie in that half, search in the other half
    public static void main(String[] args) {
        int[] arr = {7,8,9,1,2,3,4,5,6};
        int target = 8;
        int result = searchInRotated(arr, target);
        System.out.print(result);
    }
    public static int searchInRotated(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target){
                return mid;
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
        return -1;
    }
}