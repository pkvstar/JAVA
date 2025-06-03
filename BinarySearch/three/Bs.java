public class Bs {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 8, 9, 10};
        int target = 7;
        int result = upperBound(arr, target);

        System.out.print(result);
    }
    //? first occurence and last occurence of target
    //? intuition : for first occurence -> lowerbound
    //? intuition : for last occurence -> index by upperbound - 1 because 
    //? upperbound returns the index of the first element greater than target
    //? at last of both we check is index givn by them should contain value
    //? equal to target because lower&upper bound give index of closest element.

}