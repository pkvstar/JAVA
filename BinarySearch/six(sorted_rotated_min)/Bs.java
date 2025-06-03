public class Bs{
    //? minimum element in rotated sorted array
    //* find breakpoint  
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        int result = minSortedRotated(arr);
        System.out.print(result);
    }
    public static int minSortedRotated(int[] arr){
        int low=0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]<arr[high]){
                high = mid; // mid could be the minimum 
            }
            else if(arr[mid]>arr[high]){
                low = mid+1;
            }
            else{
                high--; // this is the case when arr[mid] == arr[high]
            }
        }
        return arr[low];
    }
    //? OR
    // int low=0;
    // int high = arr.length-1;
    // while(low < high){
    //     int mid = low+(high-low)/2;
    //     if(arr[mid]<arr[high]){
    //         high = mid; // mid could be the minimum 
    //     }
    //     else if(arr[mid]>arr[high]){
    //         low = mid+1;
    //     }
    // }
    // return arr[low];
}   