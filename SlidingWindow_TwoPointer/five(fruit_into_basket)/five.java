import java.util.HashMap;
public class five{
    //? Fruit Into Basket
    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        System.out.println(maxFruits(fruits)); // Output: 4
    }
    //? Brute force -> ref. image (subarray with at most 2 distinct elements)
    //? Optimal -> Sliding Window
    //* Approach: we will use hashmap to store the count of each fruit type
    //* We will maintain a window with at most 2 distinct fruit types
    //* when hashmap size is greater than 2 we trim down , reduce the frequency 
    //* and remove the fruit type if its frequency becomes 0.
    public static int maxFruits(int[] fruits){
        int left = 0, right = 0, maxLength = 0;
        HashMap<Integer, Integer> fruitCount = new HashMap<>();
        while (right < fruits.length) {
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);
            
            // If we have more than 2 distinct fruits, shrink the window from the left
            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[left], fruitCount.get(fruits[left]) - 1);
                if (fruitCount.get(fruits[left]) == 0) {
                    fruitCount.remove(fruits[left]);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}