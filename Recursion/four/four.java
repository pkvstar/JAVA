public class four{
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr, 0);
        System.out.println("Reversed array: "+java.util.Arrays.toString(arr));
        String str = "madam";
        boolean result = isPalindrome(str, 0, str.length() - 1);
        System.out.println(result);
    }
    //? Reverse Array using Recursion
    public static void reverseArray(int[] arr,int i){//* Or int start and end can be used
        if(i >= arr.length/2){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;
        reverseArray(arr, i + 1);
    }

    //? check string is palindrome or not
    public static boolean isPalindrome(String str, int start, int end) { 
        //* OR only idx can be used instead of start and end (check if idx >= str.length()/2)
        //* str.charAt(idx) == str.charAt(str.length()-idx-1)

        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }
}