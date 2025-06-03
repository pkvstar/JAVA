public class two{
    //? Maximum Points You Can Obtain from Cards
    //* we use approach leftSum And rightSum means first we take window 
    //* from left side and then we take window from right side (ref. image)

    public static void main(String[] args){
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k)); // Output: 12
    }
    public static int maxScore(int[] arr,int k){ //? TC -> O(2*k) | SC -> O(1)
        int n = arr.length;
        if(k==1){
            return (arr[0]>arr[n-1]) ? arr[0] : arr[n-1];
        }
        int max = 0;
        int lsum = 0;//? we can also use leftSum and rightSum but it also be done with single variable
        for(int i=0;i<k;i++){
            lsum+=arr[i];
        }
        if(k==n) return lsum;
        max = Math.max(max,lsum);
        int r=n-1;
        for(int i=k-1;i>=0;i--){
            lsum-=arr[i];
            lsum+=arr[r];
            max = Math.max(lsum,max);
            r--;
        }
        return max;
    }
}