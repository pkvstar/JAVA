public class five{
    //? single number
    public static void main(String[] args){
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber_i(nums));    
    }
    //* Approach (BRUTE FORCE) : use hashmap to keep frequency of each number


    //* Approach (OPTIMAL) : In given there is one number that is single and other numbers are twice
    //* we can use XOR operation to find the single number as we know that when
    //* we do XOR of two same numbers it will result in 0 and when we do XOR with 0 it 
    //* will result in the number itself
    public static int singleNumber_i(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; 
        }
        return result;
    }
}