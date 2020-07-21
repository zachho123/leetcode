/*
https://leetcode.com/problems/reconstruct-itinerary/

Given a list of airline tickets represented by pairs of departure and arrival
airports [from, to], reconstruct the itinerary in order. All of the tickets
belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

1. If there are multiple valid itineraries, you should return the itinerary
that has the smallest lexical order when read as a single string. For example,
the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
2. All airports are represented by three capital letters (IATA code).
3. You may assume all tickets form at least one valid itinerary.
*/

// TODO: REVIST THIS PROBLEM

import java.util.*;

public class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {
        return first(tickets);
    }

    private List<String> first(List<List<String>> tickets) {
        final String JFK = "JFK";
        List<String> output = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        Stack<String> stack = new Stack<>();

        // init map with key = start loc, value = priority queue of alphabetical end loc
        for (List<String> tuple : tickets) {
            String startLoc = tuple.get(0);
            String endLoc = tuple.get(1);
            if (map.containsKey(startLoc)) {
                PriorityQueue<String> temp = map.get(startLoc);
                temp.add(endLoc);
                map.put(startLoc, temp);
            } else {
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(tuple.get(1));
                map.put(tuple.get(0), pq);
            }
        }

        // construct output
        stack.push(JFK);
        while (!stack.empty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            output.add(0, stack.pop());
        }

        return output;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // List<String> l1 = Arrays.asList("MUC", "LHR");
        // List<String> l2 = Arrays.asList("JFK", "MUC");
        // List<String> l3 = Arrays.asList("SFO", "SJC");
        // List<String> l4 = Arrays.asList("LHR", "SFO");

        List<String> l1 = Arrays.asList("JFK", "KUL");
        List<String> l2 = Arrays.asList("JFK", "NRT");
        List<String> l3 = Arrays.asList("NRT", "JFK");

        List<List<String>> input1 = new ArrayList<>();
        input1.add(l1);
        input1.add(l2);
        input1.add(l3);
        // input1.add(l4);

        for (String s : sol.findItinerary(input1)) {
            System.out.println(s);
        }
    }
}
