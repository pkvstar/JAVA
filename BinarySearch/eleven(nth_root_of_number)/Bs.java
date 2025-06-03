public class Bs{
    public static void main(String[] args) {
        //? Find nth root of a N
        //? N=3 M=27 -> 3root27 = 3
        //* explanation : 1*1*1 = 1, 2*2*2 = 8, 3*3*3 = 27 got the answer
        //? N=4 M=69 -> 4root69 = -1
        //* explanation : 1*1*1*1 = 1, 2*2*2*2 = 16, 3*3*3*3 = 81,it is
        //* exceding so no integer root
        int N = 4;
        int M = 69;
        int result = Nthroot(N,M);
        System.out.print(result);
    }
    public static int Nthroot(int N,int M){
        int low = 1;
        int high = M;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int product = check(mid, N);
            if(product==M){
                ans = mid;
                break; // Found exact root
            }
            else if(product < M){
                low = mid + 1; // Search in the higher range
            }
            else{
                high = mid - 1; // Search in the lower range
            }
        }
        return ans;
    }
    public static int check(int mid, int N){
        int product = 1;
        for(int i = 0; i < N; i++){
            product *= mid;
            if(product > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE; // Avoid overflow
            }
        }
        return product;
    }
}