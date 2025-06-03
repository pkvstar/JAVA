import java.util.HashSet;    
import java.util.HashMap;
public class three{
    //? Length of the longest substring without repeating characters
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(solve(s));
    }
    //? brute force - generate all substrings and check for duplicates
    //? Optimal - use sliding window technique with HashSet
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> mp = new HashSet<>();
        int l=0;
        int maxlen = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!mp.contains(ch)){
                mp.add(ch);
                maxlen = Math.max(maxlen,mp.size());
            }
            else{
                while(s.charAt(l)!=ch){
                    mp.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
        }
        return maxlen;
    }
    //? Striver Approach -> using hashmap having character with there index
    public static int solve(String s) {
        HashMap < Character, Integer > mpp = new HashMap < Character, Integer > ();
        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left);

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}