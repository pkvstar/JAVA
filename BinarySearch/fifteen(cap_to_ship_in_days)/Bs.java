public class Bs{
    //? Capacity To Ship Packages Within D Days
    //? find the least weight capacity of a ship such that it can ship all 
    //? packages within D days
    //* striver code for reference(image , image2)
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(nums, days)); // Expected Output: 15
    }
    public static int shipWithinDays(int[] arr, int d) {
        int sum = 0;
        int max = arr[0];
        for(int el : arr){
            sum+=el;
            max=Math.max(max,el);
        }
        int ans = -1;
        int low = 1; //? can be max also
        int high = sum;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(mid<max){
                low=mid+1;
                continue;
            }
            if(check(arr,d,mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    static boolean check(int[] arr,int days,int weight){
        int temp = weight;
        for(int el : arr){
            if(temp >= el){
                temp = temp-el;
            }
            else{
                temp = weight;
                temp = temp-el;
                days--;
            }
        }
        if(temp!=weight){
            days--;
        }
        if(days>=0){
            return true;
        }
        return false;
    }
}