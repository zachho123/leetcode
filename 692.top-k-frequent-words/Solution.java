/*
https://leetcode.com/problems/top-k-frequent-words/

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words
have the same frequency, then the word with the lower alphabetical order
comes first.

Note:
    - You many assume k is always valid, 1 <= k <= number of unique elements
    - Input words contain only lowercase letters

Follow Up:
    - Try to solve it in O(n log k) time and O(n) extra space

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Comparator;

public class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        return firstAttempt(words, k);
    }

    private List<String> firstAttempt(String[] words, int k) {
        // go through input and populate map with words and their appearance count
        HashMap<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (counts.containsKey(words[i])) {
                counts.put(words[i], counts.get(words[i]) + 1);
            } else {
                counts.put(words[i], 1);
            }
        }

        // create priority queue with custom comparator
        PriorityQueue<String> pq = new PriorityQueue<>(counts.size(), new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (counts.get(s1) == counts.get(s2)) {
                    return s1.compareTo(s2);
                } else {
                    return counts.get(s2) - counts.get(s1);
                }
            }
        });

        // populate queue with unique words
        for (String s : counts.keySet()) {
            pq.add(s);
        }

        // take k most frequent from queue
        List<String> output = new ArrayList<String>();
        for (int i = 0; i < k; i++) {
            output.add(pq.remove());
        }

        return output;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] input1 = { "i", "love", "leetcode", "i", "love", "coding" };
        String[] input2 = { "the", "day", "is", "sunny",
            "the", "the", "the", "sunny", "is", "is" };

        List<String> one = sol.topKFrequent(input1, 2);
        for (String s : one) {
            System.out.print(s + ",");
        }
        System.out.println();

        List<String> two = sol.topKFrequent(input2, 4);
        for (String s : two) {
            System.out.print(s + ",");
        }
        System.out.println();
    }
}
