public class Bs{
    //? peak element in an array 
    //? here every element in an array arr[i-1] < arr[i] > arr[i+1] 
    //* we can consider arr[-1] = infinity and arr[n] = infinity
    //* Approach is that we check mid element and compare it with its neighbours
    //* if mid element is greater than both neighbours then it is a peak element
    //* if mid element is less than left neighbour then we can search in left half 
    //* because mid is the phase of increasing sequence
    //* if mid element is less than right neighbour then we can search in right half
    //* (ref. image)
    public static void main(String args[]){
        int[] arr = {1,2,1,3,5,6,4}; //* ans -> either 5 index or index 1 
        int peak = findPeak(arr);
        System.out.println("Peak element is: " + peak);
    }
    public static int findPeak(int[] arr){
        int n = arr.length;
        if(n==1){
            return 0;
        }
        if(arr[0]>arr[1]){
            return 0;
        }
        if(arr[n-1]>arr[n-2]){
            return n-1;
        }
        int low=1;int high=n-2;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>=arr[mid+1]){
                return mid;
            }
            else if(arr[mid]>arr[mid-1]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}