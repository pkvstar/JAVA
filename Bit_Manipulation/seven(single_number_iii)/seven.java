public class seven{
    //? single number iii -> 
    //? Given an integer array nums, in which exactly two elements appear only once and all the 
    //? other elements appear exactly twice. Find the two elements that appear only once.
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2, 5};
        int[] result = singleNumber_iii(arr);
        System.out.println("The two single numbers are: " + result[0] + " and " + result[1]);
    }
    //* Approach (BRUTE FORCE) : use hashmap to keep frequency of each number

    //* Approach (BETTER) : use XOR to find the two unique numbers
    //* The idea is to find the XOR of all numbers, which will give us the XOR
    //* of the two unique numbers. Then, we can find a bit that is set in the XOR result
    //* and use it to partition the numbers into two groups, one for each unique number.
    //* This approach has a time complexity of O(n) and space complexity of O(1).


    public static int[] singleNumber_iii(int[] arr){
        int xor = 0;
        for (int num : arr) {
            xor ^= num; // XOR all numbers
        }
        // Find the rightmost set bit in xor
        int rightmostSetBit = (xor & xor-1)&xor;
        int num1 = 0, num2 = 0;
        for (int num : arr) {
            if ((num & rightmostSetBit) == 0) {
                num1 ^= num; // Group 1
            } else {
                num2 ^= num; // Group 2
            }
        }
        return new int[]{num1, num2};
    } 
}