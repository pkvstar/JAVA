import java.util.HashMap;
public class eight{
    //? longest repeating character replacement
    public static void main(String[] args) {
        String s = "AABABBA";
        System.out.println(longestRepeatingCharReplace(s, 1)); // Output: 4
    }
    //? BRUTE Force Approach -> explore all the substring (reference image)
    //? during generating substring we take hash array and check 
    //? which character is repeating the most and check with every length
    //? of substring and subtract then we get changes required and if 
    //? changes required >= k then we can update the maxlength
    //* TC -> O(n^2)

    //? Optimal Approach -> Sliding Window Technique using hashmap
    //* Approach -> maintain a window and keep track of maxfreq by a variable 
    //* and if the current window size minus maxfreq is greater than k(len - maxlen>k)
    //* then we shrink the window from left side and while shrinking we traverse to 
    //* to hashmap to update the maxfreq
    public static int longestRepeatingCharReplace(String s, int k){
        int left = 0;
        int maxlen = 0;
        int maxFreq = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int windowSize = i-left+1;
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq = Math.max(map.get(ch),maxFreq);
            while(windowSize - maxFreq > k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
                for(Character key : map.keySet()){
                    //* update maxFreq after shrinking the window
                    maxFreq = Math.max(maxFreq,map.get(key));
                }
                //* as left changes window size update
                windowSize = i-left+1;
            }
            maxlen = Math.max(maxlen,windowSize);
        }
        return maxlen;
    }
}