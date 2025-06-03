import java.util.HashMap;
public class six{
    //? Longest Substring with At Most K Distinct Characters
    //* Approach -> same as previous problem (fruit in basket),
    //* but the only difference is that instead of only 2 we check size 
    //* of hashmap and if it exceeds k, we shrink the window from left side.
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(longestSubstringWithAtMostKDistinctChars(s, k)); // Output: 3
    }
    //? BRUTE Force Approach -> explore all the substring and check using hashmap

    //? OPTIMAL Approach -> Sliding Window Technique using HashMap
    //* Time Complexity -> O(2n) where n is the length of the string
    //? this time instead of right I have just used i pointer as right pointer
    public static int longestSubstringWithAtMostKDistinctChars(String str, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
		int left = 0;
		int maxlen = 0;
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			while(map.size()>k){
				map.put(str.charAt(left),map.get(str.charAt(left))-1);
				if(map.get(str.charAt(left)) == 0){
					map.remove(str.charAt(left));
				}
				left++;
			}
			maxlen = Math.max(maxlen,i-left+1);
		}	
		return maxlen;
    }

    //? MORE OPTIMAL Approach : instead of inner while loop , we use if condition
    //? and it is only appplicable for length not for if question ask to print substring
    //* Time Complexity -> O(n) where n is the length of the string
    public static int longestSubstringWithAtMostKDistinctChars2(String str, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
		int left = 0;
		int maxlen = 0;
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			if(map.size()>k){
				map.put(str.charAt(left),map.get(str.charAt(left))-1);
				if(map.get(str.charAt(left)) == 0){
					map.remove(str.charAt(left));
				}
				left++;
			}
			maxlen = Math.max(maxlen,i-left+1);
		}	
		return maxlen;
    }
}