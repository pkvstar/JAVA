public class Bs{
    //? Single Element in Sorted Array
    //* we observe that the single element left half has even odd index of same element and
    //* right half has odd even index of same element (ref. image and image2)
    //* we also trim low+1 and high-1 at starting at idx 0 and arr.length-1 we check for 
    //* single element to avoid conditions inside binary search for mid in edge cases.
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 5, 5};
        int result = SingleElement(arr);
        System.out.println("Single Element is " + result);
    }
    public static int SingleElement(int[] arr){
        if(arr.length==1){
            return arr[0];
        }
        if(arr[0]!=arr[1]){
            return arr[0];
        }
        if(arr[arr.length-1]!=arr[arr.length-2]){
            return arr[arr.length-1];
        }
        int low = 1;
        int high = arr.length-2;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]){
                return arr[mid];
            }
            //? left half
            else if((mid%2==1 && arr[mid-1]==arr[mid]) ||  (mid%2==0 && arr[mid]==arr[mid+1])){
                low=mid+1; //? eliminate the left half
            }
            //? right half
            else{
                high=mid-1; //? eliminate the right half
            }
        } 
        return -1;
    }
}