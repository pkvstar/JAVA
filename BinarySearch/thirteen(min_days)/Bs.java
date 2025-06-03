public class Bs{
    //? minimum no. of days to make m bouquets (if not possible return -1)
    //* Approach : ref(image1 , 2 and 3)
    //* in binary search we take low = min in bloomDay and high = max in bloomDay as
    //* without blooming no. of days we can't make any bouquet
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k)); // Output: 3
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int ans = -1;
        if(n<m*k){
            return -1;
        }
        int min = bloomDay[0];
        int max = bloomDay[0];
        for(int el : bloomDay){
            min=Math.min(min,el);
            max=Math.max(max,el);
        }
        int low=min;
        int high=max;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(bloomDay,m,k,mid)){
                high=mid-1;
                ans = mid;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean check(int[] arr,int m,int k,int day){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                count++;
            }
            else{
                m-=(count/k);
                count = 0;
            }
        }
        m-=(count/k);
        if(m<=0){
            return true;
        }
        return false;
    }
}