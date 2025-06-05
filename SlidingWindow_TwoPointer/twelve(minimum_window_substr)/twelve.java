public class twelve{
    //? Minimum Window Substring
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // Output: "BANC"
    }
    //? BRUTE FORCE -> generate all substrings of s and check if they contain t

    //? OPTIMAL -> Sliding Window
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        int[] charCount = new int[128]; // ASCII character set
        for (char c : t.toCharArray()) {
            charCount[c]++;
        }
        
        int left = 0, right = 0, required = t.length(), minLength = Integer.MAX_VALUE;
        int start = 0;
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (charCount[rightChar] > 0) {
                required--;
            }
            charCount[rightChar]--;
            right++;
            
            while (required == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }
                
                char leftChar = s.charAt(left);
                charCount[leftChar]++;
                if (charCount[leftChar] > 0) {
                    required++;
                }
                left++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}