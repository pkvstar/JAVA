public class Bs{
    //? Find out how many times the array is rotated
    //* approach is similar to finding the minimum element in a rotated sorted array
    //* as from where minimum element is found, we can find the number of rotations
    //* the number of rotations is equal to the index of the minimum element
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        int result = CountRotate(arr);
        System.out.print(result);
    }
    public static int CountRotate(int[] arr){
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
        return low;
    }
}   