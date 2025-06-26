import java.util.Arrays;
public class six{
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(singleNumber_ii_Optimal(nums));
    }
    //* Approach (BRUTE FORCE) : use hashmap to keep frequency of each number

    //* Approach (BETTER) :   

    //* Approach (OPTIMAL) : sort the array and keep i in the middel of three same number 
    //* and check if arr[ith] != arr[ith-1] then i mans that arr[ith-1] is single number
    //* and this approach is optimal then previous one is because in previous one 
    //* TC is 32*O(n) but this approach has O(n*logn) and this approach is good because 
    //* logn depends upon array size but in previous approach whether the array size is
    //* small or big it will run 32*O(n)
    public static int singleNumber_ii_Optimal(int[] arr){
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i+=3){
            if(arr[i]!=arr[i-1]){
                return arr[i-1];
            }
        }
        return arr[arr.length-1];
    } 
}