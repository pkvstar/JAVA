import java.util.ArrayList;
public class seventeen{
    //? Palindrome Partitioning
    //? Given a string, we need to partition it such that 
    //? every substring is a palindrome
    public static void main(String[] args){
        String s = "aab";
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        palindromePartitioning(s,0,path,ans);
        System.out.println(ans);
    }
    //* Approach : run for loop inside recursion and after every index
    //* we call and divide the string and check for palindrome and divided part is
    //* not palindrome then we increase index and divide and check again

    static void palindromePartitioning(String s,int index,ArrayList<String> path,ArrayList<ArrayList<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            String sub = s.substring(index,i+1);
            if(isPalindrome(sub)){
                path.add(sub);
                palindromePartitioning(s,i+1,path,ans);
                path.remove(path.size()-1);
            }
        }
    }
    static boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}