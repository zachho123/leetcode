/*
https://leetcode.com/problems/minimum-index-sum-of-two-lists/

Suppose Andy and Doris want to choose a restaurant for dinner, and they both
have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index
sum. If there is a choice tie between answers, output all of them with no
order requirement. You could assume there always exists an answer.

Note:
1. The length of both lists will be in the range of [1, 1000].
2. The length of strings in both lists will be in the range of [1, 30].
3. The index is starting from 0 to the list length minus 1.
4. No duplicates in both lists.
*/
import java.util.*;

public class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {
        return firstAttempt(list1, list2);
    }

    private String[] firstAttempt(String[] l1, String[] l2) {
        Map<String, Integer> p1 = new HashMap<>();
        List<String> output = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int sum;

        // map first person's restaurants with index
        for (int i = 0; i < l1.length; i++) {
            p1.put(l1[i], i);
        }

        // go through second list, and only populate output with
        // common restaurants which have index sum less than or
        // equal to the current min
        for (int j = 0; j < l2.length; j++) {
            if (p1.containsKey(l2[j])) {
                sum = j + p1.get(l2[j]);
                if (sum < min) {
                    output.clear();
                    min = sum;
                }
                if (sum <= min) {
                    output.add(l2[j]);
                }
            }
        }

        return output.toArray(new String[output.size()]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] input1_p1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] input1_p2 = { "Piatti", "The Grill at Torrey Pines",
            "Hungry Hunter Steakhouse", "Shogun" };

        for (String s : sol.findRestaurant(input1_p1, input1_p2)) {
            System.out.print(s + " ");
        }
        System.out.println();

        String[] input2_p1 = { "BK", "MCD", "TB" };
        String[] input2_p2 = { "TB", "MCD", "BK" };

        for (String s : sol.findRestaurant(input2_p1, input2_p2)) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
