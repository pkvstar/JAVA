public class four{
    //? Maximum Consecutive Ones III
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1,0,1};
        int k = 2;
        System.out.println(maxConsecutiveOnes(arr, k));
    }
    //? brute force - (reference image)
    //? OPIMAL -> use zeroes as variable and whenever zeroes become grerater than k then we will 
    //? move left pointer till left pointer passes one zero
    public static int maxConsecutiveOnes(int[] arr, int k) { //? TC -> O(n) | SC -> O(1)
        int l=0;
        int r=0;
        int zeroes=0;
        int maxlen=0;
        while(r!=arr.length){
            if(arr[r]==0){
                zeroes++;
                if(zeroes>k){
                    while(arr[l]!=0){
                        l++;
                    }
                    l++;
                    zeroes--;
                }
            }
            maxlen = Math.max(r-l+1,maxlen);
            r++;
        }
        return maxlen;
    }
    //? OR
    public static int maxConsecutiveOnes2(int[] arr, int k) { //? TC -> O(n) | SC -> O(1)
        int l = 0;
        int r = 0;
        int zeroes = 0;
        int maxlen = 0;

        while (r < arr.length) {
            if (arr[r] == 0) {
                zeroes++;
            }

            while (zeroes > k) {
                if (arr[l] == 0) {
                    zeroes--;
                }
                l++;
            }

            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }
}