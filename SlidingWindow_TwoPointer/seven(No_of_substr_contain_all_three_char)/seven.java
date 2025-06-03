public class seven{
    //? No of Substrings Containing All Three Characters
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(countSubstringsContainingAllThreeChars(s)); // Output: 10
    }
    //? BRUTE Force Approach -> explore all the substring (refernce image)

    //? Optimal Approach -> Sliding Window Technique
    //* Approach -> move from left and every time form smaller window 
    //* and when smaller window form add remaing left substring to count
    //* and move further and form small window and do till end of string

    public static int countSubstringsContainingAllThreeChars(String s){
        int lastSeen[] = new int[3];
        lastSeen[0] = -1;
        lastSeen[1] = -1;
        lastSeen[2] = -1;
        int count = 0;
        for(int i=0;i<s.length();i++){
            lastSeen[s.charAt(i)-'a'] = i;
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                count += (1+Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2])));
            }
        }
        return count;
    }
}