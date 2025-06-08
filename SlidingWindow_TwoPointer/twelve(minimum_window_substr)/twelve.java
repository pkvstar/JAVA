import java.util.HashMap;
public class twelve{
    //? Minimum Window Substring
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // Output: "BANC"
    }
    //? BRUTE FORCE -> generate all substrings of s and check if they contain t
    //* reference code(image and image2) 

    //? OPTIMAL -> Sliding Window
    //* Approach : we keep count and if that count == t.length() then we update
    //* minlen and then we shrink window and during shrinking if (count<t.length()) 
    //* then we extend the window till count == t.length() and we increase count only when
    //* frequency of character in map > 0 and we reduce the frequency in that and during 
    //* shrinking if frequency of character in map become greater than 0 then we reduce the 
    //* count. 
    public static String minWindow(String s, String t) {
        int[] hashArr = new int[128]; // Use 128 since characters can be lowercase and uppercase
        for (int i = 0; i < t.length(); i++) {
            hashArr[t.charAt(i)]++;
        }
        int l = 0, r = 0;
        int ct = 0; // Count of matching characters
        int minLen = Integer.MAX_VALUE; // Initialize minLen to a large value
        int sIndex = -1;
        while (r < s.length()) {
            // Expand window by moving r
            char rightChar = s.charAt(r);
            if (hashArr[rightChar] > 0) {
                ct++;
            }
            hashArr[rightChar]--; // Decrease the count for the current character
            // When we have a valid window, try to minimize it
            while (ct == t.length()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                // Contract the window by moving l
                char leftChar = s.charAt(l);
                hashArr[leftChar]++; // Increase the count back when moving left
                if (hashArr[leftChar] > 0) {
                    ct--; // Decrease the match count if a necessary character is lost
                }
                l++;
            }
            r++;
        }
        // Return the smallest window or an empty string if no window was found
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}